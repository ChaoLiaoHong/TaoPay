package com.hmkj.taozhifu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.adapter.ImageScaleAdapter;
import com.hmkj.taozhifu.utils.LogUtil;
import com.hmkj.taozhifu.view.HackyViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoActivity extends Activity {
    @BindView(R.id.viewPager)
    HackyViewPager viewPager;
    @BindView(R.id.back)
    LinearLayout back;
    @BindView(R.id.page)
    TextView page;
    private ArrayList<String> urlList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        urlList = getIntent().getStringArrayListExtra("list");
        for (String s : urlList) {
            LogUtil.LogLong("urlList", s);
        }
        int position = getIntent().getIntExtra("position", 0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page.setText(position + 1 + "/" + urlList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ImageScaleAdapter adapter = new ImageScaleAdapter(this, urlList);
        viewPager.setAdapter(adapter);
        //设置默认选中的页
        viewPager.setCurrentItem(position);
        page.setText(position + 1 + "/" + urlList.size());
        viewPager.setSelected(true);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
