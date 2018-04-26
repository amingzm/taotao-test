package dao;

import java.util.Date;
import java.util.List;

import pojo.Seckill;

/**
 * @author ming
 *
 */
public interface SeckillDao {

	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return 如果影响行数>1，表示更新的记录行数
	 */
	int reduceNumber(long seckillId, Date killTime);
	
	/**
	 * 根据id查询秒杀对象
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 根据偏移量查询秒杀商品列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> qureyAll(int offset, int limit);
	
}
