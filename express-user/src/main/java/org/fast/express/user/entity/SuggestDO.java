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
 * @date 2020/3/10 21:49
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "tb_suggest")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SuggestDO extends BaseEntity {

    /**
     * 反馈表唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer suggestId;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID", columnDefinition = "int not null comment '用户ID'")
    private Integer userId;

    /**
     * 反馈内容
     */
    @Column(name = "SUGGEST_CONTENT", columnDefinition = "text not null comment '反馈内容'")
    private Integer suggestContent;


}
