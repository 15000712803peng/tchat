package tonyan.chat.com.tchat.widget;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import tonyan.chat.com.tchat.base.BaseFragment;

/**
 * Created by tonyan on 2018/6/12.
 */

public class BottomBar extends BottomNavigationBar implements BottomNavigationBar.OnTabSelectedListener{


    public static final int TAB1 = 0;
    public static final int TAB2 = 1;
    public static final int TAB3 = 2;

    public interface BottomBarTabSeelcted{
        void onTabSelected(int i);
    }
    BottomBarTabSeelcted barTabSeelcted;

    public BottomBarTabSeelcted getBarTabSeelcted() {
        return barTabSeelcted;
    }

    public void setBarTabSeelcted(BottomBarTabSeelcted barTabSeelcted) {
        this.barTabSeelcted = barTabSeelcted;
    }

    final String TAG  = "BottomBar";
    FragmentActivity fragmentActivity;
    List<BottomItemHolder> itemHolders = new ArrayList<>();
    int pre = -1;
    int containerId;
    public BottomBar(Context context) {
        this(context,null);
    }

    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BottomBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void setContainerId(int containerLayout){
        this.containerId = containerLayout;
    }



    private void init(){
        setMode(BottomNavigationBar.MODE_FIXED);
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        setBarBackgroundColor(android.R.color.white);

    }

    public int getItemSize(){
        return itemHolders.size();
    }

    public BottomNavigationItem getNavigationItem(int position){
        if(position < itemHolders.size() && position >=0){
            return  itemHolders.get(position).getNavigationItem();
        }else {
            return null;
        }

    }


    public void showBadge(int position,String content){
        itemHolders.get(position).getBadgeItem().setText(content).show();
    }

    public void hideBadge(int position){
        itemHolders.get(position).getBadgeItem().hide();
    }

    public void addNavigationItem(int inactiveIcon, int activeIcon, int txt, BaseFragment fragment){
        BottomNavigationItem item = new BottomNavigationItem(activeIcon,txt);
        TextBadgeItem badgeItem  = new TextBadgeItem();
        item.setInactiveIconResource(inactiveIcon);
        badgeItem.hide();
        item.setBadgeItem(badgeItem);
        item.setActiveColor("#45bbff");
        itemHolders.add(new BottomItemHolder(item,badgeItem,fragment));
    }

    public void setUp(FragmentActivity fragmentActivity){
        this.fragmentActivity = fragmentActivity;
        if(getItemSize() > 0){
            for(BottomItemHolder item : itemHolders){
                addItem(item.getNavigationItem());
            }
        }
        initialise();
        setTabSelectedListener(this);
        setFirstSelectedPosition(0);

    }

    @Override
    public BottomNavigationBar setFirstSelectedPosition(int firstSelectedPosition) {
        pre = firstSelectedPosition;
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        ft.add(containerId, itemHolders.get(firstSelectedPosition).getFragment(), "").commitAllowingStateLoss();
        itemHolders.get(firstSelectedPosition).setAdd(true);
        return super.setFirstSelectedPosition(firstSelectedPosition);
    }

    @Override
    public void onTabSelected(int i) {
        doChangeTab(i,pre);
        pre = i;
        if(barTabSeelcted != null){
            barTabSeelcted.onTabSelected(i);
        }
    }

    @Override
    public void onTabUnselected(int i) {

    }

    @Override
    public void onTabReselected(int i) {
        BaseFragment fragment = itemHolders.get(i).getFragment();
        fragment.baseRefresh();
    }

    private void doChangeTab(int selected,int pre){
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();

        ft.detach(itemHolders.get(pre).getFragment());

        if(itemHolders.get(selected).isAdd()){
            ft.attach(itemHolders.get(selected).getFragment());
        }else {
            ft.add(containerId, itemHolders.get(selected).getFragment(), "");
            itemHolders.get(selected).setAdd(true);

        }
        ft.commitAllowingStateLoss();

    }


}
