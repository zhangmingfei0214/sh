package entity;

import java.util.Date;

/**
 *学生实体类
 */
public class Teachers {
	private String tid;
	private String tname;
	private String genter;
	private Date birthday;
	private String address;
	
	public Teachers() {
		
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
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

	public Teachers(String tid, String tname, String genter, Date birthday, String address) {
//		super();
		this.tid = tid;
		this.tname = tname;
		this.genter = genter;
		this.birthday = birthday;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Teachers [tid=" + tid + ", tname=" + tname + ", genter=" + genter + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}
	
}
