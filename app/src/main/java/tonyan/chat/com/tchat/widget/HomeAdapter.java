package tonyan.chat.com.tchat.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tonyan.chat.com.tchat.R;
import tonyan.chat.com.tchat.data.model.HomeListItem;

/**
 * Created by tonyan on 2018/6/13.
 */

public class HomeAdapter extends HomeRecyclerAdapter<HomeListItem> {


    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new HomeItemHolder(layout);

    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, HomeListItem data) {

    }

    class HomeItemHolder extends HomeRecyclerAdapter.Holder {
        TextView text;
        public HomeItemHolder(View itemView) {
            super(itemView);
        }
    }
}
