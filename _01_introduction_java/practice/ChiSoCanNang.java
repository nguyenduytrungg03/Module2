package _01_introduction_java.practice;
import java.util.Scanner;
public class ChiSoCanNang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height,bmi; //khai bao 3 bien can nang, chieu cao,chiso
        System.out.print("You weight (in kilogram):");
        weight = scanner.nextDouble();
        System.out.print("You hight (in metter):");
        height = scanner.nextDouble();
        bmi = weight / Math.pow(height,2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }


}
