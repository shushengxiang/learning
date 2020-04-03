package com.simple.rpc.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/1 14:59
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse<T> extends Response {

    T data;

    public static <T> DataResponse success(T data){
        DataResponse dataResponse = new DataResponse(data);
        return dataResponse;
    }

}
