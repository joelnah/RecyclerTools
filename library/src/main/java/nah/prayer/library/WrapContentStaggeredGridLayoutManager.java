package nah.prayer.library;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

/**
 * Created by S on 2017-10-13.
 */

public class WrapContentStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    public WrapContentStaggeredGridLayoutManager(int su, int sort) {
        super(su, sort);
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
