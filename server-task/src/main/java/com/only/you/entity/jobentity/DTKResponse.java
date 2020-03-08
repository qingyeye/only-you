package com.only.you.entity.jobentity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class DTKResponse implements Serializable {
    private Long time;
    private Integer code;
    private String msg;
    private DTKResponse.DTKDataBean data;

    @Getter
    @Setter
    @Data
    @TableName("onlyyou_dtk_goods")
    public static  class DTKDataBean implements Serializable{
        private static final long serialVersionUID = -2749826706756902901L;
        public DTKDataBean(){}
        /**商品ID*/
        @JsonProperty("goods_id")
        private String id;
        /**淘宝商品id	*/
        @JsonProperty("item_id")
        private String goodsId;
        /**淘宝标题	 */
        @JsonProperty("item_title")
        private String title;
        /**短标题	*/
        @JsonProperty("item_dtitle")
        private String dtitle;
        /**商品原价	 */
        @JsonProperty("original_price")
        private String originalPrice;
        /**券后价	 */
        @JsonProperty("actual_price")
        private String actualPrice;
        /**店铺类型，1-天猫，0-淘宝	 */
        @JsonProperty("shop_type")
        private String shopType;
        /**是否金牌卖家，1-金牌卖家，0-非金牌卖家 */
        @JsonProperty("gold_sellers")
        private String goldSellers;
        /**30天销量	*/
        @JsonProperty("month_sales")
        private String monthSales;

        /**榜单名次*/
        @JsonProperty("item_ranking")
        private String ranking;
        /**是否新上榜商品（12小时内入榜的商品） 0.否1.是*/
        @JsonProperty("item_newranking_goods")
        private String newRankingGoods;
        /**营销图*/
        @TableField(exist = false)
        private String picList;
        /**	放单人名称*/
        @JsonProperty("guide_name")
        private String guideName;
        /**	日均销量（仅复购榜返回该字段）*/
        @JsonProperty("item_avgsales")
        private String avgSales;
        /**	入榜时间（仅复购榜返回该字段）*/
        @JsonProperty("entry_time")
        private String entryTime;
        /**定金，若无定金，则显示0	*/
        @JsonProperty("item_quan_mlink")
        private String quanMLink;
        /**立减，若无立减金额，则显示0	*/
        @JsonProperty("item_hzquanover")
        private String hzQuanOver;
        /**0.不包运费险 1.包运费险	*/
        @JsonProperty("item_yunfeixian")
        private String yunfeixian;
        /** 预估淘礼金	*/
        @JsonProperty("item_estimate_amount")
        private String estimateAmount;

        /**2小时销量	*/
        @JsonProperty("item_twohours_sales")
        private String twoHoursSales;
        /**当天销量	*/
        @JsonProperty("item_daily_sales")
        private String dailySales;
        /**佣金类型，0-通用，1-定向，2-高佣，3-营销计划	*/
        @JsonProperty("item_commission_type")
        private String commissionType;
        /**推广文案	String	“宽松舒适，难以磨损典，雅而优美，倍感丝滑，质感优越，庄严而心仪，简约设计，色调清新脱俗，适合各种场合”	*/
        @JsonProperty("item_desc")
        private String desc;
        /**领券量	*/
        @JsonProperty("coupon_receive_num")
        private String couponReceiveNum;
        /**优惠券链接	*/
        @JsonProperty("coupon_link")
        private String couponLink;
        /**优惠券结束时间	*/
        @JsonProperty("coupon_end_time")
        private String couponEndTime;
        /**优惠券开始时间	*/
        @JsonProperty("coupon_start_time")
        private String couponStartTime;
        /**优惠券金额	*/
        @JsonProperty("coupon_price")
        private String couponPrice;
        /**优惠券使用条件	*/
        @JsonProperty("coupon_conditions")
        private String couponConditions;
        /**活动类型，1-无活动，2-淘抢购，3-聚划算	*/
        @JsonProperty("activity_type")
        private String activityType;
        /**商品上架时间	*/
        @JsonProperty("item_reate_time")
        private String createTime;
        /**商品主图链接	*/
        @JsonProperty("item_main_pic")
        private String mainPic;
        /**营销主图链接	*/
        @JsonProperty("marketing_mainPic")
        private String marketingMainPic;


        /**淘宝卖家id	*/
        @JsonProperty("seller_id")
        private String sellerId;
        /**商品在大淘客的分类id	*/
        @JsonProperty("item_cid")
        private String cid;
        /**商品在大淘客的二级分类id，该分类为前端分类，一个商品可能有多个二级分类idList[Number]	*/
        @JsonProperty("item_subcid")
        private String subcid;
        /**商品在淘宝的分类id	*/
        @JsonProperty("item_tbcid")
        private String tbcid;
        /**折扣力度	*/
        @JsonProperty("item_discounts")
        private String discounts;
        /**佣金比例	*/
        @JsonProperty("item_commission_rate")
        private String commissionRate;
        /**券总量	*/
        @JsonProperty("item_coupon_total_num")
        private String couponTotalNum;
        /**是否海淘,1-海淘商品，0-非海淘商品	*/
        @JsonProperty("item_haitao_type")
        private String haitao;
        /**活动开始时间	*/
        @JsonProperty("activity_start_time")
        private String activityStartTime;
        /**活动结束时间	*/
        @JsonProperty("activity_end_time")
        private String activityEndTime;
        /**店铺名称	*/
        @JsonProperty("item_shop_name")
        private String shopName;
        /**淘宝店铺等级	*/
        @JsonProperty("item_shop_level")
        private String shopLevel;
        /**描述分	*/
        @JsonProperty("item_desc_score")
        private String descScore;
        /**描述相符	*/
        @JsonProperty("item_dsr_score")
        private String dsrScore;

        /**描述同行比	*/
        @JsonProperty("item_dsr_percent")
        private String dsrPercent;
        /**服务态度	*/
        @JsonProperty("ship_score")
        private String shipScore;
        /**服务同行比	*/
        @JsonProperty("ship_percent")
        private String shipPercent;
        /**物流服务	*/
        @JsonProperty("service_score")
        private String serviceScore;
        /**物流同行比	*/
        @JsonProperty("service_percent")
        private String servicePercent;
        /**是否是品牌商品	*/
        @JsonProperty("item_brand_type")
        private String brand;
        /**品牌id	*/
        @JsonProperty("brand_id")
        private String brandId;
        /**品牌名称	*/
        @JsonProperty("brand_name")
        private String brandName;
        /**热推值	*/
        @JsonProperty("hot_push")
        private String hotPush;
        /**放单人名称	*/
        @JsonProperty("team_name")
        private String teamName;
        /**商品淘宝链接	*/
        @JsonProperty("item_link")
        private String itemLink;
        /**是否天猫超市商品，1-天猫超市商品，0-非天猫超市商品	*/
        @JsonProperty("item_tchaoshi_type")
        private String tchaoshi;

    }
}
