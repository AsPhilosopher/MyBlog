package app.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer userId;
	private TextTypeManager textTypeManager;
	private String username;
	private Short sex;
	private String password;
	private String truename;
	private String email;
	private Date birthday;
	private Date createtime;
	private Integer blognum;
	private Integer accesstimes;
	private String exp0;
	private String exp1;
	private String exp2;
	private Date exp3;
	private Date exp4;
	private Integer exp5;
	private Long exp6;
	private Short exp7;
	private Double exp8;
	private Set textTypeManagers = new HashSet(0);
	private Set blogtexts = new HashSet(0);
	private Set pictures = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer userId, String username, Short sex, String password,
			String truename, String email, Date birthday, Date createtime,
			Integer blognum, Integer accesstimes) {
		this.userId = userId;
		this.username = username;
		this.sex = sex;
		this.password = password;
		this.truename = truename;
		this.email = email;
		this.birthday = birthday;
		this.createtime = createtime;
		this.blognum = blognum;
		this.accesstimes = accesstimes;
	}

	/** full constructor */
	public User(Integer userId, TextTypeManager textTypeManager,
			String username, Short sex, String password, String truename,
			String email, Date birthday, Date createtime, Integer blognum,
			Integer accesstimes, String exp0, String exp1, String exp2,
			Date exp3, Date exp4, Integer exp5, Long exp6, Short exp7,
			Double exp8, Set textTypeManagers, Set blogtexts, Set pictures) {
		this.userId = userId;
		this.textTypeManager = textTypeManager;
		this.username = username;
		this.sex = sex;
		this.password = password;
		this.truename = truename;
		this.email = email;
		this.birthday = birthday;
		this.createtime = createtime;
		this.blognum = blognum;
		this.accesstimes = accesstimes;
		this.exp0 = exp0;
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.exp3 = exp3;
		this.exp4 = exp4;
		this.exp5 = exp5;
		this.exp6 = exp6;
		this.exp7 = exp7;
		this.exp8 = exp8;
		this.textTypeManagers = textTypeManagers;
		this.blogtexts = blogtexts;
		this.pictures = pictures;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public TextTypeManager getTextTypeManager() {
		return this.textTypeManager;
	}

	public void setTextTypeManager(TextTypeManager textTypeManager) {
		this.textTypeManager = textTypeManager;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getBlognum() {
		return this.blognum;
	}

	public void setBlognum(Integer blognum) {
		this.blognum = blognum;
	}

	public Integer getAccesstimes() {
		return this.accesstimes;
	}

	public void setAccesstimes(Integer accesstimes) {
		this.accesstimes = accesstimes;
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

	public Set getTextTypeManagers() {
		return this.textTypeManagers;
	}

	public void setTextTypeManagers(Set textTypeManagers) {
		this.textTypeManagers = textTypeManagers;
	}

	public Set getBlogtexts() {
		return this.blogtexts;
	}

	public void setBlogtexts(Set blogtexts) {
		this.blogtexts = blogtexts;
	}

	public Set getPictures() {
		return this.pictures;
	}

	public void setPictures(Set pictures) {
		this.pictures = pictures;
	}

}