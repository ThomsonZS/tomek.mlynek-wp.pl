
package lab3;

public class Product {
    //zaddanie 3 - zgodnie z instrukcją tworze klasę z polami
    private int id;
    private String name;
    private Double price;
    private String category;

    public Product(int id, String name, Double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
   @Override
    public String toString() {
        return String.valueOf(id) + ", " + name + "," + String.valueOf(price) + ", " +category +"    ";
    }
    
}
