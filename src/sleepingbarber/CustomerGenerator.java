package sleepingbarber;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author cem
 */
public class CustomerGenerator implements Runnable {
    private BarberShop shop;

    public CustomerGenerator(BarberShop shop) {
        this.shop = shop;
    }

    public void run() {
        while (true) {
            Customer customer = new Customer(shop);
            customer.setInTime(new Date());
            Thread thCustomer = new Thread(customer);
            customer.setName("Customer Thread " + thCustomer.getId());
            thCustomer.start();
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
    }
}
