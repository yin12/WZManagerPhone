package icss.wz.manager.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/25.
 */
public class GZZJInfo implements Serializable {
    private String clientId;
    private String clientName;//客户名
    private String checkInTime;//签到时间
    private String signBackTime;//签退时间
    private int scheduleType;//状态

    @Override
    public String toString() {
        return "GZZJInfo{" +
                "clientId='" + clientId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", signBackTime='" + signBackTime + '\'' +
                ", scheduleType=" + scheduleType +
                '}';
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getSignBackTime() {
        return signBackTime;
    }

    public void setSignBackTime(String signBackTime) {
        this.signBackTime = signBackTime;
    }

    public int getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(int scheduleType) {
        this.scheduleType = scheduleType;
    }

}
