package com.hmkj.taozhifu.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.TaoDianAdapter;
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
import butterknife.Unbinder;

import static com.hmkj.taozhifu.utils.ToastUtil.showToast;

/**
 * 抵用券的收入
 */

public class TaoDFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_null_state_content)
    TextView tvNullStateContent;
    @BindView(R.id.tv_null_state_onClick)
    TextView tvNullStateOnClick;
    @BindView(R.id.ll_null_state)
    LinearLayout llNullState;
    Unbinder unbinder;

    private TaoDianAdapter taoDianAdapter;
    private int currentPage = 1;
    /**
     * 类型
     */
    String type;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_taodian_ticket, container, false);
        unbinder = ButterKnife.bind(this, view);
        //2.抵用券3.商超卷1.现金
        type = (String) getArguments().get("type");
        initViews();
        return view;
    }

    private void initViews() {
        tvNullStateContent.setText("目前没有信息哦！");
        tvNullStateOnClick.setVisibility(View.GONE);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        taoDianAdapter = new TaoDianAdapter(null);
        taoDianAdapter.bindToRecyclerView(recyclerView);
        taoDianAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        taoDianAdapter.isFirstOnly(false);
        taoDianAdapter.setLoadMoreView(new CustomLoadMoreView());
        taoDianAdapter.setOnLoadMoreListener(this, recyclerView);
        taoDianAdapter.disableLoadMoreIfNotFullPage();//一定放到最后
        recyclerView.setAdapter(taoDianAdapter);
    }

    public static TaoDFragment newInstance() {
        return new TaoDFragment();
    }

    @Override
    protected void initData() {
        initLoad(currentPage);
    }

    @Override
    public void onLoadMoreRequested() {//加载更多的数据  这里不写内容很操蛋
        LogUtil.LogLong("走了onLoadMoreRequested");
        currentPage++;
        OkGo.<String>get(HttpConfig.TAO_DIAN_INFO + getMemberId())
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .params("current", currentPage + "")//页数
                .params("size", "10")//条数
                .params("type", getTitle().equals("收入") ? "2" : "1")//2.收款   1. 付款
                .params("tradeType", type)//钱包记录类型，1,现金，2，抵用券，3，商超券,4货款，空是全部
                .execute(new CustomCallback(context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("获取数据", response.body());
                        LogUtil.LogLong("请求的页数是", currentPage + "");
                        taoDianAdapter.loadMoreComplete();
                        taoDianAdapter.setEnableLoadMore(false);
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                TaoDianInfoEntity taoDianInfoEntity = GsonUtil.GsonToBean(response.body(), TaoDianInfoEntity.class);
                                if (taoDianInfoEntity != null && taoDianInfoEntity.getPage().getRecords() != null) {
                                    taoDianAdapter.addData(taoDianInfoEntity.getPage().getRecords());
                                } else {
                                    //显示没有更多数据
                                    View noDataView = LayoutInflater.from(getActivity()).inflate(R.layout.item_no_data, (ViewGroup) recyclerView.getParent(), false);
                                    taoDianAdapter.setFooterView(noDataView);
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

    private void initLoad(final int currentPage) {
        OkGo.<String>get(HttpConfig.TAO_DIAN_INFO + getMemberId())
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .params("current", currentPage + "")//页数
                .params("size", "10")//条数
                .params("type", getTitle().equals("收入") ? "2" : "1")//2.收款   1. 付款
                .params("tradeType", type)//钱包记录类型，1,现金，2，抵用券，3，商超券
                .execute(new CustomCallback(context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        super.onSuccess(response);
                        LogUtil.LogLong("请求的页数是", currentPage + "");
                        LogUtil.LogLong("淘点里面的信息", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int httpCode = jsonObject.getInt("code");
                            String msg = jsonObject.getString("msg");
                            if (httpCode == 200) {
                                TaoDianInfoEntity taoDianInfoEntity = GsonUtil.GsonToBean(response.body(), TaoDianInfoEntity.class);
                                if (taoDianInfoEntity != null & taoDianInfoEntity.getPage() != null & taoDianInfoEntity.getPage().getRecords() != null) {
                                    if (taoDianInfoEntity.getPage().getRecords().size() != 0) {
                                        llNullState.setVisibility(View.GONE);
                                        taoDianAdapter.setNewData(taoDianInfoEntity.getPage().getRecords());
                                        taoDianAdapter.notifyDataSetChanged();
                                    } else {
                                        llNullState.setVisibility(View.VISIBLE);
                                    }
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
