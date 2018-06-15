package tonyan.chat.com.tchat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import tonyan.chat.com.tchat.R;

/**
 * Created by tonyan on 2018/6/14.
 */

public class TitleBar extends LinearLayout {


    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.title_right)
    TextView rightTitle;
    @Bind(R.id.title_add)
    ImageView addImage;
    MenuPopWindow menuPopWindow;
    Activity activity;
    View menuView;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public TitleBar(Context context) {
        super(context);
        init();
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void showMenu(Activity context){

    }

    int[] location = new  int[2] ;

   private void init(){
       LayoutInflater.from(getContext()).inflate(R.layout.title_bar,this);
       ButterKnife.bind(this,getRootView());
        menuView = LayoutInflater.from(getContext()).inflate(R.layout.pop_menu,null);
       menuPopWindow = new MenuPopWindow(menuView);
       menuPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
           @Override
           public void onDismiss() {
                menuPopWindow.backgroundAlpha(activity,1.0f);
           }
       });

       addImage.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View view) {
               addImage.getLocationInWindow(location);

               menuPopWindow.showAsDropDown(activity,TitleBar.this,getWindowXOffset(),0);
           }
       });
   }

   int getWindowXOffset(){
       Resources resources = this.getResources();
       DisplayMetrics dm = resources.getDisplayMetrics();
       float density = dm.density;
       int width = dm.widthPixels;
       return  width;
   }

    public void switchTitle(int i){
        if(i == BottomBar.TAB1){
            title.setText("消息");
            addImage.setVisibility(View.VISIBLE);
            rightTitle.setVisibility(View.INVISIBLE);
        }else if(i == BottomBar.TAB2){
            title.setText("联系人");
            addImage.setVisibility(View.INVISIBLE);
            rightTitle.setVisibility(View.VISIBLE);
            rightTitle.setText("添加");
        }else if(i == BottomBar.TAB3){
            title.setText("动态");
            addImage.setVisibility(View.INVISIBLE);
            rightTitle.setVisibility(View.VISIBLE);
            rightTitle.setText("更多");
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }
}
