package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import db.MyHibernateSessionFactoty;
import entity.Students;
import service.StudentsDAO;

/**
 *学生业务逻辑接口的实现类
 */
public class StudentsDAOImpl implements StudentsDAO{
	
	//查询所有学生资料
	@Override
	public List<Students> queryAllStudents() {
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			//开启事务
			tx = session.beginTransaction();
			hql = "	from Students";
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
	public Students queryStudentsBySid(String sid) {
		Transaction tx = null;
		Students s = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			//开启事务
			tx = session.beginTransaction();
			s = (Students)session.get(Students.class, sid);
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
	public boolean addStudents(Students s) {
		s.setSid(getNewSid()); //设置学生的学号
		Transaction tx = null;
//		String hql = "";
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
//			hql = "insert into Students values(?,?,?,?,?,?)";
//			Query query = session.createQuery(hql);
			session.save(s);
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
	public boolean updateStudents(Students s) {
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
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
	public boolean deleteStudents(String sid) {
		
		Transaction tx = null;
//		String hql = "";
		
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students s = (Students)session.get(Students.class, sid);
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
	private String getNewSid() {
		
		Transaction tx = null;
		String hql = "";
		String sid = null;
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//获得当前学生的最大编号
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String)query.uniqueResult();
			System.out.println(sid);
			if(sid==null||"".equals(sid)) {
				//给一个默认的最大编号
				sid = "S0000001";
			}else {
				String temp = sid.substring(1);//区后七位
				int i = Integer.parseInt(temp);//转成数字
				i++;
				
				//再还原成字符串
				temp = String.valueOf(i);
				int len = temp.length();
				//凑足7位
				for(int j=0;j<6;j++) {
					temp ="0"+temp;
				}
				sid = "S"+temp;
			}
			tx.commit();
			return sid;
			
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
