/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectssw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Access
 */
public class Projectssw {

    static Admin admin = new Admin();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("1-register ");
            System.out.println("2-login");
            System.out.println("3-exit");
            int outerchoice = input.nextInt();
            if (outerchoice == 1) {
                User user = createUser();

                if (user instanceof Client) {
                    admin.addClient((Client) user);
                    admin.addUser(user);

                } else if (user instanceof Driver) {

                    admin.pendingDrivers((Driver) user);
//                    for(int i = 0; i < admin.getPending_drivers().size(); i++){
//                        System.out.println(admin.getPending_drivers().get(i).getUserName());
//                    
//                    }

                } else if (user instanceof Admin) {
                    continue;
                }

            } else if (outerchoice == 2) {
                System.out.println("login as :  ");
                System.out.println("1.Client");
                System.out.println("2.Driver");
                System.out.println("3.Admin");

                int choice = input.nextInt();
                if (choice == 1) {
                    System.out.println("Please enter your user name and password ");
                    String Username = input.next();
                    String Password = input.next();

                    int id = 0;
                    boolean check = false;
                    for (int i = 0; i < admin.getClients().size(); i++) {
                        if (admin.getClients().get(i).getPassword().equals(Password) && admin.getClients().get(i).getUserName().equals(Username)) {
                            id = admin.getClients().get(i).getNumClient();

                            check = true;
                            if (admin.getClients().get(i).isSusbend()) {
                                check = false;
                            }

                        }
//                        else {
//                            check = false;
//                        }
                    }
                    if (check == false) {
                        System.out.println("your user name or password is wrong or you are susbended now");
                        continue;
                    }
                    while (true) {
                        System.out.println("1.ADD RATE For Driver");
                        System.out.println("2.Request Ride");
                        System.out.println("3.Display All Offers");
                        System.out.println("4.Back to main manu");
                        choice = input.nextInt();
                        if (choice == 1) {
                            System.out.println("Plz enter the drive name and its rate");
                            String dName = input.next();
                            int rate = input.nextInt();
                            int indexDriver = 0;
                            for (int i = 0; i < admin.getDrivers().size(); i++) {
                                if (admin.getDrivers().get(i).getUserName().equals(dName)) {
                                    admin.getClients().get(id - 1).addRate(admin.getDrivers().get(i), rate);
                                    indexDriver = i;
                                    break;

                                }

                            }
                            admin.getClients().get(id - 1).checkAvgRate(admin.getDrivers().get(indexDriver));

                        } else if (choice == 2) {
                            Ride ride = new Ride();
                            admin.getClients().get(id - 1).request(ride, admin);

                        } else if (choice == 3) {
                            admin.getClients().get(id - 1).DisplayRideInfo();

                        } else if (choice == 4) {
                            break;
                        }
                    }
                } else if (choice == 2) {

                    System.out.println("Please enter your user name and password");
                    String Username = input.next();
                    String Password = input.next();
                    boolean check = false;
                    int id = 0;

                    for (int i = 0; i < admin.getDrivers().size(); i++) {

                        if (admin.getDrivers().get(i).getPassword().equals(Password) && admin.getDrivers().get(i).getUserName().equals(Username)) {
                            check = true;

                            id = admin.getDrivers().get(i).getNumDriver();

                            if (admin.getDrivers().get(i).isSusbend()) {
                                check = false;

                            }

                        }

                    }

                    if (check == false) {
                        System.out.println("your user name or password is wrong or you are suspended or Admin Did not verify you yet! ");
                        continue;

                    }

//                   
                    if (admin.getDrivers().get(id - 1).isVeryfied()) {
                        while (true) {
                            System.out.println("1.Add Favourite Area");
                            System.out.println("2.List Your Favourite Areas");
                            System.out.println("3.List Requstes From fav Area And Set Thier Offers");
                            System.out.println("4.List Users Rates");
                            System.out.println("5.Back to main manu");
                            choice = input.nextInt();
                            if (choice == 1) {  // System.out.println("Plz enter your favourite area");
                                String fav;
                                String choicen;
                                System.out.println("Plz enter your favourite area");
                                fav = input.next();
                                admin.getDrivers().get(id - 1).addFavArea(fav);

                                for (int i = 0; i < 5; i++) {

                                    System.out.println("do you want add more? y/n");
                                    choicen = input.next();
                                    if (choicen.equalsIgnoreCase("y")) {
                                        fav = input.next();
                                        admin.getDrivers().get(id - 1).addFavArea(fav);
                                    } else if ((choicen.equalsIgnoreCase("N"))) {

                                        break;

                                    }

                                }

                            } else if (choice == 2) {
                                System.out.println("Your Favourite Areas : " + admin.getDrivers().get(id - 1).getFavArea());

                            } else if (choice == 3) {

                                admin.getDrivers().get(id - 1).makeOffer();

                            } else if (choice == 4) {
                                System.out.println("Your Rates : " + admin.getDrivers().get(id - 1).getRates());

                            } else if (choice == 5) {
                                break;

                            }

                        }
                    }

                } else if (choice == 3) {
                    if (admin.login(admin)) {
                        while (true) {
                            System.out.println("1.display pending drivers ");
                            System.out.println("2.verify drivers ");

                            System.out.println("3.display drivers ");
                            System.out.println("4.Susbend Driver");
                            System.out.println("5.Susbend Client");
                            System.out.println("6.Back to main manu ");
                            //System.out.println("6.Susbend Driver ");

                            choice = input.nextInt();
                            if (choice == 1) {
                                for (int i = 0; i < admin.getPending_drivers().size(); i++) {
                                    System.out.println(admin.getPending_drivers().get(i).getUserName());

                                }
                            } else if (choice == 2) {
                                String verify;
                                System.out.println("if you want to verify (Y) or (N) if did not want to verify ");
                                for (int i = 0; i < admin.getPending_drivers().size(); i++) {
                                    System.out.print("Do you want to verify " + admin.getPending_drivers().get(i).getUserName() + " / " + admin.getPending_drivers().get(i).getDrivingLicense() + " : ");
                                    verify = input.next();
                                    if (verify.equalsIgnoreCase("Y")) {
                                        admin.getPending_drivers().get(i).setVeryfied(true);
                                        admin.addDriver(admin.getPending_drivers().get(i));
                                        admin.addUser(admin.getPending_drivers().get(i));
                                        admin.getPending_drivers().remove(i);
                                        i--;

                                    } else if (verify.equalsIgnoreCase("N")) {
                                        admin.getPending_drivers().get(i).setVeryfied(false);

                                    } else {
                                        System.out.println("plz enter y or n only");
                                        continue;
                                    }
                                }

                            } else if (choice == 3) {
                                for (int i = 0; i < admin.getDrivers().size(); i++) {
                                    System.out.println(admin.getDrivers().get(i).getUserName());
                                }
                            } else if (choice == 4) {
                                String Suspend;
                                System.out.println("if you want to Suspend (Y) or (N) if did not want to Suspend ");
                                for (int i = 0; i < admin.getDrivers().size(); i++) {
                                    System.out.print("Do you want to Suspend " + admin.getDrivers().get(i).getUserName() + " / " + admin.getDrivers().get(i).getNumDriver() + " : ");
                                    Suspend = input.next();
                                    if (Suspend.equalsIgnoreCase("Y")) {
                                        admin.getDrivers().get(i).setSusbend(true);

                                    } else if (Suspend.equalsIgnoreCase("N")) {
                                        admin.getDrivers().get(i).setSusbend(false);
                                        //System.out.println(admin.getPending_drivers().get(i).isVeryfied()+" this Driver not veryfied"); 

                                    } else {
                                        System.out.println("plz enter y or n only");
                                        continue;
                                    }
                                }

                            } else if (choice == 5) {
                                String Suspend;
                                System.out.println("if you want to Suspend (Y) or (N) if did not want to Suspend ");
                                for (int i = 0; i < admin.getClients().size(); i++) {
                                    System.out.print("Do you want to Suspend " + i + 1 + "." + admin.getClients().get(i).getUserName() + " / " + admin.getClients().get(i).getNumClient() + " : ");
                                    Suspend = input.next();
                                    if (Suspend.equalsIgnoreCase("Y")) {
                                        admin.getClients().get(i).setSusbend(true);
                                        System.out.println("Susbend= " + admin.getClients().get(i).isSusbend());

                                    } else if (Suspend.equalsIgnoreCase("N")) {
                                        admin.getClients().get(i).setSusbend(false);
                                        //System.out.println(admin.getPending_drivers().get(i).isVeryfied()+" this Driver not veryfied"); 

                                    } else {
                                        System.out.println("plz enter y or n only");
                                        continue;
                                    }
                                }

                            } else if (choice == 6) {
                                break;
                            }
                        }
                    } else {
                        continue;
                    }
                }

            } else if (outerchoice == 3) {
                break;
            }
        }

    }

    static public User createUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("register as :  ");
        System.out.println("1.Client");
        System.out.println("2.Driver");
        System.out.println("3.Admin");

        int choice = input.nextInt();
        if (choice == 1) {
            Client client = new Client();
            System.out.println("please enter Name: ");
            client.userName = input.next();
            System.out.println("please enter password : ");
            client.password = input.next();
         System.out.println("please enter email : ");
         client.email=input.nextLine();
         System.out.println("please enter phone : ");
        client.phone=input.nextLine();

//             
            return client;

        } else if (choice == 2) {

            Driver driver = new Driver();
            System.out.println("please enter Name: ");

            driver.userName = input.next();
            System.out.println("please enter password : ");
            driver.password = input.next();
         System.out.println("please enter email : ");
        driver. email=input.nextLine();
         System.out.println("please enter phone : ");
        driver. phone=input.nextLine();
         System.out.println("please enter your driving license: ");
        driver. drivingLicense=input.nextLine();
         System.out.println("please enter your nationalID: ");
        driver. nationalID=input.nextLine();

            return driver;


              
        } else if (choice == 3) {

            System.out.println("please enter Name: ");

            admin.userName = input.next();
            System.out.println("please enter password : ");
            admin.password = input.next();
            return admin;
//                       
        }
        return null;

    }
}
