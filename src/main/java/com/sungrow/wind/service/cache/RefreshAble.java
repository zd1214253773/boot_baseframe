package com.sungrow.wind.service.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ZHENGDONG
 * @date 2020/12/16 20:57
 */
public abstract class RefreshAble {


    //job.period 不设值就一分钟
    @Value("${job.period:60000}")
    private Long period;

    public abstract void refresh();

    protected long getPeriod() {
        return period;
    }

    @PostConstruct
    protected void init() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                refresh();
            }
        }, new Date(System.currentTimeMillis() + getPeriod()), getPeriod());
    }

}
