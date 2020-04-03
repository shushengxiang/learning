package com.learning.rpc.service;

import com.learning.rpc.annotation.RPC;

@RPC
public interface UserService {

    String queryName(Long id);

    String query(Long id);

}
