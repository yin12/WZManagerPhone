package icss.wz.manager.bean;

import java.io.Serializable;

import icss.wz.manager.util.Algorithm;

/**
 * Created by Administrator on 2015/12/21.
 */
public class BFJDFInfo implements Serializable {
    private Algorithm algorithm;
    private String scheduleWeek;
    private int schedulePlanNumber;
    private int scheduleRealityNumber;
    private String scheduleSize;

    public String getScheduleWeek() {
        return scheduleWeek;
    }

    public void setScheduleWeek(String scheduleWeek) {
        this.scheduleWeek = scheduleWeek;
    }

    public int getSchedulePlanNumber() {
        return schedulePlanNumber;
    }

    public void setSchedulePlanNumber(int schedulePlanNumber) {
        this.schedulePlanNumber = schedulePlanNumber;
    }

    public int getScheduleRealityNumber() {
        return scheduleRealityNumber;
    }

    public void setScheduleRealityNumber(int scheduleRealityNumber) {
        this.scheduleRealityNumber = scheduleRealityNumber;
    }

    public String getScheduleSize() {
        return scheduleSize;
    }

    public void setScheduleSize(int scheduleRealityNumber, int schedulePlanNumber) {
        double result = algorithm.div(scheduleRealityNumber, schedulePlanNumber, 4) * 100;
        this.scheduleSize = String.valueOf(algorithm.round(result, 2));
    }
}
