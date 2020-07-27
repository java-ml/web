package cn.hebeuit.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User {

    private int id;

    private String username;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY,content = JsonInclude.Include.NON_NULL)
    private List<Order> orders;


    public List<Order> getOrders() {
        return orders;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(30);
        buf.append("{");
        buf.append(id);
        buf.append(", ");
        buf.append(username);
        buf.append("}");
        return buf.toString();
    }
}