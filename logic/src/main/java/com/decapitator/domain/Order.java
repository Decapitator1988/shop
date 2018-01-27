package com.decapitator.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zakaz")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "order")
    private List<ItemInOrder> itemInOrders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ItemInOrder> getItemInOrders() {
        return itemInOrders;
    }

    public void setItemInOrders(List<ItemInOrder> itemInOrders) {
        this.itemInOrders = itemInOrders;
    }
}
