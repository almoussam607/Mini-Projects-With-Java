package vehicle_insurance_calculator;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class InsuranceCalculator {
    /*
   Project: Vehicle Insurance Payment Calculator

   Vehicle types:    car, truck, motorcycle, bus
                          bus: 18-30 seats or 31 and above seats

   Tariff period: June 2024, December 2024
     1st term: June 2024                      2nd term: December 2024
        cars: 2000                                cars: 2500
        truck: 3000                            truck: 3500
    motorcycle: 1500                         motorcycle: 1750
        bus: type1: 4000            bus: type1: 4500,
       type2: 5000               type2: 5500

   In case of incorrect entry, the "Calculation failed" warning should be given to the user and
   the menu should be shown again.

To be able to let user restart, we should present option to restart
    */
    public static void main(String[] args) {


        startCalculation();

    }

    // create our own method for calculation
    public static void startCalculation(){

        Scanner scan = new Scanner(System.in);

        boolean isFailed;

        do{
            isFailed = false;
            System.out.println("Welcome to our Insurance calculation service \nChoose a term for payment calculation");
            System.out.println("1- June 2024");
            System.out.println("2- December 2024");
            int term = scan.nextInt();

            // if the term is entered correctly, we will start the process

            if (term == 1 || term == 2){

                Vehicle vehicleObject = new Vehicle();
                System.out.println("Enter the type of vehicle ");
                System.out.println("Car, Truck, Bus, Motorcycle");
                vehicleObject.type= scan.next().toUpperCase();


                vehicleObject.payment = vehicleObject.countPayment(term);

                // ensure payment is not negative, then print all details

                String termName =  term == 1 ? "1- June 2024" : "2- December 2024";
                String busTypeStr = vehicleObject.busType==1 ? "Type 1 - 18-30 seats" : "Type 2 - 31 and above seats";

                int select;

                if ( vehicleObject.payment>0){
                    System.out.println("---- Insurance Details -----");
                    System.out.println("Vehicle type: " + vehicleObject.type);
                    System.out.println("Term: " +termName);
                    System.out.println("Total insurance: " + vehicleObject.payment);

                    // if user wants to start again
                    System.out.println("To restart, press 1; to exit, press 0");
                    select = scan.nextInt();

                    if (select==1){
                        isFailed = true;
                    }else {
                        isFailed = false;
                    }

                }else {  // if payment is negative, warn the user
                    System.out.println("Incorrect data entry. Calculation failed!!");

                    // if user wants to start again
                    System.out.println("To restart, press 1; to exit, press 0");
                    select = scan.nextInt();

                    if (select==1){
                        isFailed = true;
                    }else {
                        isFailed = false;
                    }

                }



            }else {
                System.out.println("Incorrect term is selected. Calculation failed!!");
                isFailed = true;
            }

        }while (isFailed);





    }
}
