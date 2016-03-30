package com.skyscanner.browsegrid.service;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import com.skyscanner.browsegrid.job.SimpleJob;

public class SkyScnSchedService {

	JobDetail job;
	SimpleTrigger trigger;
	public SkyScnSchedService(Long schdIntrv) {
		job = new JobDetail();
		job.setName("MyJob");
		job.setJobClass(SimpleJob.class);
		
		trigger = new SimpleTrigger();
		trigger.setName("TimeIntervalTrigger");
		trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
		trigger.setRepeatInterval(schdIntrv);
		trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
	}

	public void start() {
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}

}
