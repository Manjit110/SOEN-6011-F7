import java.util.Scanner;

public class F7 {

    public static double power_positive(double a , double b){
        System.out.println("Base:Positive , Exponent:Positive");
        double result = 1;
        for(int i=1; i<=b ; i++){
            result = result * a;
        }

        return result;
    }

    public static double power_negative(double a , double b){
        System.out.println("Base:Positive , Exponent:Negative");
        double result = 1;
        for (int i = 1; i <= (-1*b); i++) {
            result = result * a;
        }
        result = 1/result;

        return result;

    }

    static double decimal_power(double base, double exponent) {

        double finalResult= 1;

        if(exponent >= 1) {
            double[] exponentialValue = power_greater_than_1(base,exponent);

            finalResult = finalResult * exponentialValue[0];
            exponent = exponentialValue[1];

        }

        if(exponent > 0 && exponent < 1) {
            double[] results = power_less_than_1(base,exponent);
            finalResult = finalResult * whole_answer_from_decimal_power(results[2], results[0]*results[1])[0];
        }



        return finalResult;
    }

    public static double[] power_greater_than_1(double base,double exponent){
        double[] exponentialValue = new double[2];
        if(exponent >= 1) {
            exponentialValue = whole_answer_from_decimal_power(base, exponent);

        }
        return exponentialValue;

    }

    public static double[] power_less_than_1(double base,double exponent){
        String power_val = String.format("%.6f", exponent);
        exponent = Double.parseDouble(power_val);

        double numerator = exponent;
        double denominator_root = 1;
        while(!((numerator * denominator_root) % 1 == 0))
        {
            denominator_root++;

        }
        double[] decimal_to_fraction = {numerator, denominator_root};

        double accurate = 1;
        double Root_Value = Approx_Root_Value(base, decimal_to_fraction[1], 0, accurate);
        while(base < whole_answer_from_decimal_power(Root_Value, decimal_to_fraction[1])[0] && accurate > 0.000000000001) {
            Root_Value -= accurate;
            accurate *= 0.1;

            Root_Value = Approx_Root_Value(base, decimal_to_fraction[1], Root_Value, accurate);
        }
        double[] results = {numerator, denominator_root, Root_Value};

        return results;

    }



    public static double Approx_Root_Value(double base, double exponent, double Root_Value, double accurate) {
        Root_Value +=accurate;
        double[] answers = whole_answer_from_decimal_power(Root_Value, exponent);

        while(answers[0] < base) {
            Root_Value += accurate;
            answers = whole_answer_from_decimal_power(Root_Value, exponent);
        }

        return Root_Value;
    }

    public static double[] whole_answer_from_decimal_power(double base, double exponent) {
        double result = 1;

        for(double iterator = exponent;iterator>0;iterator--){
            result *= base;
            exponent--;
            if(exponent < 1) {
                break;
            }
        }

        double[] whole_part_result = {result , exponent};
        return whole_part_result;
    }

    public static double Controller(double x, double y){

        double finalResult=1;
        if(x < 0 && y % 1 != 0) {
            System.out.println("Error in exponent value: Negative base can not have non-integer powers");
            finalResult = 0;
        }
        else if( y % 1 == 0 && y > 0) {
            finalResult=power_positive(x,y);
        }
        else if(y < 0 && y % 1 == 0){
            finalResult=power_negative(x,y);
        }
        else if(y % 1 != 0){

            if(y >= 0 ){

                double ans = decimal_power(x, y);
                String output = String.format("%.6f", ans);
                finalResult = Double.parseDouble(output);



            } else if(y < 0) {

                y = -1 * y;

                double ans = decimal_power(x, y);


                finalResult = 1 / ans;
                String output = String.format("%.6f", finalResult);
                finalResult = Double.parseDouble(output);



            }
        }

        return finalResult;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Boolean looper = true;

        while(looper) {
            System.out.println("1.Use the power function calculator.");
            System.out.println("2.Exit the System");
            int choice = sc.nextInt();
            if(choice==1) {
                try {
                    System.out.println("Please Enter the  Base Value");
                    double base = sc.nextDouble();
                    System.out.println("Please Enter the Exponent Value");
                    double exponent = sc.nextDouble();
                    double answer = Controller(base, exponent);
                    System.out.print("The answer is: ");
                    System.out.print(answer);
                    System.out.println();
                } catch (Exception error) {
                    System.out.println("Incorrect Value Entered");
                    System.out.println("Please enter the values again");
                    sc.nextLine();
                    try {
                        System.out.println("Please Enter the  Base Value");
                        double base = sc.nextDouble();
                        System.out.println("Please Enter the Exponent Value");
                        double exponent = sc.nextDouble();
                        double answer = Controller(base, exponent);
                        System.out.print("The answer is: ");
                        System.out.print(answer);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println("Incorrect Value Entered");
                        System.out.println("You are being redirected to main page");
                    }

                }

            }

            if(choice==2){
                System.out.println("You have successfully exited the system.");
                System.exit(1);
            }
        }


    }
}

