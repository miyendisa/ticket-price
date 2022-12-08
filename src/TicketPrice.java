import java.util.Scanner;

public class TicketPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type;
        int distance, age;
        boolean isTypeDiscount = false;
        double normalPrice, ageDiscount, bothDiscountedPrice, discountedPrice;
        double pricePerKm = 0.10;
        double childDiscountRate = 0.5;
        double youthDiscountRate = 0.1;
        double elderDiscountRate = 0.3;
        double returnTypeDiscount = 0.2;

        System.out.print("Select the ticket type.\nWrite \"Return\" or \"One Way\" : ");
        type = scanner.nextLine();

        System.out.print("Enter the distance in km : ");
        distance = scanner.nextInt();

        System.out.print("Enter your age : ");
        age = scanner.nextInt();

        normalPrice = distance * pricePerKm;

        if (((type.equals("One Way")) || (type.equals("Return"))) && (age > 0) && (distance > 0)) {

            if (age < 12) {
                ageDiscount = normalPrice * childDiscountRate;
                if (type.equals("Return")) {
                    isTypeDiscount = true;
                }
            } else if (age <= 24) {
                ageDiscount = normalPrice * youthDiscountRate;
                if (type.equals("Return")) {
                    isTypeDiscount = true;
                }
            } else if (age > 65) {
                ageDiscount = normalPrice * elderDiscountRate;
                if (type.equals("Return")) {
                    isTypeDiscount = true;
                }
            } else {
                ageDiscount = 0;
                if (type.equals("Return")) {
                    isTypeDiscount = true;
                }
            }

            discountedPrice = normalPrice - ageDiscount;
            bothDiscountedPrice = 2 * (discountedPrice - (discountedPrice * returnTypeDiscount));

            if ((age < 25) || (age > 65)) {
                if (isTypeDiscount) {
                    System.out.println("The age-based discount and ticket type discount are available.");
                    System.out.println("Total price of your ticket: " + bothDiscountedPrice + " $");
                } else {
                    System.out.println("The age-based discount is available." + " $");
                    System.out.println("Total price of your ticket: " + discountedPrice + " $");
                }
            } else {
                if (isTypeDiscount) {
                    System.out.println("Ticket type discount is available");
                    System.out.println("Total price of your ticket: " + bothDiscountedPrice + " $");
                } else {
                    System.out.println("No Discount.");
                    System.out.println("Total price of your ticket: " + normalPrice + " $");
                }
            }
        } else {
            System.out.print("You entered wrong data!");
        }
    }
}