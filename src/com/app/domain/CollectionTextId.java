package app.domain;

/**
 * CollectionTextId entity. @author MyEclipse Persistence Tools
 */

public class CollectionTextId implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer colUserId;
	private Integer colTextId;

	// Constructors

	/** default constructor */
	public CollectionTextId() {
	}

	/** full constructor */
	public CollectionTextId(Integer colUserId, Integer colTextId) {
		this.colUserId = colUserId;
		this.colTextId = colTextId;
	}

	// Property accessors

	public Integer getColUserId() {
		return this.colUserId;
	}

	public void setColUserId(Integer colUserId) {
		this.colUserId = colUserId;
	}

	public Integer getColTextId() {
		return this.colTextId;
	}

	public void setColTextId(Integer colTextId) {
		this.colTextId = colTextId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CollectionTextId))
			return false;
		CollectionTextId castOther = (CollectionTextId) other;

		return ((this.getColUserId() == castOther.getColUserId()) || (this
				.getColUserId() != null && castOther.getColUserId() != null && this
				.getColUserId().equals(castOther.getColUserId())))
				&& ((this.getColTextId() == castOther.getColTextId()) || (this
						.getColTextId() != null
						&& castOther.getColTextId() != null && this
						.getColTextId().equals(castOther.getColTextId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getColUserId() == null ? 0 : this.getColUserId().hashCode());
		result = 37 * result
				+ (getColTextId() == null ? 0 : this.getColTextId().hashCode());
		return result;
	}

}