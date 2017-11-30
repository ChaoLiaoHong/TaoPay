// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.BoderCircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyStoreActivity_ViewBinding<T extends MyStoreActivity> implements Unbinder {
  protected T target;

  private View view2131296618;

  private View view2131296623;

  private View view2131296624;

  private View view2131296617;

  private View view2131296304;

  private View view2131296900;

  private View view2131296794;

  private View view2131296752;

  private View view2131296305;

  @UiThread
  public MyStoreActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.civStoreImg = Utils.findRequiredViewAsType(source, R.id.civ_store_img, "field 'civStoreImg'", BoderCircleImageView.class);
    target.tvFocus = Utils.findRequiredViewAsType(source, R.id.tv_focus, "field 'tvFocus'", TextView.class);
    target.tvFollow = Utils.findRequiredViewAsType(source, R.id.tv_follow, "field 'tvFollow'", TextView.class);
    target.llFocus = Utils.findRequiredViewAsType(source, R.id.ll_focus, "field 'llFocus'", LinearLayout.class);
    target.view = Utils.findRequiredView(source, R.id.view, "field 'view'");
    target.tvStoreName = Utils.findRequiredViewAsType(source, R.id.tv_store_name, "field 'tvStoreName'", TextView.class);
    target.tvStoreAddress = Utils.findRequiredViewAsType(source, R.id.tv_store_address, "field 'tvStoreAddress'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_my_product, "field 'rlMyProduct' and method 'onViewClicked'");
    target.rlMyProduct = Utils.castView(view, R.id.rl_my_product, "field 'rlMyProduct'", RelativeLayout.class);
    view2131296618 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_store_discount, "field 'rlStoreDiscount' and method 'onViewClicked'");
    target.rlStoreDiscount = Utils.castView(view, R.id.rl_store_discount, "field 'rlStoreDiscount'", RelativeLayout.class);
    view2131296623 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_store_setup, "field 'rlStoreSetup' and method 'onViewClicked'");
    target.rlStoreSetup = Utils.castView(view, R.id.rl_store_setup, "field 'rlStoreSetup'", RelativeLayout.class);
    view2131296624 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_make_collections_scanning, "field 'rlMakeCollectionsScanning' and method 'onViewClicked'");
    target.rlMakeCollectionsScanning = Utils.castView(view, R.id.rl_make_collections_scanning, "field 'rlMakeCollectionsScanning'", RelativeLayout.class);
    view2131296617 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.flBg = Utils.findRequiredViewAsType(source, R.id.fl_bg, "field 'flBg'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.bt_store_logoff, "field 'btStoreLogoff' and method 'onViewClicked'");
    target.btStoreLogoff = Utils.castView(view, R.id.bt_store_logoff, "field 'btStoreLogoff'", Button.class);
    view2131296304 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_write_off_exchange, "field 'tvWriteOffExchange' and method 'onViewClicked'");
    target.tvWriteOffExchange = Utils.castView(view, R.id.tv_write_off_exchange, "field 'tvWriteOffExchange'", TextView.class);
    view2131296900 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_exchange_order, "field 'tvExchangeOrder' and method 'onViewClicked'");
    target.tvExchangeOrder = Utils.castView(view, R.id.tv_exchange_order, "field 'tvExchangeOrder'", TextView.class);
    view2131296794 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_account_paid, "field 'tvAccountPaid' and method 'onViewClicked'");
    target.tvAccountPaid = Utils.castView(view, R.id.tv_account_paid, "field 'tvAccountPaid'", TextView.class);
    view2131296752 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.bt_store_logoff2, "field 'btStoreLogoff2' and method 'onViewClicked'");
    target.btStoreLogoff2 = Utils.castView(view, R.id.bt_store_logoff2, "field 'btStoreLogoff2'", TextView.class);
    view2131296305 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvCenterText = Utils.findRequiredViewAsType(source, R.id.tv_center_text, "field 'tvCenterText'", TextView.class);
    target.ll1 = Utils.findRequiredViewAsType(source, R.id.ll_1, "field 'll1'", LinearLayout.class);
    target.ll2 = Utils.findRequiredViewAsType(source, R.id.ll_2, "field 'll2'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbar = null;
    target.civStoreImg = null;
    target.tvFocus = null;
    target.tvFollow = null;
    target.llFocus = null;
    target.view = null;
    target.tvStoreName = null;
    target.tvStoreAddress = null;
    target.rlMyProduct = null;
    target.rlStoreDiscount = null;
    target.rlStoreSetup = null;
    target.rlMakeCollectionsScanning = null;
    target.flBg = null;
    target.btStoreLogoff = null;
    target.tvWriteOffExchange = null;
    target.tvExchangeOrder = null;
    target.tvAccountPaid = null;
    target.btStoreLogoff2 = null;
    target.tvCenterText = null;
    target.ll1 = null;
    target.ll2 = null;

    view2131296618.setOnClickListener(null);
    view2131296618 = null;
    view2131296623.setOnClickListener(null);
    view2131296623 = null;
    view2131296624.setOnClickListener(null);
    view2131296624 = null;
    view2131296617.setOnClickListener(null);
    view2131296617 = null;
    view2131296304.setOnClickListener(null);
    view2131296304 = null;
    view2131296900.setOnClickListener(null);
    view2131296900 = null;
    view2131296794.setOnClickListener(null);
    view2131296794 = null;
    view2131296752.setOnClickListener(null);
    view2131296752 = null;
    view2131296305.setOnClickListener(null);
    view2131296305 = null;

    this.target = null;
  }
}
