package com.example.mohamedarafa.sceleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohamedarafa.sceleton.MyApplication;
import com.example.mohamedarafa.sceleton.R;
import com.example.mohamedarafa.sceleton.models.request.BaseRequestModel;
import com.example.mohamedarafa.sceleton.ui.BaseContract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mohamed.arafa on 9/5/2017.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.MyViewHolder> {

    private List<BaseRequestModel> mList = new ArrayList<>();
    private int mLayout;
    private BaseContract.UserAction mPresenter;
    Picasso mPicasso;

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView mTitleTextView;

        @BindView(R.id.iv_logo)
        ImageView mThumpImageView;


        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public BaseAdapter(Context context, ArrayList<BaseRequestModel> list, int layout, BaseContract.UserAction presenter) {
        mList = list;
        mLayout = layout;
        mPresenter = presenter;
        mPicasso = ((MyApplication) context.getApplicationContext()).getPicasso();
    }

    public void updateData(List<BaseRequestModel> list) {
        mList = list;
        this.notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(mLayout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BaseRequestModel model = mList.get(position);
        holder.mTitleTextView.setText(model.getAlbumName());
        mPicasso.load(model.getAlbumImage()).into(holder.mThumpImageView);
        holder.itemView.setOnClickListener(view -> {
            mPresenter.openDetails(model.getAlbumID());
        });
    }

    @Override
    public int getItemCount() {
        if (mList != null)
            return mList.size();
        return 0;
    }
}