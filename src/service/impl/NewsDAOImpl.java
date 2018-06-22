package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import db.MyHibernateSessionFactoty;
import entity.News;
import service.NewsDAO;

/**
 *学生业务逻辑接口的实现类
 */
public class NewsDAOImpl implements NewsDAO{
	
	//查询所有学生资料
	@Override
	public List<News> queryAllNews() {
		Transaction tx = null;
		List<News> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			//开启事务
			tx = session.beginTransaction();
			hql = "	from News";
			Query query = session.createQuery(hql);
			
			list = query.list();
			//提交事务
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		}
		finally {
			if(tx!=null) {
//				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public News queryNewsByNid(String nid) {
		Transaction tx = null;
		News s = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			//开启事务
			tx = session.beginTransaction();
			s = (News)session.get(News.class, nid);
			//提交事务
			tx.commit();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return s;
		}
		finally {
			if(tx!=null) {
//				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public boolean addNews(News n) {
		n.setNid(getNewNid()); //设置学生的学号
		Transaction tx = null;
//		String hql = "";
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
//			hql = "insert into News values(?,?,?,?,?,?)";
//			Query query = session.createQuery(hql);
			session.save(n);
			tx.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
//			tx.commit();
			return false;
		}
		finally {
			if(tx!=null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean updateNews(News n) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(n);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if(tx!=null) {
				tx = null;
			}
		}
		
	}

	@Override
	public boolean deleteNews(String nid) {
		
		Transaction tx = null;
//		String hql = "";
		
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			News s = (News)session.get(News.class, nid);
			session.delete(s);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if(tx!=null) {
				tx = null;
			}
		}
	}
	
	//生成学生的学号
	private String getNewNid() {
		
		Transaction tx = null;
		String hql = "";
		String nid = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//获得当前学生的最大编号
			hql = "select max(nid) from News";
			Query query = session.createQuery(hql);
			nid = (String)query.uniqueResult();
			System.out.println(nid);
			if(nid==null||"".equals(nid)) {
				//给一个默认的最大编号
				nid = "N0000001";
			}else {
				String temp = nid.substring(1);//区后七位
				int i = Integer.parseInt(temp);//转成数字
				i++;
				
				//再还原成字符串
				temp = String.valueOf(i);
				int len = temp.length();
				//凑足7位
				for(int j=0;j<6;j++) {
					temp ="0"+temp;
				}
				nid = "N"+temp;
			}
			tx.commit();
			return nid;
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
			
		}
		finally {
			if(tx!=null) {
//				tx.commit();
				tx = null;
			}
		}
	}
}
