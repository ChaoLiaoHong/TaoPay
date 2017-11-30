// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CaptureActivity_ViewBinding<T extends CaptureActivity> implements Unbinder {
  protected T target;

  private View view2131296298;

  private View view2131296575;

  @UiThread
  public CaptureActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.back, "field 'back', method 'onClick', and method 'onViewClicked'");
    target.back = Utils.castView(view, R.id.back, "field 'back'", ImageView.class);
    view2131296298 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
        target.onViewClicked();
      }
    });
    target.flMyContainer = Utils.findRequiredViewAsType(source, R.id.fl_my_container, "field 'flMyContainer'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.photoImg, "field 'photoImg' and method 'onClick'");
    target.photoImg = Utils.castView(view, R.id.photoImg, "field 'photoImg'", TextView.class);
    view2131296575 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.back = null;
    target.flMyContainer = null;
    target.photoImg = null;

    view2131296298.setOnClickListener(null);
    view2131296298 = null;
    view2131296575.setOnClickListener(null);
    view2131296575 = null;

    this.target = null;
  }
}
