package com.learning.service;

import com.learning.annotation.MyRPC;

@MyRPC
public interface UserService {

    String query(Long id);

    void add(Long id,String name);

}
