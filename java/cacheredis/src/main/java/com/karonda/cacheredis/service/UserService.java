package com.karonda.cacheredis.service;

import com.karonda.cacheredis.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String, Object> get(int id);
    List<User> getAll();
    User update(User user);
    boolean delete(int id);
    boolean deleteAll();
}
