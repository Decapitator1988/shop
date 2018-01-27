package com.decapitator;

import com.decapitator.domain.Item;
import com.decapitator.domain.Order;
import com.decapitator.ejb.ItemManagerBean;
import com.decapitator.ejb.OrdersManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class OrderBean  implements Serializable{
    private String name;
    private int quantity;
    private Order order;

    @EJB
    private  OrdersManagerBean ordersManagerBean;

    @EJB
    private ItemManagerBean itemManagerBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {

        return quantity;
    }

    public void setPrice(int price) {
        this.quantity = price;
    }

    public void createOrder(){
        if (order==null){
            order = ordersManagerBean.createOrder();
        }
    }
    public void createItem(){
        itemManagerBean.createItem(name, quantity);
    }
    public List <Item> getItems(){
        return itemManagerBean.getItems();
    }
    public void addItem(Item item){
        if (order==null){
            return;
        }
        ordersManagerBean.addToOrder(item.getId(), order.getId(), 1);
    }
    public List<Item> getItemsInOrder(){
        if (order==null){
            return Collections.emptyList();
        }
        return  ordersManagerBean.getItemsInOrder(order.getId());

    }
}
