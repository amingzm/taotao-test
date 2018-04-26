package dto;

import enums.SeckillStatEnum;
import pojo.SuccessKilled;

/**
 * 封装秒杀执行后结果
 * @author ming
 *
 */
public class SeckillExecution {

	private long seckillId;
	
	//秒杀执行结果状态
	private int state;
	
	//状态表示
	private String stateInfo;
	
	//秒杀成功的对象
	private SuccessKilled successKilled;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId, SeckillStatEnum sEnum, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = sEnum.getState();
		this.stateInfo = sEnum.getStateInfo();
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId, SeckillStatEnum sEnum, String stateInfo) {
		super();
		this.seckillId = seckillId;
		this.state = sEnum.getState();
		this.stateInfo = stateInfo;
	}

	public SeckillExecution(Long seckillId2, SeckillStatEnum repeatKill) {
		super();
		this.seckillId = seckillId;
		this.state = repeatKill.getState();
	}

	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfo=" + stateInfo
				+ ", successKilled=" + successKilled + "]";
	}
	
	
}
