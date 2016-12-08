package app.domain;

import java.util.Date;

/**
 * CollectionText entity. @author MyEclipse Persistence Tools
 */

public class CollectionText implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private CollectionTextId id;
	private String colText;
	private String colUsername;
	private String colUrl;
	private Date colTime;
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
	public CollectionText() {
	}

	/** minimal constructor */
	public CollectionText(CollectionTextId id, String colText,
			String colUsername, String colUrl, Date colTime) {
		this.id = id;
		this.colText = colText;
		this.colUsername = colUsername;
		this.colUrl = colUrl;
		this.colTime = colTime;
	}

	/** full constructor */
	public CollectionText(CollectionTextId id, String colText,
			String colUsername, String colUrl, Date colTime, String exp0,
			String exp1, String exp2, Date exp3, Date exp4, Integer exp5,
			Long exp6, Short exp7, Double exp8) {
		this.id = id;
		this.colText = colText;
		this.colUsername = colUsername;
		this.colUrl = colUrl;
		this.colTime = colTime;
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

	public CollectionTextId getId() {
		return this.id;
	}

	public void setId(CollectionTextId id) {
		this.id = id;
	}

	public String getColText() {
		return this.colText;
	}

	public void setColText(String colText) {
		this.colText = colText;
	}

	public String getColUsername() {
		return this.colUsername;
	}

	public void setColUsername(String colUsername) {
		this.colUsername = colUsername;
	}

	public String getColUrl() {
		return this.colUrl;
	}

	public void setColUrl(String colUrl) {
		this.colUrl = colUrl;
	}

	public Date getColTime() {
		return this.colTime;
	}

	public void setColTime(Date colTime) {
		this.colTime = colTime;
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