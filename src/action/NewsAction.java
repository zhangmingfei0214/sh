package action;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.News;
import service.NewsDAO;
import service.impl.NewsDAOImpl;

/**
 *Action类
 */
public class NewsAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//查询所有学生的动作
	public String query() {
		NewsDAO ndao = new NewsDAOImpl();
		List<News> list = ndao.queryAllNews();
		
		//放进Session中
		if(list !=null && list.size()>0) {
			session.setAttribute("news_list", list);
//			return "students_query_success";
		}
		return "query_success";
	}
	
	//删除学生动作
	public String delete() {
		NewsDAO ndao = new NewsDAOImpl();
		String nid = request.getParameter("nid");
		ndao.deleteNews(nid);
		return "delete_success";
	}
	
	//添加学生的方法
	public String add() throws Exception {
		News n = new News();
		n.setTitle((request.getParameter("title")));
		n.setAuthor((request.getParameter("author")));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		n.setReleaseTime((sdf.parse(request.getParameter("releaseTime"))));
		n.setUpdateTime((sdf.parse(request.getParameter("updateTime"))));
		n.setContent((request.getParameter("content")));
		n.setKeywords(((request.getParameter("keywords"))));
		NewsDAO sdao = new NewsDAOImpl();
		sdao.addNews(n);
		return "add_success";
	}
	
	//修改学生资料的动作
	public String modify() {
		//获得传递过来的学生学号
		String nid = request.getParameter("nid");
		NewsDAO ndao = new NewsDAOImpl();
		News n = ndao.queryNewsByNid(nid);
		//保存在会话中
		session.setAttribute("modify_news", n);
		return "modify_success";	
	}
	
	//保存修改后的学习动作
	public String save() throws Exception {
		News n = new News();
		n.setNid(request.getParameter("nid"));
		n.setTitle((request.getParameter("title")));
		n.setAuthor((request.getParameter("author")));
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		n.setReleaseTime((sdf.parse(request.getParameter("releaseTime"))));
//		n.setUpdateTime((sdf.parse(request.getParameter("updateTime"))));
		n.setContent((request.getParameter("content")));
		n.setKeywords(((request.getParameter("keywords"))));
		NewsDAO sdao = new NewsDAOImpl();
		sdao.updateNews(n);
		return "save_success";
	}
}
