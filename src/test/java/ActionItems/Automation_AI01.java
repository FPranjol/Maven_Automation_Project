package ActionItems;
import java.util.ArrayList;
public class Automation_AI01 {
    public static void main(String[] args) {

        //create linear string array for
        String[] FlightNumber = new String[]{" 123 ", " 456 ", " 789", " 000"};
        String[] GateNumber = new String[]{" 1515", " 2525", " 3535", " 4545"};
        System.out.println("my Flight Number is" + FlightNumber[0] + "at Gate Number" +GateNumber[0]);

        //create string array list
        ArrayList<String> Platform_number = new ArrayList<>();
        Platform_number.add(" Platform 1 ");//index 1
        Platform_number.add(" Platform 2 ");//index 2
        Platform_number.add(" Platform 3 ");//index 3
        Platform_number.add(" Platform 4 ");//index 4
        System.out.println("My first flight is at " + Platform_number.get(0) + "My return flight is at" + Platform_number.get(2) );

        //create an arraylist for Departure dates using for loop
        ArrayList<String> DepartureDate= new ArrayList<>();
        DepartureDate.add(" 1:00 pm ");
        DepartureDate.add(" 2:00 pm ");
        DepartureDate.add(" 3:00 pm ");
        DepartureDate.add(" 4:00 pm ");
        for (int  i = 0; i < DepartureDate.size(); i++) {
            System.out.println("My flight departs at " + DepartureDate.get(i));

            //create an arraylist for departure time using while loop
            String[] Airline = new String[]{"Delta ", "Emirates ", "American Airlines ", "Etihad "};
            int[] platform=new int[]{1,2,3,4};
            //initializing your starting point before calling while loop
            int z = 0;
            //define the end point
            while (z<platform.length) {
        System.out.println(Airline[z] + "is at platform "+ platform[z]);
        //incrementing
        z = z +1;

        //Using string country and int countryCode with for loop and array list
          ArrayList<String> Country=new ArrayList<>();
        int[] countryCode=new int[]{ 61, 880, 1, 45};
                Country.add("Australia");
                Country.add("Bangladesh");
                Country.add("Canada");
                Country.add("Denmark");
        for (int x = 0; x<Country.size(); x++) {
        System.out.println("My Country is " + Country.get(x) +" and my area code is " + countryCode[x]);

//using string region and int area code with while loop and linear array
    String[] region=new  String[]{"Maine ","Delaware ","Montana ","Hawaii "};
    int[] areaCode=new int[]{207,302,406,808};
int y=0;

while (y<areaCode.length) {
    y = y + 1;
    System.out.println("My region is " + region[y] + "and my area code is " + areaCode[y]);
}
}
}
}
}//?
}//end of main
//end of java class

















