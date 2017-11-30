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

public class AutonymActivity_ViewBinding<T extends AutonymActivity> implements Unbinder {
  protected T target;

  private View view2131296529;

  @UiThread
  public AutonymActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.real_Name = Utils.findRequiredViewAsType(source, R.id.real_Name, "field 'real_Name'", EditText.class);
    view = Utils.findRequiredView(source, R.id.mSave, "field 'mSave' and method 'onClick'");
    target.mSave = Utils.castView(view, R.id.mSave, "field 'mSave'", Button.class);
    view2131296529 = view;
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
    target.real_Name = null;
    target.mSave = null;

    view2131296529.setOnClickListener(null);
    view2131296529 = null;

    this.target = null;
  }
}
