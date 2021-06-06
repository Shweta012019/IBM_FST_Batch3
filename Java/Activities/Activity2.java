package Activities;

import java.util.*;

public class Activity2 {

	public static void main(String[] args) {
        //Initialize the array
        int[] numberArray = {10, 77, 10, 54, -11, 10};      
        //Set constants
        int searchNumber = 10;
        int requiredtotal = 30;

        //Print result
        System.out.println("Result: " + result(numberArray, searchNumber, requiredtotal));
    }

    public static boolean result(int[] numarray, int searchValue, int Sum) {
        int temp_sum = 0;
        //Loop through array
        for (int number : numarray) {
            //If value is 10
            if (number == searchValue) {
                //Add them
                temp_sum += number;
            }

            //Sum should not be more than 30
            if (temp_sum > Sum) {
                break;
            }
        }
          if(temp_sum==Sum) 
               return true;
           else
               return false;
          }
    }
