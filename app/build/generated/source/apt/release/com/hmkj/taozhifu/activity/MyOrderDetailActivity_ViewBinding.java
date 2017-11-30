// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyOrderDetailActivity_ViewBinding<T extends MyOrderDetailActivity> implements Unbinder {
  protected T target;

  private View view2131296876;

  private View view2131296468;

  @UiThread
  public MyOrderDetailActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.tvIsUsed = Utils.findRequiredViewAsType(source, R.id.tv_is_used, "field 'tvIsUsed'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tvOrderStatu = Utils.findRequiredViewAsType(source, R.id.tv_order_statu, "field 'tvOrderStatu'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_statu_button, "field 'tvStatuButton' and method 'onViewClicked'");
    target.tvStatuButton = Utils.castView(view, R.id.tv_statu_button, "field 'tvStatuButton'", TextView.class);
    view2131296876 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ivProductImg = Utils.findRequiredViewAsType(source, R.id.iv_product_img, "field 'ivProductImg'", ImageView.class);
    target.tvOrderStatus = Utils.findRequiredViewAsType(source, R.id.tv_order_status, "field 'tvOrderStatus'", ImageView.class);
    target.tvProductName = Utils.findRequiredViewAsType(source, R.id.tv_product_name, "field 'tvProductName'", TextView.class);
    target.tvProductTime = Utils.findRequiredViewAsType(source, R.id.tv_product_time, "field 'tvProductTime'", TextView.class);
    target.tvProductNum = Utils.findRequiredViewAsType(source, R.id.tv_product_num, "field 'tvProductNum'", TextView.class);
    target.tvOrderNum = Utils.findRequiredViewAsType(source, R.id.tv_order_num, "field 'tvOrderNum'", TextView.class);
    target.tvProductPrice = Utils.findRequiredViewAsType(source, R.id.tv_product_price, "field 'tvProductPrice'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_content, "field 'llContent' and method 'onViewClicked'");
    target.llContent = Utils.castView(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
    view2131296468 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ivQrCode = Utils.findRequiredViewAsType(source, R.id.iv_qr_code, "field 'ivQrCode'", ImageView.class);
    target.tvIdentifyingCode = Utils.findRequiredViewAsType(source, R.id.tv_identifying_code, "field 'tvIdentifyingCode'", TextView.class);
    target.llProductInfo = Utils.findRequiredViewAsType(source, R.id.ll_product_info, "field 'llProductInfo'", LinearLayout.class);
    target.llOrderInfo = Utils.findRequiredViewAsType(source, R.id.ll_order_info, "field 'llOrderInfo'", LinearLayout.class);
    target.llCode = Utils.findRequiredViewAsType(source, R.id.ll_code, "field 'llCode'", LinearLayout.class);
    target.tvProductInfo = Utils.findRequiredViewAsType(source, R.id.tv_product_info, "field 'tvProductInfo'", TextView.class);
    target.rvProductInfo = Utils.findRequiredViewAsType(source, R.id.rv_product_info, "field 'rvProductInfo'", TextView.class);
    target.tvOrderInfo = Utils.findRequiredViewAsType(source, R.id.tv_order_info, "field 'tvOrderInfo'", TextView.class);
    target.rvOrderInfo = Utils.findRequiredViewAsType(source, R.id.rv_order_info, "field 'rvOrderInfo'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.tvIsUsed = null;
    target.toolbar = null;
    target.tvOrderStatu = null;
    target.tvStatuButton = null;
    target.ivProductImg = null;
    target.tvOrderStatus = null;
    target.tvProductName = null;
    target.tvProductTime = null;
    target.tvProductNum = null;
    target.tvOrderNum = null;
    target.tvProductPrice = null;
    target.llContent = null;
    target.ivQrCode = null;
    target.tvIdentifyingCode = null;
    target.llProductInfo = null;
    target.llOrderInfo = null;
    target.llCode = null;
    target.tvProductInfo = null;
    target.rvProductInfo = null;
    target.tvOrderInfo = null;
    target.rvOrderInfo = null;

    view2131296876.setOnClickListener(null);
    view2131296876 = null;
    view2131296468.setOnClickListener(null);
    view2131296468 = null;

    this.target = null;
  }
}
