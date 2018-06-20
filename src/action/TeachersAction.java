package action;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Teachers;
import service.TeachersDAO;
import service.impl.TeachersDAOImpl;

/**
 *学生Action类
 */
public class TeachersAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//查询所有学生的动作
	public String query() {
		TeachersDAO tdao = new TeachersDAOImpl();
		List<Teachers> list = tdao.queryAllTeachers();
		
		//放进Session中
		if(list !=null && list.size()>0) {
			session.setAttribute("teachers_list", list);
//			return "students_query_success";
		}
		return "query_success";
	}
	
	//删除学生动作
	public String delete() {
		TeachersDAO tdao = new TeachersDAOImpl();
		String tid = request.getParameter("tid");
		tdao.deleteTeachers(tid);
		return "delete_success";
	}
	
	//添加学生的方法
	public String add() throws Exception {
		Teachers t = new Teachers();
		t.setTname(request.getParameter("tname"));
		t.setGenter(request.getParameter("genter"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		t.setBirthday(sdf.parse(request.getParameter("birthday")));
		t.setAddress(request.getParameter("address"));
		TeachersDAO tdao = new TeachersDAOImpl();
		tdao.addTeachers(t);
		return "add_success";
	}
	
	//修改学生资料的动作
	public String modify() {
		//获得传递过来的学生学号
		String tid = request.getParameter("tid");
		TeachersDAO tdao = new TeachersDAOImpl();
		Teachers t = tdao.queryTeachersByTid(tid);
		//保存在会话中
		session.setAttribute("modify_teachers", t);
		return "modify_success";	
	}
	
	//保存修改后的学习动作
	public String save() throws Exception {
		Teachers t = new Teachers();
		t.setTid(request.getParameter("tid"));
		t.setTname(request.getParameter("tname"));
		t.setGenter(request.getParameter("genter"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		t.setBirthday(sdf.parse(request.getParameter("birthday")));
		t.setAddress(request.getParameter("address"));
		TeachersDAO tdao = new TeachersDAOImpl();
		tdao.updateTeachers(t);
		return "save_success";
	}
}
