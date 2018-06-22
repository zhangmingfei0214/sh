package action;


import java.text.SimpleDateFormat;
import java.util.List;

import entity.News;
import service.NewsDAO;
import service.impl.NewsDAOImpl;

/**
 *学生Action类
 */
public class NewsAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//查询所有
	public String query() {
		NewsDAO ndao = new NewsDAOImpl();
		List<News> list = ndao.queryAllNews();
		
		if(list != null && list.size() >0) {
			session.setAttribute("news_list", list);
		}
		return "query_success";	
	}
	
	//删除动作
	public String delete() {
		NewsDAO ndao = new NewsDAOImpl();
		String nid = request.getParameter("nid");
		ndao.deleteNews(nid);
		return "delete_success";
	}
	
	//添加动作
	public String add() throws Exception {
		News n = new News();
		n.setAuthor(request.getParameter("author"));
		n.setContent(request.getParameter("content"));
		n.setKeywords(request.getParameter("keywords"));
		n.setTitle(request.getParameter("title"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		n.setReleaseTime(sdf.parse(request.getParameter("releaseTime")));
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		n.setUpdateTime(sdf1.parse(request.getParameter("updateTime")));
		NewsDAO ndao = new NewsDAOImpl();
		ndao.addNews(n);
		return "add_success";
	}
	
	//修改信息资料
	public String modify() {
		String nid = request.getParameter("nid");
		NewsDAO ndao = new NewsDAOImpl();
		News n = ndao.queryNewsByNid(nid);
		
		session.setAttribute("modify_news", n);
		return "modify_success";
	}
	
	//保存修改后的学生动作
	public String save() throws Exception {
		News n = new News();
		n.setNid(request.getParameter("nid"));
		n.setAuthor(request.getParameter("author"));
		n.setContent(request.getParameter("content"));
		n.setKeywords(request.getParameter("keywords"));
		n.setTitle(request.getParameter("title"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		n.setReleaseTime(sdf.parse(request.getParameter("releaseTime")));
		n.setUpdateTime(sdf.parse(request.getParameter("updateTime")));
		NewsDAO ndao = new NewsDAOImpl();
		ndao.updateNews(n);
		return "save_success";
	}
	
}
