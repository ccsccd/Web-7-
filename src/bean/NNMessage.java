package bean;

import java.sql.Date;
import java.util.List;

public class NNMessage {
    private int id;
    private int pid;
    private String name;
    private Date time;
    private String title;
    private String message;
    private List<NNMessage> childContent;
    public NNMessage() {
    }
    public NNMessage(String name,String title, String message, int pid) {
        this.name = name;
        this.title = title;
        this.message = message;
        this.time = new Date(System.currentTimeMillis());
        this.pid = pid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time=time;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message=message;
    }
    public List<NNMessage> getChildContent() {
        return childContent;
    }

    public void setChildContent(List<NNMessage> childContent) {
        this.childContent = childContent;
    }

}

