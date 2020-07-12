package com.atguigu.bean;


import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;
import java.util.Map;

//1.@Value只能获取基本类型，不能获取复杂类型,不能直接注入map类型
/**
 *1.@ConfigurationProperties:可以获取复杂类型的数据，支持松散语法，批量注入，不支持Spring表达式（SPEL），支持数据校验
 * @Value：不能取出复杂类型的数据（Map）,不支持松散语法，一个个注入，支持Spring表达式（SPEL），不支持数据校验
 *2.@Validated:数据校验，需要配合比如@Email使用；
 * 3.@PropertySource(value={"classpath:person.properties"}):获取指定配置文件下的数据，前两个只能获取全局的配置文件的数据
 * 4.@ImportResource(locations = {"classpath:bean.xml"}):在主类中导入spring配置文件，并使其生效
 * 5.@Confuiguration:指明当前是一个配置类，用于替代Spring配置文件; 在配置类中使用@bean把方法的返回值添加到容器
 * 6.张三${random.uuid}：配置文件中可以使用占位符获取随机数; ${person.hello:hello}_dog:占位符可以获取之前配置的值，若没有，则使用冒号后的默认值
 * 7.spring.profiles.active=dev:指定激活配置文件的生产环境(application-dev.properties)
 * 8.配置文件加载顺序：a.项目根目录/config/  -->b.项目根目录/  -->c.classpath/config  -->d.classpath/;
 * 相同的配置高优先级覆盖低优先级，不相同的配置会形成互补配置; 配置文件中spring.config.location可以指定配置文件
 * 9.在配置文件中配置debug=true可以让控制台打印自动配置报告，从而知道哪些自动配置类生效
 */
//@PropertySource(value = {"classpath:person.properties"})//获取专门的类配置

//@Validated//对属性进行校验，@ConfigurationProperties才支持，@Value不支持
@ConfigurationProperties(prefix = "person")//获得全局的配置
@Component
public class Person {

    /**
     * <bean class="Person">
     * <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
     * <bean/>dsadaad
     */


    //lastName必须是邮箱格式
     //@Email
    //@Value("${person.last-name}")
    private String lastName;
    //@Value("#{11*2}")//spring表达式注入22
    private Integer age;
    //@Value("true")
    private Boolean boss;

    private Date birth;
    //@Value("${person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

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

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
