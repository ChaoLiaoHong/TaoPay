// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.fragment;

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

public class AmoyPointFragment_ViewBinding<T extends AmoyPointFragment> implements Unbinder {
  protected T target;

  private View view2131296649;

  private View view2131296534;

  private View view2131296530;

  private View view2131296546;

  @UiThread
  public AmoyPointFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.scanCode, "field 'scanCode' and method 'onClick'");
    target.scanCode = Utils.castView(view, R.id.scanCode, "field 'scanCode'", ImageView.class);
    view2131296649 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mVoucher, "field 'mVoucher' and method 'onClick'");
    target.mVoucher = Utils.castView(view, R.id.mVoucher, "field 'mVoucher'", LinearLayout.class);
    view2131296534 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mShopTicket, "field 'mShopTicket' and method 'onClick'");
    target.mShopTicket = Utils.castView(view, R.id.mShopTicket, "field 'mShopTicket'", LinearLayout.class);
    view2131296530 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.myBalance, "field 'myBalance' and method 'onClick'");
    target.myBalance = Utils.castView(view, R.id.myBalance, "field 'myBalance'", LinearLayout.class);
    view2131296546 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mdot = Utils.findRequiredViewAsType(source, R.id.mDot, "field 'mdot'", TextView.class);
    target.mIntegral = Utils.findRequiredViewAsType(source, R.id.mIntegral, "field 'mIntegral'", TextView.class);
    target.mMcashCoupon = Utils.findRequiredViewAsType(source, R.id.mmcashCoupon, "field 'mMcashCoupon'", TextView.class);
    target.mBusinessCoupon = Utils.findRequiredViewAsType(source, R.id.mbusinessCoupon, "field 'mBusinessCoupon'", TextView.class);
    target.mAmount = Utils.findRequiredViewAsType(source, R.id.mAmount, "field 'mAmount'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbar = null;
    target.scanCode = null;
    target.mVoucher = null;
    target.mShopTicket = null;
    target.myBalance = null;
    target.mdot = null;
    target.mIntegral = null;
    target.mMcashCoupon = null;
    target.mBusinessCoupon = null;
    target.mAmount = null;

    view2131296649.setOnClickListener(null);
    view2131296649 = null;
    view2131296534.setOnClickListener(null);
    view2131296534 = null;
    view2131296530.setOnClickListener(null);
    view2131296530 = null;
    view2131296546.setOnClickListener(null);
    view2131296546 = null;

    this.target = null;
  }
}
