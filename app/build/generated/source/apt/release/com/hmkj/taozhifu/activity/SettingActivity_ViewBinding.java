// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding<T extends SettingActivity> implements Unbinder {
  protected T target;

  private View view2131296922;

  private View view2131296340;

  private View view2131296333;

  private View view2131296260;

  private View view2131296513;

  @UiThread
  public SettingActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.versin_update, "field 'versinUpdate' and method 'onClick'");
    target.versinUpdate = Utils.castView(view, R.id.versin_update, "field 'versinUpdate'", LinearLayout.class);
    view2131296922 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.contact_our, "field 'contactOur' and method 'onClick'");
    target.contactOur = Utils.castView(view, R.id.contact_our, "field 'contactOur'", LinearLayout.class);
    view2131296340 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    target.cacheSize = Utils.findRequiredViewAsType(source, R.id.cacheSize, "field 'cacheSize'", TextView.class);
    view = Utils.findRequiredView(source, R.id.clearCache_ly, "field 'clearCacheLy' and method 'onClick'");
    target.clearCacheLy = Utils.castView(view, R.id.clearCache_ly, "field 'clearCacheLy'", LinearLayout.class);
    view2131296333 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.about_our, "field 'aboutOur' and method 'onClick'");
    target.aboutOur = Utils.castView(view, R.id.about_our, "field 'aboutOur'", TextView.class);
    view2131296260 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mExit, "field 'mExit' and method 'onClick'");
    target.mExit = Utils.castView(view, R.id.mExit, "field 'mExit'", Button.class);
    view2131296513 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.versionCode = Utils.findRequiredViewAsType(source, R.id.versionCode, "field 'versionCode'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbar = null;
    target.versinUpdate = null;
    target.contactOur = null;
    target.tvPhone = null;
    target.cacheSize = null;
    target.clearCacheLy = null;
    target.aboutOur = null;
    target.mExit = null;
    target.versionCode = null;

    view2131296922.setOnClickListener(null);
    view2131296922 = null;
    view2131296340.setOnClickListener(null);
    view2131296340 = null;
    view2131296333.setOnClickListener(null);
    view2131296333 = null;
    view2131296260.setOnClickListener(null);
    view2131296260 = null;
    view2131296513.setOnClickListener(null);
    view2131296513 = null;

    this.target = null;
  }
}
