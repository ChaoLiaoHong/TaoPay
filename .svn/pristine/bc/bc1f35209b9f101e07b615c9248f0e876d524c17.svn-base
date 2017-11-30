package com.hmkj.taozhifu.pay;



import android.app.Activity;
import android.os.Handler;

public class PayFactory {
	private PayMoney payMoney;
	public static PayFactory create(PayWay payWay,Handler handler){
		return new PayFactory(payWay,handler);
	}
	public PayFactory(PayWay payWay,Handler handler){
		switch (payWay) {
			//支付宝支付
		case ALIPAY:
			payMoney = new Alipay(handler);
			break;
		//微信支付
			case WEIXIN:

		    break;
		default:
			break;
		}
	}
	
	public <T extends Activity> void pay(T context,String orderDetails){
		payMoney.pay(context, orderDetails);
	}
	
	
}
