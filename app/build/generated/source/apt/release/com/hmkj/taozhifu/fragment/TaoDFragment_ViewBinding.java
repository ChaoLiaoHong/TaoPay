// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaoDFragment_ViewBinding<T extends TaoDFragment> implements Unbinder {
  protected T target;

  @UiThread
  public TaoDFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.tvNullStateContent = Utils.findRequiredViewAsType(source, R.id.tv_null_state_content, "field 'tvNullStateContent'", TextView.class);
    target.tvNullStateOnClick = Utils.findRequiredViewAsType(source, R.id.tv_null_state_onClick, "field 'tvNullStateOnClick'", TextView.class);
    target.llNullState = Utils.findRequiredViewAsType(source, R.id.ll_null_state, "field 'llNullState'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recyclerView = null;
    target.tvNullStateContent = null;
    target.tvNullStateOnClick = null;
    target.llNullState = null;

    this.target = null;
  }
}
