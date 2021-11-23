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
public class Admin extends User {

    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Driver> drivers = new ArrayList<Driver>();
    private ArrayList<Driver> pending_drivers = new ArrayList<Driver>();
    private ArrayList<User> users = new ArrayList<User>();
     boolean suspended = true;

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void pendingDrivers(Driver driver) {
        pending_drivers.add(driver);
    }

    public ArrayList<Driver> getPending_drivers() {
        return pending_drivers;
    }

    public void displayUsers() {

        for (int i = 0; i < users.size(); i++) {
            System.out.println("user " + (i + 1) + " information ");
            users.get(i).display();
        }

    }
   

    public void SuspendDriver(Driver driver, Boolean b) {
        driver.setSusbend(b);
    }

    public Boolean login(Admin admin) {
        System.out.println("Please enter your username and password");
        String Username = input.next();
        String Password = input.next();
        boolean check = false;
        if (this.getPassword().equals(Password) && this.getUserName().equals(Username)) {
            check = true;

        } else {
            check = false;
        }

        if (check == false) {
            System.out.println("your username or password is wrong ");

        }
        return check;
    }

}
