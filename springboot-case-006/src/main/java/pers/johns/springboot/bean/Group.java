package pers.johns.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * ClassName    : Group
 * Description  :
 * CreateTime   : 2024/6/1 21:59
 *
 * @author : JohnS
 * @version : 1.0
 */

@Configuration
@ConfigurationProperties(prefix = "group")
@PropertySource("classpath:/group-info.properties")
public class Group {

    private String name;
    private String leader;
    private Integer members;

    public Group() {
    }

    public Group(String name, String leader, Integer members) {
        this.name = name;
        this.leader = leader;
        this.members = members;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", leader='" + leader + '\'' +
                ", members=" + members +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }
}
