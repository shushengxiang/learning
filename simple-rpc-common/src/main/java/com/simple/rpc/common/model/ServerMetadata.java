package com.simple.rpc.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/1 14:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServerMetadata {

    String name;

    String address;

}
