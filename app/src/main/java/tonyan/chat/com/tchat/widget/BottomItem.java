package tonyan.chat.com.tchat.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.ashokvarma.bottomnavigation.BottomNavigationItem;

/**
 * Created by tonyan on 2018/6/12.
 */

public class BottomItem extends BottomNavigationItem{
    public BottomItem(int mIconResource, @NonNull String mTitle) {
        super(mIconResource, mTitle);
    }

    public BottomItem(Drawable mIcon, @NonNull String mTitle) {
        super(mIcon, mTitle);
    }

    public BottomItem(Drawable mIcon, int mTitleResource) {
        super(mIcon, mTitleResource);
    }

    public BottomItem(int mIconResource, int mTitleResource) {
        super(mIconResource, mTitleResource);
    }


}
