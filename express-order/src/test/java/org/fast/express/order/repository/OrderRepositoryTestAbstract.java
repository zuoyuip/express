package org.fast.express.order.repository;
import lombok.extern.slf4j.Slf4j;
import org.fast.express.order.AbstractExpressOrderModuleTests;
import org.fast.express.order.entity.OrderDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;


/**
 * @author wcl
 * @version 1.0
 * @date 2020/3/11 18:47
 */
@Slf4j
public class OrderRepositoryTestAbstract extends AbstractExpressOrderModuleTests {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void sava(){
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(1);
        orderDO.setOrderCode("12313111");
        orderDO.setOrderName("asdd");
        orderDO.setOrderPickupCode("123123123");
        orderDO.setOrderUserName("王");
        orderDO.setOrderUserPhone("12313131");
        orderDO.setOrderUserSex("男");
        orderDO.setOrderSexImageUrl("as15154");
        orderDO.setOrderAddress("knasd");
        orderDO.setOrderGoalAddress("书画");
        orderDO.setOrderWeight("2kg");
        orderDO.setOrderReward("344");
        orderDO.setOrderRemark("12312312");
        orderDO.setOrderStatus("1");
        orderDO.setCreateTime(new Date());
        orderDO.setUpdateTime(new Date());
        OrderDO orderDO1 = orderRepository.save(orderDO);
        System.out.println("orderDO1.toString() = " + orderDO1.toString());
    }
}
