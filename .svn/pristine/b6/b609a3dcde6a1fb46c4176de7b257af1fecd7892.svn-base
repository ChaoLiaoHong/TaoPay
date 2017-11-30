package com.hmkj.taozhifu.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.activity.MainActivity;
import com.hmkj.taozhifu.activity.ShopListActivity;
import com.hmkj.taozhifu.bean.HomeFragmentButtonBean;
import com.hmkj.taozhifu.utils.GlideUtils;
import com.hmkj.taozhifu.view.BoderCircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LiaoDuanHong  on 2017/3/22
 */

public class HomeGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<HomeFragmentButtonBean.DataBean> data;
    private LayoutInflater inflater;

    public HomeGridViewAdapter(Context context, List<HomeFragmentButtonBean.DataBean> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_circleimg_text, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GlideUtils.loadImage(context, data.get(i).buttonImg, viewHolder.circleImg);
        viewHolder.tvTitle.setText(data.get(i).buttonName == null ? "" : data.get(i).buttonName);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (data.get(i).buttonType) {
                    case 1:
                        if (data.get(i).classLevel == 0 && TextUtils.equals("全部分类", data.get(i).buttonName)) {
                            ((MainActivity) context).clickClassify();
                        } else {
                            Intent intent = new Intent(context, ShopListActivity.class);
                            intent.putExtra("classId", data.get(i).buttonValue);
                            intent.putExtra("title", data.get(i).buttonName);
                            intent.putExtra("type", "3");
                            context.startActivity(intent);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.circle_img)
        BoderCircleImageView circleImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
