/**
 * 
 */
package com.unibh.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * @author Andre
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable, Comparable<AbstractEntity> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || !isInstance(obj)) {
			return false;
		}
		if (getId() == null || ((AbstractEntity) obj).getId() == null) {
			return false;
		}
		return this.getId().equals(((AbstractEntity) obj).getId());
	}

	protected boolean isInstance(Object obj) {
		return (getClass().isInstance(obj));
	}

	@Override
	public int hashCode() {
		if (this.getId() == null) {
			return super.hashCode();
		}
		return this.getId().hashCode();
	}

	public int getHashCode() {
		return hashCode();
	}
	
	public int compareTo(AbstractEntity obj) {
		if (obj == null) {
			return 1;
		}
		if (getId() != null && obj.getId() != null) {
			return getId().compareTo(obj.getId());
		}
		if (getId() == null && obj.getId() == null) {
			return 0;
		}
		return getId() == null ? -1 : 1;
	}
	
	public abstract Integer getId();
	
}
