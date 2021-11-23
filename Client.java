/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectssw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Access
 */
public class Client extends User {

  
    private static int ClientId = 0;
    int NumClient;
    Ride ride;
    private boolean Susbend = false;
    private ArrayList<Driver> ObserverDrivers = new ArrayList<Driver>();

    public Client() {
        ClientId++;
        NumClient = ClientId;
//        userName=" ";
//        password=" ";
//         phone=" ";
    }

    public boolean isSusbend() {
        return Susbend;
    }

    public void setSusbend(boolean Susbend) {
        this.Susbend = Susbend;
    }

    public Ride getRide() {
        return ride;
    }

    public ArrayList<Driver> getObserverDrivers() {
        return ObserverDrivers;
    }

    public int getNumClient() {
        return NumClient;
    }

    public static int getClientId() {
        return ClientId;
    }

   

    public void addRate(Driver driver, int rate) {
        driver.addRate(rate);
    }

   

    public void checkAvgRate(Driver driver) {
        System.out.println("Driver " + driver.getUserName() + " rate: " + driver.avgRate());
    }

    public Client request(Ride r, Admin admin) {
        ride = r;
        System.out.println("Enter Your Source and Destination");
        ride.Source = input.next();
        ride.Destnation = input.next();
        SubcribeDriver(admin);
        notifyDrivers();

        return this;
    }

    public void SubcribeDriver(Admin admin) {
        for (int i = 0; i < admin.getDrivers().size(); i++) {
            for (int j = 0; j < admin.getDrivers().get(i).getFavArea().size(); j++) {
                if (admin.getDrivers().get(i).getFavArea().get(j).equalsIgnoreCase(ride.getSource())) {
                    ObserverDrivers.add(admin.getDrivers().get(i));
                }
            }
        }

    }

    public void notifyDrivers() {
        for (int i = 0; i < ObserverDrivers.size(); i++) {
            ObserverDrivers.get(i).update(this);

        }

    }

    public void DisplayRideInfo() {
        System.out.println("Source : " + ride.getSource());
        System.out.println("Destination : " + ride.getDestnation());
        for (int i = 0; i < ride.getMakeOfferDrivers().size(); i++) {

            System.out.println("Driver Name : " + ride.getMakeOfferDrivers().get(i).getUserName() + " , His Offer = " + ride.getOffers().get(i));

        }

    }

}
