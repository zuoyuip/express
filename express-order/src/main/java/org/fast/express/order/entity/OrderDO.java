package org.fast.express.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.fast.express.order.common.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 订单表
 *
 * @author wcl
 * @program express
 * @date 2020/3/10 21:18
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "tb_order")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderDO extends BaseEntity {

    /**
     * 订单唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;


    /**
     * 用户ID
     */
    @Column(name = "USER_ID", columnDefinition = "int not null comment '用户ID'")
    private Integer userId;

    /**
     * 订单编号
     */
    @Column(name = "ORDER_CODE", columnDefinition = "varchar(255) not null comment '订单编号'")
    private String orderCode;

    /**
     * 快递名称
     */
    @Column(name = "ORDER_NAME", columnDefinition = "varchar(25) not null comment '快递名称'")
    private String orderName;

    /**
     * 快递取货号
     */
    @Column(name = "ORDER_PICKUP_CODE", columnDefinition = "varchar(25) not null comment '快递取货号'")
    private String orderPickupCode;

    /**
     * 收货人名字
     */
    @Column(name = "ORDER_USER_NAME", columnDefinition = "varchar(25) not null comment '收货人名字'")
    private String orderUserName;

    /**
     * 收货人手机号码
     */
    @Column(name = "ORDER_USER_PHONE", columnDefinition = "varchar(40) not null comment '收货人手机号码'")
    private String orderUserPhone;

    /**
     * 收货人性别
     */
    @Column(name = "ORDER_USER_SEX", columnDefinition = "varchar(25) not null comment '收货人性别'")
    private String orderUserSex;

    /**
     * 收货人性别图片地址
     */
    @Column(name = "ORDER_SEX_IMAGE_URL", columnDefinition = "varchar(255) not null comment '收货人性别图片地址'")
    private String orderSexImageUrl;

    /**
     * 包裹所在地址
     */
    @Column(name = "ORDER_ADDRESS", columnDefinition = "tinytext not null comment '包裹所在地址'")
    private String orderAddress;

    /**
     * 包裹要送达的地址
     */
    @Column(name = "ORDER_GOAL_ADDRESS", columnDefinition = "tinytext not null comment '包裹要送达的地址'")
    private String orderGoalAddress;

    /**
     * 包裹重量
     */
    @Column(name = "ORDER_WEIGHT", columnDefinition = "varchar(50) not null comment '包裹重量'")
    private String orderWeight;

    /**
     * 包裹的赏金
     */
    @Column(name = "ORDER_REWARD", columnDefinition = "varchar(25) not null comment '包裹的赏金'")
    private String orderReward;

    /**
     * 订单信息-备注
     */
    @Column(name = "ORDER_REMARK", columnDefinition = "tinytext  not null comment '订单信息-备注'")
    private String orderRemark;

    /**
     * 订单是否被接单
     */
    @Column(name = "ORDER_STATUS", columnDefinition = "varchar(25) not null comment '订单是否被接单'")
    private String orderStatus;



}
