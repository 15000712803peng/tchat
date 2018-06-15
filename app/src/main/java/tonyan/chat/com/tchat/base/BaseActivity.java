package tonyan.chat.com.tchat.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import tonyan.chat.com.tchat.manager.ActivityMgr;


public abstract class BaseActivity extends FragmentActivity {

    Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new SafeHander(this);
        beforeSetContent();
        setContentView(getLayoutRes());
        ButterKnife.bind(this);
        initViews();
        ActivityMgr.ins().addActivity(this);
    }

    protected Handler getHandler(){
        return handler;
    }

    protected void sendMessage(Message msg){
        handler.sendMessage(msg);
    }

    protected void sendDelayMessage(Message msg,long delay){
        handler.sendMessageDelayed(msg,delay);
    }

    public abstract int getLayoutRes();

    public abstract void beforeSetContent();

    public abstract void initViews();

    public abstract void handleSafeMessage(Message msg);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityMgr.ins().removeActivity(this);
    }

    class SafeHander extends Handler{
        WeakReference<BaseActivity> _activity;
        public SafeHander(BaseActivity activity){
            _activity = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(_activity.get() != null){
                handleSafeMessage(msg);
            }
        }
    }
}
