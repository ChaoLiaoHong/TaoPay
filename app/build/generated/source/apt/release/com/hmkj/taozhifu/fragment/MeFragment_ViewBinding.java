// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.view.SwipeRefreshView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MeFragment_ViewBinding<T extends MeFragment> implements Unbinder {
  protected T target;

  private View view2131296728;

  private View view2131296508;

  private View view2131296516;

  private View view2131296520;

  private View view2131296535;

  private View view2131296531;

  private View view2131296506;

  @UiThread
  public MeFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.toolbar_title, "field 'toolbarTitle' and method 'onViewClicked'");
    target.toolbarTitle = Utils.castView(view, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    view2131296728 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.mClick_Upgrade, "field 'mClickUpgrade' and method 'onViewClicked'");
    target.mClickUpgrade = Utils.castView(view, R.id.mClick_Upgrade, "field 'mClickUpgrade'", TextView.class);
    view2131296508 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mHead, "field 'mHead' and method 'onViewClicked'");
    target.mHead = Utils.castView(view, R.id.mHead, "field 'mHead'", ImageView.class);
    view2131296516 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mInvite, "field 'mInvite' and method 'onViewClicked'");
    target.mInvite = Utils.castView(view, R.id.mInvite, "field 'mInvite'", TextView.class);
    view2131296520 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mPhone = Utils.findRequiredViewAsType(source, R.id.mPhone, "field 'mPhone'", TextView.class);
    target.mVoucher = Utils.findRequiredViewAsType(source, R.id.mVoucher, "field 'mVoucher'", TextView.class);
    target.shopVoucher = Utils.findRequiredViewAsType(source, R.id.shopVoucher, "field 'shopVoucher'", TextView.class);
    target.mCash = Utils.findRequiredViewAsType(source, R.id.mCash, "field 'mCash'", TextView.class);
    target.mContentRC = Utils.findRequiredViewAsType(source, R.id.mContent_RC, "field 'mContentRC'", RecyclerView.class);
    target.myRecommend = Utils.findRequiredViewAsType(source, R.id.my_recommend, "field 'myRecommend'", TextView.class);
    view = Utils.findRequiredView(source, R.id.mVoucher_ly, "field 'mVoucher_ly' and method 'onViewClicked'");
    target.mVoucher_ly = Utils.castView(view, R.id.mVoucher_ly, "field 'mVoucher_ly'", LinearLayout.class);
    view2131296535 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mShopTicket_ly, "field 'mShopTicket_ly' and method 'onViewClicked'");
    target.mShopTicket_ly = Utils.castView(view, R.id.mShopTicket_ly, "field 'mShopTicket_ly'", LinearLayout.class);
    view2131296531 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mCash_ly, "field 'mCash_ly' and method 'onViewClicked'");
    target.mCash_ly = Utils.castView(view, R.id.mCash_ly, "field 'mCash_ly'", LinearLayout.class);
    view2131296506 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mRefresh = Utils.findRequiredViewAsType(source, R.id.mRefresh, "field 'mRefresh'", SwipeRefreshView.class);
    target.vip_Grade = Utils.findRequiredViewAsType(source, R.id.vip_Grade, "field 'vip_Grade'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarTitle = null;
    target.toolbar = null;
    target.mClickUpgrade = null;
    target.mHead = null;
    target.mInvite = null;
    target.mPhone = null;
    target.mVoucher = null;
    target.shopVoucher = null;
    target.mCash = null;
    target.mContentRC = null;
    target.myRecommend = null;
    target.mVoucher_ly = null;
    target.mShopTicket_ly = null;
    target.mCash_ly = null;
    target.mRefresh = null;
    target.vip_Grade = null;

    view2131296728.setOnClickListener(null);
    view2131296728 = null;
    view2131296508.setOnClickListener(null);
    view2131296508 = null;
    view2131296516.setOnClickListener(null);
    view2131296516 = null;
    view2131296520.setOnClickListener(null);
    view2131296520 = null;
    view2131296535.setOnClickListener(null);
    view2131296535 = null;
    view2131296531.setOnClickListener(null);
    view2131296531 = null;
    view2131296506.setOnClickListener(null);
    view2131296506 = null;

    this.target = null;
  }
}
