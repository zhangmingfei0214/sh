package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import db.MyHibernateSessionFactoty;
import entity.Students;
import entity.Teachers;
import service.StudentsDAO;
import service.TeachersDAO;

/**
 *学生业务逻辑接口的实现类
 */
public class TeachersDAOImpl implements TeachersDAO{
	@Override
	public List<Teachers> queryAllTeachers() {
		Transaction tx = null;
		List<Teachers> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			//开启事务
			tx = session.beginTransaction();
			hql = "	from Teachers";
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
	public Teachers queryTeachersByTid(String tid) {
		Transaction tx = null;
		Teachers t = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			//开启事务
			tx = session.beginTransaction();
			t = (Teachers)session.get(Teachers.class, tid);
			//提交事务
			tx.commit();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return t;
		}
		finally {
			if(tx!=null) {
//				tx.commit();
				tx = null;
			}
		}
	}

	@Override
	public boolean addTeachers(Teachers t) {
		t.setTid(getNewTid()); //设置学生的学号
		Transaction tx = null;
//		String hql = "";
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
//			hql = "insert into Students values(?,?,?,?,?,?)";
//			Query query = session.createQuery(hql);
			session.save(t);
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
	public boolean updateTeachers(Teachers t) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(t);
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
	public boolean deleteTeachers(String tid) {
		Transaction tx = null;
//		String hql = "";
		
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Teachers t = (Teachers)session.get(Teachers.class, tid);
			session.delete(t);
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
	private String getNewTid() {
		Transaction tx = null;
		String hql = "";
		String tid = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//获得当前学生的最大编号
			hql = "select max(tid) from Teachers";
			Query query = session.createQuery(hql);
			tid = (String)query.uniqueResult();
			System.out.println(tid);
			if(tid==null||"".equals(tid)) {
				//给一个默认的最大编号
				tid = "T0000001";
			}else {
				String temp = tid.substring(1);//区后七位
				int i = Integer.parseInt(temp);//转成数字
				i++;
				
				//再还原成字符串
				temp = String.valueOf(i);
				int len = temp.length();
				//凑足7位
				for(int j=0;j<6;j++) {
					temp ="0"+temp;
				}
				tid = "T"+temp;
			}
			tx.commit();
			return tid;
			
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
