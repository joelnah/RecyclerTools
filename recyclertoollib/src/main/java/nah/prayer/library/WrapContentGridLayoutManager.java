package nah.prayer.library;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by S on 2017-10-13.
 */

public class WrapContentGridLayoutManager extends GridLayoutManager {

    public WrapContentGridLayoutManager(Context context, int su) {
        super(context, su);
    }
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            Log.e("nah", e.toString());
        }
    }
}
