package org.sangaizhi.springboot.ch3.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author sangaizhi
 * @date 2017/6/7
 */
@Component

@ConfigurationProperties(prefix = "org.sangaizhi.model")
@PropertySource("classpath:TestProperties.properties")
public class TestProperties {

    private Long id;
    private int number;
    private int random1;
    private int random2;
    private String name;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRandom1() {
        return random1;
    }

    public void setRandom1(int random1) {
        this.random1 = random1;
    }

    public int getRandom2() {
        return random2;
    }

    public void setRandom2(int random2) {
        this.random2 = random2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestProperties{" +
                "id=" + id +
                ", number=" + number +
                ", random1=" + random1 +
                ", random2=" + random2 +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
