// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserCommentsActivity_ViewBinding<T extends UserCommentsActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  @UiThread
  public UserCommentsActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.top_btn_left, "field 'topBtnLeft' and method 'onViewClicked'");
    target.topBtnLeft = Utils.castView(view, R.id.top_btn_left, "field 'topBtnLeft'", Button.class);
    view2131296733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.topTitle = Utils.findRequiredViewAsType(source, R.id.top_title, "field 'topTitle'", TextView.class);
    target.topView = Utils.findRequiredViewAsType(source, R.id.topView, "field 'topView'", LinearLayout.class);
    target.rvCommentsInfo = Utils.findRequiredViewAsType(source, R.id.rv_comments_info, "field 'rvCommentsInfo'", RecyclerView.class);
    target.refreshView = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refreshView'", SwipeRefreshView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.topBtnLeft = null;
    target.topTitle = null;
    target.topView = null;
    target.rvCommentsInfo = null;
    target.refreshView = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;

    this.target = null;
  }
}
