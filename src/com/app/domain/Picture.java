package app.domain;

import java.util.Date;

/**
 * Picture entity. @author MyEclipse Persistence Tools
 */

public class Picture implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer picId;
	private User user;
	private String foruser;
	private String picurl;
	private Date uploadtime;
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
	public Picture() {
	}

	/** minimal constructor */
	public Picture(Integer picId, String foruser, String picurl, Date uploadtime) {
		this.picId = picId;
		this.foruser = foruser;
		this.picurl = picurl;
		this.uploadtime = uploadtime;
	}

	/** full constructor */
	public Picture(Integer picId, User user, String foruser, String picurl,
			Date uploadtime, String exp0, String exp1, String exp2, Date exp3,
			Date exp4, Integer exp5, Long exp6, Short exp7, Double exp8) {
		this.picId = picId;
		this.user = user;
		this.foruser = foruser;
		this.picurl = picurl;
		this.uploadtime = uploadtime;
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

	public Integer getPicId() {
		return this.picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getForuser() {
		return this.foruser;
	}

	public void setForuser(String foruser) {
		this.foruser = foruser;
	}

	public String getPicurl() {
		return this.picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public Date getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
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