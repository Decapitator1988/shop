package com.decapitator.ejb;

import com.decapitator.domain.Item;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ItemManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Item createItem(String name, int quantity){
        Item item = new Item();
        item.setName(name);
        item.setQuantity(quantity);
        entityManager.persist(item);

        return item;
    }
    public List<Item> getItems(){
        TypedQuery<Item> typedQuery = entityManager.createQuery("select c from Item c", Item.class);
         return  typedQuery.getResultList();
    }
}
