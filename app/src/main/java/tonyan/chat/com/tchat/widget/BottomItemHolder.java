package tonyan.chat.com.tchat.widget;

import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;

import tonyan.chat.com.tchat.base.BaseFragment;

/**
 * Created by tonyan on 2018/6/12.
 */

public class BottomItemHolder {
    BottomNavigationItem navigationItem;
    TextBadgeItem badgeItem;
    BaseFragment fragment;
    boolean isAdd = false;
    public BottomNavigationItem getNavigationItem() {
        return navigationItem;
    }

    public void setNavigationItem(BottomNavigationItem navigationItem) {
        this.navigationItem = navigationItem;
    }

    public TextBadgeItem getBadgeItem() {
        return badgeItem;
    }

    public void setBadgeItem(TextBadgeItem badgeItem) {
        this.badgeItem = badgeItem;
    }

    public BottomItemHolder(BottomNavigationItem navigationItem, TextBadgeItem badgeItem) {
        this.navigationItem = navigationItem;
        this.badgeItem = badgeItem;
    }

    public BaseFragment getFragment() {
        return fragment;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }

    public BottomItemHolder(BottomNavigationItem navigationItem, TextBadgeItem badgeItem, BaseFragment fragment) {
        this.navigationItem = navigationItem;
        this.badgeItem = badgeItem;
        this.fragment = fragment;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }
}
