package tonyan.chat.com.tchat.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import tonyan.chat.com.tchat.fragment.EmptyFragment;
import tonyan.chat.com.tchat.fragment.FriendsFragment;

public class ContactTabAdapter extends FragmentPagerAdapter{

    String[] titles = new String[]{"好友","群聊","设备","通讯录","公众号",};
    public ContactTabAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new FriendsFragment();
        }
        EmptyFragment fragment = new EmptyFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}