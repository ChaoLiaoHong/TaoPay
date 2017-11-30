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

public class CommodityDetailedInformationActivity_ViewBinding<T extends CommodityDetailedInformationActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  private View view2131296429;

  private View view2131296755;

  private View view2131296840;

  private View view2131296770;

  private View view2131296781;

  private View view2131296823;

  @UiThread
  public CommodityDetailedInformationActivity_ViewBinding(final T target, View source) {
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
    target.tvConvert = Utils.findRequiredViewAsType(source, R.id.tv_convert, "field 'tvConvert'", TextView.class);
    target.tvNum = Utils.findRequiredViewAsType(source, R.id.tv_num, "field 'tvNum'", TextView.class);
    target.tvCommodityName = Utils.findRequiredViewAsType(source, R.id.tv_commodity_name, "field 'tvCommodityName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_address, "field 'tvAddress' and method 'onViewClicked'");
    target.tvAddress = Utils.castView(view, R.id.tv_address, "field 'tvAddress'", TextView.class);
    view2131296755 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_phone, "field 'tvPhone' and method 'onViewClicked'");
    target.tvPhone = Utils.castView(view, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    view2131296840 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_commodityJia, "field 'tvCommodityJia' and method 'onViewClicked'");
    target.tvCommodityJia = Utils.castView(view, R.id.tv_commodityJia, "field 'tvCommodityJia'", TextView.class);
    view2131296770 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvCommodityIntroduce = Utils.findRequiredViewAsType(source, R.id.tv_commodityDescr, "field 'rvCommodityIntroduce'", TextView.class);
    target.tvValidDate = Utils.findRequiredViewAsType(source, R.id.tv_valid_date, "field 'tvValidDate'", TextView.class);
    target.tvConvertWay = Utils.findRequiredViewAsType(source, R.id.tv_convert_way, "field 'tvConvertWay'", TextView.class);
    target.tvUseRule = Utils.findRequiredViewAsType(source, R.id.tv_use_rule, "field 'tvUseRule'", TextView.class);
    target.rb = Utils.findRequiredViewAsType(source, R.id.rb, "field 'rb'", RatingBar.class);
    target.tvAssess = Utils.findRequiredViewAsType(source, R.id.tv_assess, "field 'tvAssess'", TextView.class);
    target.tvNumAssess = Utils.findRequiredViewAsType(source, R.id.tv_num_assess, "field 'tvNumAssess'", TextView.class);
    target.rvAssess = Utils.findRequiredViewAsType(source, R.id.rv_assess, "field 'rvAssess'", RecyclerView.class);
    target.tvShowAllAssess = Utils.findRequiredViewAsType(source, R.id.tv_show_all_assess, "field 'tvShowAllAssess'", TextView.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tvPrice'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_convert_onclick, "field 'tvConvertOnclick' and method 'onViewClicked'");
    target.tvConvertOnclick = Utils.castView(view, R.id.tv_convert_onclick, "field 'tvConvertOnclick'", TextView.class);
    view2131296781 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvShowConvert = Utils.findRequiredViewAsType(source, R.id.tv_show_convert, "field 'tvShowConvert'", TextView.class);
    target.textView = Utils.findRequiredViewAsType(source, R.id.textView, "field 'textView'", TextView.class);
    target.vLian = Utils.findRequiredView(source, R.id.v_lian, "field 'vLian'");
    target.rlNoNull = Utils.findRequiredViewAsType(source, R.id.rl_no_null, "field 'rlNoNull'", RelativeLayout.class);
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
    target.topView = null;
    target.convenientBanner = null;
    target.tvCommodityTitle = null;
    target.ivCollect = null;
    target.tvConvert = null;
    target.tvNum = null;
    target.tvCommodityName = null;
    target.tvAddress = null;
    target.tvPhone = null;
    target.tvCommodityJia = null;
    target.rvCommodityIntroduce = null;
    target.tvValidDate = null;
    target.tvConvertWay = null;
    target.tvUseRule = null;
    target.rb = null;
    target.tvAssess = null;
    target.tvNumAssess = null;
    target.rvAssess = null;
    target.tvShowAllAssess = null;
    target.tvPrice = null;
    target.tvConvertOnclick = null;
    target.tvShowConvert = null;
    target.textView = null;
    target.vLian = null;
    target.rlNoNull = null;
    target.tvNullStateContent = null;
    target.tvNullStateOnClick = null;
    target.llNullState = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296429.setOnClickListener(null);
    view2131296429 = null;
    view2131296755.setOnClickListener(null);
    view2131296755 = null;
    view2131296840.setOnClickListener(null);
    view2131296840 = null;
    view2131296770.setOnClickListener(null);
    view2131296770 = null;
    view2131296781.setOnClickListener(null);
    view2131296781 = null;
    view2131296823.setOnClickListener(null);
    view2131296823 = null;

    this.target = null;
  }
}
