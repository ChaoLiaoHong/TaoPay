// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.flowlayoututil.TagCloudLayout;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchShoppingActivity_ViewBinding<T extends SearchShoppingActivity> implements Unbinder {
  protected T target;

  private View view2131296367;

  private View view2131296410;

  private View view2131296764;

  private View view2131296409;

  @UiThread
  public SearchShoppingActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.edt_input, "field 'edtInput' and method 'onClick'");
    target.edtInput = Utils.castView(view, R.id.edt_input, "field 'edtInput'", NOPasteEditText.class);
    view2131296367 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ico_search, "field 'icoSearch' and method 'onClick'");
    target.icoSearch = Utils.castView(view, R.id.ico_search, "field 'icoSearch'", ImageView.class);
    view2131296410 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_cancel, "field 'tvCancel' and method 'onClick'");
    target.tvCancel = Utils.castView(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
    view2131296764 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ico_delete, "field 'icoDelete' and method 'onClick'");
    target.icoDelete = Utils.castView(view, R.id.ico_delete, "field 'icoDelete'", ImageView.class);
    view2131296409 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", TagCloudLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.edtInput = null;
    target.icoSearch = null;
    target.tvCancel = null;
    target.icoDelete = null;
    target.container = null;

    view2131296367.setOnClickListener(null);
    view2131296367 = null;
    view2131296410.setOnClickListener(null);
    view2131296410 = null;
    view2131296764.setOnClickListener(null);
    view2131296764 = null;
    view2131296409.setOnClickListener(null);
    view2131296409 = null;

    this.target = null;
  }
}
