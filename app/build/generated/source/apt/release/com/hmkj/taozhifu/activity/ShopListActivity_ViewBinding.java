// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShopListActivity_ViewBinding<T extends ShopListActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  private View view2131296661;

  private View view2131296448;

  @UiThread
  public ShopListActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.topView = Utils.findRequiredViewAsType(source, R.id.topView, "field 'topView'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.top_btn_left, "field 'topBtnLeft' and method 'onViewClicked'");
    target.topBtnLeft = Utils.castView(view, R.id.top_btn_left, "field 'topBtnLeft'", Button.class);
    view2131296733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.topTitle = Utils.findRequiredViewAsType(source, R.id.top_title, "field 'topTitle'", TextView.class);
    target.rv_commodity_list_info = Utils.findRequiredViewAsType(source, R.id.rv_commodity_list_info, "field 'rv_commodity_list_info'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.search_btn_left, "field 'searchBtnLeft' and method 'onViewClicked'");
    target.searchBtnLeft = Utils.castView(view, R.id.search_btn_left, "field 'searchBtnLeft'", Button.class);
    view2131296661 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_search, "field 'ivSearch' and method 'onViewClicked'");
    target.ivSearch = Utils.castView(view, R.id.iv_search, "field 'ivSearch'", ImageView.class);
    view2131296448 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtInput = Utils.findRequiredViewAsType(source, R.id.edt_input, "field 'edtInput'", NOPasteEditText.class);
    target.topSearchVIew = Utils.findRequiredViewAsType(source, R.id.topSearchVIew, "field 'topSearchVIew'", LinearLayout.class);
    target.tvNullStateContent = Utils.findRequiredViewAsType(source, R.id.tv_null_state_content, "field 'tvNullStateContent'", TextView.class);
    target.tvNullStateOnClick = Utils.findRequiredViewAsType(source, R.id.tv_null_state_onClick, "field 'tvNullStateOnClick'", TextView.class);
    target.llNullState = Utils.findRequiredViewAsType(source, R.id.ll_null_state, "field 'llNullState'", LinearLayout.class);
    target.srv = Utils.findRequiredViewAsType(source, R.id.srv, "field 'srv'", SwipeRefreshView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.topView = null;
    target.topBtnLeft = null;
    target.topTitle = null;
    target.rv_commodity_list_info = null;
    target.searchBtnLeft = null;
    target.ivSearch = null;
    target.edtInput = null;
    target.topSearchVIew = null;
    target.tvNullStateContent = null;
    target.tvNullStateOnClick = null;
    target.llNullState = null;
    target.srv = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296661.setOnClickListener(null);
    view2131296661 = null;
    view2131296448.setOnClickListener(null);
    view2131296448 = null;

    this.target = null;
  }
}
