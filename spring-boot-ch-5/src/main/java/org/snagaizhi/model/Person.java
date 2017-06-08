package org.snagaizhi.model;

/**
 * @author sangaizhi
 * @date 2017/6/8
 */
public class Person {
    private String name;
    private Integer age;
    private Short sex;

    public Person(){}
    public Person(String name, Integer age, Short sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }
}
