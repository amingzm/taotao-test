package dao;

import pojo.SuccessKilled;

/**
 * @author ming
 *
 */
public interface SuccessKilledDao {

	/**
	 * ���빺����ϸ���ɹ����ظ�
	 * @param seckillId
	 * @param userPhone
	 * @return ���������
	 */
	int insertSuccessKilled(long seckillId, long userPhone);
	
	
	/**
	 * ����id��ѯSuccessKilled��Я����ɱ��Ʒ����ʵ��
	 * @param SeckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(long SeckillId);
}
