import java.util.*;

public class ProductManager {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 1;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Створити продукт");
            System.out.println("2. Показати всі продукти");
            System.out.println("3. Оновити продукт");
            System.out.println("4. Видалити продукт");
            System.out.println("5. Сортувати продукти");
            System.out.println("6. Пошук продуктів");
            System.out.println("0. Вихід");
            System.out.print("Виберіть опцію: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> createProduct();
                case 2 -> readProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> sortProducts();
                case 6 -> searchProducts();
                case 0 -> System.out.println("До побачення!");
                default -> System.out.println("Невірна опція!");
            }
        } while (choice != 0);
    }


    private static void createProduct() {
        System.out.print("Введіть назву: ");
        String name = scanner.nextLine();
        System.out.print("Введіть ціну: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Введіть примітку: ");
        String note = scanner.nextLine();

        Product product = new Product(idCounter++, name, price, note);
        products.add(product);
        System.out.println("Продукт додано.");
    }

    private static void readProducts() {
        if (products.isEmpty()) {
            System.out.println("Список порожній.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private static void updateProduct() {
        System.out.print("Введіть ID продукту для оновлення: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product p : products) {
            if (p.getId() == id) {
                System.out.print("Нова назва (" + p.getName() + "): ");
                p.setName(scanner.nextLine());
                System.out.print("Нова ціна (" + p.getPrice() + "): ");
                p.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.print("Нова примітка (" + p.getNote() + "): ");
                p.setNote(scanner.nextLine());
                System.out.println("Оновлено.");
                return;
            }
        }
        System.out.println("Продукт не знайдено.");
    }

    private static void deleteProduct() {
        System.out.print("Введіть ID продукту для видалення: ");
        int id = Integer.parseInt(scanner.nextLine());
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Продукт видалено.");
                return;
            }
        }
        System.out.println("Продукт не знайдено.");
    }

    private static void sortProducts() {
        System.out.println("\nСортування за критеріями:");
        System.out.println("1. Назва (А-Я)");
        System.out.println("2. Ціна (від меншої до більшої)");
        System.out.print("Виберіть опцію: ");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1 -> {
                products.sort(Comparator.comparing(Product::getName));
                System.out.println("Відсортовано за назвою:");
            }
            case 2 -> {
                products.sort(Comparator.comparingDouble(Product::getPrice));
                System.out.println("Відсортовано за ціною:");
            }
            default -> {
                System.out.println("Невірна опція!");
                return;
            }

        }

        readProducts();

    }

    private static void searchProducts() {
        System.out.println("\nПошук за критеріями:");
        System.out.println("1. За назвою");
        System.out.println("2. За максимальною ціною");
        System.out.print("Виберіть опцію: ");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1 -> {
                System.out.print("Введіть назву або її частину: ");
                String keyword = scanner.nextLine().toLowerCase();
                List<Product> results = products.stream()
                        .filter(p -> p.getName().toLowerCase().contains(keyword))
                        .toList();

                displaySearchResults(results);
            }
            case 2 -> {
                System.out.print("Введіть максимальну ціну: ");
                double maxPrice = Double.parseDouble(scanner.nextLine());
                List<Product> results = products.stream()
                        .filter(p -> p.getPrice() <= maxPrice)
                        .toList();

                displaySearchResults(results);
            }
            default -> System.out.println("Невірна опція.");
        }
    }

    private static void displaySearchResults(List<Product> results) {
        if (results.isEmpty()) {
            System.out.println("Нічого не знайдено.");
        } else {
            System.out.println("Знайдені продукти:");
            results.forEach(System.out::println);
        }
    }

}


