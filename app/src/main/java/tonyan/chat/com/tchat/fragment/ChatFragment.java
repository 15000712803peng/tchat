package tonyan.chat.com.tchat.fragment;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import tonyan.chat.com.tchat.R;
import tonyan.chat.com.tchat.base.BaseFragment;
import tonyan.chat.com.tchat.data.model.HomeListItem;
import tonyan.chat.com.tchat.widget.HomeAdapter;
import tonyan.chat.com.tchat.widget.HomeList;
import tonyan.chat.com.tchat.widget.NormalRefreshViewHolder;
import tonyan.chat.com.tchat.widget.RefreshLayout;

/**
 * Created by tonyan on 2018/6/12.
 */

public class ChatFragment extends BaseFragment implements RefreshLayout.RefreshLayoutDelegate{

    @Bind(R.id.refresh)
    RefreshLayout refreshLayout;

    @Bind(R.id.list)
    HomeList list;
    HomeAdapter adapter;
    List<HomeListItem> items = new ArrayList<>();


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_chat;
    }

    @Override
    public void initViews() {
        adapter = new HomeAdapter();
        items.add(new HomeListItem());
        items.add(new HomeListItem());
        items.add(new HomeListItem());
        items.add(new HomeListItem());
        items.add(new HomeListItem());
        items.add(new HomeListItem());
        items.add(new HomeListItem());
        items.add(new HomeListItem());
        items.add(new HomeListItem());
        adapter.addDatas(items);
        list.setAdapter(adapter);
        list.setHeader(R.layout.top_search_bar);
        list.setBottomView(R.layout.divider_view);
        refreshLayout.setDelegate(this);
        refreshLayout.setRefreshViewHolder(new NormalRefreshViewHolder(getActivity(),true));

//        refreshLayout.beginRefreshing();
    }

    @Override
    public void baseRefresh() {

    }

    @Override
    public void onRefreshLayoutBeginRefreshing(RefreshLayout refreshLayout) {

    }

    @Override
    public boolean onRefreshLayoutBeginLoadingMore(RefreshLayout refreshLayout) {
        return false;
    }
}
