/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hmkj.taozhifu.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

public class GankModel implements Serializable {
    private static final long serialVersionUID = 6753210234564872868L;


    /**
     * error : false
     * results : [{"_id":"598c1db2421aa90ca209c58b","createdAt":"2017-08-10T16:47:46.44Z","desc":"用户体验极佳的干货集中营 iOS App","images":["http://img.gank.io/218bcc4e-8d85-479d-b8ce-0d674eb38ef8"],"publishedAt":"2017-08-15T13:32:36.998Z","source":"web","type":"iOS","url":"https://github.com/yeziahehe/Gank","used":true,"who":"Fan Ye"},{"_id":"59911759421aa9672f354db2","createdAt":"2017-08-14T11:22:01.227Z","desc":"通过 Kalman filter （卡尔曼滤波）解决 GPS 抖动路径记录问题。","images":["http://img.gank.io/03f69bd1-49b6-4028-a66d-421e0b28f372"],"publishedAt":"2017-08-14T17:04:50.266Z","source":"chrome","type":"iOS","url":"https://github.com/Hypercubesoft/HCKalmanFilter","used":true,"who":"S"},{"_id":"59911788421aa967262e1c1a","createdAt":"2017-08-14T11:22:48.804Z","desc":"利用 AR Kit 来精确测量长度，有意思。","images":["http://img.gank.io/af0bf1fe-3195-445f-875a-4b14ce30b90c"],"publishedAt":"2017-08-14T17:04:50.266Z","source":"chrome","type":"iOS","url":"https://github.com/levantAJ/Measure","used":true,"who":"代码家"},{"_id":"599117ed421aa9672f354db5","createdAt":"2017-08-14T11:24:29.855Z","desc":"炫酷的下载按钮！","publishedAt":"2017-08-14T17:04:50.266Z","source":"chrome","type":"iOS","url":"https://github.com/MagicBlind/Download-Button","used":true,"who":"S"},{"_id":"59916664421aa96729c57240","createdAt":"2017-08-14T16:59:16.344Z","desc":"iOS优秀第三方开源库汇总，收藏备用","publishedAt":"2017-08-14T17:04:50.266Z","source":"chrome","type":"iOS","url":"http://blog.csdn.net/x32sky/article/details/77112964","used":true,"who":"x32sky"},{"_id":"598d28a5421aa97de5c7ca5a","createdAt":"2017-08-11T11:46:45.578Z","desc":"A drop-in replacement for UICollectionViewFlowLayout","images":["http://img.gank.io/42c469c0-013e-4994-8b83-af02cb362d12"],"publishedAt":"2017-08-11T14:05:53.749Z","source":"chrome","type":"iOS","url":"https://github.com/devxoul/UICollectionViewFlexLayout","used":true,"who":"S"},{"_id":"598d28d3421aa90c9203d49a","createdAt":"2017-08-11T11:47:31.557Z","desc":"可伸展的 Table Cell","publishedAt":"2017-08-11T14:05:53.749Z","source":"chrome","type":"iOS","url":"https://github.com/rob-nash/CollapsibleTable","used":true,"who":"S"},{"_id":"597c5540421aa90ca209c510","createdAt":"2017-07-29T17:28:32.705Z","desc":"一款完成度较高的记录跑步App。：）","images":["http://img.gank.io/fe1d3102-cbe9-4ef2-9def-12a41a8d7146"],"publishedAt":"2017-08-09T13:49:27.260Z","source":"web","type":"iOS","url":"https://github.com/moshuqi/YSRun","used":true,"who":"moshuqi"},{"_id":"598a803f421aa97de5c7ca44","createdAt":"2017-08-09T11:23:43.237Z","desc":"潘多拉播放器，做的超漂亮~","images":["http://img.gank.io/6bee277d-2aa4-42b5-9fa2-82654dd45bde"],"publishedAt":"2017-08-09T13:49:27.260Z","source":"chrome","type":"iOS","url":"https://github.com/AppliKeySolutions/PandoraPlayer","used":true,"who":"代码家"},{"_id":"5985e1bc421aa97de5c7ca31","createdAt":"2017-08-05T23:18:20.217Z","desc":"swift版Luban，最接近微信朋友圈图片压缩效果的lib","publishedAt":"2017-08-08T11: 34: 20.37Z","source":"web","type":"iOS","url":"https: //github.com/iCell/Mozi","used":true,"who":"diaocow"},{"_id":"59892f30421aa97de5c7ca40","createdAt":"2017-08-08T11: 25: 36.509Z","desc":"iOS声明式Layout布局。","publishedAt":"2017-08-08T11: 34: 20.37Z","source":"chrome","type":"iOS","url":"https: //github.com/schibsted/layout","used":true,"who":"代码家"},{"_id":"59823dbe421aa90ca209c54b","createdAt":"2017-08-03T05: 01: 50.665Z","desc":"EasyMoreOperationViewControllerinswift.","publishedAt":"2017-08-03T12: 08: 07.258Z","source":"web","type":"iOS","url":"https: //github.com/yeziahehe/YFMoreViewController","used":true,"who":"FanYe"},{"_id":"59826cf3421aa90ca209c54f","createdAt":"2017-08-03T08: 23: 15.157Z","desc":"SwiftGif提取器和制作工具。","publishedAt":"2017-08-03T12: 08: 07.258Z","source":"chrome","type":"iOS","url":"https: //github.com/onmyway133/GifMagic","used":true,"who":"代码家"},{"_id":"59811a1f421aa90ca3bb6bce","createdAt":"2017-08-02T08: 17: 35.941Z","desc":"轻量图片编辑组件。","images":["http: //img.gank.io/9c78edf3-e270-4002-be93-5d7adb279f59"],"publishedAt":"2017-08-02T12: 21: 45.220Z","source":"chrome","type":"iOS","url":"https: //github.com/agilie/AGImageControls","used":true,"who":"代码家"},{"_id":"59811a38421aa90ca209c53e","createdAt":"2017-08-02T08: 18: 00.155Z","desc":"按钮加载动画效果Demo，简单易懂。","images":["http: //img.gank.io/9672070b-bbf7-4be9-b290-ea5342564224"],"publishedAt":"2017-08-02T12: 21: 45.220Z","source":"chrome","type":"iOS","url":"https: //github.com/AladinWay/TransitionButton","used":true,"who":"S"},{"_id":"59811a51421aa97de5c7ca07","createdAt":"2017-08-02T08: 18: 25.770Z","desc":"Swift实现的Terminal进度效果。","publishedAt":"2017-08-02T12: 21: 45.220Z","source":"chrome","type":"iOS","url":"https: //github.com/kiliankoe/CLISpinner","used":true,"who":"代码家"},{"_id":"597fcba0421aa90ca3bb6bb9","createdAt":"2017-08-01T08: 30: 24.163Z","desc":"几行代码实现macOS开机启动功能。","publishedAt":"2017-08-01T11: 48: 20.466Z","source":"chrome","type":"iOS","url":"https: //github.com/sindresorhus/LaunchAtLogin","used":true,"who":"代码家"},{"_id":"597fcbbd421aa90ca209c52b","createdAt":"2017-08-01T08: 30: 53.751Z","desc":"姿势多样的Shadow效果。","images":["http: //img.gank.io/fb39ee74-4563-4abd-b7fc-c7863797a451"],"publishedAt":"2017-08-01T11: 48: 20.466Z","source":"chrome","type":"iOS","url":"https: //github.com/PierrePerrin/ShadowView","used":true,"who":"S"},{"_id":"597fcbe2421aa97de5c7c9f6","createdAt":"2017-08-01T08: 31: 30.716Z","desc":"AppLocker-simplelockscreenforiOSApplication","images":["http: //img.gank.io/ffb91bbc-6355-4f41-831e-a529ff972e14"],"publishedAt":"2017-08-01T11: 48: 20.466Z","source":"chrome","type":"iOS","url":"https: //github.com/Ryasnoy/AppLocker","used":true,"who":"RYA"},{"_id":"59796bc5421aa90c9203d411","createdAt":"2017-07-27T12: 27: 49.649Z","desc":"iOS上的一个简单，实用的无限循环轮播图组件","images":["http: //img.gank.io/2a48d6b2-83c5-4993-ab5e-e56b19658070"],"publishedAt":"2017-07-27T14: 16: 33.773Z","source":"web","type":"iOS","url":"https: //github.com/12207480/TYCyclePagerView","used":true,"who":"yeBlueColor"}]
     */

    public boolean error;
    public List<ResultsBean> results;

    public static class ResultsBean implements MultiItemEntity {
        /**
         * _id : 598c1db2421aa90ca209c58b
         * createdAt : 2017-08-10T16:47:46.44Z
         * desc : 用户体验极佳的干货集中营 iOS App
         * images : ["http://img.gank.io/218bcc4e-8d85-479d-b8ce-0d674eb38ef8"]
         * publishedAt : 2017-08-15T13:32:36.998Z
         * source : web
         * type : iOS
         * url : https://github.com/yeziahehe/Gank
         * used : true
         * who : Fan Ye
         */

        public String _id;
        public String createdAt;
        public String desc;
        public String publishedAt;
        public String source;
        public String type;
        public String url;
        public boolean used;
        public String who;
        public List<String> images;

        @Override
        public int getItemType() {
            return 0;
        }
    }
}
