// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

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

public class PersonInfoActivity_ViewBinding<T extends PersonInfoActivity> implements Unbinder {
  protected T target;

  private View view2131296405;

  private View view2131296672;

  private View view2131296597;

  private View view2131296501;

  private View view2131296572;

  @UiThread
  public PersonInfoActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.head_ly, "field 'headLy' and method 'onClick'");
    target.headLy = Utils.castView(view, R.id.head_ly, "field 'headLy'", LinearLayout.class);
    view2131296405 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.sex = Utils.findRequiredViewAsType(source, R.id.sex, "field 'sex'", TextView.class);
    view = Utils.findRequiredView(source, R.id.sex_ly, "field 'sexLy' and method 'onClick'");
    target.sexLy = Utils.castView(view, R.id.sex_ly, "field 'sexLy'", LinearLayout.class);
    view2131296672 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.realName = Utils.findRequiredViewAsType(source, R.id.real_name, "field 'realName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.realName_ly, "field 'realNameLy' and method 'onClick'");
    target.realNameLy = Utils.castView(view, R.id.realName_ly, "field 'realNameLy'", LinearLayout.class);
    view2131296597 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.loginPwd_ly, "field 'loginPwdLy' and method 'onClick'");
    target.loginPwdLy = Utils.castView(view, R.id.loginPwd_ly, "field 'loginPwdLy'", LinearLayout.class);
    view2131296501 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.payPwd_ly, "field 'payPwdLy' and method 'onClick'");
    target.payPwdLy = Utils.castView(view, R.id.payPwd_ly, "field 'payPwdLy'", LinearLayout.class);
    view2131296572 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mHead = Utils.findRequiredViewAsType(source, R.id.mHead, "field 'mHead'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbar = null;
    target.headLy = null;
    target.sex = null;
    target.sexLy = null;
    target.realName = null;
    target.realNameLy = null;
    target.loginPwdLy = null;
    target.payPwdLy = null;
    target.mHead = null;

    view2131296405.setOnClickListener(null);
    view2131296405 = null;
    view2131296672.setOnClickListener(null);
    view2131296672 = null;
    view2131296597.setOnClickListener(null);
    view2131296597 = null;
    view2131296501.setOnClickListener(null);
    view2131296501 = null;
    view2131296572.setOnClickListener(null);
    view2131296572 = null;

    this.target = null;
  }
}
