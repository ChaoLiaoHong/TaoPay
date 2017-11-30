// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
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

public class ShareZXcodeActivity_ViewBinding<T extends ShareZXcodeActivity> implements Unbinder {
  protected T target;

  private View view2131296728;

  private View view2131296648;

  @UiThread
  public ShareZXcodeActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.LlBg = Utils.findRequiredViewAsType(source, R.id.ll_bg, "field 'LlBg'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.toolbar_title, "field 'toolbarTitle' and method 'onClick'");
    target.toolbarTitle = Utils.castView(view, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    view2131296728 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.mZXcode = Utils.findRequiredViewAsType(source, R.id.mZXcode, "field 'mZXcode'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.saveCode, "field 'saveCode' and method 'onClick'");
    target.saveCode = Utils.castView(view, R.id.saveCode, "field 'saveCode'", TextView.class);
    view2131296648 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.textCK = Utils.findRequiredViewAsType(source, R.id.textCK, "field 'textCK'", TextView.class);
    target.textCK1 = Utils.findRequiredViewAsType(source, R.id.textCK1, "field 'textCK1'", TextView.class);
    target.rvPayInfo = Utils.findRequiredViewAsType(source, R.id.rv_payInfo, "field 'rvPayInfo'", RecyclerView.class);
    target.tvShopName = Utils.findRequiredViewAsType(source, R.id.tv_shopName, "field 'tvShopName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.LlBg = null;
    target.toolbarTitle = null;
    target.toolbar = null;
    target.mZXcode = null;
    target.saveCode = null;
    target.recyclerView = null;
    target.textCK = null;
    target.textCK1 = null;
    target.rvPayInfo = null;
    target.tvShopName = null;

    view2131296728.setOnClickListener(null);
    view2131296728 = null;
    view2131296648.setOnClickListener(null);
    view2131296648 = null;

    this.target = null;
  }
}
