package com.hmkj.taozhifu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.SearchHistoryAdapter;
import com.hmkj.taozhifu.base.BaseActivity;
import com.hmkj.taozhifu.bean.HistoryEntity;
import com.hmkj.taozhifu.database.MyExpress;
import com.hmkj.taozhifu.flowlayoututil.TagCloudLayout;
import com.hmkj.taozhifu.utils.StatusBarUtil;
import com.hmkj.taozhifu.utils.ToastUtil;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchShoppingActivity extends BaseActivity implements TextView.OnEditorActionListener {

    @BindView(R.id.edt_input)
    NOPasteEditText edtInput;
    @BindView(R.id.ico_search)
    ImageView icoSearch;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.ico_delete)
    ImageView icoDelete;
    @BindView(R.id.container)
    TagCloudLayout container;
    private SearchHistoryAdapter adapter;
    private ArrayList<HistoryEntity> mList = new ArrayList<HistoryEntity>();
    private MyExpress myExpress;
    private ArrayList<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_shopping);
        ButterKnife.bind(this);
        initListener();
    }

    @Override
    public void initData() {
        initEvent();
    }

    Timer timer = new Timer();

    @Override
    public void initView() {
        edtInput.requestFocus();
        timer.schedule(new TimerTask() {
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }, 500); // 秒后自动弹出
        myExpress = new MyExpress(this);
        adapter = new SearchHistoryAdapter(this, mList);
        container.setAdapter(adapter);
    }

    private void initEvent() {
        container.setItemClickListener(new TagCloudLayout.TagItemClickListener() {
            @Override
            public void itemClick(int position) {
                Intent intent = new Intent(SearchShoppingActivity.this, ShopListActivity.class);
                intent.putExtra("title", mList.get(position).getTitle());
                intent.putExtra("type", "1");
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.ico_search, R.id.tv_cancel, R.id.ico_delete, R.id.edt_input})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edt_input:
                edtInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                            ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                                    .hideSoftInputFromWindow(SearchShoppingActivity.this.getCurrentFocus()
                                            .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                            String title = edtInput.getText().toString().trim();
                            if (TextUtils.isEmpty(title)) {
                                ToastUtil.showToast("请输入搜索商品关键字");
                                return false;
                            }
                            if (myExpress.getAllData().size() == 0) {
                                myExpress.addTitle(title);
                            } else {
                                for (HistoryEntity bean : myExpress.getAllData()) {
                                    titles.add(bean.getTitle());
                                }
                                if (!titles.contains(title)) {
                                    myExpress.addTitle(title);
                                }
                            }
                            Intent intent = new Intent(SearchShoppingActivity.this, ShopListActivity.class);
                            intent.putExtra("title", title);
                            intent.putExtra("type", "1");
                            startActivity(intent);
                            return true;
                        }
                        return false;
                    }
                });
                break;
            case R.id.ico_search:
                search();
                break;
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.ico_delete:
                myExpress.deleteAll();
                refresh();
                break;
        }
    }

    private void search() {
        String title = edtInput.getText().toString().trim();
        if (TextUtils.isEmpty(title)) {
            ToastUtil.showToast("请输入搜索商品关键字");
            return;
        }
        if (myExpress.getAllData().size() == 0) {
            myExpress.addTitle(title);
        } else {
            for (HistoryEntity bean : myExpress.getAllData()) {
                titles.add(bean.getTitle());
            }
            if (!titles.contains(title)) {
                myExpress.addTitle(title);
            }
        }
        Intent intent = new Intent(SearchShoppingActivity.this, ShopListActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("type", "1");
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        mList.clear();
        mList.addAll(myExpress.getAllData());
        adapter.notifyDataSetChanged();
    }

    /**
     * 初始化监听
     */
    private void initListener() {
        edtInput.setOnEditorActionListener(this);
    }

    /**
     * 监听
     */
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // 当按了搜索之后关闭软键盘
            ((InputMethodManager) edtInput.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    SearchShoppingActivity.this.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
            search();
            return true;
        }
        return false;
    }
}
