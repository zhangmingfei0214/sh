package entity;

import java.util.Date;

/**
 * 新闻管理实体类
 */
public class News {
	private String nid;// 编号
	private String title;// 主题
	private String author;// 作者
	private Date releaseTime;// 发布时间;
	private Date updateTime;// 修改时间
	private String content;// 内容
	private String keywords;// 关键字

	public News() {

	}

	public News(String nid, String title, String author, Date releaseTime, Date updateTime, String content,
			String keywords) {
		// super();
		this.nid = nid;
		this.title = title;
		this.author = author;
		this.releaseTime = releaseTime;
		this.updateTime = updateTime;
		this.content = content;
		this.keywords = keywords;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", author=" + author + ", releaseTime=" + releaseTime
				+ ", updateTime=" + updateTime + ", content=" + content + ", keywords=" + keywords + "]";
	}
}
