package com.heyyw.seckill.queue.disruptor;


import com.heyyw.seckill.common.config.SpringUtil;
import com.heyyw.seckill.service.ISeckillService;
import com.lmax.disruptor.EventHandler;

/**
 * 消费者(秒杀处理器)
 * 创建者 科帮网
 */
public class SeckillEventConsumer implements EventHandler<SeckillEvent> {
	
	private ISeckillService seckillService = (ISeckillService) SpringUtil.getBean("seckillService");
	
	public void onEvent(SeckillEvent seckillEvent, long seq, boolean bool) throws Exception {
		seckillService.startSeckil(seckillEvent.getSeckillId(), seckillEvent.getUserId());
	}
}
