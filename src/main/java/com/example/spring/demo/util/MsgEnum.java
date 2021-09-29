package com.example.spring.demo.util;




/**
 * 管理平台错误码枚举
 *
 * @author xuhuanchao
 * @date 2020/7/22 14:08
 */
public enum MsgEnum {
    /**
     * 返回码 返回描述
     */
    SUCCESS("HMJ00000", "成功"),
    ING("HMJ00001", "处理中"),
    PARAM_ERROR("HMJ00002", "入参校验不通过"),
    NO_EXIST("HMJ00003", "数据不存在"),
    PARAM_EMPTY_ERROR("HMJ00004", "入参校验不通过，参数[{1}]为空"),
    PARAM_LENGTH_ERR("HMJ00005", "入参校验不通过，参数[{1}]长度超长"),
    PARAM_MAX_ERR("HMJ00006", "入参校验不通过，参数[{1}]大小超过范围"),
    PARAM_NULL_ERR("HMJ00007", "[{1}]为空"),
    INSTITUTION_INFO_NOT_EXIST("HMJ00008", "金融机构信息不存在"),
    INSTITUTION_GREATER_THAN_ONE("HMJ00009", "系统异常，一个金融机构id得到多个金融机构"),
    REAL_CHANNEL_CODE_NOT_EQUAL("HMJ00010", "接入渠道编码或者渠道key与同产品的接入渠道不一致"),
    UPDATE_CHANNEL_LOGO_ERROR("HMJ00011", "更新资金方logo失败"),
    DELETE_AGREEMENT_ERROR("HMJ00012", "删除协议失败"),
    MOBILE_NO_NULL("HMJ00013", "手机号为空"),
    SAVE_BLACK_WHITELIST_ERROR("HMJ00014", "新增名单失败"),
    LABEL_NAME_IS_NULL("HMJ00015", "标签名称为空"),
    MODULE_NAME_IS_NULL("HMJ00016", "模块名称为空"),
    ROSTER_TYPE_IS_NULL("HMJ00017", "名单类型为空"),
    NAME_IS_NULL("HMJ00018", "姓名为空"),
    CERT_NO_IS_NULL("HMJ00019", "身份证为空"),
    MOBILE_IS_ILLEGAL("HMJ00020", "手机号不合法"),
    USER_NO_IS_NULL("HMJ00021", "用户号为空"),
    ROSTER_TYPE_ERROR("HMJ00022", "名单类型错误"),
    USER_ALREADY_IN_BLACKLIST("HMJ00023", "用户已在黑名单中"),
    USER_ALREADY_IN_WHITELIST("HMJ00024", "用户已在白名单中"),
    DELETE_BLACK_WHITELIST_ERROR("HMJ00025", "删除黑/白名单失败"),
    PRODUCT_CODE_NOT_NULL("HMJ00026", "产品编码为空"),
    SAVE_HELPER_ERROR("HMJ00027", "保存帮助信息失败"),
    DELETE_HELPER_ERROR("HMJ00028", "删除帮助信息失败"),
    OPERATE_TYPE_ERROR("HMJ00029", "操作类型有误"),
    QUESTION_TYPE_IS_NULL("HMJ00030", "问题类型为空"),
    QUESTION_DESC_IS_NULL("HMJ00031", "问题描述为空"),
    ANSWER_IS_NULL("HMJ00032", "答案为空"),
    USE_SCENE_IS_NULL("HMJ00033", "业务线为空"),
    SERIAL_NO_IS_NULL("HMJ00034", "流水号为空"),
    CANCEL_CHECK_DIFF_ERROR("HMJ00035", "取消对账差错失败"),
    USER_NOT_EXIST("HMJ00036", "用户不存在"),
    SAVE_ILLEGAL_MOBILE_ERROR("HMJ00037", "保存违规号段失败"),
    DELETE_ILLEGAL_MOBILE_ERROR("HMJ00038", "删除违规号段失败"),
    ILLEGAL_MOBILE_IS_NULL("HMJ00039", "违规号段不能为空"),
    ILLEGAL_MOBILE_FORMAT_NOT_MATCH("HMJ00040", "号段格式不符"),
    SAVE_ERROR_FOR_BATCH("HMJ00041", "添加失败，请尝试单个添加"),
    ILLEGAL_MOBILE_IS_EXISTS("HMJ00042", "添加失败，号段重复"),
    SAVE_BUSINESS_PARAMETER_ERROR("HMJ00043", "保存业务参数失败"),
    NOTICE_TITLE_IS_NULL("HMJ00074", "公告标题为空"),
    NOTICE_CONTENT_IS_NULL("HMJ00075", "公告内容为空"),
    EFFECTIVE_DATE_IS_NULL("HMJ00076", "生效日期为空"),
    EXPIRE_DATE_IS_NULL("HMJ00077", "失效日期为空"),
    EFFECTIVE_DATE_GREATER_THAN_EXPIRE_DATE("HMJ00078", "生效日期大于失效日期"),
    NOTICE_SHOW_PAGE_IS_NULL("HMJ00079", "展示页面为空"),
    SAVE_NOTICE_ERROR("HMJ00080", "保存公告信息失败"),
    DELETE_NOTICE_ERROR("HMJ00081", "删除公告信息失败"),
    PRODUCT_NAME_ERROR("HMJ00082", "产品名称不合法"),
    PRODUCT_TYPE_ERROR("HMJ00083", "产品类型不合法"),
    REPAYMENT_WAY_ERROR("HMJ00084", "还款方式不合法"),
    LOAN_AMOUNT_ERROR("HMJ00085", "贷款额度不合法"),
    PRODUCE_DESC_ERROR("HMJ00086", "产品属性不合法"),
    REPAY_DESC_ERROR("HMJ00087", "还款说明不合法"),
    USER_LABEL_ERROR("HMJ00088", "用户标签不合法"),
    USER_AGE_ERROR("HMJ00089", "用户年龄不合法"),
    USER_SOCIAL_IDENTITY_ERROR("HMJ00090", "用户社会身份不合法"),
    CREDIT_TIME_ERROR("HMJ00091", "授信时间范围不合法"),
    LOAN_TIME_ERROR("HMJ00092", "借款时间范围不合法"),
    REPAY_TIME_ERROR("HMJ00093", "还款时间范围不合法"),
    MAINTENANCE_TIME_ERROR("HMJ00094", "维护时间范围不合法"),
    CREDIT_ROUTER_ERROR("HMJ00095", "授信方路由开关不合法"),
    DEFAULT_CREDIT_ERROR("HMJ00096", "默认授信方不合法"),
    LOAN_ROUTER_ERROR("HMJ00097", "放款方路由开关不合法"),
    REPAY_TYPE_SUPPORT_OVERDUE_ERROR("HMJ00098", "还款类型[逾期还款]不合法"),
    REPAY_TYPE_PRE_PAYMENT_ERROR("HMJ00099", "还款类型[提前还款]不合法"),
    REPAY_TYPE_PRE_SETTLE_ERROR("HMJ00100", "还款类型[提前结清]不合法"),
    REPAY_TYPE_MORE_REPAYMENT_ERROR("HMJ00101", "还款类型[多期还款]不合法"),
    FIRST_ROUTE_WEIGHT_ERROR("HMJ00103", "首次授信路由权重不合法"),
    NON_FIRST_ROUTE_WEIGHT_ERROR("HMJ00104", "非首次授信路由权重不合法"),
    BUSINESS_TYPE_ERROR("HMJ00105", "准入类型不合法"),
    BUSINESS_DESC_ERROR("HMJ00106", "类型描述不合法"),
    RULE_CONDITIONS_ERROR("HMJ00107", "规则条件不合法"),
    RECORDS_HAD_DELETED("HMJ00108", "该记录已被删除，请勿重复操作"),
    MODULE_ID_IS_NULL("HMJ00109", "模块ID为空"),
    SHOW_IMAGE_IS_NULL("HMJ00110", "展示图标为空"),
    MODULE_INFO_EXISTS("HMJ00111", "模块信息已存在"),
    SAVE_MODULE_INFO_ERROR("HMJ00112", "保存模块信息失败"),
    DELETE_MODULE_INFO_ERROR("HMJ00113", "删除模块信息失败"),
    CLIENT_ID_IS_NULL("HMJ00114", "渠道ID为空"),
    MODULE_CLIENT_INFO_EXISTS("HMJ00115", "模块渠道信息已存在"),
    SAVE_RECOMMEND_INFO_ERROR("HMJ00116", "保存推荐有奖信息失败"),
    AT_LEAST_ONE_PARAM_VALUE_CANNOT_BE_NULL("HMJ00117", "至少有一个参数值不能为空"),
    DELETE_CAPITAL_MERCHANT_INFO_ERROR("HMJ00118", "删除资金方商户信息失败"),
    PARTNER_ALREADY_HAS_SAME_MERCHANT_FLAG("HMJ00119", "该合作伙伴已存在相同的商户标识，请勿重复录入"),
    PARTNER_ALREADY_HAS_MERCHANT_FLAG_ASTERISK("HMJ00120", "当前合作伙伴已存在资方商户标识为*的商户，请勿重复添加"),
    PARTNER_SUPPORT_MULTI_MERCHANT_CONFIG("HMJ00121", "当前合作伙伴支持多商户配置，请勿添加*号标识"),
    SAVE_CAPITAL_MERCHANT_INFO_ERROR("HMJ00122", "保存资金方商户信息失败"),
    CLIENT_ID_INFO_EXISTS("HMJ00123", "渠道信息已存在"),
    SAVE_CLIENT_ID_INFO_ERROR("HMJ00124", "保存渠道信息失败"),
    DELETE_CLIENT_ID_INFO_ERROR("HMJ00125", "删除渠道信息失败"),
    CLIENT_ID_INFO_EXISTS_FOR_NAME("HMJ00126", "该渠道名称对应的渠道信息已存在"),
    CLIENT_NAME_ILLEGAL("HMJ00127", "渠道名称不合法"),
    PARAM_EXIST_ERROR("HMJ00128", "{1}已存在"),
    SAVE_PRODUCTNOTICE_INFO_ERROR("HMJ00129", "保存借款提示语信息失败"),
    DELETE_PRODUCTNOTICE_INFO_ERROR("HMJ00130", "删除借款提示语信息失败"),
    SAVE_DISCOUNTELEMENT_INFO_ERROR("HMJ00131", "保存活动元素信息失败"),
    SAVE_ERROR("HMJ00132", "保存{1}失败"),
    TIPS_LANGUAGE_ALREADY_EXISTS("HMJ00133", "该时段的首页提示语已存在"),
    INSERT_TIPS_LANGUAGE_FAILE("HMJ00134", "数据库新增首页提示语失败"),
    UPDATE_TIPS_LANGUAGE_FAILE("HMJ00135", "数据库更新首页提示语失败"),
    DELETE_TIPS_LANGUAGE_FAILE("HMJ00136", "数据库删除首页提示语失败"),
    PARTNER_MERCHANT_ID_ERROR("HMJ00137", "和包商户号输入有误"),
    USER_MOBILE_IN_BLACKLIST("HMJ00138", "用户路由手机号已存在列表中"),
    SANE_TIME_RANGE_EXIST_NOTICE("HMJ00139", "同一时间范围内存在其他公告信息"),
    ADD_REASON_IS_NULL("HMJ00140", "添加原因为空"),
    EXCEL_DATA_FORMAT_ERROR("HMJ00141", "表格文件内容与模板不符"),
    EXCEL_ADD_REASON_LENGTH_TOO_LONG("HMJ00142", "添加原因不能超过{1}字"),
    EXCEL_REMARK_LENGTH_TOO_LONG("HMJ00143", "备注不能超过{1}字"),
    QUERY_CONDITION_LACKING("HMJ00144", "查询条件太少，请保证手机号/交易日期/订单号至少一个不为空"),
    NAME_LENGTH_TOO_LONG("HMJ00145", "姓名不能超过{1}字"),
    USR_NOT_IVT_CODE_ERROR("HMJ00146", "未找到该邀请码对应的用户"),
    FOUND_CENTER_HAS_SAME_PRODUCT_FLAG("HMJ00148", "该公积金中心已存在配置信息，请勿重复录入"),
    SAVE_FOUND_CENTER_ERROR("HMJ00147", "保存公积金中心配置信息失败"),
    MSG_NO_IS_NULL("HMJ00149", "消息id为空"),
    UPDATE_MSG_PUSH_INFO_ERROR("HMJ00150", "更新消息推送信息失败"),
    DELETE_PROVINCIAL_COMPANL_ERROR("HMJ00151", "删除省公司失败"),
    PROVINCIAL_COMPANL_NOTEXIST_ERROR("HMJ00152", "暂未处理生成当前省公司余额数据"),
    USER_NOTEXIST_ERROR("HMJ00153", "收款账户用户号不存在，请联系第二推荐人操作和包支付注册开户"),
    USERNO_NOT_EQUALS_ERROR("HMJ00154", "收款账户用户号与手机号匹配不一致"),
    USR_ISNOT_IVT_CODE_ERROR("HMJ00155", "未找到该邀请码对应的用户"),


