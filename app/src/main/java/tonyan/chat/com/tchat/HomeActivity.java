package tonyan.chat.com.tchat;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import butterknife.Bind;
import tonyan.chat.com.tchat.base.BaseActivity;
import tonyan.chat.com.tchat.fragment.ChatFragment;
import tonyan.chat.com.tchat.fragment.ContactFragment;
import tonyan.chat.com.tchat.fragment.TrendsFragment;
import tonyan.chat.com.tchat.widget.BottomBar;
import tonyan.chat.com.tchat.widget.HomeMenu;
import tonyan.chat.com.tchat.widget.TitleBar;

public class HomeActivity extends BaseActivity implements View.OnClickListener,BottomBar.BottomBarTabSeelcted{

    @Bind(R.id.bottom_bar)
    BottomBar bottomBar;
    @Bind(R.id.shadow)
    View shadowView;
    HomeMenu menu;
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.title_bar)
    TitleBar titleBar;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    public void beforeSetContent() {

    }

    @Override
    public void initViews() {
        titleBar.setActivity(this);
        bottomBar.setContainerId(R.id.container);
        bottomBar.addNavigationItem(R.mipmap.tab1_inactive,R.mipmap.tab1_active,R.string.tab1,new ChatFragment());
        bottomBar.addNavigationItem(R.mipmap.tab2_inactive,R.mipmap.tab2_active,R.string.tab2,new ContactFragment());
        bottomBar.addNavigationItem(R.mipmap.tab3_inactive,R.mipmap.tab3_active,R.string.tab3,new TrendsFragment());
        bottomBar.setBarTabSeelcted(this);
        bottomBar.setUp(this);
        initSlidingMenu();
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(menu != null){
                    menu.toggle();
                }
            }
        });
    }

    @Override
    public void handleSafeMessage(Message msg) {
        bottomBar.showBadge(0,"10");
    }

    private void initSlidingMenu(){
        menu = new HomeMenu(this);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setOnScrollDistanceListener(new SlidingMenu.OnScrollDistanceListener() {
            @Override
            public void onPageScrolled(float positionOffset, int positionOffsetPixels) {
                setActivityShadow(positionOffset);
            }
        });
        menu.getItem1().setOnClickListener(this);

    }

    private void setActivityShadow(float positionOffset) {
        float alpha = positionOffset * 0.7f;
        shadowView.setAlpha(alpha);
        if (alpha <= 0) {
            if (shadowView.isShown())
                shadowView.setVisibility(View.GONE);
        } else {
            if (!shadowView.isShown())
                shadowView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == menu.getItem1()){
            Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTabSelected(int i) {
        titleBar.switchTitle(i);
    }


}
