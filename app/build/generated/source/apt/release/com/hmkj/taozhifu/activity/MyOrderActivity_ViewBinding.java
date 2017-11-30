// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyOrderActivity_ViewBinding<T extends MyOrderActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MyOrderActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tab = Utils.findRequiredViewAsType(source, R.id.tab, "field 'tab'", TabLayout.class);
    target.appbar = Utils.findRequiredViewAsType(source, R.id.appbar, "field 'appbar'", AppBarLayout.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", NoScrollViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.tab = null;
    target.appbar = null;
    target.viewPager = null;

    this.target = null;
  }
}
