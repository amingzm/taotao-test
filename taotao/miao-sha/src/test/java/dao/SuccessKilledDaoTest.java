package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration(locations={"classpath:spring/applicationContext-dao.xml"})

public class SuccessKilledDaoTest {

	@Autowired
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() {
		int count = successKilledDao.insertSuccessKilled(1000L, 1325125121512L);
		System.out.println(count);
	}

	@Test
	public void testQueryByIdWithSeckill() {
		SuccessKilled result = successKilledDao.queryByIdWithSeckill(1000L, 1325125121512L);
		System.out.println(result.getUserphone());
	}

}
