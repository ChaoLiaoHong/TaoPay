// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoticeDetailsActivity_ViewBinding<T extends NoticeDetailsActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  @UiThread
  public NoticeDetailsActivity_ViewBinding(final T target, View source) {
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
    target.topBtnRight = Utils.findRequiredViewAsType(source, R.id.top_btn_right, "field 'topBtnRight'", Button.class);
    target.topIvRight = Utils.findRequiredViewAsType(source, R.id.top_iv_right, "field 'topIvRight'", ImageView.class);
    target.topView = Utils.findRequiredViewAsType(source, R.id.topView, "field 'topView'", LinearLayout.class);
    target.tvNoticeName = Utils.findRequiredViewAsType(source, R.id.tv_notice_name, "field 'tvNoticeName'", TextView.class);
    target.tvNoticeDate = Utils.findRequiredViewAsType(source, R.id.tv_notice_date, "field 'tvNoticeDate'", TextView.class);
    target.tvNoticeContent = Utils.findRequiredViewAsType(source, R.id.tv_notice_content, "field 'tvNoticeContent'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.topBtnLeft = null;
    target.topTitle = null;
    target.topBtnRight = null;
    target.topIvRight = null;
    target.topView = null;
    target.tvNoticeName = null;
    target.tvNoticeDate = null;
    target.tvNoticeContent = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;

    this.target = null;
  }
}
