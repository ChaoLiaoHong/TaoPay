// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.HackyViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PhotoActivity_ViewBinding<T extends PhotoActivity> implements Unbinder {
  protected T target;

  @UiThread
  public PhotoActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", HackyViewPager.class);
    target.back = Utils.findRequiredViewAsType(source, R.id.back, "field 'back'", LinearLayout.class);
    target.page = Utils.findRequiredViewAsType(source, R.id.page, "field 'page'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.viewPager = null;
    target.back = null;
    target.page = null;

    this.target = null;
  }
}
