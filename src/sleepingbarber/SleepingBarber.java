package sleepingbarber;

/**
 *
 * @author cem
 */
public class SleepingBarber {

    public static void main(String[] args) {
        BarberShop shop = new BarberShop(); 
        Barber barber = new Barber(shop);
        CustomerGenerator customerGenerator = new CustomerGenerator(shop); 
        
        Thread thBarber = new Thread(barber);
        Thread thCustomer = new Thread(customerGenerator);
        
        thCustomer.start();
        thBarber.start();
    }    
}
