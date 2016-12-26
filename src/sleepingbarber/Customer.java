package sleepingbarber;

import java.util.Date;

/**
 *
 * @author cem
 */
public class Customer implements Runnable {
    private String name;
    private Date inTime;
    private BarberShop shop;

    public Customer(BarberShop shop) {
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run() {
        goForHairCut();
    }

    private synchronized void goForHairCut() {
        shop.addQueue(this);
    }

}
