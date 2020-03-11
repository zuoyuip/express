package org.fast.express.user.entity;

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
 * @author wcl
 * @version 1.0
 * @date 2020/3/10 21:42
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "tb_check")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CheckDO extends BaseEntity {

    /**
     * 审核表唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer checkId;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID", columnDefinition = "int not null comment '用户ID'")
    private Integer userId;

    /**
     * 审核是否已通过
     */
    @Column(name = "CHEACK_IS_BY", columnDefinition = "VARCHAR(5) not null comment '审核是否已通过'")
    private Integer checkIsBy;

    /**
     * 审核说明
     */
    @Column(name = "CHEACK_MESSAGE", columnDefinition = "text not null comment '审核说明'")
    private String checkMessage;

    /**
     * 审核图片地址
     */
    @Column(name = "CHEACK_PHOTO_URL", columnDefinition = "VARCHAR(120) not null comment '审核图片地址'")
    private String checkPhotoUrl;

    /**
     * 审核缩略图片地址
     */
    @Column(name = "CHEACK_THUMB_PHOTO_URL", columnDefinition = "VARCHAR(5) not null comment '审核缩略图片地址'")
    private String checThumbPhotoUrl;


}
