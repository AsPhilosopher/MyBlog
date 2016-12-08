package app.domain;

import java.util.Date;

/**
 * Blogtext entity. @author MyEclipse Persistence Tools
 */

public class Blogtext implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer btId;
	private TextType textType;
	private User user;
	private String title;
	private String authorname;
	private String btType;
	private String blogtext;
	private Integer readtimes;
	private String bturl;
	private Integer good;
	private Integer bad;
	private Integer collection;
	private Date publishtime;
	private Date lastmodify;
	private String exp0;
	private String exp1;
	private String exp2;
	private Date exp3;
	private Date exp4;
	private Integer exp5;
	private Long exp6;
	private Short exp7;
	private Double exp8;

	// Constructors

	/** default constructor */
	public Blogtext() {
	}

	/** minimal constructor */
	public Blogtext(Integer btId, String title, String authorname,
			String btType, String blogtext, Integer readtimes, String bturl,
			Integer good, Integer bad, Integer collection, Date publishtime,
			Date lastmodify) {
		this.btId = btId;
		this.title = title;
		this.authorname = authorname;
		this.btType = btType;
		this.blogtext = blogtext;
		this.readtimes = readtimes;
		this.bturl = bturl;
		this.good = good;
		this.bad = bad;
		this.collection = collection;
		this.publishtime = publishtime;
		this.lastmodify = lastmodify;
	}

	/** full constructor */
	public Blogtext(Integer btId, TextType textType, User user, String title,
			String authorname, String btType, String blogtext,
			Integer readtimes, String bturl, Integer good, Integer bad,
			Integer collection, Date publishtime, Date lastmodify, String exp0,
			String exp1, String exp2, Date exp3, Date exp4, Integer exp5,
			Long exp6, Short exp7, Double exp8) {
		this.btId = btId;
		this.textType = textType;
		this.user = user;
		this.title = title;
		this.authorname = authorname;
		this.btType = btType;
		this.blogtext = blogtext;
		this.readtimes = readtimes;
		this.bturl = bturl;
		this.good = good;
		this.bad = bad;
		this.collection = collection;
		this.publishtime = publishtime;
		this.lastmodify = lastmodify;
		this.exp0 = exp0;
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.exp3 = exp3;
		this.exp4 = exp4;
		this.exp5 = exp5;
		this.exp6 = exp6;
		this.exp7 = exp7;
		this.exp8 = exp8;
	}

	// Property accessors

	public Integer getBtId() {
		return this.btId;
	}

	public void setBtId(Integer btId) {
		this.btId = btId;
	}

	public TextType getTextType() {
		return this.textType;
	}

	public void setTextType(TextType textType) {
		this.textType = textType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorname() {
		return this.authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getBtType() {
		return this.btType;
	}

	public void setBtType(String btType) {
		this.btType = btType;
	}

	public String getBlogtext() {
		return this.blogtext;
	}

	public void setBlogtext(String blogtext) {
		this.blogtext = blogtext;
	}

	public Integer getReadtimes() {
		return this.readtimes;
	}

	public void setReadtimes(Integer readtimes) {
		this.readtimes = readtimes;
	}

	public String getBturl() {
		return this.bturl;
	}

	public void setBturl(String bturl) {
		this.bturl = bturl;
	}

	public Integer getGood() {
		return this.good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}

	public Integer getBad() {
		return this.bad;
	}

	public void setBad(Integer bad) {
		this.bad = bad;
	}

	public Integer getCollection() {
		return this.collection;
	}

	public void setCollection(Integer collection) {
		this.collection = collection;
	}

	public Date getPublishtime() {
		return this.publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public Date getLastmodify() {
		return this.lastmodify;
	}

	public void setLastmodify(Date lastmodify) {
		this.lastmodify = lastmodify;
	}

	public String getExp0() {
		return this.exp0;
	}

	public void setExp0(String exp0) {
		this.exp0 = exp0;
	}

	public String getExp1() {
		return this.exp1;
	}

	public void setExp1(String exp1) {
		this.exp1 = exp1;
	}

	public String getExp2() {
		return this.exp2;
	}

	public void setExp2(String exp2) {
		this.exp2 = exp2;
	}

	public Date getExp3() {
		return this.exp3;
	}

	public void setExp3(Date exp3) {
		this.exp3 = exp3;
	}

	public Date getExp4() {
		return this.exp4;
	}

	public void setExp4(Date exp4) {
		this.exp4 = exp4;
	}

	public Integer getExp5() {
		return this.exp5;
	}

	public void setExp5(Integer exp5) {
		this.exp5 = exp5;
	}

	public Long getExp6() {
		return this.exp6;
	}

	public void setExp6(Long exp6) {
		this.exp6 = exp6;
	}

	public Short getExp7() {
		return this.exp7;
	}

	public void setExp7(Short exp7) {
		this.exp7 = exp7;
	}

	public Double getExp8() {
		return this.exp8;
	}

	public void setExp8(Double exp8) {
		this.exp8 = exp8;
	}

}