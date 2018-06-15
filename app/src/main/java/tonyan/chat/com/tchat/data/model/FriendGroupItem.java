package tonyan.chat.com.tchat.data.model;

import java.util.List;

/**
 * Created by tonyan on 2018/6/14.
 */

public class FriendGroupItem {
    String groupName;
    String guoupPrompt;
    List<FriendItem> friendItems;

    public FriendGroupItem(String groupName, String guoupPrompt, List<FriendItem> friendItems) {
        this.groupName = groupName;
        this.guoupPrompt = guoupPrompt;
        this.friendItems = friendItems;
    }

    public FriendGroupItem(String groupName) {
        this.groupName = groupName;
    }

    public FriendGroupItem(String groupName, String guoupPrompt) {
        this.groupName = groupName;
        this.guoupPrompt = guoupPrompt;
    }

    public FriendGroupItem() {

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGuoupPrompt() {
        return guoupPrompt;
    }

    public void setGuoupPrompt(String guoupPrompt) {
        this.guoupPrompt = guoupPrompt;
    }

    public List<FriendItem> getFriendItems() {
        return friendItems;
    }

    public void setFriendItems(List<FriendItem> friendItems) {
        this.friendItems = friendItems;
    }
}
