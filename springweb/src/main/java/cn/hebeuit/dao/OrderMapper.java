package cn.hebeuit.dao;

import cn.hebeuit.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    List<Order> getOrders();
    void putOrder(int uid, Date date);
}
