package org.fast.express.order.repository;

import org.fast.express.order.entity.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wcl
 * @version 1.0
 * @date 2020/3/11 18:46
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderDO, Integer> {
}
