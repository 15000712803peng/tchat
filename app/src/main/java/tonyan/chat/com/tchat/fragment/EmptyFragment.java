package tonyan.chat.com.tchat.fragment;

import butterknife.Bind;
import tonyan.chat.com.tchat.R;
import tonyan.chat.com.tchat.base.BaseFragment;
import tonyan.chat.com.tchat.widget.ContactScrollView;
import tonyan.chat.com.tchat.widget.NormalRefreshViewHolder;
import tonyan.chat.com.tchat.widget.RefreshLayout;

/**
 * Created by tonyan on 2018/6/12.
 */

public class EmptyFragment extends BaseFragment implements RefreshLayout.RefreshLayoutDelegate{


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_empty;
    }

    @Override
    public void initViews() {

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
