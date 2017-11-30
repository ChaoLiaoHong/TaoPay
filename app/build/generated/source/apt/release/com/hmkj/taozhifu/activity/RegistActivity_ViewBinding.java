// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import com.hmkj.taozhifu.utils.ClearEditText;
import com.hmkj.taozhifu.view.emoji.NOPasteEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegistActivity_ViewBinding<T extends RegistActivity> implements Unbinder {
  protected T target;

  private View view2131296733;

  private View view2131296515;

  private View view2131296522;

  private View view2131296507;

  private View view2131296511;

  private View view2131296647;

  @UiThread
  public RegistActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.top_btn_left, "field 'topBtnLeft' and method 'onClick'");
    target.topBtnLeft = Utils.castView(view, R.id.top_btn_left, "field 'topBtnLeft'", Button.class);
    view2131296733 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.topTitle = Utils.findRequiredViewAsType(source, R.id.top_title, "field 'topTitle'", TextView.class);
    target.inviterCode = Utils.findRequiredViewAsType(source, R.id.inviterCode, "field 'inviterCode'", NOPasteEditText.class);
    target.mPhone = Utils.findRequiredViewAsType(source, R.id.mPhone, "field 'mPhone'", ClearEditText.class);
    target.codeEditText = Utils.findRequiredViewAsType(source, R.id.code_EditText, "field 'codeEditText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.mGain_Code, "field 'mGainCode' and method 'onClick'");
    target.mGainCode = Utils.castView(view, R.id.mGain_Code, "field 'mGainCode'", TextView.class);
    view2131296515 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mNext, "field 'mNext' and method 'onClick'");
    target.mNext = Utils.castView(view, R.id.mNext, "field 'mNext'", Button.class);
    view2131296522 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mCheck_state, "field 'mCheckState' and method 'onClick'");
    target.mCheckState = Utils.castView(view, R.id.mCheck_state, "field 'mCheckState'", CheckBox.class);
    view2131296507 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mDeal, "field 'mDeal' and method 'onClick'");
    target.mDeal = Utils.castView(view, R.id.mDeal, "field 'mDeal'", TextView.class);
    view2131296511 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mTime = Utils.findRequiredViewAsType(source, R.id.mTime, "field 'mTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.sao_sao, "field 'sao_sao' and method 'onClick'");
    target.sao_sao = Utils.castView(view, R.id.sao_sao, "field 'sao_sao'", ImageView.class);
    view2131296647 = view;
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

    target.topBtnLeft = null;
    target.topTitle = null;
    target.inviterCode = null;
    target.mPhone = null;
    target.codeEditText = null;
    target.mGainCode = null;
    target.mNext = null;
    target.mCheckState = null;
    target.mDeal = null;
    target.mTime = null;
    target.sao_sao = null;

    view2131296733.setOnClickListener(null);
    view2131296733 = null;
    view2131296515.setOnClickListener(null);
    view2131296515 = null;
    view2131296522.setOnClickListener(null);
    view2131296522 = null;
    view2131296507.setOnClickListener(null);
    view2131296507 = null;
    view2131296511.setOnClickListener(null);
    view2131296511 = null;
    view2131296647.setOnClickListener(null);
    view2131296647 = null;

    this.target = null;
  }
}
