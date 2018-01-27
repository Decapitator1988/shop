package com.decapitator.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "item")
    private List<ItemInOrder> itemInOrders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<ItemInOrder> getItemInOrders() {
        return itemInOrders;
    }

    public void setItemInOrders(List<ItemInOrder> itemInOrders) {
        this.itemInOrders = itemInOrders;
    }
}
