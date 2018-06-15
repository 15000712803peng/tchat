package tonyan.chat.com.tchat.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tonyan.chat.com.tchat.R;
import tonyan.chat.com.tchat.data.model.FriendGroupItem;
import tonyan.chat.com.tchat.data.model.FriendItem;

/**
 * Created by tonyan on 2018/6/14.
 */

public class FriendGroupList extends ExpandableListView{

    FriendAdapter adapter;
    public FriendGroupList(Context context) {
        super(context);
        init();
    }

    public FriendGroupList(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FriendGroupList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        adapter = new FriendAdapter();
        setAdapter(adapter);
        setGroupIndicator(null);
    }

    public void setDatas(List<FriendGroupItem> datas){
        adapter.setDatas(datas);
    }

    class FriendAdapter extends BaseExpandableListAdapter {

        List<FriendGroupItem> groups = new ArrayList<>();
        public FriendAdapter(){

        }

        public void setDatas(List<FriendGroupItem> datas){
            groups.clear();
            groups.addAll(datas);
            notifyDataSetChanged();
        }




        @Override
        public int getGroupCount() {
            return groups.size();
        }

        @Override
        public int getChildrenCount(int i) {

            if(groups.get(i).getFriendItems() == null){
                return 0;
            }

            return groups.get(i).getFriendItems().size();
        }

        @Override
        public Object getGroup(int i) {
            return groups.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return groups.get(i).getFriendItems().get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            GroupHolder holder;
            FriendGroupItem item = (FriendGroupItem) getGroup(i);
            if(view == null){
                holder = new GroupHolder();
                view = LayoutInflater.from(getContext()).inflate(R.layout.item_friend_group,null);
                holder.gruopName = (TextView) view.findViewById(R.id.group_name);
                holder.desc  = (TextView) view.findViewById(R.id.group_desc);
                view.setTag(holder);
            }else {
                holder = (GroupHolder) view.getTag();
            }
            holder.gruopName.setText(item.getGroupName());
            holder.desc.setText(item.getGuoupPrompt()+"");
            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            ChildHolder holder;
            FriendItem item = (FriendItem) getChild(i,i1);
            if(view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.item_friend,null);
                holder = new ChildHolder();
                holder.childName = (TextView) view.findViewById(R.id.name);
                holder.desc = (TextView) view.findViewById(R.id.desc);
                view.setTag(holder);

            }else {
                holder = (ChildHolder) view.getTag();
            }
            holder.childName.setText(item.getName());
            holder.desc.setText(item.getDesc());
            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }

    class GroupHolder{
        TextView gruopName;
        TextView desc;
    }

    class ChildHolder{
        TextView childName;
        TextView desc;
    }
}
