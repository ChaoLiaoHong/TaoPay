// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PaySuccessActivity_ViewBinding<T extends PaySuccessActivity> implements Unbinder {
  protected T target;

  private View view2131296734;

  private View view2131296860;

  private View view2131296767;

  private View view2131296861;

  @UiThread
  public PaySuccessActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.topBtnLeft = Utils.findRequiredViewAsType(source, R.id.top_btn_left, "field 'topBtnLeft'", Button.class);
    target.topTitle = Utils.findRequiredViewAsType(source, R.id.top_title, "field 'topTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.top_btn_right, "field 'topBtnRight' and method 'onViewClicked'");
    target.topBtnRight = Utils.castView(view, R.id.top_btn_right, "field 'topBtnRight'", Button.class);
    view2131296734 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.topIvRight = Utils.findRequiredViewAsType(source, R.id.top_iv_right, "field 'topIvRight'", ImageView.class);
    target.topView = Utils.findRequiredViewAsType(source, R.id.topView, "field 'topView'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_return, "field 'tvReturn' and method 'onViewClicked'");
    target.tvReturn = Utils.castView(view, R.id.tv_return, "field 'tvReturn'", TextView.class);
    view2131296860 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_check_order, "field 'tvCheckOrder' and method 'onViewClicked'");
    target.tvCheckOrder = Utils.castView(view, R.id.tv_check_order, "field 'tvCheckOrder'", TextView.class);
    view2131296767 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvTicket = Utils.findRequiredViewAsType(source, R.id.tv_ticket, "field 'tvTicket'", TextView.class);
    target.tvReceiptShop = Utils.findRequiredViewAsType(source, R.id.tv_receipt_shop, "field 'tvReceiptShop'", TextView.class);
    target.orderNumber = Utils.findRequiredViewAsType(source, R.id.order_number, "field 'orderNumber'", TextView.class);
    target.tvPayDate = Utils.findRequiredViewAsType(source, R.id.tv_pay_date, "field 'tvPayDate'", TextView.class);
    target.llOrderNum = Utils.findRequiredViewAsType(source, R.id.ll_order_num, "field 'llOrderNum'", LinearLayout.class);
    target.llCheck = Utils.findRequiredViewAsType(source, R.id.ll_check, "field 'llCheck'", LinearLayout.class);
    target.rlReturn = Utils.findRequiredViewAsType(source, R.id.rl_return, "field 'rlReturn'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_return2, "field 'tvReturn2' and method 'onViewClicked'");
    target.tvReturn2 = Utils.castView(view, R.id.tv_return2, "field 'tvReturn2'", TextView.class);
    view2131296861 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvSuccessMoney = Utils.findRequiredViewAsType(source, R.id.tv_success_money, "field 'tvSuccessMoney'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.topBtnLeft = null;
    target.topTitle = null;
    target.topBtnRight = null;
    target.topIvRight = null;
    target.topView = null;
    target.tvReturn = null;
    target.tvCheckOrder = null;
    target.tvTicket = null;
    target.tvReceiptShop = null;
    target.orderNumber = null;
    target.tvPayDate = null;
    target.llOrderNum = null;
    target.llCheck = null;
    target.rlReturn = null;
    target.tvReturn2 = null;
    target.tvSuccessMoney = null;

    view2131296734.setOnClickListener(null);
    view2131296734 = null;
    view2131296860.setOnClickListener(null);
    view2131296860 = null;
    view2131296767.setOnClickListener(null);
    view2131296767 = null;
    view2131296861.setOnClickListener(null);
    view2131296861 = null;

    this.target = null;
  }
}
