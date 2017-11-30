// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginPwdActivity_ViewBinding<T extends LoginPwdActivity> implements Unbinder {
  protected T target;

  private View view2131296406;

  private View view2131296679;

  private View view2131296529;

  @UiThread
  public LoginPwdActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.newPwd = Utils.findRequiredViewAsType(source, R.id.new_pwd, "field 'newPwd'", EditText.class);
    view = Utils.findRequiredView(source, R.id.hide, "field 'hide' and method 'onClick'");
    target.hide = Utils.castView(view, R.id.hide, "field 'hide'", ImageView.class);
    view2131296406 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.newPwds = Utils.findRequiredViewAsType(source, R.id.new_pwds, "field 'newPwds'", EditText.class);
    view = Utils.findRequiredView(source, R.id.show, "field 'show' and method 'onClick'");
    target.show = Utils.castView(view, R.id.show, "field 'show'", ImageView.class);
    view2131296679 = view;
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
    target.newPwd = null;
    target.hide = null;
    target.newPwds = null;
    target.show = null;
    target.mSave = null;

    view2131296406.setOnClickListener(null);
    view2131296406 = null;
    view2131296679.setOnClickListener(null);
    view2131296679 = null;
    view2131296529.setOnClickListener(null);
    view2131296529 = null;

    this.target = null;
  }
}
