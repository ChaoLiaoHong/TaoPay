package com.hmkj.taozhifu.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.MessageAdapter;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.view.CustomLoadMoreView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/1.
 */

public class MessageFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private MessageAdapter messageAdapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_message, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        messageAdapter = new MessageAdapter(null);
        messageAdapter.bindToRecyclerView(recyclerView);
        messageAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        messageAdapter.isFirstOnly(false);
        messageAdapter.setLoadMoreView(new CustomLoadMoreView());
        messageAdapter.setOnLoadMoreListener(this, recyclerView);
        messageAdapter.disableLoadMoreIfNotFullPage();//一定放到最后
        recyclerView.setAdapter(messageAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onLoadMoreRequested() {

    }

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }


}
