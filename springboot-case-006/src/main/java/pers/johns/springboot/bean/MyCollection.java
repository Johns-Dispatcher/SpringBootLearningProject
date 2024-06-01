package pers.johns.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ClassName    : MyCollection
 * Description  :
 * CreateTime   : 2024/6/1 18:38
 *
 * @author : JohnS
 * @version : 1.0
 */

@ConfigurationProperties
public class MyCollection {
    private List<MyServer> servers;
    private Map<String, User> users;
    private String[] names;

    public MyCollection() {
    }

    public MyCollection(List<MyServer> servers, Map<String, User> users, String[] names) {
        this.servers = servers;
        this.users = users;
        this.names = names;
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "servers=" + servers +
                ", users=" + users +
                ", names=" + Arrays.toString(names) +
                '}';
    }

    public List<MyServer> getServers() {
        return servers;
    }

    public void setServers(List<MyServer> servers) {
        this.servers = servers;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}
