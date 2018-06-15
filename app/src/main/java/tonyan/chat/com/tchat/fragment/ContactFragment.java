package tonyan.chat.com.tchat.fragment;

import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import tonyan.chat.com.tchat.R;
import tonyan.chat.com.tchat.base.BaseFragment;
import tonyan.chat.com.tchat.widget.ContactScrollView;
import tonyan.chat.com.tchat.widget.ContactTabAdapter;
import tonyan.chat.com.tchat.widget.NormalRefreshViewHolder;
import tonyan.chat.com.tchat.widget.PagerSlidingTabStrip;
import tonyan.chat.com.tchat.widget.PoitionSlidingTabStrip;
import tonyan.chat.com.tchat.widget.RefreshLayout;

/**
 * Created by tonyan on 2018/6/12.
 */

public class ContactFragment extends BaseFragment implements RefreshLayout.RefreshLayoutDelegate,ContactScrollView.StickHeaderLinster {

    @Bind(R.id.refresh)
    RefreshLayout refreshLayout;
    @Bind(R.id.scoller)
    ContactScrollView scroller;
    ContactTabAdapter adapter;

    @Bind(R.id.top_tab)
    PoitionSlidingTabStrip topTab;

    @Bind(R.id.top_header)
    LinearLayout topHeader;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_contact;
    }

    @Override
    public void initViews() {
        refreshLayout.setDelegate(this);
        adapter = new ContactTabAdapter(getFragmentManager());
        refreshLayout.setRefreshViewHolder(new NormalRefreshViewHolder(getActivity(),true));
        scroller.addHeaerView(R.layout.contact_header);
        scroller.addCenterPager(adapter);
        scroller.attchTopTab(topTab);
        scroller.setStickHeaderLinster(this);
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

    @Override
    public void onStickHeader(boolean isCover) {
        if(isCover){
            topHeader.setVisibility(View.VISIBLE);
            topTab.resetPageListener();
        }else {
            topHeader.setVisibility(View.GONE);
            scroller.resetPageLinster();
        }
    }
}
