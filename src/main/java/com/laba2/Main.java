package com.laba2;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати предмет");
            System.out.println("2. Видалити предмет");
            System.out.println("3. Зареєструвати читача");
            System.out.println("4. Видати предмет читачеві");
            System.out.println("5. Повернути предмет у бібліотеку");
            System.out.println("6. Показати доступні предмети");
            System.out.println("7. Показати список взятих предметів та їхніх читачів");
            System.out.println("0. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                // Користувач може вибрати пункт меню для виконання певної дії.
                // Кожен вибраний пункт виконує відповідний метод класу LibrarySystem.

                case 1:
                    System.out.print("Введіть назву предмету: ");
                    String itemTitle = scanner.nextLine();
                    library.addItem(itemTitle);
                    System.out.println("Предмет додано до бібліотеки.");
                    break;
                case 2:
                    System.out.print("Введіть назву предмету для видалення: ");
                    itemTitle = scanner.nextLine();
                    try {
                        library.removeItem(itemTitle);
                        System.out.println("Предмет видалено з бібліотеки.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Введіть ім'я читача: ");
                    String clientName = scanner.nextLine();
                    library.registerClient(clientName);
                    System.out.println("Читача зареєстровано.");
                    break;
                case 4:
                    System.out.print("Введіть назву предмету, який видається: ");
                    itemTitle = scanner.nextLine();
                    System.out.print("Введіть ім'я читача: ");
                    clientName = scanner.nextLine();
                    try {
                        library.checkOutItem(itemTitle, clientName);
                        System.out.println("Предмет видано читачеві.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Введіть назву предмету, який повертається: ");
                    itemTitle = scanner.nextLine();
                    System.out.print("Введіть ім'я читача: ");
                    clientName = scanner.nextLine();
                    try {
                        library.checkInItem(itemTitle, clientName);
                        System.out.println("Предмет повернуто в бібліотеку.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Доступні предмети:");
                    List<Item> availableItems = library.getAvailableItems();
                    for (Item item : availableItems) {
                        System.out.println(item.getTitle());
                    }
                    break;
                case 7:
                    System.out.println("Список взятих предметів та їхніх читачів:");
                    Map<Client, List<Item>> checkedOutItems = library.getCheckedOutItems();
                    for (Client client : checkedOutItems.keySet()) {
                        System.out.println(client.getName() + " взяв:");
                        List<Item> clientItems = checkedOutItems.get(client);
                        for (Item item : clientItems) {
                            System.out.println("- " + item.getTitle());
                        }
                    }

                    break;
                case 0:
                    System.out.println("Дякую за використання бібліотеки. До побачення!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}

