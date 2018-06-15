package tonyan.chat.com.tchat.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;
import tonyan.chat.com.tchat.R;

/**
 * Created by tonyan on 2018/6/14.
 */

public class ContactScrollView extends ScrollView{
    @Bind(R.id.scroll)
    LinearLayout scroller;
    ContactPager contactPager;

    View topDivider;

    public ContactScrollView(Context context) {
        super(context);
        init();
    }

    public ContactScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ContactScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        setFillViewport(true);
        LayoutInflater.from(getContext()).inflate(R.layout.container_scroller,this);
        ButterKnife.bind(this,getRootView());
    }

    public void addHeaerView(int layoutRes){
        View header = LayoutInflater.from(getContext()).inflate(layoutRes,null);
        scroller.addView(header);
    }

    public void addCenterPager(ContactTabAdapter adapter){
        contactPager = new ContactPager(getContext());
        scroller.addView(contactPager);
        initTab(contactPager.getCenterTab(),adapter);
        topDivider = findViewById(R.id.tab_top_divider);
//        initTab(tab,adapter);
    }

    public void resetPageLinster(){
        contactPager.getCenterTab().resetPageListener();
    }

    public void attchTopTab(PoitionSlidingTabStrip tab){
        DisplayMetrics dm = getResources().getDisplayMetrics();
        tab.attchViewPager(contactPager.getPager());
        contactPager.getCenterTab().setOnPageChangeListener(tab.getDelegatePageListener());
        tab.setDividerColor(Color.TRANSPARENT);
        tab.setUnderlineColor(Color.parseColor("#f0f0f0"));
        tab.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        tab.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 3, dm));
        // 设置Tab标题文字的大小
        tab.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 18, dm));
        tab.setTextColor(Color.parseColor("#9EA9B7"));
        tab.setIndicatorColor(Color.parseColor("#18b6f6"));
        tab.setSelectedTextColor(Color.parseColor("#18b6f6"));
        // 取消点击Tab时的背景色
        tab.setTabBackground(0);
        tab.setShouldExpand(true);
    }

    private void initTab(PagerSlidingTabStrip tab,ContactTabAdapter adapter){
        DisplayMetrics dm = getResources().getDisplayMetrics();
        contactPager.getPager().setAdapter(adapter);
        tab.setViewPager(contactPager.getPager());
        tab.setDividerColor(Color.TRANSPARENT);

        tab.setUnderlineColor(Color.parseColor("#f0f0f0"));
        tab.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        tab.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 3, dm));
        // 设置Tab标题文字的大小
        tab.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 18, dm));
        tab.setTextColor(Color.parseColor("#9EA9B7"));
        tab.setIndicatorColor(Color.parseColor("#18b6f6"));
        tab.setSelectedTextColor(Color.parseColor("#18b6f6"));
        // 取消点击Tab时的背景色
        tab.setTabBackground(0);
        tab.setShouldExpand(true);
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
         if(isCover(topDivider)){

         }else {
             Log.e("-------","可见");
         }

         if(stickHeaderLinster != null){
             stickHeaderLinster.onStickHeader(isCover(topDivider));
         }
//        if (scrollViewListener != null) {
//            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
//        }
    }


    public StickHeaderLinster getStickHeaderLinster() {
        return stickHeaderLinster;
    }

    public void setStickHeaderLinster(StickHeaderLinster stickHeaderLinster) {
        this.stickHeaderLinster = stickHeaderLinster;
    }

    StickHeaderLinster stickHeaderLinster;
    public interface StickHeaderLinster {
       void onStickHeader(boolean isCover);
    }

    protected boolean isCover(View view) {
        boolean cover = false;
        Rect rect = new Rect();
        cover = view.getGlobalVisibleRect(rect);
        if (cover) {
            if (rect.width() >= view.getMeasuredWidth() && rect.height() >= view.getMeasuredHeight()) {
                return !cover;
            }
        }
        return true;
    }
}
