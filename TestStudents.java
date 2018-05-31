package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {
	//生成表的方法
//	@Test
//	public void testSchemaExport() {
//	    Configuration config = new Configuration().configure();
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();  
//		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
//		
//		Session session = (Session) sessionFactory.getCurrentSession();
//		SchemaExport export = new SchemaExport();  
//	    export.create(true, true);  
//	}
	//添加测试方法
//		@Test
//		public void testSaveSudents() {
//			//创建配置对象
//			Configuration config = new Configuration().configure();
//			//创建服务注册对象
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//			//创建SessionFactory对象
//			SessionFactory sessionFactory = config.buildSessionFactory();
//			//创建Session对象
//			Session session = (Session) sessionFactory.getCurrentSession();
//			//创建事务对象
//			Transaction tx = session.beginTransaction();
//			
//			Students s1 = new Students("s0000001","张三丰","男",new Date(),"武当山");
//			Students s2 = new Students("s0000002","郭靖","女",new Date(),"桃花岛");
//			Students s3 = new Students("s0000003","黄蓉","男",new Date(),"挑花岛");
//			
//			session.save(s1);
//			session.save(s2);
//			session.save(s3);
//			
//			tx.commit();
//			sessionFactory.close();
//		}
}
