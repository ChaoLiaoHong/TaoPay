// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WithdrawDepositActivity_ViewBinding<T extends WithdrawDepositActivity> implements Unbinder {
  protected T target;

  private View view2131296291;

  private View view2131296702;

  private View view2131296733;

  private View view2131296734;

  @UiThread
  public WithdrawDepositActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.wxAnumber = Utils.findRequiredViewAsType(source, R.id.wxAnumber, "field 'wxAnumber'", RadioButton.class);
    target.zfbAnumber = Utils.findRequiredViewAsType(source, R.id.zfbAnumber, "field 'zfbAnumber'", RadioButton.class);
    target.tixianMoney = Utils.findRequiredViewAsType(source, R.id.tixian_money, "field 'tixianMoney'", EditText.class);
    target.balanceMoney = Utils.findRequiredViewAsType(source, R.id.balance_money, "field 'balanceMoney'", TextView.class);
    view = Utils.findRequiredView(source, R.id.all_withdraw, "field 'allWithdraw' and method 'onClick'");
    target.allWithdraw = Utils.castView(view, R.id.all_withdraw, "field 'allWithdraw'", TextView.class);
    view2131296291 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sure_withdraw, "field 'sureWithdraw' and method 'onClick'");
    target.sureWithdraw = Utils.castView(view, R.id.sure_withdraw, "field 'sureWithdraw'", Button.class);
    view2131296702 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.payWay = Utils.findRequiredViewAsType(source, R.id.payWay, "field 'payWay'", RadioGroup.class);
    target.alipay_ly = Utils.findRequiredViewAsType(source, R.id.alipay_ly, "field 'alipay_ly'", LinearLayout.class);
    target.edtAccountNumber = Utils.findRequiredViewAsType(source, R.id.edt_account_number, "field 'edtAccountNumber'", EditText.class);
    target.edtName = Utils.findRequiredViewAsType(source, R.id.edt_name, "field 'edtName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.top_btn_left, "field 'topBtnLeft' and method 'onClick'");
    target.topBtnLeft = Utils.castView(view, R.id.top_btn_left, "field 'topBtnLeft'", Button.class);
    view2131296733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.topTitle = Utils.findRequiredViewAsType(source, R.id.top_title, "field 'topTitle'", TextView.class);
    target.topView = Utils.findRequiredViewAsType(source, R.id.topView, "field 'topView'", LinearLayout.class);
    target.textView2 = Utils.findRequiredViewAsType(source, R.id.textView2, "field 'textView2'", TextView.class);
    view = Utils.findRequiredView(source, R.id.top_btn_right, "field 'topBtnRight' and method 'onClick'");
    target.topBtnRight = Utils.castView(view, R.id.top_btn_right, "field 'topBtnRight'", Button.class);
    view2131296734 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
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
    target.wxAnumber = null;
    target.zfbAnumber = null;
    target.tixianMoney = null;
    target.balanceMoney = null;
    target.allWithdraw = null;
    target.sureWithdraw = null;
    target.payWay = null;
    target.alipay_ly = null;
    target.edtAccountNumber = null;
    target.edtName = null;
    target.topBtnLeft = null;
    target.topTitle = null;
    target.topView = null;
    target.textView2 = null;
    target.topBtnRight = null;

    view2131296291.setOnClickListener(null);
    view2131296291 = null;
    view2131296702.setOnClickListener(null);
    view2131296702 = null;
    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296734.setOnClickListener(null);
    view2131296734 = null;

    this.target = null;
  }
}
