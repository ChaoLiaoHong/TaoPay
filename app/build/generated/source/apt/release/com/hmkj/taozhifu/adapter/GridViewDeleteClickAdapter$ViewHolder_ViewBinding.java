// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GridViewDeleteClickAdapter$ViewHolder_ViewBinding<T extends GridViewDeleteClickAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public GridViewDeleteClickAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.ivImg = Utils.findRequiredViewAsType(source, R.id.iv_img, "field 'ivImg'", ImageView.class);
    target.ivDeleteImg = Utils.findRequiredViewAsType(source, R.id.iv_delete_img, "field 'ivDeleteImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivImg = null;
    target.ivDeleteImg = null;

    this.target = null;
  }
}
