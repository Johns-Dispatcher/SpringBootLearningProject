package pers.johns.springboot.bean;

/**
 * ClassName    : MyServer
 * Description  :
 * CreateTime   : 2024/6/1 18:37
 *
 * @author : JohnS
 * @version : 1.0
 */
public class MyServer {
    private String title;
    private String ip;

    public MyServer() {
    }

    public MyServer(String title, String ip) {
        this.title = title;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "MyServer{" +
                "title='" + title + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
