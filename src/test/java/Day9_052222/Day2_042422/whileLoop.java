package Day9_052222.Day2_042422;

public class whileLoop {
    public static void main(String[] args) {
        //iterate through zipcode and its streetNumber using linear array and while loop
        String[] zipCodes = new  String[]{" 11218", " 11219", " 11232", " 10001"};
int[] houseNumber = new  int[]{111,222,333,444};
//initializing your starting point before calling while loop
        int i = 0;
//define the end point
while (i< houseNumber.length){
    System.out.println("My zip code is " + zipCodes[i] + " House Number " + houseNumber[i]);

//incrementing
    i = i +1;




}//end of while loop



    }//end of main
}//end of java class








































