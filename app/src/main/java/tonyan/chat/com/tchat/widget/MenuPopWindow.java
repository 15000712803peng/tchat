package tonyan.chat.com.tchat.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import butterknife.ButterKnife;

/**
 * Created by tonyan on 2018/6/15.
 */

public class MenuPopWindow extends PopupWindow{



    public MenuPopWindow(View contentView) {
        super(contentView);
        init();
        ButterKnife.bind(this,contentView);
    }



    private void init(){
        // 为了避免部分机型不显示，我们需要重新设置一下宽高
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置pop透明效果
        setBackgroundDrawable(new ColorDrawable(0x0000));
        // 设置pop出入动画
//        setAnimationStyle(R.style.pop_add);
        // 设置pop获取焦点，如果为false点击返回按钮会退出当前Activity，如果pop中有Editor的话，focusable必须要为true
        setFocusable(true);
        // 设置pop可点击，为false点击事件无效，默认为true
        setTouchable(true);
        // 设置点击pop外侧消失，默认为false；在focusable为true时点击外侧始终消失
        setOutsideTouchable(true);

        // 相对于 + 号正下面，同时可以设置偏移量
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        super.showAsDropDown(anchor, xoff, yoff);

    }

    public void showAsDropDown(Activity context,View anchor, int xoff, int yoff) {

        super.showAsDropDown(anchor, xoff, yoff);
        backgroundAlpha(context,0.8f);

    }



    public void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }
}
