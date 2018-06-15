package tonyan.chat.com.tchat.data.model;

/**
 * Created by tonyan on 2018/6/14.
 */

public class FriendItem {
    String url;
    String name;
    String desc;

    public FriendItem(String url, String name, String desc) {
        this.url = url;
        this.name = name;
        this.desc = desc;
    }

    public FriendItem(String name) {
        this.name = name;
    }

    public FriendItem(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
