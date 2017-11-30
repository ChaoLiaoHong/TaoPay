package com.hmkj.taozhifu.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.hmkj.taozhifu.R;


public class BoderCircleImageView extends AppCompatImageView{
  // ��������
  private static final ScaleType SCALE_TYPE = ScaleType.CENTER_CROP;
  private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
  private static final int COLORDRAWABLE_DIMENSION = 2;
  // Ĭ�ϱ߽���
  private static final int DEFAULT_BORDER_WIDTH = 0;
  // Ĭ�ϱ߽���ɫ
  private static final int DEFAULT_BORDER_COLOR = Color.BLACK;
  private static final boolean DEFAULT_BORDER_OVERLAY = false;

  private final RectF mDrawableRect = new RectF();
  private final RectF mBorderRect = new RectF();

  private final Matrix mShaderMatrix = new Matrix();
  // �����������Ҫ���ǹ�����mBitmapShader
  // ʹcanvas��ִ�е�ʱ������и�ԭͼƬ(mBitmapShader�ǹ�����ԭͼ��bitmap��)
  private final Paint mBitmapPaint = new Paint();
  // �����ߣ����뱾���ԭͼbitmapû���κι�����
  private final Paint mBorderPaint = new Paint();
  // ���ﶨ���� Բ�α�Ե��Ĭ�Ͽ�Ⱥ���ɫ
  private int mBorderColor = DEFAULT_BORDER_COLOR;
  private int mBorderWidth = DEFAULT_BORDER_WIDTH;

  private Bitmap mBitmap;
  private BitmapShader mBitmapShader; // λͼ��Ⱦ
  private int mBitmapWidth; // λͼ���
  private int mBitmapHeight; // λͼ�߶�

  private float mDrawableRadius;// ͼƬ�뾶
  private float mBorderRadius;// ���߿�ĵ�ͼƬ�뾶

  private ColorFilter mColorFilter;
  // ��ʼfalse
  private boolean mReady;
  private boolean mSetupPending;
  private boolean mBorderOverlay;

  // ���캯��
  public BoderCircleImageView(Context context) {
    super(context);
    init();
  }

