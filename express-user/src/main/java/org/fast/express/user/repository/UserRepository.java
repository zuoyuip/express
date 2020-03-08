package org.fast.express.user.repository;

import org.fast.express.user.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 用户数据库操作.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 22:52
 **/
@Repository
public interface UserRepository extends JpaRepository<UserDO, Integer>,
    JpaSpecificationExecutor<UserDO> {

}
