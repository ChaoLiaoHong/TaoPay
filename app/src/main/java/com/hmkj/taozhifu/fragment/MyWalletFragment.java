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
import com.hmkj.taozhifu.adapter.MyWalletAdapter;
import com.hmkj.taozhifu.base.BaseFragment;
import com.hmkj.taozhifu.bean.TaoDianInfoEntity;
import com.hmkj.taozhifu.http.CustomCallback;
import com.hmkj.taozhifu.http.HttpConfig;
import com.hmkj.taozhifu.utils.GsonUtil;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.view.CustomLoadMoreView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hmkj.taozhifu.utils.ToastUtil.showToast;

/**
 * Created by Administrator on 2017/8/22.
 */

public class MyWalletFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private MyWalletAdapter myWalletAdapter;
    //    private List<String> list;
    private int currentPage = 1;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_wallet, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        list = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            list.add(i + "");
//        }
        myWalletAdapter = new MyWalletAdapter(null);
        myWalletAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        myWalletAdapter.isFirstOnly(false);
        myWalletAdapter.setLoadMoreView(new CustomLoadMoreView());
        myWalletAdapter.setOnLoadMoreListener(this, recyclerView);
        myWalletAdapter.disableLoadMoreIfNotFullPage();//默认第一次加载会进入回调，如果不需要可以配置
        recyclerView.setAdapter(myWalletAdapter);
        myWalletAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {

                }
            }
        });
    }

    @Override
    protected void initData() {
        initLoad(currentPage);
//        myWalletAdapter.setNewData(list);
    }

    private void initLoad(final int currentPage) {
        String typeLx = "";
        if (getTitle().equals("收入")) {
            typeLx = "2";
        } else if (getTitle().equals("支出")) {
            typeLx = "1";
        }
        LogUtil.LogLong("我的钱包类型" + typeLx);

        OkGo.<String>get(HttpConfig.memberAcountAndRecord + getMemberId())
//                .cacheKey("TabFragment_" + fragmentTitle)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .params("current", currentPage + "")//页数
                .params("size", "10")//条数
                .params("type", typeLx)//2.收款   1. 付款  空就是全部记录
                .params("tradeType", "")//钱包记录类型，1,现金，2，抵用券，3，商超券,空就是全部记录
                .execute(new CustomCallback(context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("请求的页数是", currentPage + "");
                        LogUtil.LogLong("我的钱包", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                TaoDianInfoEntity taoDianInfoEntity = GsonUtil.GsonToBean(response.body(), TaoDianInfoEntity.class);
                                if (taoDianInfoEntity != null && taoDianInfoEntity.getPage().getRecords() != null) {
                                    myWalletAdapter.setNewData(taoDianInfoEntity.getPage().getRecords());
                                    myWalletAdapter.notifyDataSetChanged();
                                }
                            } else {
                                showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static MyWalletFragment newInstance() {
        return new MyWalletFragment();
    }

    int pageNum = 2;

    @Override
    public void onLoadMoreRequested() {
        String typeLx = "";
        if (getTitle().equals("收入")) {
            typeLx = "2";
        } else if (getTitle().equals("支出")) {
            typeLx = "1";
        }
        LogUtil.LogLong("我的钱包类型" + typeLx);

        OkGo.<String>get(HttpConfig.memberAcountAndRecord + getMemberId())
//                .cacheKey("TabFragment_" + fragmentTitle)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .params("current", pageNum + "")//页数
                .params("size", "10")//条数
                .params("type", typeLx)//2.收款   1. 付款  空就是全部记录
                .params("tradeType", "")//钱包记录类型，1,现金，2，抵用券，3，商超券，4，货款
                .execute(new CustomCallback(context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("请求的页数是", pageNum + "");
                        LogUtil.LogLong("我的钱包", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                TaoDianInfoEntity taoDianInfoEntity = GsonUtil.GsonToBean(response.body(), TaoDianInfoEntity.class);
                                if (taoDianInfoEntity != null && taoDianInfoEntity.getPage().getRecords() != null) {
                                    pageNum++;
                                    if (taoDianInfoEntity.getPage().getRecords().size() != 0) {
                                        myWalletAdapter.loadMoreComplete();
                                        myWalletAdapter.addData(taoDianInfoEntity.getPage().getRecords());
                                    } else {
                                        myWalletAdapter.loadMoreComplete();
                                        View noDataView = inflater.inflate(R.layout.item_no_data, (ViewGroup) recyclerView.getParent(), false);
                                        myWalletAdapter.setFooterView(noDataView);
                                        myWalletAdapter.setEnableLoadMore(false);
                                    }
                                }
                            } else {
                                showToast(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        myWalletAdapter.removeAllFooterView();
                    }
                });
    }


}
