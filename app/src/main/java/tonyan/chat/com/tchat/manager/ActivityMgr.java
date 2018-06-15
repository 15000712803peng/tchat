package tonyan.chat.com.tchat.manager;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by tonyan on 2018/6/11.
 */

public class ActivityMgr {

    static Stack<Activity> stack = new Stack<>();

    private ActivityMgr(){

    }

    public static class InstanceHolder{
        private static ActivityMgr ins = new ActivityMgr();
    }

    public static ActivityMgr ins(){
        return InstanceHolder.ins;
    }

    public void addActivity(Activity activity){
        stack.push(activity);
    }

    public void removeActivity(Activity activity){
        if(stack.contains(activity)){
            stack.remove(activity);
        }
    }
}
