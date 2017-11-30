// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyWalletActivity_ViewBinding<T extends MyWalletActivity> implements Unbinder {
  protected T target;

  private View view2131296899;

  @UiThread
  public MyWalletActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_withdraw_deposit, "field 'tvWithdrawDeposit' and method 'onViewClicked'");
    target.tvWithdrawDeposit = Utils.castView(view, R.id.tv_withdraw_deposit, "field 'tvWithdrawDeposit'", TextView.class);
    view2131296899 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvMyMoney = Utils.findRequiredViewAsType(source, R.id.tv_my_money, "field 'tvMyMoney'", TextView.class);
    target.flBg = Utils.findRequiredViewAsType(source, R.id.fl_bg, "field 'flBg'", LinearLayout.class);
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tab = Utils.findRequiredViewAsType(source, R.id.tab, "field 'tab'", TabLayout.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvWithdrawDeposit = null;
    target.tvMyMoney = null;
    target.flBg = null;
    target.toolbarTitle = null;
    target.toolbar = null;
    target.tab = null;
    target.viewPager = null;

    view2131296899.setOnClickListener(null);
    view2131296899 = null;

    this.target = null;
  }
}
