package icss.wz.manager.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/24.
 * <p/>
 * 客户——信息
 */
public class ClientInfo implements Serializable {

    private String id;
    private String clientName;//客户名称
    private String clientCode;//简码
    private String clientAddress;//客户地址
    private String clientPhoneNumber;//客户联系号
    private String planDate;//计划日期
    private String finishDate;//完成日期
    private String behavior;//拜放状态

    @Override
    public String toString() {
        return "ClientInfo{" +
                "id='" + id + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", planDate='" + planDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", behavior='" + behavior + '\'' +
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

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }
}
