package service;

import java.util.List;
import entity.News;

/**
 *学生的业务逻辑接口
 */
public interface NewsDAO {
	
	//查询所有的信息
	public List<News> queryAllNews();
	
	//根据编号查询信息资料
	public News queryNewsByNid(String nid);
	
	//添加信息资料
	public boolean addNews(News n);
	
	//修改信息资料
	public boolean updateNews(News n);
	
	//删除信息资料
	public boolean deleteNews(String nid);
}
