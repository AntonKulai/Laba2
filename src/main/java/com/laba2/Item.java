package com.laba2;

class Item {
    private String title;
    private boolean checkedOut;

    public Item(String title) {
        this.title = title;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void checkIn() {
        checkedOut = false;
    }

    @Override
    public String toString() {
        return title;
    }
}
