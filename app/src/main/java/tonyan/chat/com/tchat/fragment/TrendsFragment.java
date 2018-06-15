package tonyan.chat.com.tchat.fragment;

import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import butterknife.Bind;
import tonyan.chat.com.tchat.R;
import tonyan.chat.com.tchat.base.BaseFragment;

/**
 * Created by tonyan on 2018/6/14.
 */

public class TrendsFragment extends BaseFragment{

    @Bind(R.id.refresh)
    TwinklingRefreshLayout refreshLayout;

    @Bind(R.id.text_search)
    TextView searchText;
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_trends;
    }

    @Override
    public void initViews() {
        refreshLayout.setPureScrollModeOn(true);
        searchText.setText("大家都在搜");
    }

    @Override
    public void baseRefresh() {

    }
}
