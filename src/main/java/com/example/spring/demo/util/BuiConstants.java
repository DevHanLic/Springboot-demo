package com.example.spring.demo.util;


/**
 * @author zhou_xiong
 */
public class BuiConstants {
    /**
     * 公共序列号
     */
    public static final String PUBLIC_SEQUENCE_NAME = "SYS_PUB_SEQ";

    /**
     * 业务线    -请求金融中台入参
     */
    public static final String PLATFORM_HMJ = "HMJ";

    /**
     * 资金渠道编码 生成id名称
     */
    public static final String CHANNEL_CODE_ID_NAME = "CHANNELCODE";

    /**
     * 资金渠道编码 生成id 前缀
     */
    public static final String CHANNEL_CODE_PREFIX = "9";

    /**
     * 资金渠道 生成id 长度  首位9，后边14位，总共15位
     */
    public static final int CHANNEL_CODE_LEN = 14;

    /**
     * 分页查询第一页页码
     */
    public static final int FIRST_PAGE_NUM = 1;

    /**
     * 分页查询每页最大数，用于查询所有
     */
    public static final int MAX_PAGE_SIZE = 50;

    /**
     * 资金渠道分页查询每页最大数，用于查询所有
     */
    public static final int MAX_PAGE_SIZE_100 = 100;

    /**
     * 分隔符
     */
    public static final String SPLIT_REGEX = "|";

    /**
     * http
     */
    public static final String HTTP = "http";

    /**
     * 图片路径长度最大值
     */
    public static final int IMAGE_PATH_LEN_MAX = 128;

    /**
     * 状态-是
     */
    public static final String STATUS_YES = "是";

    /**
     * 状态-否
     */
    public static final String STATUS_NO = "否";

    /**
     * 文件大小 2M
     */
    public static final int FILE_MAX_SIZE_2M = 2 * 1024 * 1024;

    /**
     * 默认编码 UTF-8
     */
    public static final String DEFAULT_ENCODING = "ISO8859-1";

    /**
     * 默认日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";

    /**
     * 下划线
     */
    public static final String UNDER_LINE = "_";

    /**
     * 逗号
     */
    public static final String COMMA = ",";

    /**
     * 星号
     */
    public static final String ASTERISK = "*";

    /**
     * 模板文件目录
     */
    public static final String TEMPLATE_FILE_PATH = "/template/";

    /**
     * 文件名后缀 .xls
     */
    public static final String FILE_SUFFIX_NAME_XLS = ".xls";

    /**
     * 文件名后缀 .xlsx
     */
    public static final String FILE_SUFFIX_NAME_XLSX = ".xlsx";

    /**
     * 文件名后缀 .csv
     */
    public static final String FILE_SUFFIX_NAME_CSV = ".csv";

    /**
     * 文件名后缀 .txt
     */
    public static final String FILE_SUFFIX_NAME_TXT = ".txt";

    /**
     * 黑/白名单批量导入模板文件名
     */
    public static final String BLACKLIST_TEMPLATE_FILE_NAME = "template_blacklist.xlsx";

    /**
     * 黑/白名单批量导入模板文件名
     */
    public static final String  WHITELIST_TEMPLATE_FILE_NAME = "template_whitelist.xlsx";

    /**
     * 违规号段批量导入模板文件名
     */
    public static final String ILLEGAL_MOBILE_TEMPLATE_FILE_NAME = "template_illegal_mobile.xlsx";

    /**
     * 公共流水号生成序列号长度 当前日期+8位序号
     */
    public static final int PUBLIC_SEQUENCE_LENGTH = 8;

    /**
     * 帮助中心问题分类管理 参数名
     */
    public static final String HELP_CENTER_QA_TYP = "HELPCENTER_QA_TYP";

    /**
     * 进度条配置参数名
     */
    public static final String USR_INF_PROGRESS = "USR_INF_PROGRESS";

    /**
     * 活动类型 有活动情况
     */
    public static final String ACTIVITIES = "activities";

    /**
     * 应用ID
     */
    public static final String APPLICATION_ID_MPL = "MPL";

    /**
     * 业务参数设置名
     */
    public static final String BUSINESS_PARAM_SETTING = "BusinessParam";


    /**
     *  成功标识
     */
    public static final String SUCCESS_FLAG = "S";


    /**
     *  失败标识
     */
    public static final String FAILED_FLAG = "F";

    /**
     *  处理中标识
     */
    public static final String PROCESSING_FLAG = "W";

    /**
     * 预授信交易类型
     */
    public static final String PRE_CREDIT_TRANSACTION_TYPE = "预申请";

    /**
     * 预授信交易类型
     */
    public static final String CREDIT_ACCESS_CHECK_TRANSACTION_TYPE = "授信准入";

    /**
     * 电子账户开户交易类型
     */
    public static final String OPEN_ELECTRONIC_ACCOUNT_TRANSACTION_TYPE = "电子账户开户";

    /**
     * 政企经理用户名单批量导入模板
     */
    public static final String ENTERPRISE_TEMPLATE_FILE_NAME = "template_enterprise.xlsx";

}
