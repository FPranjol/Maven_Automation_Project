package Day9_052222.Day2_042422;

import java.util.ArrayList;

public class forLoop {
    public static void main(String[] args) {
//create an arraylist for cities and loop/starting through all the values for the loop

        ArrayList<String> Cities = new ArrayList<>();


        Cities.add("Brooklyn");
        Cities.add("Queens");
        Cities.add("Bronx");
        Cities.add("Manhattan");
        Cities.add("Staten Island");

        for (int i = 0; i< Cities.size(); i++){
        System.out.println("i is now " + 1);
        System.out.println("My city is " + Cities.get(i));
    }//end of for loop

}}//end of main
