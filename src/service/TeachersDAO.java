package service;

import java.util.List;

import entity.Students;
import entity.Teachers;

/**
 *学生的业务逻辑接口
 */
public interface TeachersDAO {
	
	//查询所有学生的资料
	public List<Teachers> queryAllTeachers();
	
	//根据学生编号查询学生资料
	public Teachers queryTeachersByTid(String tid);
	
	//添加学生资料
	public boolean addTeachers(Teachers t);
	
	//修改学生资料
	public boolean updateTeachers(Teachers t);
	
	//删除学生资料
	public boolean deleteTeachers(String tid);
}
