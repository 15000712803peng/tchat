package tonyan.chat.com.tchat.data.model;

/**
 * Created by tonyan on 2018/6/13.
 */

public class HomeListItem {
    String itemUrl;
    String itemName;
    String itemLastMessage;
    String time;
    int newMessagesCount;

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemLastMessage() {
        return itemLastMessage;
    }

    public void setItemLastMessage(String itemLastMessage) {
        this.itemLastMessage = itemLastMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNewMessagesCount() {
        return newMessagesCount;
    }

    public void setNewMessagesCount(int newMessagesCount) {
        this.newMessagesCount = newMessagesCount;
    }
}
