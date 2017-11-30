package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.ShopClassifyEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LiaoDuanHong  on 2017/8/21
 */

public class ShopSmallClassifyAdapter extends BaseAdapter {
    private List<ShopClassifyEntity.DataBean.UnderClassBean> data;
    private Context context;
    private OnItemClick onItemClick;
    private int type;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public ShopSmallClassifyAdapter(Context context, List<ShopClassifyEntity.DataBean.UnderClassBean> data,int type) {
        this.data = data;
        this.context = context;
        this.type = type;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shop_small_classify_info, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.shopTitle.setText(data.get(position).getClassName());
        viewHolder.shopTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(data.get(position));
                }
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.shop_title)
        TextView shopTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClick {
        void onItemClick(ShopClassifyEntity.DataBean.UnderClassBean itemData);
    }
}
