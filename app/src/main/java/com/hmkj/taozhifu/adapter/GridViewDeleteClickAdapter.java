package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.yanzhenjie.album.AlbumFile;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/25.
 *
 * @选择图片后带删除图标的通用adapter
 */

public class GridViewDeleteClickAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    ArrayList<AlbumFile> data;

    /**
     * 原集合移除后调用此方法
     *
     * @param images
     */
    public void setData(ArrayList<AlbumFile> images) {
        data = images;
        this.notifyDataSetChanged();
    }

    public GridViewDeleteClickAdapter(Context context, ArrayList<AlbumFile> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data == null ? null : data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {//创建ImageView
            convertView = inflater.inflate(R.layout.item_img_can_delete, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GlideUtils.loadImage(context, data.get(position).getPath(), viewHolder.ivImg);
        viewHolder.ivDeleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.iv_delete_img)
        ImageView ivDeleteImg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
