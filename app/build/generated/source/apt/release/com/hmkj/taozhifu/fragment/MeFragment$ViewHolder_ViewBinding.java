// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MeFragment$ViewHolder_ViewBinding<T extends MeFragment.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public MeFragment$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.mImage = Utils.findRequiredViewAsType(source, R.id.mImage, "field 'mImage'", ImageView.class);
    target.mTitle = Utils.findRequiredViewAsType(source, R.id.mTitle, "field 'mTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mImage = null;
    target.mTitle = null;

    this.target = null;
  }
}
