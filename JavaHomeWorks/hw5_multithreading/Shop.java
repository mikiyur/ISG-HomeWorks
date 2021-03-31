package hw5_multithreading;

public class Shop {

    private int products;


    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread customer = new Thread(new Customer(shop));
        Thread manufacturer = new Thread(new Manufacturer(shop));
        manufacturer.setDaemon(true);
        customer.setDaemon(true);
        manufacturer.start();
        customer.start();


        //the program will run for 10 seconds;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }
}
