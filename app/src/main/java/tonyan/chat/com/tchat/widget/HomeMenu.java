package tonyan.chat.com.tchat.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import butterknife.Bind;
import butterknife.ButterKnife;
import tonyan.chat.com.tchat.R;

/**
 * Created by tonyan on 2018/6/13.
 */

public class HomeMenu extends SlidingMenu{

    @Bind(R.id.item1)
    LinearLayout item1;

    @Override
    public View getMenu() {
        return super.getMenu();
    }

    public HomeMenu(Context context) {
        super(context);
        init();
    }

    public HomeMenu(Activity activity, int slideStyle) {
        super(activity, slideStyle);
        init();
    }

    public HomeMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HomeMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setMode(SlidingMenu.LEFT);
        setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        setFadeDegree(0.35f);
        setBehindOffsetRes(R.dimen.menu_behind_offset);
        setMenu(R.layout.left_menu);
        ButterKnife.bind(this,getMenu());
    }

    public LinearLayout getItem1() {
        return item1;
    }

}
