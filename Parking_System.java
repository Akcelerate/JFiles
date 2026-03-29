package My_Stuff;

import java.util.Scanner;
//diff between '==' and '.equals()'

public class Parking_System {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int total = 0;
        double fee = 0;
        String ask;

        do {
            System.out.println("Enter Command(park/exit/shutdown)");
            ask = inp.nextLine();
        }while(!ask.equals("park") && !ask.equals("exit") && !ask.equals("shutdown"));

        while (ask.equals("park") || ask.equals("exit")) {
            if (ask.equals("park") && total != 10) {
                ++total;
                if(total < 6 && total > 0){
                    fee = 50;
                }else if(total < 10 && total > 5){
                    fee = 100;
                }else{
                    fee = 200;
                }
                System.out.println("Car added. Parking fee: " + fee + " (Cars Parked: " + total + ")");
            }
            else if(ask.equals("park") && total == 10){
                System.out.println("Garage  Full !");
            }
            else if(ask.equals("exit") && total > 0){
                --total;
                System.out.println("Car removed. (Cars Parked: " + total + ")");
            }
            else if(ask.equals("exit") && total == 0){
                System.out.println("Garage is empty.");
            }
            else{}

            do {
                System.out.println("Enter Command(park/exit/shutdown)");
                ask = inp.nextLine();
            }while(!ask.equals("park") && !ask.equals("exit") && !ask.equals("shutdown"));
        }

        System.out.println("Cars Parked: " + total + " System shutting down.");
    }
}
