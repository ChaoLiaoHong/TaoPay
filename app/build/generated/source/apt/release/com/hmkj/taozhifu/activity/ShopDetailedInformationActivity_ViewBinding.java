// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShopDetailedInformationActivity_ViewBinding<T extends ShopDetailedInformationActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  private View view2131296429;

  private View view2131296755;

  private View view2131296442;

  private View view2131296869;

  private View view2131296801;

  @UiThread
  public ShopDetailedInformationActivity_ViewBinding(final T target, View source) {
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
    target.topView = Utils.findRequiredViewAsType(source, R.id.topView, "field 'topView'", LinearLayout.class);
    target.convenientBanner = Utils.findRequiredViewAsType(source, R.id.convenientBanner, "field 'convenientBanner'", ConvenientBanner.class);
    target.tvCommodityTitle = Utils.findRequiredViewAsType(source, R.id.tv_commodity_title, "field 'tvCommodityTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_collect, "field 'ivCollect' and method 'onViewClicked'");
    target.ivCollect = Utils.castView(view, R.id.iv_collect, "field 'ivCollect'", ImageView.class);
    view2131296429 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rbPerson = Utils.findRequiredViewAsType(source, R.id.rb_person, "field 'rbPerson'", RatingBar.class);
    target.tvMoneyPerson = Utils.findRequiredViewAsType(source, R.id.tv_money_person, "field 'tvMoneyPerson'", TextView.class);
    target.tvNum = Utils.findRequiredViewAsType(source, R.id.tv_num, "field 'tvNum'", TextView.class);
    target.tvIntegral = Utils.findRequiredViewAsType(source, R.id.tv_integral, "field 'tvIntegral'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_address, "field 'tvAddress' and method 'onViewClicked'");
    target.tvAddress = Utils.castView(view, R.id.tv_address, "field 'tvAddress'", TextView.class);
    view2131296755 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_phone, "field 'ivPhone' and method 'onViewClicked'");
    target.ivPhone = Utils.castView(view, R.id.iv_phone, "field 'ivPhone'", ImageView.class);
    view2131296442 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvShopNotice = Utils.findRequiredViewAsType(source, R.id.tv_shop_notice, "field 'tvShopNotice'", TextView.class);
    target.rvCommodityIntroduce = Utils.findRequiredViewAsType(source, R.id.rv_commodity_introduce, "field 'rvCommodityIntroduce'", RecyclerView.class);
    target.tvDoBusinessData = Utils.findRequiredViewAsType(source, R.id.tv_do_business_data, "field 'tvDoBusinessData'", TextView.class);
    target.tvMasterRule = Utils.findRequiredViewAsType(source, R.id.tv_master_rule, "field 'tvMasterRule'", TextView.class);
    target.rb = Utils.findRequiredViewAsType(source, R.id.rb, "field 'rb'", RatingBar.class);
    target.tvAssess = Utils.findRequiredViewAsType(source, R.id.tv_assess, "field 'tvAssess'", TextView.class);
    target.tvNumAssess = Utils.findRequiredViewAsType(source, R.id.tv_num_assess, "field 'tvNumAssess'", TextView.class);
    target.rvAssess = Utils.findRequiredViewAsType(source, R.id.rv_assess, "field 'rvAssess'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_show_all_assess, "field 'tvShowAllAssess' and method 'onViewClicked'");
    target.tvShowAllAssess = Utils.castView(view, R.id.tv_show_all_assess, "field 'tvShowAllAssess'", TextView.class);
    view2131296869 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_immediately_sale, "field 'tvImmediatelySale' and method 'onViewClicked'");
    target.tvImmediatelySale = Utils.castView(view, R.id.tv_immediately_sale, "field 'tvImmediatelySale'", TextView.class);
    view2131296801 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.ll_hot_commodity = Utils.findRequiredViewAsType(source, R.id.ll_hot_commodity, "field 'll_hot_commodity'", RelativeLayout.class);
    target.llAssess = Utils.findRequiredViewAsType(source, R.id.ll_assess, "field 'llAssess'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.topBtnLeft = null;
    target.topTitle = null;
    target.topView = null;
    target.convenientBanner = null;
    target.tvCommodityTitle = null;
    target.ivCollect = null;
    target.rbPerson = null;
    target.tvMoneyPerson = null;
    target.tvNum = null;
    target.tvIntegral = null;
    target.tvAddress = null;
    target.ivPhone = null;
    target.tvShopNotice = null;
    target.rvCommodityIntroduce = null;
    target.tvDoBusinessData = null;
    target.tvMasterRule = null;
    target.rb = null;
    target.tvAssess = null;
    target.tvNumAssess = null;
    target.rvAssess = null;
    target.tvShowAllAssess = null;
    target.tvImmediatelySale = null;
    target.ll_hot_commodity = null;
    target.llAssess = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296429.setOnClickListener(null);
    view2131296429 = null;
    view2131296755.setOnClickListener(null);
    view2131296755 = null;
    view2131296442.setOnClickListener(null);
    view2131296442 = null;
    view2131296869.setOnClickListener(null);
    view2131296869 = null;
    view2131296801.setOnClickListener(null);
    view2131296801 = null;

    this.target = null;
  }
}
