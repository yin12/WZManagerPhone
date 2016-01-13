package icss.wz.manager.bean;

import java.io.Serializable;

import icss.wz.manager.util.Algorithm;

/**
 * Created by Administrator on 2015/12/23.
 */
public class DHGZSInfo implements Serializable {
    private Algorithm algorithm;
    private String id;
    private String cigaretteOrders;//订单卷烟
    private double goodsQuantity;//订货量
    private double amount;//金额
    private String orderDate;//订单日期

    @Override
    public String toString() {
        return "DHGZSInfo{" +
                "id='" + id + '\'' +
                ", cigaretteOrders='" + cigaretteOrders + '\'' +
                ", goodsQuantity=" + goodsQuantity +
                ", amount='" + amount + '\'' +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCigaretteOrders() {
        return cigaretteOrders;
    }

    public void setCigaretteOrders(String cigaretteOrders) {
        this.cigaretteOrders = cigaretteOrders;
    }

    public double getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(double goodsQuantity) {
//        this.goodsQuantity = goodsQuantity;
        this.goodsQuantity = algorithm.round(goodsQuantity, 1);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
//        this.amount = amount;
        this.amount = algorithm.round(amount, 2);
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
