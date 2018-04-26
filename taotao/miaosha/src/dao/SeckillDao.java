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
	 * �����
	 * @param seckillId
	 * @param killTime
	 * @return ���Ӱ������>1����ʾ���µļ�¼����
	 */
	int reduceNumber(long seckillId, Date killTime);
	
	/**
	 * ����id��ѯ��ɱ����
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * ����ƫ������ѯ��ɱ��Ʒ�б�
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> qureyAll(int offset, int limit);
	
}
