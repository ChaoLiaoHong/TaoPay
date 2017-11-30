// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LaunchActivity_ViewBinding<T extends LaunchActivity> implements Unbinder {
  protected T target;

  @UiThread
  public LaunchActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.welcomeIv = Utils.findRequiredViewAsType(source, R.id.welcome_iv, "field 'welcomeIv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.welcomeIv = null;

    this.target = null;
  }
}
