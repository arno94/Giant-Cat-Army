import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static int check_condition(int current, int input, ArrayList list) {
        if (input == 5 || input == 7) {  //if input is +5 (input==1) or +7 (input==2)
            int test_value = current + input;
            if (list.contains(test_value) || test_value > 60) {
                if (list.contains(test_value)) {
                    return -1;  //if a number is reached twice return -1
                } else {
                    return -2; //if a number go though the 60 game limit return -2
                }
            } else {
                return test_value; //other case return the value after add +5 or +7
            }
        } else if (input == 1) { //if input is sqrt (input==3)
            double test_value = Math.sqrt(current);
            if ((test_value == Math.floor(test_value)) && !Double.isInfinite(test_value)) {
                if (list.contains((int)Math.floor(test_value)))
                {
                    return -1;
                }
                else{
                    return (int) Math.floor(test_value); //return the the value in int type after calculate sqrt
                }
            } else {
                return -3; //if a number is not int after calculate the square return -3
            }
        } else {        
            return -4; //incorrect inputs
        }
    }

    public static void main(String[] args) {
        int current_value;
        ArrayList<Integer> usedValues_list = new ArrayList<Integer>(); //store the previously used numbers during a game

        current_value = 0;
        usedValues_list.add(current_value);

        //list of booleans of a previously reached goal numbers (2,10,12)
        boolean[] goal_booleanList = {false, false, false};

        //int[] goal_intList = {2, 10, 12};

        //list of  of a previously reached goal numbers (2,10,12)
        ArrayList<Integer> goal_intList = new ArrayList<Integer>(Arrays.asList(2,10,12));

        //scanner to read input
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
        	int inputNumber = Integer.parseInt(scanner.nextLine());       
        //ArrayList<Integer> testValues_list = new ArrayList<>(Arrays.asList(7,7,7,5,5,5,1,5,5,1,1)); //test object of random input 5=+5, 7=+q, 1=sqrt

       // for (int i : testValues_list) { //run through a test list with finite number of inputs
            int value = check_condition(current_value, inputNumber, usedValues_list); //check if it's prev. used or >60 or non int
            //System.out.println("after check:"+value);
            if (value >= 0) { //if it's correct after checking conditions
                current_value = value;
                usedValues_list.add(current_value);
                if (goal_intList.contains(current_value) == true) {
                    System.out.println("target");
                    int index = goal_intList.indexOf(current_value);
                    switch (index) {
                        case 0:
                            goal_booleanList[index] = true;
                            System.out.println("first reached");
                            break;
                        case 1:
                            if (goal_booleanList[index - 1] == true) {
                                goal_booleanList[index] = true;
                                System.out.println("second reached");
                            }
                            ;
                            break;
                        case 2:
                            System.out.println("third reached");
                            break;
                        default:
                            break;
                    }
                }
                System.out.println("input:"+inputNumber);
                System.out.println("current:"+current_value);
                System.out.println(usedValues_list);
                System.out.println("---");
                } else { //print 'game over'
                    System.out.println("current:"+current_value);
                    switch (value) {
                        case -1:
                            System.out.println("previously used");
                            break;
                        case -2:
                            System.out.println("number >60");
                            break;
                        case -3:
                            System.out.println("non whole after sqrt");
                            break;
                        default:
                            break;
                    }
                    System.out.println("Gave over");
                    return;
                }
            }
    }
}

