package hw5_multithreading;

public class Customer implements Runnable{
    private final Shop shop;

    public Customer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {  // the thread is daemon (loop will close by main thread)
            synchronized (shop) {
                if (shop.getProducts() == 10) {
                    shop.setProducts(0);
                    System.out.println("Customer consumes all products, count of products = " + shop.getProducts());
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
