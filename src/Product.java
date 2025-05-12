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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Назва: %s | Ціна: %.2f | Примітка: %s", id, name, price, note);
    }
}
