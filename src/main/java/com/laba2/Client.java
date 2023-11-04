package com.laba2;
import java.util.ArrayList;
import java.util.List;
class Client {
    private String name;
    private List<Item> checkedOutItems;

    public Client(String name) {
        this.name = name;
        this.checkedOutItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getCheckedOutItems() {
        return checkedOutItems;
    }

    public void checkOutItem(Item item) {
        checkedOutItems.add(item);
    }

    public void checkInItem(Item item) {
        checkedOutItems.remove(item);
    }

    @Override
    public String toString() {
        return name;
    }
}
