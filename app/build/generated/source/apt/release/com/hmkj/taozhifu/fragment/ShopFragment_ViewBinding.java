// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShopFragment_ViewBinding<T extends ShopFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ShopFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.top_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.topView, "field 'toolbar'", LinearLayout.class);
    target.top_btn_left = Utils.findRequiredViewAsType(source, R.id.top_btn_left, "field 'top_btn_left'", Button.class);
    target.shopRv = Utils.findRequiredViewAsType(source, R.id.shop_rv, "field 'shopRv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbar = null;
    target.top_btn_left = null;
    target.shopRv = null;

    this.target = null;
  }
}
