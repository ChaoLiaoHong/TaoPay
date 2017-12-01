package com.hmkj.taozhifu.http;

import com.hmkj.taozhifu.BuildConfig;

/**
 * Created by Administrator on 2017/8/16.
 *
 * @author zhifubao
 * @接口写上注释，表明是干什么的，名字用地址后面的方法名，方便查找
 * @写网络请求的时候考虑全面一点，避免出现不必要的小问题
 */

public class HttpConfig {
    public static final String WIP = BuildConfig.DEBUG ? "http://120.26.235.96:9088/" : "http://www.gxtzfpt.com/";
    //扫一扫返回码
    public static final int REQUEST_CODE = 11;
    //图库
    public static final int REQUEST_IMAGE = 13;
    //完善信息返回码
    public static final int REQUEST_CODE_MY = 12;
    //微信的appid  用的佳联邦的ID
    //wx874efc3b70b1baed
    public static final String APP_ID = "wxc299b121dea640c4";
    /**
     * 分享链接
     */
    public static final String shareURL = WIP + "share/register.html?memberId=";
    /**
     * 在线培训
     */
    public static final String classroom = "http://xfc.ws1688.com/college/front/classroom/index?classroom_code=POyLnj&share_code=m08KqAUPJ1BW";
    /**
     * 4.27 查询会员足迹中商品
     */
    public static final String getFootPrintCommodityByMemberId = WIP + "appShoppingCart/read/getFootPrintCommodityByMemberId";
    /**
     * 商品分类（查询所有分类）
     */
    public static final String getLayeredClassAll = WIP + "api/pro/proClass/getLayeredClassAll";
    public static final String getLevelToTwoClassByOneClassId = WIP + "api/pro/proClass/getLevelToTwoClassByOneClassId/";
    /**
     * 首页轮播图
     */
    public static final String getAdver = WIP + "api/pro/adver/getAdver";
    /**
     * 首页按钮
     */
    public static final String indexButton = WIP + "api/pro/indexButton/";
    /**
     * 首页公告
     */
    public static final String querySysNotice = WIP + "api/sys/sysNotice/querySysNotice";
    /**
     * 公告详情
     */
    public static final String queryByNotice = WIP + "api/sys/sysNotice/queryByNotice/";
    /**
     * 登录注册
     */
    public static final String GET_REGIST_CODE = WIP + "api/sysMember/getSmsCodes";
    public static final String ISTRUE_CODE = WIP + "api/sysMember/registerPhone";
    public static final String REGIST_FINAL = WIP + "api/sysMember/registerPassword";
    public static final String LOGIN = WIP + "api/login";
    /**
     * 周边搜索店铺
     */
    public static final String getShopPoiGeoSearchByNear = WIP + "api/pro/proShop/getShopPoiGeoSearchByNear";
    /**
     * 商品搜索
     */
    public static final String queryProCommodity = WIP + "api/proCommodity/queryProCommodity";
    /**
     * 店铺详情
     */
    public static final String getShopDetailByShopId = WIP + "api/pro/proShop/getShopDetailByShopId/";
    public static final String getMemberRebateIntegral = WIP + "api/pro/proShop/getMemberRebateIntegral/%s";
    /**
     * 添加店铺收藏
     */
    public static final String shopCollection = WIP + "api/pro/shopCollection/add/shopCollection";
    /**
     * 查询收藏的店铺
     */
    public static final String queryShopCollection = WIP + "api/pro/shopCollection/query/shopCollection";
    /**
     * 删除店铺收藏
     */
    public static final String deleteShopCollection = WIP + "api/pro/shopCollection/delete/shopCollection/";
    /**
     * 获取商家收藏的状态
     */
    public static final String getShopCollection = WIP + "api/pro/shopCollection/get/shopCollection/";
    /**
     * 获取商品收藏的状态
     */
    public static final String proCommodityCollection = WIP + "api/pro/commodityCollection/get/proCommodityCollection";
    /**
     * 删除商品收藏
     */
    public static final String deleteProCommodityCollection = WIP + "api/pro/commodityCollection/delete/proCommodityCollection/";
    /**
     * 添加商品收藏
     */
    public static final String addroCommodityCollection = WIP + "api/pro/commodityCollection/add/proCommodityCollection";
    /**
     * 查询收藏的商品
     */
    public static final String queryCommodityCollection = WIP + "api/pro/commodityCollection/query/commodityCollection";
    /**
     * 查询店铺评论
     */
    public static final String getShopCommentByShop = WIP + "api/pro/proShopComment/getShopCommentByShop";
    /**
     * 会员钱包接口
     */
    public static final String memberAcountAndRecord = WIP + "api/pay/memberAcountAndRecord/";
    /**
     * 店铺商品查询
     */
    public static final String selectByShopId = WIP + "api/proCommodity/selectByShopId/";
    /**
     * 商品详情
     */
    public static final String getProCommodityById = WIP + "api/proCommodity/getProCommodityById/%s";
    /**
     * 获取用户信息
     */
    public static final String QUERY_USER_INFO = WIP + "/api/sysMember/queryByMember";
    /**
     * 获取淘点信息
     */
    public static final String QUERY_TAODIAN_INFO = WIP + "api/pay/memberAcount/";
    public static final String TAO_DIAN_INFO = WIP + "api/pay/tradeMemberRecord/";
    /**
     * 查询店铺信息
     */
    public static final String shopDetailByMemberId = WIP + "api/pro/proShop/shopDetailByMemberId/%s";
    /**
     * 商铺-查询兑换订单
     */
    public static final String selectExchangeOrder = WIP + "api/order/selectExchangeOrder/%s";

