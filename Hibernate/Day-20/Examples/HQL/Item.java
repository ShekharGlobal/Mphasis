
package com.example.hql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Shekhar
 */
@NamedQueries({
    @NamedQuery(
            name = "fetchItems",
            query = "from Item"
    ),
    @NamedQuery(
            name = "fetchItemsById",
            query = "from Item where id=:id"
    )

})
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "item_name")
    String itemName;
    @Column(name = "item_cost")
    double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", itemName=" + itemName + ", price=" + price + '}';
    }

}
