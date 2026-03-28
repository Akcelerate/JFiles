package My_Stuff; //Change this line accordingly, or you can just keep this for your package name as well

import java.util.Scanner;
import java.util.ArrayList;

class Suit{
    private String Designation;
    private String Primary_Weapon;
    private String d;
    public static int total = 0;

    Suit(){
        this.Designation = "";
        this.Primary_Weapon = "";
        this.d = "";
        total += 1;
    }
    Suit(String des, String w, String d){
        this.Designation = des;
        this.Primary_Weapon = w;
        this.d = d;
        total += 1;
    }

    String getdes(){
        return Designation;
    }
    void display(){
        System.out.println("Designation: " + Designation + "\nPrimary Weapon: " + Primary_Weapon + "\nd: " + d);
        System.out.println("-------");
    }
}

class IronManArmour extends Suit{
    private ArrayList<Suit> Armoury;

    IronManArmour(){
        this.Armoury = new ArrayList<>();
    }

    Suit search(String des){
        if(Armoury.size() > 0) {
            for (Suit s : Armoury) {
                if (s.getdes().equals(des)) {
                    return s;
                } else{}
            }
        } else{}
        return null;
    }
    void add(Suit s){
        Armoury.add(s);
        System.out.println("Suit Successfully Added.");
    }
    void remove(String des){
        Suit s = search(des);
        if(s.equals(null)){
            System.out.println("Suit not found.");
        }
        else{
            Armoury.remove(s);
            System.out.println("Suit successfully removed.");
        }
    }
    void displayArmoury(){
        for(Suit s: Armoury){
            s.display();
        }
    }
}

public class IronManSuit{
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        IronManArmour a = new IronManArmour();
        Suit s = new Suit();
        String des;
        String w;
        String d;
        String ask;
        String remdes;

        do{
            System.out.println("Enter Command");
            System.out.println("(create / add / remove / display --all / shutdown)");
            ask = inp.nextLine();
            ask.toLowerCase();
        }while(!ask.equals("create") && !ask.equals("add") && !ask.equals("remove") && !ask.equals("display --all") && !ask.equals("shutdown"));
        main: while(true){
            if(ask.equals("shutdown")){
                System.out.println("Initiating Shutdown...\nShutdown Sequence Initiated...\n3...2...1...");
                System.out.println("-----\nShutdown\n-----");
                break main;
            }
            else if(ask.equals("create")){
                System.out.println("Creating suit framework\nEnter details");
                System.out.print("Designation: "); des = inp.nextLine();
                System.out.print("Primary Weapon: "); w = inp.nextLine();
                System.out.print("d: "); d = inp.nextLine();
                s = new Suit(des, w, d);
            }
            else if(ask.equals("add")){
                a.add(s);
            }
            else if(ask.equals("remove")){
                System.out.print("Desigantion: "); remdes = inp.nextLine();
                a.remove(remdes);
            }
            else if(ask.equals("display --all")){
                a.displayArmoury();
            }
            else{}
            do{
                System.out.println("Enter Command");
                System.out.println("(create / add / remove / display --all / shutdown)");
                ask = inp.nextLine();
                ask.toLowerCase();
            }while(!ask.equals("create") && !ask.equals("add") && !ask.equals("remove") && !ask.equals("display --all") && !ask.equals("shutdown"));

        }
    }
}
