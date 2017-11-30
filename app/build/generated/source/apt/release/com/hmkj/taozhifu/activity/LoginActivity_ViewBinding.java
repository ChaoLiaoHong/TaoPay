// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding<T extends LoginActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  private View view2131296514;

  private View view2131296521;

  private View view2131296528;

  private View view2131296525;

  private View view2131296509;

  private View view2131296515;

  @UiThread
  public LoginActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.top_btn_left, "field 'mBack' and method 'onClick'");
    target.mBack = Utils.castView(view, R.id.top_btn_left, "field 'mBack'", Button.class);
    view2131296733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mPhone = Utils.findRequiredViewAsType(source, R.id.mPhone, "field 'mPhone'", EditText.class);
    target.mPwd = Utils.findRequiredViewAsType(source, R.id.mPwd, "field 'mPwd'", NOPasteEditText.class);
    view = Utils.findRequiredView(source, R.id.mForgetPwd, "field 'mForgetPwd' and method 'onClick'");
    target.mForgetPwd = Utils.castView(view, R.id.mForgetPwd, "field 'mForgetPwd'", TextView.class);
    view2131296514 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mLogin, "field 'mLogin' and method 'onClick'");
    target.mLogin = Utils.castView(view, R.id.mLogin, "field 'mLogin'", Button.class);
    view2131296521 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mRegist, "field 'mRegist' and method 'onClick'");
    target.mRegist = Utils.castView(view, R.id.mRegist, "field 'mRegist'", TextView.class);
    view2131296528 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mPwdHide, "field 'mPwdHide' and method 'onClick'");
    target.mPwdHide = Utils.castView(view, R.id.mPwdHide, "field 'mPwdHide'", ImageView.class);
    view2131296525 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mCodeLogin, "field 'mCodeLogin' and method 'onClick'");
    target.mCodeLogin = Utils.castView(view, R.id.mCodeLogin, "field 'mCodeLogin'", Button.class);
    view2131296509 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.code_EditText = Utils.findRequiredViewAsType(source, R.id.code_EditText, "field 'code_EditText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.mGain_Code, "field 'mGainCode' and method 'onClick'");
    target.mGainCode = Utils.castView(view, R.id.mGain_Code, "field 'mGainCode'", TextView.class);
    view2131296515 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.codeLy = Utils.findRequiredViewAsType(source, R.id.codeLy, "field 'codeLy'", LinearLayout.class);
    target.pwdLy = Utils.findRequiredViewAsType(source, R.id.pwdLy, "field 'pwdLy'", LinearLayout.class);
    target.mTime = Utils.findRequiredViewAsType(source, R.id.mTime, "field 'mTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mBack = null;
    target.mPhone = null;
    target.mPwd = null;
    target.mForgetPwd = null;
    target.mLogin = null;
    target.mRegist = null;
    target.mPwdHide = null;
    target.mCodeLogin = null;
    target.code_EditText = null;
    target.mGainCode = null;
    target.codeLy = null;
    target.pwdLy = null;
    target.mTime = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296514.setOnClickListener(null);
    view2131296514 = null;
    view2131296521.setOnClickListener(null);
    view2131296521 = null;
    view2131296528.setOnClickListener(null);
    view2131296528 = null;
    view2131296525.setOnClickListener(null);
    view2131296525 = null;
    view2131296509.setOnClickListener(null);
    view2131296509 = null;
    view2131296515.setOnClickListener(null);
    view2131296515 = null;

    this.target = null;
  }
}
