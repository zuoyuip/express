package org.fast.express.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * 基础模型.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 20:47
 **/
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Create time.
   */
  @Column(name = "create_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP comment '创建时间'")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createTime;

  /**
   * Update time.
   */
  @Column(name = "update_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP comment '修改时间'")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateTime;

  /**
   * Delete flag.
   */
  @Column(name = "deleted", columnDefinition = "TINYINT default 0  comment '是否已被删除'")
  private Boolean deleted = false;

  @PrePersist
  void prePersist() {
    this.deleted = false;
    Date now = Date.from(Instant.now());
    if (this.createTime == null) {
      this.createTime = now;
    }

    if (this.updateTime == null) {
      this.updateTime = now;
    }
  }

  @PreUpdate
  void preUpdate() {
    this.updateTime = new Date();
  }

  @PreRemove
  void preRemove() {
    this.updateTime = new Date();
    this.deleted = true;
  }
}
