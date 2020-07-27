package cn.hebeuit.server;

import cn.hebeuit.dao.UserMapper;
import cn.hebeuit.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServer {
     @Resource
     UserMapper userMapper;
     public User getUserById(int id){
         return userMapper.getUser(id);
     }
    public List<User> getUserByIds(int... ids){
        return userMapper.getUsersByIds(ids);
    }
    public  List<User> getUsers(){
         return userMapper.getUsers();
    };

    public  void addUser(String name){
        userMapper.addUser(name);
    };

    public List<User> getUserAndOrders(){
        return userMapper.getUserAndOrders();
    };
}
