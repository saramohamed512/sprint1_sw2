/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectssw;

import java.util.Scanner;

/**
 *
 * @author Access
 */
public class User {

    protected String userName;

    protected String password, email, phone;
    Scanner input = new Scanner(System.in);

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


    public User() {
    }

    public User(String userName, int id, String password, String email, String phone) {
        this.userName = userName;

        this.password = password;
        this.email = email;
        this.phone = phone;
    }
   

    public void display() {
        System.out.println("Name: " + userName);

        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);

    }

}
