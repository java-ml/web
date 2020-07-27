package cn.hebeuit.dao;

import cn.hebeuit.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();
    User getUser(int id);
    void addUser(String name);
    List<User> getUsersByIds(int[] ids);
    List<User> getUserAndOrders();
}