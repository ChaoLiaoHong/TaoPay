// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SubmitOrderActivity_ViewBinding<T extends SubmitOrderActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  private View view2131296885;

  private View view2131296859;

  private View view2131296753;

  @UiThread
  public SubmitOrderActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.top_btn_left, "field 'topBtnLeft' and method 'onViewClicked'");
    target.topBtnLeft = Utils.castView(view, R.id.top_btn_left, "field 'topBtnLeft'", Button.class);
    view2131296733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.topTitle = Utils.findRequiredViewAsType(source, R.id.top_title, "field 'topTitle'", TextView.class);
    target.topBtnRight = Utils.findRequiredViewAsType(source, R.id.top_btn_right, "field 'topBtnRight'", Button.class);
    target.topIvRight = Utils.findRequiredViewAsType(source, R.id.top_iv_right, "field 'topIvRight'", ImageView.class);
    target.topView = Utils.findRequiredViewAsType(source, R.id.topView, "field 'topView'", LinearLayout.class);
    target.ivOrderImg = Utils.findRequiredViewAsType(source, R.id.iv_order_img, "field 'ivOrderImg'", ImageView.class);
    target.tvSubmitCommodityName = Utils.findRequiredViewAsType(source, R.id.tv_submit_commodity_name, "field 'tvSubmitCommodityName'", TextView.class);
    target.tvSubmitCommodityMoney = Utils.findRequiredViewAsType(source, R.id.tv_submit_commodity_money, "field 'tvSubmitCommodityMoney'", TextView.class);
    target.tvCommodityUseRule = Utils.findRequiredViewAsType(source, R.id.tv_commodity_use_rule, "field 'tvCommodityUseRule'", TextView.class);
    target.tvCommodityConvert = Utils.findRequiredViewAsType(source, R.id.tv_commodity_convert, "field 'tvCommodityConvert'", TextView.class);
    target.tvCommoditySale = Utils.findRequiredViewAsType(source, R.id.tv_commodity_sale, "field 'tvCommoditySale'", TextView.class);
    target.tvNumber = Utils.findRequiredViewAsType(source, R.id.tv_square, "field 'tvNumber'", TextView.class);
    target.tvGross = Utils.findRequiredViewAsType(source, R.id.tv_gross, "field 'tvGross'", TextView.class);
    target.tvTruePay = Utils.findRequiredViewAsType(source, R.id.tv_true_pay, "field 'tvTruePay'", TextView.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_submit_order, "field 'tvSubmitOrder' and method 'onViewClicked'");
    target.tvSubmitOrder = Utils.castView(view, R.id.tv_submit_order, "field 'tvSubmitOrder'", TextView.class);
    view2131296885 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_reduce, "field 'tvReduce' and method 'onViewClicked'");
    target.tvReduce = Utils.castView(view, R.id.tv_reduce, "field 'tvReduce'", ImageView.class);
    view2131296859 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_add, "field 'tvAdd' and method 'onViewClicked'");
    target.tvAdd = Utils.castView(view, R.id.tv_add, "field 'tvAdd'", ImageView.class);
    view2131296753 = view;
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

    target.topBtnLeft = null;
    target.topTitle = null;
    target.topBtnRight = null;
    target.topIvRight = null;
    target.topView = null;
    target.ivOrderImg = null;
    target.tvSubmitCommodityName = null;
    target.tvSubmitCommodityMoney = null;
    target.tvCommodityUseRule = null;
    target.tvCommodityConvert = null;
    target.tvCommoditySale = null;
    target.tvNumber = null;
    target.tvGross = null;
    target.tvTruePay = null;
    target.tvPhone = null;
    target.tvSubmitOrder = null;
    target.tvReduce = null;
    target.tvAdd = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296885.setOnClickListener(null);
    view2131296885 = null;
    view2131296859.setOnClickListener(null);
    view2131296859 = null;
    view2131296753.setOnClickListener(null);
    view2131296753 = null;

    this.target = null;
  }
}
