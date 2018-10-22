package org.irri.varipirusasyarakshna.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.irri.varipirusasyarakshna.R;
import org.irri.varipirusasyarakshna.RoundishImageView;
import org.irri.varipirusasyarakshna.model.FindImage;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<FindImage> mDataset;
//    private Map<String,Integer> mDataset;
    private Context mContext;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public RoundishImageView mImageView;
        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.tv_label);
            mImageView = v.findViewById(R.id.iv_find);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, List<FindImage> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }

//    public MyAdapter(Context context, Map<String,Integer> myDataset) {
//        mDataset = myDataset;
//        mContext = context;
//    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.how_to_identify_img_row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Drawable res = mContext.getResources().getDrawable(mDataset.get(position).getImageUrl());
        holder.mImageView.setImageDrawable(res);

        holder.mTextView.setText(mDataset.get(position).getImageName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}