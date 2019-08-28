package com.huang;


import java.io.Serializable;

/**
 * Created by sccy on 2019/7/5/0005.
 */
public class OrderPaidEvent implements Serializable {
    private String id;
    private Integer money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public OrderPaidEvent() {
    }

    OrderPaidEvent(String id, Integer money) {
        this.id = id;
        this.money = money;
    }

    @Override
    public String toString() {
        return "OrderPaidEvent{" +
                "id='" + id + '\'' +
                ", money=" + money +
                '}';
    }
}
