package app.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TextTypeManager entity. @author MyEclipse Persistence Tools
 */

public class TextTypeManager implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer typeId;
	private User user;
	private String username;
	private Integer codelanguage;
	private Integer algorithm;
	private Integer front;
	private Integer back;
	private Integer mobile;
	private Integer bigdata;
	private Integer machinelearning;
	private Integer cloud;
	private Integer ai;
	private Integer othertype;
	private String exp0;
	private String exp1;
	private String exp2;
	private Date exp3;
	private Date exp4;
	private Integer exp5;
	private Long exp6;
	private Short exp7;
	private Double exp8;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public TextTypeManager() {
	}

	/** minimal constructor */
	public TextTypeManager(Integer typeId, String username,
			Integer codelanguage, Integer algorithm, Integer front,
			Integer back, Integer mobile, Integer bigdata,
			Integer machinelearning, Integer cloud, Integer ai,
			Integer othertype) {
		this.typeId = typeId;
		this.username = username;
		this.codelanguage = codelanguage;
		this.algorithm = algorithm;
		this.front = front;
		this.back = back;
		this.mobile = mobile;
		this.bigdata = bigdata;
		this.machinelearning = machinelearning;
		this.cloud = cloud;
		this.ai = ai;
		this.othertype = othertype;
	}

	/** full constructor */
	public TextTypeManager(Integer typeId, User user, String username,
			Integer codelanguage, Integer algorithm, Integer front,
			Integer back, Integer mobile, Integer bigdata,
			Integer machinelearning, Integer cloud, Integer ai,
			Integer othertype, String exp0, String exp1, String exp2,
			Date exp3, Date exp4, Integer exp5, Long exp6, Short exp7,
			Double exp8, Set users) {
		this.typeId = typeId;
		this.user = user;
		this.username = username;
		this.codelanguage = codelanguage;
		this.algorithm = algorithm;
		this.front = front;
		this.back = back;
		this.mobile = mobile;
		this.bigdata = bigdata;
		this.machinelearning = machinelearning;
		this.cloud = cloud;
		this.ai = ai;
		this.othertype = othertype;
		this.exp0 = exp0;
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.exp3 = exp3;
		this.exp4 = exp4;
		this.exp5 = exp5;
		this.exp6 = exp6;
		this.exp7 = exp7;
		this.exp8 = exp8;
		this.users = users;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCodelanguage() {
		return this.codelanguage;
	}

	public void setCodelanguage(Integer codelanguage) {
		this.codelanguage = codelanguage;
	}

	public Integer getAlgorithm() {
		return this.algorithm;
	}

	public void setAlgorithm(Integer algorithm) {
		this.algorithm = algorithm;
	}

	public Integer getFront() {
		return this.front;
	}

	public void setFront(Integer front) {
		this.front = front;
	}

	public Integer getBack() {
		return this.back;
	}

	public void setBack(Integer back) {
		this.back = back;
	}

	public Integer getMobile() {
		return this.mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public Integer getBigdata() {
		return this.bigdata;
	}

	public void setBigdata(Integer bigdata) {
		this.bigdata = bigdata;
	}

	public Integer getMachinelearning() {
		return this.machinelearning;
	}

	public void setMachinelearning(Integer machinelearning) {
		this.machinelearning = machinelearning;
	}

	public Integer getCloud() {
		return this.cloud;
	}

	public void setCloud(Integer cloud) {
		this.cloud = cloud;
	}

	public Integer getAi() {
		return this.ai;
	}

	public void setAi(Integer ai) {
		this.ai = ai;
	}

	public Integer getOthertype() {
		return this.othertype;
	}

	public void setOthertype(Integer othertype) {
		this.othertype = othertype;
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

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}