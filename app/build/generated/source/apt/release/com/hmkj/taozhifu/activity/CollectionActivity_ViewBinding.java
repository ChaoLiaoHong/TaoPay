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
import java.lang.IllegalStateException;
import java.lang.Override;

public class CollectionActivity_ViewBinding<T extends CollectionActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  private View view2131296488;

  private View view2131296466;

  private View view2131296823;

  @UiThread
  public CollectionActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
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
    target.topBtnRight = Utils.findRequiredViewAsType(source, R.id.top_btn_right, "field 'topBtnRight'", Button.class);
    target.topIvRight = Utils.findRequiredViewAsType(source, R.id.top_iv_right, "field 'topIvRight'", ImageView.class);
    target.topView = Utils.findRequiredViewAsType(source, R.id.topView, "field 'topView'", LinearLayout.class);
    target.tvShopCollection = Utils.findRequiredViewAsType(source, R.id.tv_shop_collection, "field 'tvShopCollection'", TextView.class);
    target.shopLien = Utils.findRequiredView(source, R.id.shop_lien, "field 'shopLien'");
    view = Utils.findRequiredView(source, R.id.ll_shop_collection, "field 'llShopCollection' and method 'onViewClicked'");
    target.llShopCollection = Utils.castView(view, R.id.ll_shop_collection, "field 'llShopCollection'", LinearLayout.class);
    view2131296488 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvCommodityCollection = Utils.findRequiredViewAsType(source, R.id.tv_commodity_collection, "field 'tvCommodityCollection'", TextView.class);
    target.commodityLian = Utils.findRequiredView(source, R.id.commodity_lian, "field 'commodityLian'");
    view = Utils.findRequiredView(source, R.id.ll_commodity_collection, "field 'llCommodityCollection' and method 'onViewClicked'");
    target.llCommodityCollection = Utils.castView(view, R.id.ll_commodity_collection, "field 'llCommodityCollection'", LinearLayout.class);
    view2131296466 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvShopCollectionInfo = Utils.findRequiredViewAsType(source, R.id.rv_shop_collection_info, "field 'rvShopCollectionInfo'", RecyclerView.class);
    target.rvCommodityCollectionInfo = Utils.findRequiredViewAsType(source, R.id.rv_commodity_collection_info, "field 'rvCommodityCollectionInfo'", RecyclerView.class);
    target.llHaveContent = Utils.findRequiredViewAsType(source, R.id.ll_have_content, "field 'llHaveContent'", LinearLayout.class);
    target.tvNullStateContent = Utils.findRequiredViewAsType(source, R.id.tv_null_state_content, "field 'tvNullStateContent'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_null_state_onClick, "field 'tvNullStateOnClick' and method 'onViewClicked'");
    target.tvNullStateOnClick = Utils.castView(view, R.id.tv_null_state_onClick, "field 'tvNullStateOnClick'", TextView.class);
    view2131296823 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llNullState = Utils.findRequiredViewAsType(source, R.id.ll_null_state, "field 'llNullState'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.topBtnLeft = null;
    target.topTitle = null;
    target.topBtnRight = null;
    target.topIvRight = null;
    target.topView = null;
    target.tvShopCollection = null;
    target.shopLien = null;
    target.llShopCollection = null;
    target.tvCommodityCollection = null;
    target.commodityLian = null;
    target.llCommodityCollection = null;
    target.rvShopCollectionInfo = null;
    target.rvCommodityCollectionInfo = null;
    target.llHaveContent = null;
    target.tvNullStateContent = null;
    target.tvNullStateOnClick = null;
    target.llNullState = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296488.setOnClickListener(null);
    view2131296488 = null;
    view2131296466.setOnClickListener(null);
    view2131296466 = null;
    view2131296823.setOnClickListener(null);
    view2131296823 = null;

    this.target = null;
  }
}
