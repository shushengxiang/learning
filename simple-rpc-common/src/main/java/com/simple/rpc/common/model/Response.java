package com.simple.rpc.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/1 14:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    int status;

    String msg;

    public static Response success(){
        Response response = new Response();
        return response;
    }

    public static Response fail(int status,String msg){
        return new Response(status,msg);
    }

}
