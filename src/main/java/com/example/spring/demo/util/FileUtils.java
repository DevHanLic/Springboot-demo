package com.example.spring.demo.util;


import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author zhou_xiong
 */
@Slf4j
public class FileUtils {
    public static final String BASE_PATH = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    private static final int BYTE_LENGTH = 4096;

    /**
     * 获取文件系统分隔符
     *
     * @return
     */
    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }

    /**
     * 获取文件保存的文件夹
     *
     * @return
     */
    public static String getFolder() {
        String dateStr = DateTimeUtils.getCurrentDateStr();
        String timeStr = DateTimeUtils.getCurrentTimeStr();
        return StringUtils.join(getFileSeparator(), dateStr, getFileSeparator(), timeStr, getFileSeparator());
    }

    /**
     * 获取随机文件名
     *
     * @return
     */
    public static String getFileName() {
        return UUID.randomUUID().toString();
    }

    /**
     * 返回文件名后缀
     *
     * @param fileName
     *
     * @return
     */
    public static String getFileNameSub(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 文件上传 这样上传,如果文件过大,会导致内存溢出
     *
     * @param file
     * @param filePath
     * @param fileName
     *
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(filePath + fileName);
        }finally {
            out.write(file);
            out.flush();
            out.close();
        }
    }

    /**
     * 匹配文件的后缀
     *
     * @param fileName
     * @param exts
     *
     * @return
     */
    public static boolean match(String fileName, String... exts) {
        if (StringUtils.isEmpty(fileName)) {
            return false;
        }
        String ext = getFileNameSub(fileName);
        return JudgeUtils.equalsAny(ext, exts);
    }

    /**
     * 文件路径取md5
     *
     * @param path
     *
     * @return
     */
    public static String md5File(String path) {
        String value = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[BYTE_LENGTH];
            int length;
            while ((length = fis.read(buffer, 0, BYTE_LENGTH)) != -1) {
                md.update(buffer, 0, length);
            }
            value = Hex.encodeHexString(md.digest());
        } catch (NoSuchAlgorithmException | IOException e) {
            LOGGER.error("calc md5 failed", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    LOGGER.error("close resource failed");
                }
            }
        }

        return value;
    }

    /**
     * 获取上传的文件
     *
     * @param multipartFile MultipartFile
     *
     * @return File
     *
     * @throws Exception Exception
     */
    public static File getMultipartFile(MultipartFile multipartFile) throws Exception {
        InputStream inputStream = multipartFile.getInputStream();
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename(), "The original file name is null"));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int bytesRead;
        int length = 8192;
        byte[] byteBuffer = new byte[length];
        try {
            while ((bytesRead = inputStream.read(byteBuffer, 0, length)) != -1) {
                fileOutputStream.write(byteBuffer, 0, bytesRead);
            }
        }finally {
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
            }catch (IOException e) {
                log.error("方法FileUtils.getMultipartFile流关闭异常,忽略此报错");
            }
        }



        return file;
    }

    /**
     * 解析Text文件内容
     *
     * @param fileParseInfo 文件解析请求信息
     * @param tClass Class
     *
     * @return List<T>
     */
    public static <T> List<T> parseTextFile(FileParseInfo fileParseInfo, Class<T> tClass) {
        List<T> resultList = Lists.newLinkedList();
        String fileCharset = getFileCharset(fileParseInfo.getFile());
        LOGGER.info("platform charset: {}, current file charset: {}", Charset.defaultCharset(), fileCharset);
        try (FileInputStream fileInputStream = new FileInputStream(fileParseInfo.getFile());
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, fileCharset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            //构造一个BufferedReader类来读取文件
            String content;
            int count = 0;
            int fileCountLine = (int) getLineNumber(fileParseInfo.getFile());
            //使用readLine方法，一次读一行
            while ((content = bufferedReader.readLine()) != null) {
                count++;
                if (count <= fileParseInfo.getBeginIgnoreLines() || JudgeUtils.isBlank(content)) {
                    continue;
                }

                if (count > (fileCountLine - fileParseInfo.getEndIgnoreLines())) {
                    break;
                }

                resultList.add(tClass.getDeclaredConstructor(String.class).newInstance(content));
            }
        } catch (Exception e) {
            LOGGER.error("parse text file error.", e);
            return null;
        }
        return resultList;
    }

    /**
     * 获取文件编码格式
     *
     * @param sourceFile 源文件
     *
     * @return 字符编码
     */
    private static String getFileCharset(File sourceFile) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile))) {
            boolean checked = false;
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            int char1 = 0xFF;
            int char2 = 0xFE;
            int char3 = 0xEF;
            int char4 = 0xBB;
            int char5 = 0xBF;
            int char6 = 2;
            // 文件编码为 ANSI
            if (read == -1) {
                return charset;
            }
            // 文件编码为 Unicode
            else if (first3Bytes[0] == (byte) char1 && first3Bytes[1] == (byte) char2) {
                charset = "UTF-16LE";
                checked = true;
            }
            // 文件编码为 Unicode big endian
            else if (first3Bytes[0] == (byte) char2 && first3Bytes[1] == (byte) char1) {
                charset = "UTF-16BE";
                checked = true;
            }
            // 文件编码为 UTF-8
            else if (first3Bytes[0] == (byte) char3 && first3Bytes[1] == (byte) char4 && first3Bytes[char6] == (byte) char5) {
                charset = "UTF-8";
                checked = true;
            }
            bis.reset();
            if (!checked) {
                while ((read = bis.read()) != -1) {
                    if (read >= 0xF0) {
                        break;
                    }
                    // 单独出现BF以下的，也算是GBK
                    if (0x80 <= read && read <= 0xBF) {
                        break;
                    }
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        // 双字节 (0xC0 - 0xDF)
                        if (! (0x80 <= read && read <= 0xBF)) {
                            break;
                        }
                    }
                    // 也有可能出错，但是几率较小
                    else if (0xE0 <= read && read <= 0xEF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            }
                            break;
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.info("get file charset error, return of default charset.", e);
            return BuiConstants.DEFAULT_ENCODING;
        }
        return charset;
    }

    public static long getLineNumber(File filePath) {
        if (filePath.exists()) {
            try (FileReader fileReader = new FileReader(filePath);
                 LineNumberReader lineNumberReader = new LineNumberReader(fileReader)) {
                lineNumberReader.skip(Long.MAX_VALUE);
                return lineNumberReader.getLineNumber() + 1;
            } catch (IOException e) {
                LOGGER.error("get file count line error.", e);
            }
        }
        return 0;
    }

    /**
     * 解析文件内容
     *
     * @param fileParseInfo 文件解析请求信息
     * @param tClass Class
     *
     * @return List<T>
     */
    public static <T> List<T> parseFile(FileParseInfo fileParseInfo, Class<T> tClass) {
        //Assert.isNotNull(fileParseInfo, MsgEnum.PARAM_ERROR);
        fileParseInfo.init();

        // 获取文件后缀
        String fileSuffix = getFileNameSub(fileParseInfo.getFile().getName());
        switch (fileSuffix) {
            case BuiConstants.FILE_SUFFIX_NAME_XLS:
            case BuiConstants.FILE_SUFFIX_NAME_XLSX:
                return ExcelUtils.parseExcelFile(fileParseInfo, tClass);
            case BuiConstants.FILE_SUFFIX_NAME_CSV:
            case BuiConstants.FILE_SUFFIX_NAME_TXT:
                return parseTextFile(fileParseInfo, tClass);
            default:
                return null;
        }
    }
}
