package vehicle_insurance_calculator;

import java.util.Scanner;

public class Vehicle {

       /*
    Project: Vehicle Insurance Payment Calculator
Vehicle types:   car, truck, motorcycle, bus
                          bus: 18-30 seats or 31 and above seats
Tariff period: June 2024, December 2024
     1st term: June 2024                     2nd term: December 2024
        cars: 2000                            cars: 2500
        truck: 3000                           truck: 3500
   motorcycle: 1500                        motorcycle: 1750
        bus: type1: 4000  bus: type1: 4500,
  type2: 5000  type2: 5500
In case of incorrect entry, the "Calculation failed" warning should be given to the user and the menu should be shown again.
To be able to let user restart, we should present option to restart
*/

        public String type;
        public int payment;
        int busType;

        public int countPayment(int term) {

            if (term == 1) {
                switch (type) {
                    case "CAR":
                        payment = 2000;
                        break;
                    case "TRUCK":
                        payment = 3000;
                        break;
                    case "MOTORCYCLE":
                        payment = 1500;
                        break;
                    case "BUS":
                        calculateBusPayment(term);  // method call  => create a separate method to calculate bus insurance based on type 1 or type 2
                        break;
                    default:
                        System.out.println("Incorrect data");
                        payment = 0;
                        break;

                }

            } else if (term == 2) {

                switch (type) {
                    case "CAR":
                        payment = 2500;
                        break;
                    case "TRUCK":
                        payment = 3500;
                        break;
                    case "MOTORCYCLE":
                        payment = 1750;
                        break;
                    case "BUS":
                        calculateBusPayment(term);  // method call  => create a separate method to calculate bus insurance based on type 1 or type 2
                        break;
                    default:
                        System.out.println("Incorrect data");
                        payment = 0;
                        break;

                }

            } else {
                System.out.println("Incorrect data");
                payment = 0;
            }

            return payment;
        }


        public int calculateBusPayment(int term) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose the type of the bus");
            System.out.println("Type 1 - 18-30 seats \nType 2 - 31 and above seats");

            busType = scan.nextInt();

            switch (busType) {
                case 1:  // bus type 1
                    if (term == 1) {
                        payment = 4000;
                    } else {
                        payment = 4500;
                    }
                    System.out.println("Bus Type 1 - 18-30 seats");
                    break;

                case 2: // bus type 2
                    if (term == 1) {
                        payment = 5000;
                    } else {
                        payment = 5500;
                    }
                    System.out.println("Bus Type 2 - 31 and above seats");
                    break;

            }
            return payment;

        }

    /*
    HW:
    Refine and improve your project by: (adding any ONE of the following)
      1. adding discounts e.g. 10% less if you pay by this ....  date OR 25% less if you insure your car with us for 2 terms etc.
      2. we can add different calculations for cars (hybrid, electric, diesel etc.), for trucks (tow truck, trailer, flatbed truck  etc.) for motorcycles(heavy bike, mountain bike, hybrid bike etc.)
      3. discounts for registering more than one vehicles with us

     */
    }