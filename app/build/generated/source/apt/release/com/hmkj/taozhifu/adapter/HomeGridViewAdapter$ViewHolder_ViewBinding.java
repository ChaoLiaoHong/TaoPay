// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.BoderCircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeGridViewAdapter$ViewHolder_ViewBinding<T extends HomeGridViewAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public HomeGridViewAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.circleImg = Utils.findRequiredViewAsType(source, R.id.circle_img, "field 'circleImg'", BoderCircleImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.circleImg = null;
    target.tvTitle = null;

    this.target = null;
  }
}
