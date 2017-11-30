// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyStoreDiscountActivity_ViewBinding<T extends MyStoreDiscountActivity> implements Unbinder {
  protected T target;

  private View view2131296727;

  private View view2131296879;

  @UiThread
  public MyStoreDiscountActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.toolbar_menu, "field 'toolbarMenu' and method 'onViewClicked'");
    target.toolbarMenu = Utils.castView(view, R.id.toolbar_menu, "field 'toolbarMenu'", TextView.class);
    view2131296727 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.tv_store_discount, "field 'tvStoreDiscount' and method 'onViewClicked'");
    target.tvStoreDiscount = Utils.castView(view, R.id.tv_store_discount, "field 'tvStoreDiscount'", TextView.class);
    view2131296879 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etNoticeDes = Utils.findRequiredViewAsType(source, R.id.et_notice_des, "field 'etNoticeDes'", NOPasteEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbarMenu = null;
    target.toolbar = null;
    target.tvStoreDiscount = null;
    target.etNoticeDes = null;

    view2131296727.setOnClickListener(null);
    view2131296727 = null;
    view2131296879.setOnClickListener(null);
    view2131296879 = null;

    this.target = null;
  }
}
