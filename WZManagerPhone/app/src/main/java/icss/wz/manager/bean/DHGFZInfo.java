package icss.wz.manager.bean;

import java.io.Serializable;

import icss.wz.manager.util.Algorithm;

/**
 * Created by Administrator on 2015/12/22.
 */
public class DHGFZInfo implements Serializable {
    private Algorithm algorithm;
    private String id;//编号
    private String clientName;//客户名称
    private String clientCode;//简码
    private int orderQuantity;//订货量
    private double money;//金额
    private double orderPrice;//单条值
    private int orderNumber;//单品数


    @Override
    public String toString() {
        return "DHGFZInfo{" +
                "id='" + id + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", money=" + money +
                ", orderPrice=" + orderPrice +
                ", orderNumber=" + orderNumber +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = algorithm.round(money, 2);
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = algorithm.round(orderPrice, 2);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
