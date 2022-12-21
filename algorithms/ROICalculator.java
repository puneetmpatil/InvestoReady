import java.util.Scanner;

public class ROICalculator {
    // Method to check if the year is bonus year
    public static Boolean isBonusYear(int bonusYear[], int year) {
        for (int element : bonusYear) {
            if (element == year) {
                return true;
            }
        }
        return false;
    }

    // Method to calculate the total dividend and current valuation
    public static void Calculator(Double amount, Double[] price, Double dividendFactor, int bonusYear[],
            int bonusYearRatioFactor[]) {
        int no_of_years = 17; // 17 years of data (2006 - 2022)
        int quantity = (int) (amount / price[no_of_years - 1]);

        Double totalDividend = 0.0;

        int index = 0;
        for (int i = no_of_years - 2, year = 2006; i >= 0; i--, year++) {
            if (isBonusYear(bonusYear, year)) {
                quantity = quantity * bonusYearRatioFactor[index];
                index++;
            }
            totalDividend += quantity * ((price[i] * dividendFactor) / 100);
        }
        Double currentEvaluation = 3737.9 * quantity;
        System.out.println("Current valuation: " + currentEvaluation);
        System.out.println("Total Dividend Received over 16 years: " + totalDividend);
    }

    public static void main(String[] args) {

        // Input amount to be invested from user
        // Ensure that amount entered by user is minimum 10000
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount:");
        Double amount = sc.nextDouble();

        // TCS and INFY data
        int TCS_bonus_year[] = { 2006, 2009, 2018 };
        int TCS_bonus_year_ratio_factor[] = { 2, 2, 2 };
        Double TCS_dividendFactor = 1.24;
        Double[] TCSPrice = { 3737.9, 3112.9, 2079.3, 2014.6, 3111.75, 2229.9, 2391.2, 2481.0, 2236.2, 1342.75, 1130.5,
                1157.15, 735.45, 511.95, 875.25, 1278.6, 1670.1 };

        int INFY_bonus_year[] = { 2006, 2014, 2015 };
        int INFY_bonus_year_ratio_factor[] = { 2, 2, 2 };
        Double INFY_dividendFactor = 1.87;
        Double[] INFYPrice = { 1736.7, 1239.65, 776.35, 749.6, 1150.65, 929.3, 1164.85, 2142.75, 3699.45, 2788.75,
                2743.35, 3116.3, 2476.7, 1305.5, 1503.9, 2244.45, 2879.7 };

        do {
            System.out.println("Enter 1 for TCS and 2 for INFY and 3 to exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Calculator(amount, TCSPrice, TCS_dividendFactor, TCS_bonus_year, TCS_bonus_year_ratio_factor);
                    break;
                case 2:
                    Calculator(amount, INFYPrice, INFY_dividendFactor, INFY_bonus_year, INFY_bonus_year_ratio_factor);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
        } while (true);
    }
}