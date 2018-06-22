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
	//查询所有信息资料
	@Override
	public List<News> queryAllNews() {
		Transaction tx = null;
		List<News> list = null;
		try {
			String hql = "";
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from News";
			Query query = session.createQuery(hql);
			
			list = query.list();
			//提交事务
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if(tx != null) {
//				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public News queryNewsByNid(String nid) {
		Transaction tx = null;
		News n = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			//开启事务
			tx = session.beginTransaction();
			n = session.get(News.class, nid);
			//提交事务
			tx.commit();
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return n;
		} finally {
			if(tx != null) {
//				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public boolean addNews(News n) {
		n.setNid(getNewNid());
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
//			hql = "insert into News values(?,?,?,?,?,?,?,?)";
//			Query query = session.createQuery(hql);
			session.save(n);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if(tx != null) {
//				tx.commit();
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
			session.save(n);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if(tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean deleteNews(String nid) {
		Transaction tx = null;
		try {
			Session session  = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			News n = session.get(News.class, nid);
			session.delete(n);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if(tx != null) {
				tx = null;
			}
		}
	}
	private String getNewNid() {
		Transaction tx = null;
		String hql = "";
		String nid = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select max(nid) from News";
			Query query = session.createQuery(hql);
			nid = (String) query.uniqueResult();
			if(nid == null || "".equals(nid)) {
				nid = "N0000001";
			} else {
				
				String temp = nid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				
				temp = String.valueOf(i);
				int len = temp.length();
				
				for(int j = 0;j<6;j++) {
					temp = "0"+temp;
				}
				nid = "N"+temp;
			}
			tx.commit();
			return nid;
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
			
		} finally {
			if(tx!=null) {
//				tx.commit();
				tx = null;
			}
		}
	}
	
}
