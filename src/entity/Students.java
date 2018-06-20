package entity;

import java.util.Date;

/**
 *学生实体类
 */
public class Students {
	private String sid;
	private String sname;
	private String genter;
	private Date birthday;
	private String address;
	
	public Students() {
		
	}
	
	public Students(String sid, String sname, String genter, Date birthday, String address) {
//		super();
		this.sid = sid;
		this.sname = sname;
		this.genter = genter;
		this.birthday = birthday;
		this.address = address;
	}

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGenter() {
		return genter;
	}
	public void setGenter(String genter) {
		this.genter = genter;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", genter=" + genter + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}	
}
