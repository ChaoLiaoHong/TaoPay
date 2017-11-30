// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.NoScrollGridView;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyStoreSetupActivity_ViewBinding<T extends MyStoreSetupActivity> implements Unbinder {
  protected T target;

  private View view2131296434;

  private View view2131296756;

  private View view2131296757;

  private View view2131296758;

  private View view2131296763;

  private View view2131296621;

  private View view2131296622;

  private View view2131296450;

  private View view2131296857;

  @UiThread
  public MyStoreSetupActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.view = Utils.findRequiredView(source, R.id.view, "field 'view'");
    target.etStoreName = Utils.findRequiredViewAsType(source, R.id.et_store_name, "field 'etStoreName'", NOPasteEditText.class);
    view = Utils.findRequiredView(source, R.id.iv_delete_store_name, "field 'ivDeleteStoreName' and method 'onViewClicked'");
    target.ivDeleteStoreName = Utils.castView(view, R.id.iv_delete_store_name, "field 'ivDeleteStoreName'", ImageView.class);
    view2131296434 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etStorePhone = Utils.findRequiredViewAsType(source, R.id.et_store_phone, "field 'etStorePhone'", NOPasteEditText.class);
    target.etStoreAddress = Utils.findRequiredViewAsType(source, R.id.et_store_address, "field 'etStoreAddress'", NOPasteEditText.class);
    view = Utils.findRequiredView(source, R.id.tv_address1, "field 'tvAddress1' and method 'onViewClicked'");
    target.tvAddress1 = Utils.castView(view, R.id.tv_address1, "field 'tvAddress1'", TextView.class);
    view2131296756 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_address2, "field 'tvAddress2' and method 'onViewClicked'");
    target.tvAddress2 = Utils.castView(view, R.id.tv_address2, "field 'tvAddress2'", TextView.class);
    view2131296757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_address3, "field 'tvAddress3' and method 'onViewClicked'");
    target.tvAddress3 = Utils.castView(view, R.id.tv_address3, "field 'tvAddress3'", TextView.class);
    view2131296758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_business_time, "field 'tvBusinessTime' and method 'onViewClicked'");
    target.tvBusinessTime = Utils.castView(view, R.id.tv_business_time, "field 'tvBusinessTime'", TextView.class);
    view2131296763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etStoreConsume = Utils.findRequiredViewAsType(source, R.id.et_store_consume, "field 'etStoreConsume'", NOPasteEditText.class);
    target.etProductDes = Utils.findRequiredViewAsType(source, R.id.et_product_des, "field 'etProductDes'", NOPasteEditText.class);
    target.tvStoreServe = Utils.findRequiredViewAsType(source, R.id.tv_store_serve, "field 'tvStoreServe'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_select_product_main_img, "field 'rlSelectProductMainImg' and method 'onViewClicked'");
    target.rlSelectProductMainImg = Utils.castView(view, R.id.rl_select_product_main_img, "field 'rlSelectProductMainImg'", RelativeLayout.class);
    view2131296621 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_select_shop_main_img, "field 'rlSelectShopMainImg' and method 'onViewClicked'");
    target.rlSelectShopMainImg = Utils.castView(view, R.id.rl_select_shop_main_img, "field 'rlSelectShopMainImg'", RelativeLayout.class);
    view2131296622 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ivProductMainImg = Utils.findRequiredViewAsType(source, R.id.iv_product_main_img, "field 'ivProductMainImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.iv_select_pic, "field 'ivSelectPic' and method 'onViewClicked'");
    target.ivSelectPic = Utils.castView(view, R.id.iv_select_pic, "field 'ivSelectPic'", ImageView.class);
    view2131296450 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.gvGridView = Utils.findRequiredViewAsType(source, R.id.gv_grid_view, "field 'gvGridView'", NoScrollGridView.class);
    view = Utils.findRequiredView(source, R.id.tv_publish, "field 'tvPublish' and method 'onViewClicked'");
    target.tvPublish = Utils.castView(view, R.id.tv_publish, "field 'tvPublish'", TextView.class);
    view2131296857 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbar = null;
    target.view = null;
    target.etStoreName = null;
    target.ivDeleteStoreName = null;
    target.etStorePhone = null;
    target.etStoreAddress = null;
    target.tvAddress1 = null;
    target.tvAddress2 = null;
    target.tvAddress3 = null;
    target.tvBusinessTime = null;
    target.etStoreConsume = null;
    target.etProductDes = null;
    target.tvStoreServe = null;
    target.rlSelectProductMainImg = null;
    target.rlSelectShopMainImg = null;
    target.ivProductMainImg = null;
    target.ivSelectPic = null;
    target.gvGridView = null;
    target.tvPublish = null;

    view2131296434.setOnClickListener(null);
    view2131296434 = null;
    view2131296756.setOnClickListener(null);
    view2131296756 = null;
    view2131296757.setOnClickListener(null);
    view2131296757 = null;
    view2131296758.setOnClickListener(null);
    view2131296758 = null;
    view2131296763.setOnClickListener(null);
    view2131296763 = null;
    view2131296621.setOnClickListener(null);
    view2131296621 = null;
    view2131296622.setOnClickListener(null);
    view2131296622 = null;
    view2131296450.setOnClickListener(null);
    view2131296450 = null;
    view2131296857.setOnClickListener(null);
    view2131296857 = null;

    this.target = null;
  }
}
