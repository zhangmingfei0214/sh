package service.impl;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import db.MyHibernateSessionFactoty;
import entity.Users;
import service.UsersDAO;

public class UsersDAOImpl implements UsersDAO{

	@Override
	public boolean usersLogin(Users u) {
		
		Transaction tx = null;
		String hql = "";
		
		try {
			Session session = MyHibernateSessionFactoty.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			
//			Query query=session.createQuery("from Users where username=? and password=? ");
//			query.setParameter(0, u.getUsername());
//			query.setParameter(1, u.getPassword());
//			List list = new ArrayList<Users>();
			List	list = query.list();
			tx.commit();//提交事务
			
			if(list.size()>0) {
				return true;
			} else {
				return false;
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		//释放资源
		finally {
			if(tx!=null) {
//				tx.commit();
				tx=null;
			}
		}
	}

}