    /**
     * 商品添加
     */
    public static final String addProCommodity = WIP + "api/proCommodity/addProCommodity";
    /**
     * 商品编辑
     */
    public static final String updateProCommodity = WIP + "api/proCommodity/updateProCommodity";
    /**
     * 我的店铺商品查询
     */
    public static final String selectByMemberId = WIP + "api/proCommodity/selectByMemberId/%s";
    /**
     * 我的店铺商品下架
     */
    public static final String updateProCommodityByUpState = WIP + "/api/proCommodity/updateProCommodityByUpState";
    /**
     * 查询店铺折扣信息
     */
    public static final String getShopDiscountList = WIP + "api/pro/proShop/getShopDiscountList";
    /**
     * 添加店铺
     */
    public static final String proShop = WIP + "api/pro/proShop/";
    /**
     * 会员申请注销店铺
     */
    public static final String logoutShop = WIP + "/api/pro/proShop/logoutShop";
    /**
     * 实名认证
     */
    public static final String FILL_IN_INFO = WIP + "/api/sysMember/addByRealName";
    /**
     * 性别完善
     */
    public static final String SEX_INFO = WIP + "/api/sysMember/updateBySex";
    /**
     * 忘记密码验证码匹配
     */
    public static final String ISTRUE_CODE_FORGET = WIP + "api/sysMember/forgotPasswordCode";
    public static final String FORGET_PWD_SET = WIP + "api/sysMember/forgotPassword";
    public static final String GET_CODE = WIP + "api/sysMember/getSmsverification";
    public static final String GETSMS = WIP + "api/sysMember/getSms";
    /**
     * 商品生成订单
     */
    public static final String addOrder = WIP + "api/order/addOrder";
    /**
     * 线下生成订单
     */
    public static final String offlineOrder = WIP + "api/order/offlineOrder/%s";
    /**
     * 支付接口
     */
    public static final String initPay = WIP + "api/pay/thirdPay/initPay";
    /**
     * 更换头像的地址
     */
    public static final String HEAD_UPDATE = WIP + "api/sysMember/updateByImgUrl";
    /**
     * 设置支付密码
     */
    public static final String GET_ZFCODE = WIP + "/api/pay/memberAcount/getSmsCodes";
    public static final String SETTING_ZF_PWD = WIP + "/api/pay/memberAcount/";
    /**
     * 会员查询自己所下订单
     */
    public static final String selectPayOrderByMemberId = WIP + "api/order/selectPayOrderByMemberId/%s";
    /**
     * 会员查询自己所下订单
     */
    public static final String updateOrderByOrdesState = WIP + "api/order/updateOrderByOrdesState/%s";
    /**
     * 订单详情
     */
    public static final String selectOrderDetailByOrderId = WIP + "api/order/selectOrderDetailByOrderId/%s";
    /**
     * 商家查询线下订单
     */
    public static final String selectOrderByMemberId = WIP + "api/order/selectOrderByMemberId/%s";
    /**
     * 核销兑换吗
     */
    public static final String updateOrder = WIP + "api/order/updateOrder/%s";
    /**
     * 核销兑换查询商品信息
     */
    public static final String updateOrderByOrderCode = WIP + "api/order/updateOrderByOrderCode";
    /**
     * 我的商品删除
     */
    public static final String deleteById = WIP + "/api/proCommodity/deleteById/%s";
    /**
     * 查看用户是否绑定了支付宝/微信账号
     */
    public static final String payWithdrawalAccount = WIP + "api/pay/withdrawal/account/%s";
    /**
     * 同步阿里账号
     */
    public static final String syncAliAccount = WIP + "api/pay/withdrawal/updateAliAccount";
    /**
     * 同步微信账号
     */
    public static final String syncWeiXiAccount = WIP + "api/pay/withdrawal/updateWeixAccount";
    /**
     * 提交提现申请
     */
    public static final String payWithdrawal = WIP + "api/pay/withdrawal";
    /**
     * 版本更新
     */
    public static final String versionUpdate = WIP + "api/sysAppVersion/query";
    /**
     * 提现记录
     */
    public static final String withdrawalRecord = WIP + "/api/pay/withdrawal/%s";
    /**
     * 聚合支付的二维码地址
     */
    public static final String getCode = WIP + "api/qrpay/toQrPay?shopId=%s";
    /**
     * 验证码登录
     */
    public static final String codeLogin = WIP + "/api/sysMember/codeLogin";

}
