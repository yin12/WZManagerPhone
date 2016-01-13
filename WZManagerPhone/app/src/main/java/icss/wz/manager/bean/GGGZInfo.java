package icss.wz.manager.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/25.
 * <p/>
 * 规格跟踪——信息
 */
public class GGGZInfo implements Serializable {
    private String id;
    private String clientName;//客户名
    private String clientCode;//简码
    private int orderQuantity;//订货量
    private double money;//金额

    @Override
    public String toString() {
        return "GGGZInfo{" +
                "id='" + id + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", money=" + money +
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

    public void setClientName(String clientNamee) {
        this.clientName = clientNamee;
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
        this.money = money;
    }
}
