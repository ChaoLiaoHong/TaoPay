// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.PswInputView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PayPwdActivity_ViewBinding<T extends PayPwdActivity> implements Unbinder {
  protected T target;

  private View view2131296515;

  private View view2131296529;

  @UiThread
  public PayPwdActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.pswInput = Utils.findRequiredViewAsType(source, R.id.psw_input, "field 'pswInput'", PswInputView.class);
    target.codeEditText = Utils.findRequiredViewAsType(source, R.id.code_EditText, "field 'codeEditText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.mGain_Code, "field 'mGainCode' and method 'onClick'");
    target.mGainCode = Utils.castView(view, R.id.mGain_Code, "field 'mGainCode'", TextView.class);
    view2131296515 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mSave, "field 'mSave' and method 'onClick'");
    target.mSave = Utils.castView(view, R.id.mSave, "field 'mSave'", Button.class);
    view2131296529 = view;
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
    target.pswInput = null;
    target.codeEditText = null;
    target.mGainCode = null;
    target.mSave = null;

    view2131296515.setOnClickListener(null);
    view2131296515 = null;
    view2131296529.setOnClickListener(null);
    view2131296529 = null;

    this.target = null;
  }
}
