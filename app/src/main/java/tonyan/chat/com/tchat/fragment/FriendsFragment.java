package tonyan.chat.com.tchat.fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import tonyan.chat.com.tchat.R;
import tonyan.chat.com.tchat.base.BaseFragment;
import tonyan.chat.com.tchat.data.model.FriendGroupItem;
import tonyan.chat.com.tchat.data.model.FriendItem;
import tonyan.chat.com.tchat.widget.FriendGroupList;

/**
 * Created by tonyan on 2018/6/14.
 */

public class FriendsFragment extends BaseFragment{


    @Bind(R.id.list)
    FriendGroupList list;
    List<FriendGroupItem> datas = new ArrayList<>();
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_friends;
    }

    @Override
    public void initViews() {
        List<FriendItem> items1 =new ArrayList<>();
        List<FriendItem> items2 =new ArrayList<>();
        items2.add(new FriendItem("阿杜","[手机在线]"));
        items2.add(new FriendItem("拉风老年","[4g在线]"));

        List<FriendItem> items3 =new ArrayList<>();
        items3.add(new FriendItem("sky","[wifi在线]"));
        items3.add(new FriendItem("王羽端","[手机在线]"));
        items3.add(new FriendItem("张光yi","[手机在线]"));
        items3.add(new FriendItem("阿杜","[手机在线]"));
        List<FriendItem> items4 =new ArrayList<>();
        List<FriendItem> items5 =new ArrayList<>();
        List<FriendItem> items6 =new ArrayList<>();
        datas.add(new FriendGroupItem("特别关心","0／0",items1));
        datas.add(new FriendGroupItem("我的好友","70／110",items2));
        datas.add(new FriendGroupItem("好友","10／69",items3));
        datas.add(new FriendGroupItem("不认识","2／10"));
        datas.add(new FriendGroupItem("高中同学","2／8"));
        datas.add(new FriendGroupItem("大学同学","0／17"));
        list.setDatas(datas);
    }

    @Override
    public void baseRefresh() {

    }
}
