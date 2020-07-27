package cn.hebeuit.controller;

import cn.hebeuit.dao.OrderMapper;
import cn.hebeuit.dao.UserMapper;
import cn.hebeuit.entity.Order;
import cn.hebeuit.entity.User;
import cn.hebeuit.server.OrderServer;
import cn.hebeuit.server.UserServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ViewController {
     @Resource
     UserServer userServer;
     @Resource
    OrderServer orderServer;
    @RequestMapping("/get/{id}")
    @ResponseBody
    public User getUser(@PathVariable(value = "id") Integer id){
        return userServer.getUserById(id);
    }
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String addUser(String username,Model model){
        userServer.addUser(username);
        model.addAttribute("user",username);
        return "forward:/WEB-INF/jsp/index.jsp";
    }
    @RequestMapping("/show")
    @ResponseBody
    public List<User> getAllUsersOrder(){
        return userServer.getUserAndOrders();
    }
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView model=new ModelAndView();
        model.setViewName("index");
        return model;
    }
}
