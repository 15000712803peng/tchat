package tonyan.chat.com.tchat.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by tonyan on 2018/6/13.
 */

public class HomeList extends RecyclerView{

    LinearLayoutManager mLayoutManager;
    public HomeList(Context context) {
        this(context,null);

    }

    public HomeList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HomeList(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    public void setHeader(int headerRes) {
        View header = LayoutInflater.from(getContext()).inflate(headerRes, this, false);
        if(getAdapter() != null && getAdapter() instanceof HomeRecyclerAdapter){
            HomeRecyclerAdapter adapter = (HomeRecyclerAdapter) getAdapter();
            adapter.setHeaderView(header);
        }

    }

    public void setBottomView(int bottomRes) {
        View bottom = LayoutInflater.from(getContext()).inflate(bottomRes, this, false);
        if(getAdapter() != null && getAdapter() instanceof HomeRecyclerAdapter){
            HomeRecyclerAdapter adapter = (HomeRecyclerAdapter) getAdapter();
            adapter.setBottomView(bottom);
        }

    }

    public void setBottomMargin(){

    }

    private void init(){
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        setLayoutManager(mLayoutManager);
        setItemAnimator(new DefaultItemAnimator());
    }


}
