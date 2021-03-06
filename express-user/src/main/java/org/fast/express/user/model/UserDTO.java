package org.fast.express.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * 用户业务数据.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 21:26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonRootName(value = "user")
@ApiModel(value = "User", parent = UserDetails.class, description = "安全账户")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO implements UserDetails {


  /**
   * 安全用户唯一标识
   */
  @JsonProperty("id")
  @ApiModelProperty(name = "id", value = "安全用户唯一标识")
  private Integer userId;

  /**
   * 安全用户帐号（手机号）
   */
  @JsonProperty("phone")
  @NotNull(message = "手机号不得为空")
  @ApiModelProperty(name = "phone", value = "安全用户帐号（手机号）")
  private String userPhone;

  /**
   * 安全用户的密码
   */
  @JsonIgnore
  @NotNull(message = "密码不得为空")
  @ApiModelProperty(name = "password", value = "安全用户的密码")
  private String userPassword;


  /**
   * 该安全用户帐号是否未锁定
   */
  @JsonProperty("isAccountNonLocked")
  @ApiModelProperty(name = "isAccountNonLocked", value = "该安全用户帐号是否未锁定")
  private Boolean userIsAccountNonLocked;


  /**
   * 该帐号拥有的权限
   */
  @JsonProperty("authorities")
  @ApiModelProperty(value = "该帐号拥有的权限")
  private List<GrantedAuthority> authorities;


  @Override
  @JsonIgnore
  @ApiModelProperty(hidden = true)
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  @JsonIgnore
  @ApiModelProperty(hidden = true)
  public String getPassword() {
    return this.userPassword;
  }

  @Override
  @JsonIgnore
  @ApiModelProperty(hidden = true)
  public String getUsername() {
    return this.userPhone;
  }


  @Override
  @JsonIgnore
  @ApiModelProperty(hidden = true)
  public boolean isAccountNonLocked() {
    return this.userIsAccountNonLocked;
  }

  /**
   * 该安全用户帐号是否未过期
   */
  @Override
  @JsonIgnore
  @ApiModelProperty(hidden = true)
  public boolean isAccountNonExpired() {
    return true;
  }


  /**
   * 该安全用户帐号凭证是否未过期
   */
  @Override
  @JsonIgnore
  @ApiModelProperty(hidden = true)
  public boolean isCredentialsNonExpired() {
    return true;
  }


  /**
   * 该安全用户帐号是否启用
   */
  @Override
  @JsonIgnore
  @ApiModelProperty(hidden = true)
  public boolean isEnabled() {
    return true;
  }

  public UserDTO(
      @NotNull(message = "手机号不得为空") String userPhone,
      @NotNull(message = "密码不得为空") String userPassword) {
    this.userPhone = userPhone;
    this.userPassword = userPassword;
  }
}
