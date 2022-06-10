package com.cshisan.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态码枚举类
 *
 * @author CShisan
 * @date 2022-2-19 0:19
 */
@Getter
@AllArgsConstructor
public enum CodeEnum {
    /**
     * 系统状态code
     */
    OK(200, "操作成功"),
    NO(400, "操作失败"),
    PARAM_ERROR(403, "参数有误"),
    NOT_FOUND(404, "找不到资源"),
    FAIL(500, "系统异常,请稍后再试"),

    /**
     * 操作数据库状态code
     */
    DB_OPERATE_ERROR(10501, "数据库操作失败"),

    /**
     * 用户状态code
     */
    USER_AUTH_ERROR(10701, "认证失败"),
    USER_NOT_FOUND(10702, "用户不存在"),
    USER_PW_ERROR(10703, "密码错误"),
    USER_ID_CARD_ERROR(10704, "身份证错误"),
    USER_PHONE_ERROR(10705, "手机号码错误"),
    USER_ROLES_ERROR(10706, "角色分配错误"),
    USER_WX_LOGIN_ERROR(10707, "微信登录失败"),
    USER_WX_ENCODE_ERROR(10708, "微信加密数据解密失败"),

    /**
     * 业务状态code
     */
    SERVICE_DATA_NULL(10901, "数据为空"),
    SERVICE_DATA_EMPTY(10902, "数据为空/空字符串"),
    SERVICE_DATA_ERROR(10903, "数据异常");


    private final int code;
    private final String message;

    public static CodeEnum codeOf(int code) {
        for (CodeEnum value : values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new RuntimeException("获取枚举类异常");
    }
}
