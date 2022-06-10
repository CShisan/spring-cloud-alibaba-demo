package com.cshisan.common.base;

import lombok.Data;

/**
 * @author yuanbai
 * @date 2022/6/9 14:02
 */
@Data
public class Result<T> {
    public int code;
    public String msg;
    public T data;
}
