package main;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import helper.StringHelper;
import screens.MainMenu;
import screens.MyScreen;
import screens.Screen;

public class Main{

	private static MyScreen screen;		
	
	private static int current_value;
	
	private static ArrayList<Integer> usedValues_list;
	
	private static boolean[] goal_booleanList = {false, false, false};
	
	private static ArrayList<Integer> goal_intList;
	
	public static void restart() {
		goal_booleanList = new boolean[] { false, false, false};
		usedValues_list = new ArrayList<>();
		usedValues_list.add(0);
		current_value = 0;					
		goal_intList = new ArrayList<Integer>(Arrays.asList(2,10,14));
	}
	
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
    
    public static void check(int number) {
    	int inputNumber = number;
    	screen.setCurrentValueColor(Color.WHITE);
        //ArrayList<Integer> testValues_list = new ArrayList<>(Arrays.asList(7,7,7,5,5,5,1,5,5,1,1)); //test object of random input 5=+5, 7=+q, 1=sqrt

       // for (int i : testValues_list) { //run through a test list with finite number of inputs
            int value = check_condition(current_value, inputNumber, usedValues_list); //check if it's prev. used or >60 or non int
            //System.out.println("after check:"+value);
            if (value >= 0) { //if it's correct after checking conditions
                current_value = value;
                usedValues_list.add(current_value);
                screen.setUsedValues(usedValues_list);
                if (goal_intList.contains(current_value) == true) {
                    System.out.println("target");
                    int index = goal_intList.indexOf(current_value);
                    screen.setCurrentValueColor(Color.GREEN);
                    switch (index) {
                        case 0:                        
                            goal_booleanList[index] = true;
                            screen.goalReached(1);
                            System.out.println("first reached");
                            break;
                        case 1:
                            if (goal_booleanList[index - 1] == true) {
                                goal_booleanList[index] = true;
                                screen.goalReached(2);
                                System.out.println("second reached");
                            }
                            ;
                            break;
                        case 2:
                        	if(goal_booleanList[index - 1] == true && goal_booleanList[index -2] == true) {
                        		goal_booleanList[index] = true;
                        		screen.setEndQuote(Color.GREEN, StringHelper.win);
                        	}
                        	screen.goalReached(3);
                            System.out.println("third reached");
                            break;
                    }
                }
                System.out.println("input:"+inputNumber);
                screen.setCurrentValue(current_value);                
                System.out.println("current:"+current_value);
                System.out.println(usedValues_list);
                System.out.println("---");
                } else { //print 'game over'
                    System.out.println("current:"+current_value);
                    screen.setCurrentValueColor(Color.RED);
                    switch (value) {
                        case -1:                        	
                            System.out.println("previously used");
                            screen.setEndQuote(Color.RED, StringHelper.lose_repeating_number);
                            break;
                        case -2:
                            System.out.println("number >60");
                            screen.setEndQuote(Color.RED, StringHelper.lose_bigger_than_60);
                            break;
                        case -3:
                            System.out.println("non whole after sqrt");
                            screen.setEndQuote(Color.RED, StringHelper.lose_non_whole_number);
                            break;
                        default:
                            break;
                    }
                    System.out.println("Gave over");
                    // exit on game over --temp
                   // System.exit(0);
                    return;
                }
    }
    
    public static void main(String[] args) {
    	
    	//screen = new MyScreen();
    	MainMenu menu = new MainMenu();
    	        
        usedValues_list = new ArrayList<Integer>(); //store the previously used numbers during a game

        current_value = 0;
        usedValues_list.add(current_value);

        //int[] goal_intList = {2, 10, 12};

        //list of  of a previously reached goal numbers (2,10,14)
        goal_intList = new ArrayList<Integer>(Arrays.asList(2,10,14));
        
    }
    
    public static void createScreen() {
    	screen = new MyScreen();
    }
	
}

