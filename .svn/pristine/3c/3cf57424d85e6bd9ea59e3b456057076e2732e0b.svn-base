package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.bean.HistoryEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LiaoDuanHong  on 2017/5/27
 */

public class SearchHistoryAdapter extends BaseAdapter {
    private Context mContext;
    private List<HistoryEntity> mList;
    private LayoutInflater layoutInflater;

    public SearchHistoryAdapter(Context context, List<HistoryEntity> list) {
        this.mContext = context;
        this.mList = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.tagview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final String text = mList.get(position).getTitle();
        viewHolder.tagBtn.setText(text);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tag_btn)
        TextView tagBtn;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
