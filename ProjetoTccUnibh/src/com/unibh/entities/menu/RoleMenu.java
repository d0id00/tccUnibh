/**
 * 
 */
package com.unibh.entities.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.unibh.entities.AbstractEntity;
import com.unibh.entities.role.Role;

/**
 * @author Andre
 *
 */
@SuppressWarnings("serial")
@Entity
public class RoleMenu extends AbstractEntity {

	@Id
	@GeneratedValue
	@Column(name = "idRoleMenu")
	private Integer id;
	
	@ManyToOne
	private Role role;
	
	@ManyToOne
	private Menu menu;
	
	public RoleMenu() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
