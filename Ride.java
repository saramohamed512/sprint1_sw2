/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectssw;

import java.util.ArrayList;

/**
 *
 * @author Access
 */
public class Ride {

    String Source, Destnation, driverName;
    double Price;
    private ArrayList<Double> Offers = new ArrayList<Double>();
    private ArrayList<Driver> makeOfferDrivers = new ArrayList<Driver>();

    public Ride() {
    }

    public Ride(String Source, String Destnation, double Price) {
        this.Source = Source;
        this.Destnation = Destnation;
        this.Price = Price;
    }

    public ArrayList<Driver> getMakeOfferDrivers() {
        return makeOfferDrivers;
    }

    public String getSource() {
        return Source;
    }

    public String getDestnation() {
        return Destnation;
    }

    public double getPrice() {
        return Price;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public void setDestnation(String Destnation) {
        this.Destnation = Destnation;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setOffers(Double offer, Driver driver) {
        Offers.add(offer);
        makeOfferDrivers.add(driver);

    }

    public ArrayList<Double> getOffers() {
        return Offers;
    }

    public String getDriverName() {
        return driverName;
    }

}
