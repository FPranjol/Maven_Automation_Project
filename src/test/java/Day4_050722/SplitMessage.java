package Day4_050722;

public class SplitMessage{
    public static void main(String[] args) {
        //declare string variable
        String splitmessage = "my name is John";
        //declare an array of string to store the string split
        String[] splitmessageArray = splitmessage.split(" ");

        //print out john to the console
        System.out.println("my first name is " + splitmessageArray[3]);
    }
}
