// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductClassifyActivity_ViewBinding<T extends ProductClassifyActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ProductClassifyActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbarMenu = Utils.findRequiredViewAsType(source, R.id.toolbar_menu, "field 'toolbarMenu'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tvSelectedCategories = Utils.findRequiredViewAsType(source, R.id.tv_selected_categories, "field 'tvSelectedCategories'", TextView.class);
    target.llSelectedCategories = Utils.findRequiredViewAsType(source, R.id.ll_selected_categories, "field 'llSelectedCategories'", LinearLayout.class);
    target.rvProductClassify = Utils.findRequiredViewAsType(source, R.id.rv_product_classify, "field 'rvProductClassify'", RecyclerView.class);
    target.llNullState = Utils.findRequiredViewAsType(source, R.id.ll_null_state, "field 'llNullState'", LinearLayout.class);
    target.tvNullStateOnClick = Utils.findRequiredViewAsType(source, R.id.tv_null_state_onClick, "field 'tvNullStateOnClick'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbarMenu = null;
    target.toolbar = null;
    target.tvSelectedCategories = null;
    target.llSelectedCategories = null;
    target.rvProductClassify = null;
    target.llNullState = null;
    target.tvNullStateOnClick = null;

    this.target = null;
  }
}
