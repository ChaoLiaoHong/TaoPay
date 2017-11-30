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
import java.lang.IllegalStateException;
import java.lang.Override;

public class SetPwdForgetActivity_ViewBinding<T extends SetPwdForgetActivity> implements Unbinder {
  protected T target;

  private View view2131296528;

  @UiThread
  public SetPwdForgetActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.mPwd = Utils.findRequiredViewAsType(source, R.id.mPwd, "field 'mPwd'", EditText.class);
    target.mPwds = Utils.findRequiredViewAsType(source, R.id.mPwds, "field 'mPwds'", EditText.class);
    view = Utils.findRequiredView(source, R.id.mRegist, "field 'mRegist' and method 'onClick'");
    target.mRegist = Utils.castView(view, R.id.mRegist, "field 'mRegist'", Button.class);
    view2131296528 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
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
    target.mPwd = null;
    target.mPwds = null;
    target.mRegist = null;

    view2131296528.setOnClickListener(null);
    view2131296528 = null;

    this.target = null;
  }
}
