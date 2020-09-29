import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput(){
        Scanner yesOrNo = new Scanner(System.in);
        String response = "";
        System.out.println("Input a height and weight? Y/N");
        response = yesOrNo.nextLine();

        while (!response.equals("Y") && !response.equals("N")) {
            System.out.println("Please input a valid character. Input a height and weight? Y/N");
            response = yesOrNo.next();
        }

        //yesOrNo.close();

        if (response.equals("Y")){
            return true;
        }
        else {
            return false;
        }
    }

    public static double getUserHeight(){
        Scanner heightScanner = new Scanner(System.in);
        double height = 0;

        System.out.println("What is your height, in inches?");

        while(height <= 0)
        {
                height = heightScanner.nextDouble();
                if (height <= 0)
                {
                    System.out.println("Please input a valid, positive number.");
                }
        }

        return height;
    }

    public static double getUserWeight(){
        Scanner weightScanner = new Scanner(System.in);
        double weight = 0;

        System.out.println("What is your weight, in pounds?");

        while(weight <= 0)
        {
            weight = weightScanner.nextDouble();
            if (weight < 0)
            {
                System.out.println("Please input a valid, positive number.");
            }
        }

        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi){
        System.out.printf("The BMI Score is: %.1f.\nThe BMI Category is %s.\n",
                bmi.calculateBmiScore(bmi.height,bmi.weight), bmi.calculateBmiCategory(bmi.height, bmi.weight));
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double averageBmi = 0;
        BodyMassIndex currentBmi = null;
        for (int i = 0; i < bmiData.size(); i++)
        {
            currentBmi = bmiData.get(i);
            averageBmi += currentBmi.calculateBmiScore(currentBmi.height, currentBmi.weight);
        }
        averageBmi /= bmiData.size();

        System.out.printf("The Average BMI Score is: %.1f.\n", averageBmi);
    }

}
