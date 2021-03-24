package hw5_multithreading;

public class Manufacturer implements Runnable{
    private final Shop shop;

    public Manufacturer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {  // the thread is daemon (loop will close by main thread)
            synchronized (shop) {
                if (shop.getProducts() < 10) {
                    shop.setProducts(shop.getProducts()+1);
                    System.out.println("Manufacturer supplies new products, count of products = " + shop.getProducts());
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
