package nah.prayer.recyclertools;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import nah.prayer.recyclertoollibrary.MultiChoice.MultiChoiceAdapter;


public class RecyclerAdapter extends MultiChoiceAdapter<RecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mDatas;


    public RecyclerAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_one, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        Picasso picasso = Picasso.with(mContext);

        picasso
                .load(mDatas.get(position))
                .error(R.drawable.placeholder)
                .resize(200, 200)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public void setActive(@NonNull View view, boolean state) {

        ImageView imageView =  view.findViewById(R.id.image_view);
        final ImageView tickImage = view.findViewById(R.id.tick_image);

        if (state) {
            imageView.setScaleX(0.7f);
            imageView.setScaleY(0.7f);
            tickImage.setVisibility(View.VISIBLE);
        } else {
            imageView.setScaleX(1f);
            imageView.setScaleY(1f);
            tickImage.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    protected View.OnClickListener defaultItemViewClickListener(MyViewHolder holder, final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("nah", "Click on item " + position);
            }
        };
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            imageView =  view.findViewById(R.id.image_view);
        }
    }
}