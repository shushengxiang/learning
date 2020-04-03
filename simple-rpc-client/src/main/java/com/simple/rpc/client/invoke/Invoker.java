package com.simple.rpc.client.invoke;

import com.simple.rpc.common.model.RPCRequest;
import com.simple.rpc.common.model.RPCResponse;

public interface Invoker {

    RPCResponse invoke(RPCRequest request);

}
