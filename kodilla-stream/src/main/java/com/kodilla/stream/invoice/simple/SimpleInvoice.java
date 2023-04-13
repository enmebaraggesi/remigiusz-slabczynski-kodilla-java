package com.kodilla.stream.invoice.simple;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleInvoice {

    private final List<SimpleItem> items = new ArrayList<>();

    public void addItem(SimpleItem item) {
        items.add(item);
    }

    public boolean removeItem(SimpleItem item) {
        return items.remove(item);
    }

    public double getValueToPay() {
        return items.stream()
            .collect(Collectors.summingDouble(SimpleItem::getValue));
    }
}
