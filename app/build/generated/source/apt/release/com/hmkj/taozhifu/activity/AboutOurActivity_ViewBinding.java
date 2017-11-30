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

public class AboutOurActivity_ViewBinding<T extends AboutOurActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  @UiThread
  public AboutOurActivity_ViewBinding(final T target, View source) {
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
    target.wbAboutOur = Utils.findRequiredViewAsType(source, R.id.wb_about_our, "field 'wbAboutOur'", WebView.class);
    target.tvAboutOur = Utils.findRequiredViewAsType(source, R.id.tv_about_our, "field 'tvAboutOur'", TextView.class);
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
    target.wbAboutOur = null;
    target.tvAboutOur = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;

    this.target = null;
  }
}