    // 请求外部系统返回错误 start
    PRODUCT_RES_ERROR("HMJ10001", "产品中心返回错误"),
    PRODUCT_REQUEST_ERROR("HMJ10002", "请求产品中心异常"),
    CAP_REQUEST_ERROR("HMJ10003", "请求资方中心异常"),
    LOAN_RES_ERROR("HMJ10004", "信贷中心返回错误"),
    TASK_RES_ERROR("HMJ10005", "对账中心返回错误,{1}:{2}"),
    // 请求外部系统错误 end
    FILE_UPLOAD_ERROR("HMJ20001", "文件上传失败"),
    FILE_NOT_EMPTY("HMJ20002", "文件不能为空"),
    FILE_SIZE_PASS_2M("HMJ20003", "文件大小不能超过2M"),
    FILE_DOWNLOAD_ERROR("HMJ20004", "文件下载失败"),
    FILE_TYPE_ERROR("HMJ20005", "文件类型有误"),
    FILE_NOT_EXISTS("HMJ20006", "文件不存在"),
    EXCEL_FILE_MAX_COUNT_BEYOND("HMJ20007", "文件最大笔数限制为{1}条"),
    FILE_RESOLUTION_FAILURE("HMJ20008", "文件解析失败"),
    ERROR("HMJ00999", "系统异常"),

    ;


    MsgEnum(String msgCd, String msgInfo) {
        this.msgCd = msgCd;
        this.msgInfo = msgInfo;
    }

    private final String msgCd;

    private final String msgInfo;


}
