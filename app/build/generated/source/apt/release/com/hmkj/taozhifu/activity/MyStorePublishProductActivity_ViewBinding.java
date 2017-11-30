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

public class MyStorePublishProductActivity_ViewBinding<T extends MyStorePublishProductActivity> implements Unbinder {
  protected T target;

  private View view2131296433;

  private View view2131296845;

  private View view2131296804;

  private View view2131296874;

  private View view2131296792;

  private View view2131296621;

  private View view2131296450;

  private View view2131296857;

  @UiThread
  public MyStorePublishProductActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.etProductName = Utils.findRequiredViewAsType(source, R.id.et_product_name, "field 'etProductName'", NOPasteEditText.class);
    view = Utils.findRequiredView(source, R.id.iv_delete_product_name, "field 'ivDeleteProductName' and method 'onViewClicked'");
    target.ivDeleteProductName = Utils.castView(view, R.id.iv_delete_product_name, "field 'ivDeleteProductName'", ImageView.class);
    view2131296433 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_product_classify, "field 'tvProductClassify' and method 'onViewClicked'");
    target.tvProductClassify = Utils.castView(view, R.id.tv_product_classify, "field 'tvProductClassify'", TextView.class);
    view2131296845 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etProductPrice = Utils.findRequiredViewAsType(source, R.id.et_product_price, "field 'etProductPrice'", NOPasteEditText.class);
    target.etProductNum = Utils.findRequiredViewAsType(source, R.id.et_product_num, "field 'etProductNum'", NOPasteEditText.class);
    view = Utils.findRequiredView(source, R.id.tv_is_drawback, "field 'tvIsDrawback' and method 'onViewClicked'");
    target.tvIsDrawback = Utils.castView(view, R.id.tv_is_drawback, "field 'tvIsDrawback'", TextView.class);
    view2131296804 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_start_time, "field 'tvStartTime' and method 'onViewClicked'");
    target.tvStartTime = Utils.castView(view, R.id.tv_start_time, "field 'tvStartTime'", TextView.class);
    view2131296874 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_end_time, "field 'tvEndTime' and method 'onViewClicked'");
    target.tvEndTime = Utils.castView(view, R.id.tv_end_time, "field 'tvEndTime'", TextView.class);
    view2131296792 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etProductDes = Utils.findRequiredViewAsType(source, R.id.et_product_des, "field 'etProductDes'", NOPasteEditText.class);
    target.etProductUseRule = Utils.findRequiredViewAsType(source, R.id.et_product_use_rule, "field 'etProductUseRule'", NOPasteEditText.class);
    target.ivSelectMainPic = Utils.findRequiredViewAsType(source, R.id.iv_select_main_pic, "field 'ivSelectMainPic'", ImageView.class);
    target.ivProductMainImg = Utils.findRequiredViewAsType(source, R.id.iv_product_main_img, "field 'ivProductMainImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.rl_select_product_main_img, "field 'rlSelectProductMainImg' and method 'onViewClicked'");
    target.rlSelectProductMainImg = Utils.castView(view, R.id.rl_select_product_main_img, "field 'rlSelectProductMainImg'", RelativeLayout.class);
    view2131296621 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
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
    target.etProductName = null;
    target.ivDeleteProductName = null;
    target.tvProductClassify = null;
    target.etProductPrice = null;
    target.etProductNum = null;
    target.tvIsDrawback = null;
    target.tvStartTime = null;
    target.tvEndTime = null;
    target.etProductDes = null;
    target.etProductUseRule = null;
    target.ivSelectMainPic = null;
    target.ivProductMainImg = null;
    target.rlSelectProductMainImg = null;
    target.ivSelectPic = null;
    target.gvGridView = null;
    target.tvPublish = null;

    view2131296433.setOnClickListener(null);
    view2131296433 = null;
    view2131296845.setOnClickListener(null);
    view2131296845 = null;
    view2131296804.setOnClickListener(null);
    view2131296804 = null;
    view2131296874.setOnClickListener(null);
    view2131296874 = null;
    view2131296792.setOnClickListener(null);
    view2131296792 = null;
    view2131296621.setOnClickListener(null);
    view2131296621 = null;
    view2131296450.setOnClickListener(null);
    view2131296450 = null;
    view2131296857.setOnClickListener(null);
    view2131296857 = null;

    this.target = null;
  }
}
