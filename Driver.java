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
public class Driver extends User {

    private static int DriverId = 0;
    int numDriver;
    double Offer;
    String drivingLicense, nationalID;
    
    private boolean veryfied = false;
    private boolean Susbend = false;
    private ArrayList<Client> clientsRequsts = new ArrayList<Client>();
    private ArrayList<Integer> rates = new ArrayList<Integer>();
    private ArrayList<String> favArea = new ArrayList<String>();

    public Driver() {
        DriverId++;
        numDriver = DriverId;

    }
    public Driver(String drivingLicense, String nationalID, String userName, int id, String password, String email, String phone) {
        super(userName, id, password, email, phone);
        this.drivingLicense = drivingLicense;
        this.nationalID = nationalID;
    }

    public boolean isSusbend() {
        return Susbend;
    }

    public void setSusbend(boolean Susbend) {
        this.Susbend = Susbend;
    }

    public double getOffer() {
        return Offer;
    }

    public ArrayList<Client> getClientsRequsts() {
        return clientsRequsts;
    }

    public int getNumDriver() {
        return numDriver;
    }

    public static int getDriverId() {
        return DriverId;

    }

    public void addFavArea(String favarea) {
        
        favArea.add(favarea);
    }

    public ArrayList<String> getFavArea() {
        return favArea;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }

    

    public boolean isVeryfied() {
        return veryfied;
    }

    public void setVeryfied(boolean veryfied) {
        this.veryfied = veryfied;
    }

    public void addRate(int rate) {
        rates.add(rate);

    }

    public double avgRate() {
        int i = 0, sum = 0;
        for (i = 0; i < rates.size(); i++) {
            sum += rates.get(i);
        }
        return sum / (double) i;

    }

    public ArrayList<Integer> getRates() {
        return rates;
    }


    public void makeOffer() {
        double price;
        for (int i = 0; i < clientsRequsts.size(); i++) {
            System.out.println("Enter the price for "
                    + "  #Client User Name " + clientsRequsts.get(i).getUserName()
                    + "  #Source :" + clientsRequsts.get(i).ride.getSource()
                    + "  #Destination :" + clientsRequsts.get(i).ride.getDestnation());

            price = input.nextDouble();
            Offer = price;
            clientsRequsts.get(i).ride.setOffers(price, this);

            
        }

    }

    public void update(Client c) {
        clientsRequsts.add(c);

    }
}
