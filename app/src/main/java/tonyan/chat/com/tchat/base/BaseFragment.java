package tonyan.chat.com.tchat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by tonyan on 2018/6/11.
 */

public abstract class BaseFragment extends Fragment{

    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate(getLayoutRes(),container,false);
            ButterKnife.bind(this,rootView);
            initViews();
        }else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if(parent != null){
                parent.removeView(rootView);
            }
        }

        return rootView;
    }

    public abstract int getLayoutRes();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != rootView) {
            if (rootView.getParent() != null) {
                ((ViewGroup) rootView.getParent()).removeView(rootView);
            }
        }
    }

    public abstract void initViews();

    public abstract void baseRefresh();
}
