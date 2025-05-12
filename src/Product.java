public class Product {
    private int id;
    private String name;
    private double price;
    private String note;

    public Product(int id, String name, double price, String note) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.note = note;
    }

    // Геттери та сеттери
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getNote() { return note; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setNote(String note) { this.note = note; }

    @Override
    public String toString() {
        return "ID: " + id + " | Назва: " + name + " | Ціна: " + price + " | Примітка: " + note;
    }
}
