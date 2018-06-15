package tonyan.chat.com.tchat.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.zip.Inflater;

/**
 * Created by tonyan on 2018/6/13.
 */

public class MenuItemWidget extends LinearLayout{
    public MenuItemWidget(Context context) {
        this(context,null);
    }

    public MenuItemWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MenuItemWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        setOrientation(LinearLayout.HORIZONTAL);
    }
}
