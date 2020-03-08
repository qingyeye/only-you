package com.only.you.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Data
@ApiModel(value = "首页商品")
@TableName("app_goods")
public class IndexGoods implements Serializable {

    @ApiModelProperty(hidden = true)
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    //商品id
    @ApiModelProperty(value = "商品id")
    @TableId("item_id")
    private String itemId;
    //商品标题
    @ApiModelProperty(value = "商品标题")
    @TableId("item_dtitle")
    private String itemDtitle;
    //商品原价
    @ApiModelProperty(value = "商品原价")
    @TableId("original_price")
    private BigDecimal originalPrice;
    //劵后价
    @ApiModelProperty(value = "劵后价")
    @TableId("actual_price")
    private BigDecimal actualPrice;
    //店铺类型
    @ApiModelProperty(value = "店铺类型，1-天猫，0-淘宝")
    @TableId("shop_type")
    private int shopType;
    //30天销量
    @ApiModelProperty(value = "30天销量")
    @TableId("month_sales")
    private int monthSales;
    //佣金类型，0-通用，1-定向，2-高佣，3-营销计划
    @ApiModelProperty(value = "佣金类型，0-通用，1-定向，2-高佣，3-营销计划")
    @TableId("item_commission_type")
    private int itemCommissionType;
    //优惠券链接
    @ApiModelProperty(value = "优惠券链接")
    @TableId("coupon_link")
    private String couponLink;
    //优惠券结束时间
    @ApiModelProperty(value = "优惠券结束时间")
    @TableId("coupon_end_time")
    private Date couponEndTime;
    //优惠券开始时间
    @ApiModelProperty(value = "优惠券开始时间")
    @TableId("coupon_start_time")
    private Date couponStartTime;
    //优惠券金额
    @ApiModelProperty(value = "优惠券金额")
    @TableId("coupon_price")
    private BigDecimal couponPrice;
    //商品主图链接
    @ApiModelProperty(value = "商品主图链接")
    @TableId("item_main_pic")
    private String itemMainPic;
    //佣金比例
    @ApiModelProperty(value = "佣金比例")
    @TableId("item_commission_rate")
    private double itemCommissionRate;
    //活动开始时间
    @ApiModelProperty(value = "活动开始时间")
    @TableId("activity_start_time")
    private Date activityStartTime;
    //活动结束时间
    @ApiModelProperty(value = "活动结束时间")
    @TableId("activity_end_time")
    private Date activityEndTime;
    //店铺名称
    @ApiModelProperty(value = "店铺名称")
    @TableId("item_shop_name")
    private String itemShopName;
    //商品淘宝链接
    @ApiModelProperty(value = "商品淘宝链接")
    @TableId("item_link")
    private String itemLink;
    //是否天猫超市商品，1-天猫超市商品，0-非天猫超市商品
    @ApiModelProperty(value = "是否天猫超市商品，1-天猫超市商品，0-非天猫超市商品")
    @TableId("item_tchaoshi_type")
    private int itemTchaoshiType;

}
