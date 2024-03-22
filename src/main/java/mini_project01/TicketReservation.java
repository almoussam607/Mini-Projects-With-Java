package mini_project01;

import java.util.Scanner;

public class TicketReservation {

    /*
    Project: app that calculates bus ticket price based on distance and conditions

Distance from User (KM), age and trip type (One-Way OR  Round-trip (Going&Returning )
Get seat number information.
All buses should have a seat number in total "32".

Take the payment as 1 USD / km for distance. (*2 for Round-trip trip)
First, calculate the total price of the trip and then apply the following rules to the customer according to the conditions;

Conditions:

Values received from the user must be valid (distance and age are positive numbers, trip type is 1 or 2).
Otherwise, "You Have Entered Wrong Data!" or Any warning should be given.

Discounts:

1- If the person has chosen the "Journey Type" Round-trip trip, 20% discount is applied on the ticket price.

2- Single Seat Fee:
If the seat number is 3 or a multiple of 3, the ticket price is increased by 20%.

3- Age discount:
If the person is younger than 12 years old, 50% discount is applied on the ticket price.
If the person is between the ages of 12-24, a 10% discount is applied on the ticket price.
If the person is over 65 years old, a 30% discount is applied on the ticket price.

     */

    public static void main(String[] args) {

        Bus bus = new Bus("Baker Street, 74");
//        System.out.println("bus.seats = " + bus.seats);
          Ticket ticket = new Ticket();

           start(bus, ticket);


    }

    // To get the input from the user

    public static void start(Bus bus, Ticket ticket) {
        Scanner scan = new Scanner(System.in);

        int select;

        do {
            System.out.println("*** Welcome to our Ticket Reservation System ***");
            System.out.println("Enter the distance in KM");
            double distance = scan.nextDouble();

            System.out.println("Enter the journey type");
            System.out.println("1- One way \n2- Round Trip");
            int type = scan.nextInt();

            System.out.println("Enter your age");
            int age = scan.nextInt();

            System.out.println("Choose the seat number");
            System.out.println("Single seats is 20% more expensive");
            System.out.println("Available seats: " + bus.seats);  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32]
            int seat = scan.nextInt();
            // removes the seat that choose for next opitions
            bus.seats.remove(String.valueOf(seat));


            // Conditions
            boolean check = type == 1 || type ==2;

            if (distance>0 && age>0 && check){

                ticket.distance = distance;
                ticket.journeyType = type;
                ticket.seatNo = seat;
                ticket.price = calculatePrice(ticket, age);  // method call to calculate the price
                ticket.printTicket(bus);

            }else {
                System.out.println("You Have Entered Wrong Data!");
            }
            // To give a second chance to the user in case of any invalid value
            System.out.println("Press any number to Restart or 0 to quit");
            select = scan.nextInt();


        } while (select !=0);


    }


    // Create a method to calculate the price

    public static double calculatePrice(Ticket ticket, int age) {
        double dis = ticket.distance;
        int type = ticket.journeyType;
        int seat = ticket.seatNo;

        // journeyType (Single or Round Trip) and seat (Single or not) condition

        double totalPrice = 0;

        switch (type) {
            case 1:  // One way
                if (seat % 3 == 0) { // single seat
                    totalPrice = dis * 1.2;
                    System.out.println("Total price for Single seat:" + totalPrice);
                } else {
                    totalPrice = dis * 1;
                    System.out.println("Total price for Regular seat:" + totalPrice);
                }
                break;
            case 2:  // Round Trip
                if (seat % 3 == 0) {
                    totalPrice = dis * 2.4;
                    System.out.println("Total price for Single seat on a Round Trip:" + totalPrice);
                } else {
                    totalPrice = dis * 2;
                    System.out.println("Total price for Regular seat on a Round Trip:" + totalPrice);
                }

                totalPrice = totalPrice * 0.8;
                System.out.println("Total price after Round-Trip discount:" + totalPrice);
                break;
        }
        // age discount

        if (age < 12) {
            totalPrice = totalPrice * 0.5; // 50% discount for children
            System.out.println("Total price after child discount: " + totalPrice);
        } else if (age < 25) {
            totalPrice = totalPrice * 0.9; // 10% discount for student
            System.out.println("Total price after student discount: " + totalPrice);
        } else if (age > 65 && age < 150) {
            totalPrice = totalPrice * 0.7; // 30% discount for senior citizens
            System.out.println("Total price after seniors discount: " + totalPrice);
        }

        return totalPrice;
    }



}

