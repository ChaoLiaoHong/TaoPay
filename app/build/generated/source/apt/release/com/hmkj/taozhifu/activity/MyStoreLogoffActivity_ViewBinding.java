// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyStoreLogoffActivity_ViewBinding<T extends MyStoreLogoffActivity> implements Unbinder {
  protected T target;

  private View view2131296727;

  @UiThread
  public MyStoreLogoffActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.npetReason = Utils.findRequiredViewAsType(source, R.id.npet_reason, "field 'npetReason'", NOPasteEditText.class);
    target.tvKindlyReminder = Utils.findRequiredViewAsType(source, R.id.tv_kindly_reminder, "field 'tvKindlyReminder'", TextView.class);
    view = Utils.findRequiredView(source, R.id.toolbar_menu, "method 'onViewClicked'");
    view2131296727 = view;
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

    target.toolbarTitle = null;
    target.toolbar = null;
    target.npetReason = null;
    target.tvKindlyReminder = null;

    view2131296727.setOnClickListener(null);
    view2131296727 = null;

    this.target = null;
  }
}
