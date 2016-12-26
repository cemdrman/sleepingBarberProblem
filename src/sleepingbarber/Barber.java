/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepingbarber;

/**
 *
 * @author cem
 */
public class Barber implements Runnable {

    private BarberShop shop;

    public Barber(BarberShop shop) {
        this.shop = shop;
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        System.out.println("Barber started..");
        while (true) {
            shop.cutHair();
        }
    }
}
