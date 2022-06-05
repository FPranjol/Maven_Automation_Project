package ActionItems;

import java.util.ArrayList;

public class Automation_A102part2 {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");
        for (int i = 0; i < cities.size(); i++) {
            //with if conditions

        if (cities.get(i) == "Brooklyn") {
                System.out.println("My City is " + cities.get(i));

            }
            if (cities.get(i) == "Manhattan") {
                System.out.println("My City is " + cities.get(i));


        }}
    }
}