package com.mengxuegu.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 1、@ConfigurationProperties 告诉SpringBoot将配置文件中对应属性的值，映射到这个组件类中,进
 * 行一一绑定
 * prefix = "emp"：配置文件中的前缀名，哪个前缀与下面的所有属性进行一一映射
 * 2、@Component 必须将当前组件作为SpringBoot中的一个组件，才能使用容器提供的@ConfigurationProperties功能；
 * @Validated 校验
 * @PropertySource ：加载指定的配置文件; value 属性是数组类型, 用于指定文件位置
 */
@PropertySource(value = {"classpath:emp.properties"})
//@Validated
@Component
@ConfigurationProperties(prefix = "emp")
public class Emp {
    /**
     * 类似spring中使用配置文件中的数据注入方式
     * <bean class="emp">
     *      <property name="lastName" value="字面量/#{SpEl} spring表达式/${key}从配置文件获取"></property>
     *  </bean>
     */
//    @Value("${emp.last-name}")
//            @Email
    private String lastName;
//    @Value("#{10*2}")
    private  Integer age;
//    @Value("8000")
    private  Double salary;
    private Boolean boss;
    private Date birthday;

    private Map map;
    private List list;

    private Forte forte;//特长

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Forte getForte() {
        return forte;
    }

    public void setForte(Forte forte) {
        this.forte = forte;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", map=" + map +
                ", list=" + list +
                ", forte=" + forte +
                '}';
    }
}
