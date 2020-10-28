package com.example.spring.demo;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;


public class JNADllCall {
    /**
     * DLL动态库调用方法
     * @Description: 读取调用CDecl方式导出的DLL动态库方法
     * @author: LinWenLi
     * @date: 2018年7月18日 上午10:49:02
     */
    public interface CLibrary extends Library {
        // DLL文件默认路径为项目根目录，若DLL文件存放在项目外，请使用绝对路径。（此处：(Platform.isWindows()?"msvcrt":"c")指本地动态库msvcrt.dll）
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("C:\\Users\\HLC\\Desktop\\Dll1",CLibrary.class);
        void isPrime(int OID);

    }

    public static void main(String[] args) {
//        CLibrary.INSTANCE.printf("Hello, World!");
        CLibrary.INSTANCE.isPrime(5);


    }
}
