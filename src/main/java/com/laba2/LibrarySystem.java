package com.laba2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {
    private Map<String, Item> libraryItems;
    private Map<String, Client> clients;

    public LibrarySystem() {
        libraryItems = new HashMap<>();
        clients = new HashMap<>();
    }

    // Додавання предмета (книги, DVD) до бібліотеки.
    public void addItem(String title) {
        Item item = new Item(title);
        libraryItems.put(title, item);
    }

    // Видалення предмета з бібліотеки.
    public void removeItem(String title) {
        if (libraryItems.containsKey(title)) {
            libraryItems.remove(title);
        } else {
            throw new IllegalArgumentException("Предмет з назвою '" + title + "' не існує.");
        }
    }

    // Реєстрація нового читача.
    public void registerClient(String name) {
        Client client = new Client(name);
        clients.put(name, client);
    }

    // Видача предмета читачеві.
    public void checkOutItem(String itemName, String clientName) {
        Item item = libraryItems.get(itemName);
        Client client = clients.get(clientName);

        if (item != null && client != null && !item.isCheckedOut()) {
            item.checkOut();
            client.checkOutItem(item);
        } else {
            throw new IllegalArgumentException("Помилка видачі предмета читачеві.");
        }
    }

    // Повернення предмета в бібліотеку.
    public void checkInItem(String itemName, String clientName) {
        Item item = libraryItems.get(itemName);
        Client client = clients.get(clientName);

        if (item != null && client != null) {
            item.checkIn();
            client.checkInItem(item);
        } else {
            throw new IllegalArgumentException("Помилка повернення предмета в бібліотеку.");
        }
    }

    // Отримання списку доступних предметів.
    public List<Item> getAvailableItems() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : libraryItems.values()) {
            if (!item.isCheckedOut()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    // Отримання списку взятих предметів та їхніх читачів.
    public Map<Client, List<Item>> getCheckedOutItems() {
        Map<Client, List<Item>> checkedOutItems = new HashMap<>();
        for (Client client : clients.values()) {
            checkedOutItems.put(client, client.getCheckedOutItems());
        }
        return checkedOutItems;
    }
}
