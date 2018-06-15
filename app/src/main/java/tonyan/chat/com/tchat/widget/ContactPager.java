package tonyan.chat.com.tchat.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import tonyan.chat.com.tchat.R;

/**
 * Created by tonyan on 2018/6/14.
 */

public class ContactPager extends LinearLayout{

    @Bind(R.id.center_tabs)
    PagerSlidingTabStrip tab;

    @Bind(R.id.pager)
    ViewPager pager;

    public ViewPager getPager() {
        return pager;
    }



    public ContactPager(Context context) {
        super(context);
        init();
    }

    public ContactPager(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ContactPager(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.contact_pager,this);
        ButterKnife.bind(this,getRootView());
    }

    public PagerSlidingTabStrip getCenterTab(){
        return tab;
    }
}
