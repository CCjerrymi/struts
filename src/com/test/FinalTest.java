package com.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.entity.Customer;
import com.entity.Orders;

public class FinalTest {
	
	
	@Test
	public void sessionTest(){
		//1.加载hibernate.cfg.xml配置
		Configuration config = new Configuration().configure();
		//2.获取sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3.得到一个session
		Session session = sessionFactory.openSession();
		//4.开启事物
		Transaction transaction = session.beginTransaction();
		//5.操作
		Orders first = new Orders();
		//first.setId(1);
		first.setName("first");
		Orders second = new Orders();
		//second.setId(2);
		first.setName("second");
		
		Set<Orders> orders = new HashSet<Orders>();
		orders.add(first);
		orders.add(second);
		
		
		Customer customer = new Customer();
		
		customer.setAge(23);
		customer.setCity("beijing");
		//customer.setId(001);
		customer.setSex("man");
		customer.setName("roof");
		customer.setOrders(orders);
		
		
		session.save(first);
		session.save(orders);
		session.save(customer);
	
		//6.提交事物
		transaction.commit();
		//7.关闭资源
		session.clear();  
	    session.flush();
		session.close();
		
		sessionFactory.close();
	}

}
