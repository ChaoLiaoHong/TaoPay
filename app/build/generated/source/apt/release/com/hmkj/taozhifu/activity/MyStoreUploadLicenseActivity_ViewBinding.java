// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyStoreUploadLicenseActivity_ViewBinding<T extends MyStoreUploadLicenseActivity> implements Unbinder {
  protected T target;

  private View view2131296727;

  private View view2131296434;

  private View view2131296621;

  @UiThread
  public MyStoreUploadLicenseActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.toolbar_menu, "field 'toolbarMenu' and method 'onViewClicked'");
    target.toolbarMenu = Utils.castView(view, R.id.toolbar_menu, "field 'toolbarMenu'", TextView.class);
    view2131296727 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.etStoreName = Utils.findRequiredViewAsType(source, R.id.et_store_name, "field 'etStoreName'", NOPasteEditText.class);
    view = Utils.findRequiredView(source, R.id.iv_delete_store_name, "field 'ivDeleteStoreName' and method 'onViewClicked'");
    target.ivDeleteStoreName = Utils.castView(view, R.id.iv_delete_store_name, "field 'ivDeleteStoreName'", ImageView.class);
    view2131296434 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ivSelectMainPic = Utils.findRequiredViewAsType(source, R.id.iv_select_main_pic, "field 'ivSelectMainPic'", ImageView.class);
    target.ivProductMainImg = Utils.findRequiredViewAsType(source, R.id.iv_product_main_img, "field 'ivProductMainImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.rl_select_product_main_img, "field 'rlSelectProductMainImg' and method 'onViewClicked'");
    target.rlSelectProductMainImg = Utils.castView(view, R.id.rl_select_product_main_img, "field 'rlSelectProductMainImg'", RelativeLayout.class);
    view2131296621 = view;
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
    target.toolbarMenu = null;
    target.toolbar = null;
    target.etStoreName = null;
    target.ivDeleteStoreName = null;
    target.ivSelectMainPic = null;
    target.ivProductMainImg = null;
    target.rlSelectProductMainImg = null;

    view2131296727.setOnClickListener(null);
    view2131296727 = null;
    view2131296434.setOnClickListener(null);
    view2131296434 = null;
    view2131296621.setOnClickListener(null);
    view2131296621 = null;

    this.target = null;
  }
}
