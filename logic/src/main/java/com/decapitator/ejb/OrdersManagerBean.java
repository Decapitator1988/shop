package com.decapitator.ejb;

import com.decapitator.domain.Item;
import com.decapitator.domain.ItemInOrder;
import com.decapitator.domain.Order;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
@LocalBean
public class OrdersManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Order createOrder(){
        Order order = new Order();
        entityManager.persist(order);

        return order;
    }

    public boolean addToOrder(long itemId, long orderId, int qunatity){
        Item item = entityManager.find(Item.class, itemId);
        if (item==null){
            return false;
        }
        Order order = entityManager.find(Order.class, orderId);
        if (order==null){
            return false;
        }
        ItemInOrder itemInOrder = new ItemInOrder();
        itemInOrder.setOrder(order);
        itemInOrder.setItem(item);
        itemInOrder.setQuantity(qunatity);

        entityManager.persist(itemInOrder);

        return true;
    }
    public List<Item> getItemsInOrder(long orderId){
        Order order = entityManager.find(Order.class, orderId);
        if (order==null){
            return Collections.emptyList();
        }
        List <ItemInOrder> itemInOrders =  order.getItemInOrders();
        List <Item> result = new ArrayList<>();
        for (ItemInOrder itemInOrder: itemInOrders){
            result.add(itemInOrder.getItem());
        }
        return result;
    }
}
