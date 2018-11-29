package nah.prayer.recyclertools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import nah.prayer.recyclertoollibrary.EndlessRecyclerViewScrollListener;
import nah.prayer.recyclertoollibrary.MultiChoice.MultiChoiceAdapter;
import nah.prayer.recyclertoollibrary.RecyclerItemClickListener;
import nah.prayer.recyclertoollibrary.WrapContentGridLayoutManager;

public class MainActivity extends AppCompatActivity {

RecyclerView recyclerView ;
RecyclerAdapter adapter;
    private List<String> mDatas;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        ((MultiChoiceAdapter) recyclerView.getAdapter()).onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ((MultiChoiceAdapter) recyclerView.getAdapter()).onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initData();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerAdapter(this, mDatas);

        recyclerView.setAdapter(adapter);


        //recyclerView.setHasFixedSize(true);

        // StaggeredGrid 레이아웃을 사용한다
        //StaggeredGridLayoutManager layoutManager = new WrapContentStaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager layoutManager = new WrapContentGridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false);
        //LinearLayoutManager layoutManager = new WrapContentLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


/*

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                //call.add(page + 1);
            }
        });




        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("nah", "Click position"+position);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );

*/



    }

    private void initData() {
        mDatas = new ArrayList<>();
        mDatas.add("https://i1.wp.com/vanwckc.com/wp-content/uploads/2018/01/%EA%B8%B0%EB%8F%84%EB%AC%B8-%EA%B8%B0%EB%8F%84.jpg?fit=1280%2C706");
        mDatas.add("http://www.godpeople.com/img/cnts/thumb/8457/8457_2702609.png");
        mDatas.add("http://daeyoung.org/images/p_05.jpg");
        mDatas.add("http://libertyherald.co.kr/article/data/libertyherald_news/107382eb4dee5c7f83523aeb7e9bec236363c7.jpg");
        mDatas.add("http://www.bonhd.net/news/photo/201707/3050_6891_2550.jpg");
        mDatas.add("http://3.bp.blogspot.com/-YNRnHctuJ40/UI03yYvn4qI/AAAAAAAAAeA/SHvRvmdC4xg/s1600/23e6cb9b3e7848f4005ec315ab1c050a.jpg");
    }
}
