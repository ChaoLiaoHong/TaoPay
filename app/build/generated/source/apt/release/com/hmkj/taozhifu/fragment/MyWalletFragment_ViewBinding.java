// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyWalletFragment_ViewBinding<T extends MyWalletFragment> implements Unbinder {
  protected T target;

  @UiThread
  public MyWalletFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recyclerView = null;

    this.target = null;
  }
}
