package com.unideb.beadando.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *user entity class it has special jpql example which is i think anti pattern.
 * @author gagyi.norbert
 *
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "find_all_users", query = "SELECT u FROM User u")
public class User {

	/**
	 * username tag which is id and must not be emtpy.
	 */
	@NotEmpty(message = "{user.username.notnull}")
	@Column(name = "username")
	@Id
	private String userName;

	/**
	 * password tag which is not be emtpy.
	 */
	@NotEmpty
	@Column(name = "password")
	private String password;

	/**
	 * default construct.
	 */
	public User() {
	}

	/**
	 * construct with username and password.
	 * @param username username tag.
	 * @param password password tag.
	 */
	public User(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	/**
	 * username getter.
	 * @return username.
	 */
	public String getUsername() {
		return userName;
	}

	/**
	 * username setter.
	 * @param username usnerma tag.
	 */
	public void setUsername(String username) {
		this.userName = username;
	}

	/**
	 * password getter.
	 * @return password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password setter.
	 * @param password password tag.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	

}
