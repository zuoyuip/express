package org.fast.express.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.fast.express.order.common.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 用户表.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 20:47
 **/
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDO extends BaseEntity {

  /**
   * 安全用户唯一标识
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  /**
   * 安全用户帐号（手机号）
   */
  @Column(name = "phone", columnDefinition = "varchar(255) not null comment '安全用户帐号（手机号）'")
  private String userPhone;

  /**
   * 安全用户的密码
   */
  @Column(name = "password", columnDefinition = "varchar(255) not null comment '安全用户的密码'")
  private String userPassword;


  /**
   * 该安全用户帐号是否未锁定
   */
  @Column(name = "is_account_non_locked", columnDefinition = "TINYINT default 1 comment '该安全用户帐号是否未锁定'")
  private Boolean userIsAccountNonLocked;


  /**
   * 真实姓名
   */
  @Column(name = "USER_REAL_NAME", columnDefinition = "varchar(50)  comment '真实姓名'")
  private String userRealName;

  /**
   * 性别
   */
  @Column(name = "USER_GENDER", columnDefinition = "varchar(5)  comment '性别'")
  private String userGender;

  /**
   * 学院
   */
  @Column(name = "USER_COLLEGE", columnDefinition = "varchar(50)  comment '学院'")
  private String userCollege;

  /**
   * 专业
   */
  @Column(name = "USER_SUBJECT", columnDefinition = "varchar(50)  comment '专业'")
  private String userSubject;

  /**
   * 班级
   */
  @Column(name = "USER_CLASS", columnDefinition = "varchar(50)  comment '班级'")
  private String userClass;

  /**
   * 学号
   */
  @Column(name = "USER_NUMBER", columnDefinition = "varchar(50)  comment '学号'")
  private String userNumber;

  /**
   * 状态
   */
  @Column(name = "USER_STATUS", columnDefinition = "varchar(5)  comment '状态'")
  private String userStatus;

  /**
   * 审核状态
   */
  @Column(name = "USER_CHECK_STATUS", columnDefinition = "varchar(5)  comment '审核状态'")
  private String userCheckStatus;

  /**
   * 创建时间
   */
/*  @Column(name = "USER_CREATE_TIME", columnDefinition = "datetime  comment '创建时间'")
  private Data userDate;*/

  /**
   * 操作时间
   */
/*  @Column(name = "USER_LAST_UPDATE_TIME", columnDefinition = "datetime  comment '操作时间'")
  private Data userLastUpdateTime;*/


}

