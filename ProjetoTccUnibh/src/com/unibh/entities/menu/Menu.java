/**
 * 
 */
package com.unibh.entities.menu;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.unibh.entities.AbstractEntity;

/**
 * @author Andre
 *
 */
@SuppressWarnings("serial")
@Entity
public class Menu extends AbstractEntity {

	@Id
	@GeneratedValue
	@Column(name = "idMenu")
	private Integer id;
	
	@Column(length = 80)
	private String nome;
	
	@ManyToOne
	private Menu menu;
	
	@OneToMany
	private Set<Menu> menus;
	
	@OneToMany
	private Set<RoleMenu> roleMenu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Set<RoleMenu> getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(Set<RoleMenu> roleMenu) {
		this.roleMenu = roleMenu;
	}

}
