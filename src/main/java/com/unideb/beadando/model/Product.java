package com.unideb.beadando.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * this is an entity class.
 * @author gagyi.norbert
 *
 */
@Entity
public class Product {

	/**
	 * id and autoincrement.
	 */
	@Id
	@GeneratedValue
	private int id;

	/**
	 * name tag.
	 */
	private String name;
	/**
	 * price tag.
	 */
	private int price;
	/**
	 * description tag.
	 */
	private String description;
	/**
	 * img1 tag.
	 */
	private String img1;
	/**
	 * img2 tag.
	 */
	private String img2;
	/**
	 * img3. tag.
	 */
	private String img3;
	/**
	 * filter tag which is represent some how what kind of items is for instance men, women ... 
	 */
	private String filter;

	/**
	 * default construct.
	 */
	public Product() {

	}

	/**
	 * construct with some param.
	 * @param name name tag.
	 * @param price price tag.
	 * @param description description tag.
	 * @param img1 img1 tag.
	 * @param img2 img2 tag.
	 * @param img3 img3 tag.
	 * @param filter filter tag.
	 */
	public Product(String name, int price, String description, String img1, String img2, String img3,
			String filter) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.filter = filter;
	}

	/**
	 * id getter.
	 * @return id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * id setter.
	 * @param id new id tag i do not know why is in.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * name getter.
	 * @return name tag.
	 */
	public String getName() {
		return name;
	}

	/**
	 * name setter.
	 * @param name new name tag.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * price getter.
	 * @return price tag.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * price setter.
	 * @param price new price.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * description getter.
	 * @return description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * description setter.
	 * @param description new description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * img1 getter.
	 * @return img1 tag.
	 */
	public String getImg1() {
		return img1;
	}

	/**
	 * img1 setter.
	 * @param img1 img1 tag.
	 */
	public void setImg1(String img1) {
		this.img1 = img1;
	}

	/**
	 * img2 getter.
	 * @return getimg2
	 */
	public String getImg2() {
		return img2;
	}

	/**
	 * img2 setter.
	 * @param img2 img2 tag.
	 */
	public void setImg2(String img2) {
		this.img2 = img2;
	}

	/**
	 * img3 getter.
	 * @return img3.
	 */
	public String getImg3() {
		return img3;
	}

	/**
	 * img3 setter.
	 * @param img3 img3 tag.
	 */
	public void setImg3(String img3) {
		this.img3 = img3;
	}

	/**
	 * filter getter.
	 * @return filter.
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * filter setter.
	 * @param filter new filter.
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Product other = (Product) obj;
		if (obj == null) return false;
		if (this.id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", img1="
			+ img1 + ", img2=" + img2 + ", img3=" + img3 + ", filter=" + filter + "]";
	}
	
	
	
	

}
