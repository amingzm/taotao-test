package dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration(locations={"classpath:spring/applicationContext-dao.xml"})

public class SeckillDaoTest {

	//注入Dao实现类依赖
	@Autowired
	public SeckillDao seckillDao;
	
	
	@Test
	public void testReduceNumber() {
		Date killTime = new Date();
		int update = seckillDao.reduceNumber(1000L, killTime);
		System.out.println(update);
	}

	@Test
	public void testQueryById() {
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill.getName());
	}

	@Test
	public void Test() {
//		long id = 1000;
//		Seckill seckill = seckillDao.queryById(id);
//		System.out.println(seckill.getName());
		System.out.println("1");
//		System.out.println(seckill.getName());
	}
	
	@Test
	public void testQureyAll() {
		List<Seckill> seckills = seckillDao.qureyAll(0, 100);
		for (Seckill seckill : seckills) {
			System.out.println(seckill.getName());
		}
	}

}
/*
 * org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): dao.SeckillDao.queryById
	at org.apache.ibatis.binding.MapperMethod$SqlCommand.<init>(MapperMethod.java:189)
	at org.apache.ibatis.binding.MapperMethod.<init>(MapperMethod.java:43)
	at org.apache.ibatis.binding.MapperProxy.cachedMapperMethod(MapperProxy.java:58)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:51)
	at com.sun.proxy.$Proxy14.queryById(Unknown Source)
	at dao.SeckillDaoTest.testQueryById(SeckillDaoTest.java:35)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.springframework.test.context.junit4.statements.RunBeforeTestMethodCallbacks.evaluate(RunBeforeTestMethodCallbacks.java:73)
	at org.springframework.test.context.junit4.statements.RunAfterTestMethodCallbacks.evaluate(RunAfterTestMethodCallbacks.java:82)
	at org.springframework.test.context.junit4.statements.SpringRepeat.evaluate(SpringRepeat.java:73)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:217)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:83)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:68)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:163)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)








*/

