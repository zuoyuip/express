package org.fast.express.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
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
   * 该安全用户帐号是否已注册
   */
  @Column(name = "is_valid", columnDefinition = "TINYINT default 1 comment '该安全用户帐号是否已注册'")
  private Boolean userIsValid;

  /**
   * 该安全用户帐号是否启用
   */
  @Column(name = "is_enabled", columnDefinition = "TINYINT default 1 comment '该安全用户帐号是否启用'")
  private Boolean userIsEnabled;

  /**
   * 该安全用户帐号是否未过期
   */
  @Column(name = "is_account_non_expired", columnDefinition = "TINYINT default 1 comment '该安全用户帐号是否未过期'")
  private Boolean userIsAccountNonExpired;

  /**
   * 该安全用户帐号凭证是否未过期
   */
  @Column(name = "is_credentials_non_expired", columnDefinition = "TINYINT default 1 comment '该安全用户帐号凭证是否未过期'")
  private Boolean userIsCredentialsNonExpired;

  /**
   * 该安全用户帐号是否未锁定
   */
  @Column(name = "is_account_non_locked", columnDefinition = "TINYINT default 1 comment '该安全用户帐号是否未锁定'")
  private Boolean userIsAccountNonLocked;


}

