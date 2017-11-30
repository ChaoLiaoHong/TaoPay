// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TestExamineAndVerifyActivity_ViewBinding<T extends TestExamineAndVerifyActivity> implements Unbinder {
  protected T target;

  private View view2131296888;

  @UiThread
  public TestExamineAndVerifyActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_test, "field 'tvTest' and method 'onViewClicked'");
    target.tvTest = Utils.castView(view, R.id.tv_test, "field 'tvTest'", TextView.class);
    view2131296888 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tvTest = null;

    view2131296888.setOnClickListener(null);
    view2131296888 = null;

    this.target = null;
  }
}
