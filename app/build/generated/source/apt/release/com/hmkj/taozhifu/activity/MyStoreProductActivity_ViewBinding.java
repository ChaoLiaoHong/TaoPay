// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyStoreProductActivity_ViewBinding<T extends MyStoreProductActivity> implements Unbinder {
  protected T target;

  private View view2131296754;

  @UiThread
  public MyStoreProductActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.rvMyStoreProduct = Utils.findRequiredViewAsType(source, R.id.rv_my_store_product, "field 'rvMyStoreProduct'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_add_product, "field 'tvAddProduct' and method 'onViewClicked'");
    target.tvAddProduct = Utils.castView(view, R.id.tv_add_product, "field 'tvAddProduct'", TextView.class);
    view2131296754 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
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
    target.rvMyStoreProduct = null;
    target.tvAddProduct = null;

    view2131296754.setOnClickListener(null);
    view2131296754 = null;

    this.target = null;
  }
}
