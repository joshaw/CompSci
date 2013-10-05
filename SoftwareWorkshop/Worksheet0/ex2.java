/* Date        : 2013-10-04
 * Name        : Josh Wainwright
 * UID         : 1079596
 * Worksheet   : 0
 * Title       : Exercise 2
 * Description : Convert various imperial units into kilograms with variables
 *             : used to select the unit and the number*/

import java.util.Scanner;
public class ex2 {
	public static void main(String[] args) {

		double       ton = 2240; 		//1
		double hunWeight = 112;			//2
		double   quarter = 28;			//3
		double     stone = 14;			//4
		double     ounce = 1.0/16;		//5
		double    drachm = 1.0/256;		//6
		double     grain = 1.0/7000;	//7
		double     pound = 1.0/0.45359237;

		double kg = 0.45359237;

		double input = 5;
		int choice = 1;

		if(choice == 1){
			System.out.print(input + " ton(s) in kg is ");
			System.out.println(input*ton*kg);
		}else if(choice ==2){
			System.out.print(input + " hundredweight(s) in kg is ");
			System.out.println(input*hunWeight*kg);
		}else if(choice ==3){
			System.out.print(input + " quarter(s) in kg is ");
			System.out.println(input*quarter*kg);
		}else if(choice ==4){
			System.out.print(input + " stone(s) in kg is ");
			System.out.println(input*stone*kg);
		}else if(choice ==5){
			System.out.print(input + " ounce(s) in kg is ");
			System.out.println(input*ounce*kg);
		}else if(choice ==6){
			System.out.print(input + " drachm(s) in kg is ");
			System.out.println(input*drachm*kg);
		}else if(choice ==7){
			System.out.print(input + " grain(s) in kg is ");
			System.out.println(input*grain*kg);
		}

		System.out.print("\nIf a person weighs 11 stones and 6 pounds, then "
				+ "their weight in kg is ");
		System.out.println( Math.round((11 *stone + 6*pound) * kg*100)/100.0 );
	}
}
