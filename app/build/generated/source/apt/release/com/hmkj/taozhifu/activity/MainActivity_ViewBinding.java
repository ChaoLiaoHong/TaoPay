// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.NoScrollViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.navigation = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'navigation'", BottomNavigationView.class);
    target.vpHome = Utils.findRequiredViewAsType(source, R.id.vp_home, "field 'vpHome'", NoScrollViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.navigation = null;
    target.vpHome = null;

    this.target = null;
  }
}
