// Generated code from Butter Knife. Do not modify!
package com.hmkj.taozhifu.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hmkj.taozhifu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebActivity_ViewBinding<T extends WebActivity> implements Unbinder {
  protected T target;

  @UiThread
  public WebActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.pb = Utils.findRequiredViewAsType(source, R.id.pb, "field 'pb'", ProgressBar.class);
    target.webView = Utils.findRequiredViewAsType(source, R.id.webView, "field 'webView'", WebView.class);
    target.et = Utils.findRequiredViewAsType(source, R.id.et, "field 'et'", EditText.class);
    target.button = Utils.findRequiredViewAsType(source, R.id.button, "field 'button'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.pb = null;
    target.webView = null;
    target.et = null;
    target.button = null;

    this.target = null;
  }
}
