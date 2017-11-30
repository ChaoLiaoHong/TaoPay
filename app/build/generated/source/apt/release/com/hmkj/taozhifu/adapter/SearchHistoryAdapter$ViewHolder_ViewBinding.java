// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchHistoryAdapter$ViewHolder_ViewBinding<T extends SearchHistoryAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public SearchHistoryAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tagBtn = Utils.findRequiredViewAsType(source, R.id.tag_btn, "field 'tagBtn'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tagBtn = null;

    this.target = null;
  }
}
