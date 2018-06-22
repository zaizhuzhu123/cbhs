package com.server.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
/**
 * 任务发送类
 * @author hanlai
 *
 */
public class TaskPublisher {
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	/**
	 * 放置任务到任务池
	 * @param task
	 */
	public void pushTask(Task task){
		eventPublisher.publishEvent(new TaskEvent(task));
	}
}
