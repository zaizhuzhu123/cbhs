package com.server.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * 任务池
 * @author hanlai
 *
 */
@Configuration
@Component
@EnableAsync
public class TaskPool implements ApplicationListener<TaskEvent>{
	private final ScheduledExecutorService SCHEDULEDTHREADPOOL = Executors.newScheduledThreadPool(10);
	private final BlockingQueue<Task> blockingQueue = new LinkedBlockingQueue<Task>();
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	@PostConstruct
	public void init(){
		for(int i=0;i<10;i++){
			SCHEDULEDTHREADPOOL.scheduleAtFixedRate(new TaskRunner(blockingQueue,eventPublisher), 0, 1, TimeUnit.MICROSECONDS);
		}
	}
	/**
	 * 任务监听器，如果收到新任务则把任务加入任务池
	 */
	@Async
	@Override
	public void onApplicationEvent(TaskEvent taskEvent) {
		try {
			blockingQueue.put((Task)taskEvent.getSource());
		} catch (InterruptedException e) {
			LoggerFactory.getLogger(getClass()).error("任务池添加任务失败",e);
		}
	}
}
/**
 * 接收任务并运行如果运行失败重新放回任务池
 *    如果不想失败后继续执行，请捕获异常
 * @author hanlai
 *
 */
class TaskRunner implements Runnable{
	private BlockingQueue<Task> blockingQueue;
	private ApplicationEventPublisher eventPublisher;
	public TaskRunner(BlockingQueue<Task> blockingQueue,ApplicationEventPublisher eventPublisher) {
		this.blockingQueue = blockingQueue;
		this.eventPublisher = eventPublisher;
	}
	@Override
	public void run() {
		Task task= null;
		try {
			task=blockingQueue.take();
			task.run();
		} catch (InterruptedException e) {
			LoggerFactory.getLogger(getClass()).error("任务池获取任务失败",e);
		} catch (Exception e) {
			LoggerFactory.getLogger(getClass()).error("任务执行失败",e);
			if(task!=null){
				eventPublisher.publishEvent(new TaskEvent(task));
			}
		}
	}
	
}
class TaskEvent extends ApplicationEvent{
	private static final long serialVersionUID = 7362868145366914705L;

	public TaskEvent(Object source) {
		super(source);
	}
	
}
