package org.sangaizhi.springboot.ch6.model;

/**
 * @author sangaizhi
 * @date 2017/6/9
 */
public class User {
    private Long id;
    private String name;

    public User(){}
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
