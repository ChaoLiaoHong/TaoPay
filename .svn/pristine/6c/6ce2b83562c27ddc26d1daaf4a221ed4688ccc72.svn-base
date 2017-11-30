package com.hmkj.taozhifu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hmkj.taozhifu.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/6/24.
 * @param 你的Fragment必须继承BaseFragment
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<BaseFragment> list;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  list.get(position).getTitle();
    }
}
