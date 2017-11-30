// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class PayActivity_ViewBinding<T extends PayActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  private View view2131296611;

  private View view2131296612;

  private View view2131296613;

  private View view2131296614;

  private View view2131296615;

  private View view2131296894;

  @UiThread
  public PayActivity_ViewBinding(final T target, View source) {
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
    target.tv1 = Utils.findRequiredViewAsType(source, R.id.tv_1, "field 'tv1'", TextView.class);
    target.tvDyBalance = Utils.findRequiredViewAsType(source, R.id.tv_dy_balance, "field 'tvDyBalance'", TextView.class);
    target.iv1 = Utils.findRequiredViewAsType(source, R.id.iv_1, "field 'iv1'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.rl_1, "field 'rl1' and method 'onViewClicked'");
    target.rl1 = Utils.castView(view, R.id.rl_1, "field 'rl1'", RelativeLayout.class);
    view2131296611 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tv2 = Utils.findRequiredViewAsType(source, R.id.tv_2, "field 'tv2'", TextView.class);
    target.tvScBalance = Utils.findRequiredViewAsType(source, R.id.tv_sc_balance, "field 'tvScBalance'", TextView.class);
    target.iv2 = Utils.findRequiredViewAsType(source, R.id.iv_2, "field 'iv2'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.rl_2, "field 'rl2' and method 'onViewClicked'");
    target.rl2 = Utils.castView(view, R.id.rl_2, "field 'rl2'", RelativeLayout.class);
    view2131296612 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tv3 = Utils.findRequiredViewAsType(source, R.id.tv_3, "field 'tv3'", TextView.class);
    target.tvXjBalance = Utils.findRequiredViewAsType(source, R.id.tv_xj_balance, "field 'tvXjBalance'", TextView.class);
    target.iv3 = Utils.findRequiredViewAsType(source, R.id.iv_3, "field 'iv3'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.rl_3, "field 'rl3' and method 'onViewClicked'");
    target.rl3 = Utils.castView(view, R.id.rl_3, "field 'rl3'", RelativeLayout.class);
    view2131296613 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tv4 = Utils.findRequiredViewAsType(source, R.id.tv_4, "field 'tv4'", TextView.class);
    target.tvWxBalance = Utils.findRequiredViewAsType(source, R.id.tv_wx_balance, "field 'tvWxBalance'", TextView.class);
    target.iv4 = Utils.findRequiredViewAsType(source, R.id.iv_4, "field 'iv4'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.rl_4, "field 'rl4' and method 'onViewClicked'");
    target.rl4 = Utils.castView(view, R.id.rl_4, "field 'rl4'", RelativeLayout.class);
    view2131296614 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tv5 = Utils.findRequiredViewAsType(source, R.id.tv_5, "field 'tv5'", TextView.class);
    target.tvZfbBalance = Utils.findRequiredViewAsType(source, R.id.tv_zfb_balance, "field 'tvZfbBalance'", TextView.class);
    target.iv5 = Utils.findRequiredViewAsType(source, R.id.iv_5, "field 'iv5'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.rl_5, "field 'rl5' and method 'onViewClicked'");
    target.rl5 = Utils.castView(view, R.id.rl_5, "field 'rl5'", RelativeLayout.class);
    view2131296615 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_true_pay_onClick, "field 'tvTruePayOnClick' and method 'onViewClicked'");
    target.tvTruePayOnClick = Utils.castView(view, R.id.tv_true_pay_onClick, "field 'tvTruePayOnClick'", TextView.class);
    view2131296894 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtMoney = Utils.findRequiredViewAsType(source, R.id.edt_money, "field 'edtMoney'", EditText.class);
    target.tvShopName = Utils.findRequiredViewAsType(source, R.id.tv_shopName, "field 'tvShopName'", TextView.class);
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
    target.tv1 = null;
    target.tvDyBalance = null;
    target.iv1 = null;
    target.rl1 = null;
    target.tv2 = null;
    target.tvScBalance = null;
    target.iv2 = null;
    target.rl2 = null;
    target.tv3 = null;
    target.tvXjBalance = null;
    target.iv3 = null;
    target.rl3 = null;
    target.tv4 = null;
    target.tvWxBalance = null;
    target.iv4 = null;
    target.rl4 = null;
    target.tv5 = null;
    target.tvZfbBalance = null;
    target.iv5 = null;
    target.rl5 = null;
    target.tvTruePayOnClick = null;
    target.edtMoney = null;
    target.tvShopName = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296611.setOnClickListener(null);
    view2131296611 = null;
    view2131296612.setOnClickListener(null);
    view2131296612 = null;
    view2131296613.setOnClickListener(null);
    view2131296613 = null;
    view2131296614.setOnClickListener(null);
    view2131296614 = null;
    view2131296615.setOnClickListener(null);
    view2131296615 = null;
    view2131296894.setOnClickListener(null);
    view2131296894 = null;

    this.target = null;
  }
}
