// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.NoScrollGridView;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import com.hmkj.taozhifu.view.UpDownTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding<T extends HomeFragment> implements Unbinder {
  protected T target;

  private View view2131296817;

  private View view2131296399;

  private View view2131296820;

  private View view2131296892;

  private View view2131296439;

  private View view2131296813;

  @UiThread
  public HomeFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.convenientBanner = Utils.findRequiredViewAsType(source, R.id.convenientBanner, "field 'convenientBanner'", ConvenientBanner.class);
    target.llHomeTitle = Utils.findRequiredViewAsType(source, R.id.ll_home_title, "field 'llHomeTitle'", LinearLayout.class);
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.scroll_view, "field 'scrollView'", NestedScrollView.class);
    target.category = Utils.findRequiredViewAsType(source, R.id.category, "field 'category'", NoScrollGridView.class);
    target.rvRecommendedProducts = Utils.findRequiredViewAsType(source, R.id.rv_recommended_products, "field 'rvRecommendedProducts'", RecyclerView.class);
    target.refresh = Utils.findRequiredViewAsType(source, R.id.refresh, "field 'refresh'", SwipeRefreshView.class);
    view = Utils.findRequiredView(source, R.id.tv_notice, "field 'tvNotice' and method 'onViewClicked'");
    target.tvNotice = Utils.castView(view, R.id.tv_notice, "field 'tvNotice'", UpDownTextView.class);
    view2131296817 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fragment_home_title_search, "field 'fragment_home_title_search' and method 'onViewClicked'");
    target.fragment_home_title_search = Utils.castView(view, R.id.fragment_home_title_search, "field 'fragment_home_title_search'", TextView.class);
    view2131296399 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_notice_more, "field 'tvNoticeMore' and method 'onViewClicked'");
    target.tvNoticeMore = Utils.castView(view, R.id.tv_notice_more, "field 'tvNoticeMore'", TextView.class);
    view2131296820 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rvNearbyMerchants = Utils.findRequiredViewAsType(source, R.id.rv_nearby_merchants, "field 'rvNearbyMerchants'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_title_address, "field 'tvTitleAddress' and method 'onViewClicked'");
    target.tvTitleAddress = Utils.castView(view, R.id.tv_title_address, "field 'tvTitleAddress'", TextView.class);
    view2131296892 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_notice, "field 'ivNotice' and method 'onViewClicked'");
    target.ivNotice = Utils.castView(view, R.id.iv_notice, "field 'ivNotice'", ImageView.class);
    view2131296439 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.view1 = Utils.findRequiredView(source, R.id.view1, "field 'view1'");
    target.view2 = Utils.findRequiredView(source, R.id.view2, "field 'view2'");
    target.llNotice = Utils.findRequiredViewAsType(source, R.id.ll_notice, "field 'llNotice'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_more_store, "field 'tvMoreStore' and method 'onViewClicked'");
    target.tvMoreStore = Utils.castView(view, R.id.tv_more_store, "field 'tvMoreStore'", TextView.class);
    view2131296813 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llRecommendedProducts = Utils.findRequiredViewAsType(source, R.id.ll_recommended_products, "field 'llRecommendedProducts'", LinearLayout.class);
    target.llNearbyMerchants = Utils.findRequiredViewAsType(source, R.id.ll_nearby_merchants, "field 'llNearbyMerchants'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.convenientBanner = null;
    target.llHomeTitle = null;
    target.scrollView = null;
    target.category = null;
    target.rvRecommendedProducts = null;
    target.refresh = null;
    target.tvNotice = null;
    target.fragment_home_title_search = null;
    target.tvNoticeMore = null;
    target.rvNearbyMerchants = null;
    target.tvTitleAddress = null;
    target.ivNotice = null;
    target.view1 = null;
    target.view2 = null;
    target.llNotice = null;
    target.tvMoreStore = null;
    target.llRecommendedProducts = null;
    target.llNearbyMerchants = null;

    view2131296817.setOnClickListener(null);
    view2131296817 = null;
    view2131296399.setOnClickListener(null);
    view2131296399 = null;
    view2131296820.setOnClickListener(null);
    view2131296820 = null;
    view2131296892.setOnClickListener(null);
    view2131296892 = null;
    view2131296439.setOnClickListener(null);
    view2131296439 = null;
    view2131296813.setOnClickListener(null);
    view2131296813 = null;

    this.target = null;
  }
}
