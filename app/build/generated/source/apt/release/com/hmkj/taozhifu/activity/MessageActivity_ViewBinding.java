// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MessageActivity_ViewBinding<T extends MessageActivity> implements Unbinder {
  protected T target;

  private View view2131296703;

  private View view2131296932;

  @UiThread
  public MessageActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.tab, "field 'tab' and method 'onClick'");
    target.tab = Utils.castView(view, R.id.tab, "field 'tab'", TabLayout.class);
    view2131296703 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.view_pager, "field 'viewPager' and method 'onClick'");
    target.viewPager = Utils.castView(view, R.id.view_pager, "field 'viewPager'", ViewPager.class);
    view2131296932 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbar = null;
    target.tab = null;
    target.viewPager = null;

    view2131296703.setOnClickListener(null);
    view2131296703 = null;
    view2131296932.setOnClickListener(null);
    view2131296932 = null;

    this.target = null;
  }
}