  // ���캯��
  public BoderCircleImageView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  /**
   * ���캯��
   */
  public BoderCircleImageView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    // ͨ��obtainStyledAttributes ���һ��ֵ���� TypedArray�����飩 ,
    // ��һ��ֵ������res/values/attrs.xml�е�name="CircleImageView"��declare-styleable�С�
    TypedArray a =
            context.obtainStyledAttributes(attrs, R.styleable.BoderCircleImageView, defStyle, 0);
    // ͨ��TypedArray�ṩ��һϵ�з���getXXXXȡ��������xml�ﶨ��Ĳ���ֵ��
    // ��ȡ�߽�Ŀ��
    mBorderWidth = a.getDimensionPixelSize(R.styleable.BoderCircleImageView_border_width,
            DEFAULT_BORDER_WIDTH);
    // ��ȡ�߽����ɫ
    mBorderColor = a.getColor(R.styleable.BoderCircleImageView_border_color, DEFAULT_BORDER_COLOR);
    mBorderOverlay =
            a.getBoolean(R.styleable.BoderCircleImageView_border_overlay, DEFAULT_BORDER_OVERLAY);
    // ���� recycle() ����TypedArray,�Ա��������
    a.recycle();
    System.out.println("CircleImageView -- ���캯��");
    init();
  }

  /**
   * ���þ��Ǳ�֤��һ��ִ��setup�������������Ҫ�ڹ��캯��ִ�����ʱ����
   */
  private void init() {
    // ������ScaleType��ǿ���趨ΪCENTER_CROP�����ǽ�ͼƬˮƽ��ֱ���У��������š�
    super.setScaleType(SCALE_TYPE);
    mReady = true;

    if (mSetupPending) {
      setup();
      mSetupPending = false;
    }
  }

  @Override public ScaleType getScaleType() {
    return SCALE_TYPE;
  }

  /**
   * ������ȷָ�� ����imageview ֻ֧��CENTER_CROP ��һ������
   */
  @Override public void setScaleType(ScaleType scaleType) {
    if (scaleType != SCALE_TYPE) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
    }
  }

  @Override public void setAdjustViewBounds(boolean adjustViewBounds) {
    if (adjustViewBounds) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
  }

  @Override protected void onDraw(Canvas canvas) {
    // ���ͼƬ�����ھͲ���
    if (getDrawable() == null) {
      return;
    }
    // ������Բ�� ͼƬ ����ΪmBitmapPaint
    canvas.drawCircle(getWidth() / 2, getHeight() / 2, mDrawableRadius, mBitmapPaint);
    // ���Բ�α�Ե�Ŀ�Ȳ�Ϊ0 ���ǻ�Ҫ���ƴ��߽����Բ�� �߽续��ΪmBorderPaint
    if (mBorderWidth != 0) {
      canvas.drawCircle(getWidth() / 2, getHeight() / 2, mBorderRadius, mBorderPaint);
    }
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    setup();
  }

  public int getBorderColor() {
    return mBorderColor;
  }

  public void setBorderColor(int borderColor) {
    if (borderColor == mBorderColor) {
      return;
    }

    mBorderColor = borderColor;
    mBorderPaint.setColor(mBorderColor);
    invalidate();
  }

  public void setBorderColorResource(@ColorRes int borderColorRes) {
    setBorderColor(getContext().getResources().getColor(borderColorRes));
  }

  public int getBorderWidth() {
    return mBorderWidth;
  }

  public void setBorderWidth(int borderWidth) {
    if (borderWidth == mBorderWidth) {
      return;
    }

    mBorderWidth = borderWidth;
    setup();
  }

  public boolean isBorderOverlay() {
    return mBorderOverlay;
  }

  public void setBorderOverlay(boolean borderOverlay) {
    if (borderOverlay == mBorderOverlay) {
      return;
    }

    mBorderOverlay = borderOverlay;
    setup();
  }

  /**
   * �����ĸ��������� ��дImageView��setImageXxx()���� ע������������ڹ��캯������֮ǰ����
   */
  @Override public void setImageBitmap(Bitmap bm) {
    super.setImageBitmap(bm);
    mBitmap = bm;
    setup();
  }

  @Override public void setImageDrawable(Drawable drawable) {
    super.setImageDrawable(drawable);
    mBitmap = getBitmapFromDrawable(drawable);
    System.out.println("setImageDrawable -- setup");
    setup();
  }

  @Override public void setImageResource(@DrawableRes int resId) {
    super.setImageResource(resId);
    mBitmap = getBitmapFromDrawable(getDrawable());
    setup();
  }

  @Override public void setImageURI(Uri uri) {
    super.setImageURI(uri);
    mBitmap = getBitmapFromDrawable(getDrawable());
    setup();
  }

  @Override public void setColorFilter(ColorFilter cf) {
    if (cf == mColorFilter) {
      return;
    }

    mColorFilter = cf;
    mBitmapPaint.setColorFilter(mColorFilter);
    invalidate();
  }

  /**
   * DrawableתBitmap
   */
  private Bitmap getBitmapFromDrawable(Drawable drawable) {
    if (drawable == null) {
      return null;
    }

    if (drawable instanceof BitmapDrawable) {
      // ͨ����˵ ���ǵĴ������ִ�е�����ͷ����ˡ����صľ���������ԭʼ��bitmap
      return ((BitmapDrawable) drawable).getBitmap();
    }

    try {
      Bitmap bitmap;

      if (drawable instanceof ColorDrawable) {
        bitmap =
                Bitmap.createBitmap(COLORDRAWABLE_DIMENSION, COLORDRAWABLE_DIMENSION, BITMAP_CONFIG);
      } else {
        bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                BITMAP_CONFIG);
      }

      Canvas canvas = new Canvas(bitmap);
      drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
      drawable.draw(canvas);
      return bitmap;
    } catch (OutOfMemoryError e) {
      return null;
    }
  }

  /**
   * ��������ܹؼ�������ͼƬ���ʱ߽续��(Paint)һЩ�ػ������ʼ����
   * ������Ⱦ��BitmapShader��Bitmap������������,������ʽ�Լ�����Բ�뾶����ȣ�
   * �Լ�����updateShaderMatrix()������ invalidate()������
   */
  private void setup() {
    // ��ΪmReadyĬ��ֵΪfalse,���Ե�һ�ν����������ʱ��if���Ϊ�������������
    // ����mSetupPendingΪtrueȻ��ֱ�ӷ��أ�����Ĵ��벢û��ִ�С�
    if (!mReady) {
      mSetupPending = true;
      return;
    }
    // ��ֹ��ָ���쳣
    if (mBitmap == null) {
      return;
    }
    // ������Ⱦ������mBitmapλͼ������������ ������ֵ�������ͼƬ̫С�Ļ� ��ֱ������
    mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    // ����ͼƬ���ʷ����
    mBitmapPaint.setAntiAlias(true);
    // ����ͼƬ������Ⱦ��
    mBitmapPaint.setShader(mBitmapShader);
    // ���ñ߽续����ʽ
    mBorderPaint.setStyle(Paint.Style.STROKE);// �軭��Ϊ����
    mBorderPaint.setAntiAlias(true);
    mBorderPaint.setColor(mBorderColor); // ������ɫ
    mBorderPaint.setStrokeWidth(mBorderWidth);// ���ʱ߽���
    // ����ط���ȡ��ԭͼƬ�Ŀ��
    mBitmapHeight = mBitmap.getHeight();
    mBitmapWidth = mBitmap.getWidth();
    // ���ú��߽���ʾ����ȡ����CircleImageView�Ĳ���ʵ�ʴ�С��Ϊ���Σ��鿴xmlҲ����160dp(240px)
    // getWidth�õ���ĳ��view��ʵ�ʳߴ�
    mBorderRect.set(0, 0, getWidth(), getHeight());
    // ����
    // Բ�δ��߽粿�֣���Բ������С�뾶��ȡmBorderRect�Ŀ�߼�ȥһ����Ե��С��һ��Ľ�Сֵ������ط��ұȽ�����Ϊʲô����Բ�뾶��Ҫ�ȼ�ȥһ����Ե��С��
    mBorderRadius = Math.min((mBorderRect.height() - mBorderWidth) / 2,
            (mBorderRect.width() - mBorderWidth) / 2);
    // ��ʼͼƬ��ʾ����ΪmBorderRect��CircleImageView�Ĳ���ʵ�ʴ�С��
    mDrawableRect.set(mBorderRect);
    if (!mBorderOverlay) {
      // demo��ʼ��ִ��
      // ͨ��inset����
      // ʹ��ͼƬ��ʾ�������mBorderRect��С�����������Ʊ߽�Ŀ���γ����򣬲鿴xml�߽���Ϊ2dp��3px��,���Է��α߳�Ϊ����160-4=156dp(234px)
      mDrawableRect.inset(mBorderWidth, mBorderWidth);
    }
    // ������������Բ����С�뾶��Ҳ��ȥ���߽��ȵİ뾶
    mDrawableRadius = Math.min(mDrawableRect.height() / 2, mDrawableRect.width() / 2);
    // ������Ⱦ���ı任����Ҳ����mBitmap�ú���������ʽ���
    updateShaderMatrix();
    // �ֶ�����ondraw()���� ������յĻ���
    invalidate();
  }

  /**
   * �������Ϊ����BitmapShader��Matrix������������С���ű�����ƽ�Ʋ����� ���ã���֤ͼƬ��ʧ����С��ʼ�ջ���ͼƬ��������ǲ���
   */
  private void updateShaderMatrix() {
    float scale;
    float dx = 0;
    float dy = 0;

    mShaderMatrix.set(null);
    // ���ﲻ����� �������ʽҲ����(mBitmapWidth / mDrawableRect.width()) >
    // (mBitmapHeight / mDrawableRect.height())
    // ȡ��С�����ű���
    if (mBitmapWidth * mDrawableRect.height() > mDrawableRect.width() * mBitmapHeight) {
      // y������ x��ƽ�� ʹ��ͼƬ��y�᷽��ıߵĳߴ����ŵ�ͼƬ��ʾ����mDrawableRect��һ����
      scale = mDrawableRect.height() / (float) mBitmapHeight;
      dx = (mDrawableRect.width() - mBitmapWidth * scale) * 0.5f;
    } else {
      // x������ y��ƽ�� ʹ��ͼƬ��x�᷽��ıߵĳߴ����ŵ�ͼƬ��ʾ����mDrawableRect��һ����
      scale = mDrawableRect.width() / (float) mBitmapWidth;
      dy = (mDrawableRect.height() - mBitmapHeight * scale) * 0.5f;
    }
    // shaeder�ı任��������������Ҫ���ڷŴ������С��
    mShaderMatrix.setScale(scale, scale);
    // ƽ��
    mShaderMatrix.postTranslate((int) (dx + 0.5f) + mDrawableRect.left,
            (int) (dy + 0.5f) + mDrawableRect.top);
    // ���ñ任����
    mBitmapShader.setLocalMatrix(mShaderMatrix);
  }
}