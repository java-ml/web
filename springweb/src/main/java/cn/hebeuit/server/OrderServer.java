package cn.hebeuit.server;

import cn.hebeuit.dao.OrderMapper;
import cn.hebeuit.dao.UserMapper;
import cn.hebeuit.entity.Order;
import cn.hebeuit.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServer {
     @Resource
     OrderMapper orderMapper;
     public List<Order> getUsersOrder(){
         return  orderMapper.getOrders();
     }
}
