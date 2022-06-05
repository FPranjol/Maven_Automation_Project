package ActionItems;

import java.util.ArrayList;

public class RedoAutomation_A101 {
    public static void main(String[] args) {
//Using string country and int countryCode with for loop and array list
        ArrayList<String> Country=new ArrayList<>();

 ArrayList<Integer> countryCode=new ArrayList<>();
        Country.add("Australia");
        Country.add("Bangladesh");
        Country.add("Canada");
        Country.add("Denmark");

        countryCode.add(61);
        countryCode.add(880);
        countryCode.add(1);
        countryCode.add(45);

        for (int i=0; i<Country.size();i++) {
System.out.println("My Country is "+Country.get(i)+" and my country code is "+ countryCode.get(i));

//using string region and int area code with while loop and linear array

            String[] Region=new String[]{"Maine", "Delaware", "Montana", "Hawaii"};
int[] areaCode=new int[]{207,302,406,808};
int x=0;
while (x<Region.length) {
System.out.println(" My region is "  + Region[x] + " and my area code is "  + areaCode[x]);
x++;

//when I use different variables the while loop repeats between each for loop response

}

        }

    }//end of main

}//end of java class
