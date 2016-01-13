package icss.wz.manager.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/21.
 */
public class BFJDSInfo implements Serializable {
    private String scheduleName;
    private String scheduleData;
    private String ScheduleCode;
    private String scheduleAddress;

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleData() {
        return scheduleData;
    }

    public void setScheduleData(String scheduleData) {
        this.scheduleData = scheduleData;
    }

    public String getScheduleCode() {
        return ScheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        ScheduleCode = scheduleCode;
    }

    public String getScheduleAddress() {
        return scheduleAddress;
    }

    public void setScheduleAddress(String scheduleAddress) {
        this.scheduleAddress = scheduleAddress;
    }
}
