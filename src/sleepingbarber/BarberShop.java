package sleepingbarber;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author cem
 */
public class BarberShop {
    private int chair;
    private List<Customer> listCustomer;
    
    public BarberShop() {
        chair = 3;
        listCustomer = new LinkedList<Customer>();
    }

    public void cutHair() {
        Customer customer;
        long duration = 0;
        System.out.println("Barber waiting for lock.");
        synchronized (listCustomer) {
            while (listCustomer.size() == 0) {
                System.out.println("Barber is waiting for customer.");
                try {
                    listCustomer.wait();
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
            System.out.println("Barber found a customer in the queue.");
            customer = (Customer) ((LinkedList<Customer>) listCustomer).poll();
        }        
        try {
            
            System.out.println("Cuting hair of Customer : " + customer.getName());
            duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        System.out.println("Completed Cuting hair of Customer : " + customer.getName() + " in " + duration + " seconds.");
        System.out.println("----------------------------------------------------------------------------------------------");
    }
    
    public void addQueue(Customer customer){
        listCustomer.add(customer);
    }   
}
