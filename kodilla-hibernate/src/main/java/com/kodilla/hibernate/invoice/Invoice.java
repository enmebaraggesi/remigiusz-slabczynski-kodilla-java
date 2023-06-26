package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
@Table(name = "INVOICES")
public class Invoice {

    private int id;
    private String name;
    private List<Item> items = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @OneToMany(
        targetEntity = Item.class,
        mappedBy = "invoice",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }
}
