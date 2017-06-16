package org.sangaizhi.mdoel;

import javax.persistence.*;

/**
 * @author sangaizhi
 * @date 2017/6/16
 */
@Entity
@Table(name="t_user")
@NamedQuery(name = "User.findByNameWithNamedQuery", query = "SELECT u FROM User u WHERE u.name=?1")
public class User {

    @Id
    @GeneratedValue
	private Long id;
    @Column(name = "name")
	private String name;
    @Column(name = "age")
	private Integer age;
    @Column(name = "address")
	private String address;

	public User() {
	}

	public User(String name, Integer age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
