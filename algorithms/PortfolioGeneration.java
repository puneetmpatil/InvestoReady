import java.util.Scanner;
import java.util.Random;

public class PortfolioGeneration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the user's budget
        System.out.print("Enter the budget:");
        int budget = sc.nextInt();

        // Assuming there are 6 sectors
        int noOfSectors = 6;

        // Calculating amount to be allocated per sector
        double sectoralAmount = budget / noOfSectors;

        // We are selecting top 3 stocks from each sector therefore upperbound = 3
        int upperBound = 3;
        int lowerBound = 0;

        sc.nextLine();

        String sectorName[] = new String[6];
        String sectoralStocks[][] = new String[6][3];
        Double[][] sectoralStocksPrice = new Double[6][3];

        // Input the names of top 3 stocks from each sector
        System.out.println("Enter sectorwise");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                sectoralStocks[i][j] = sc.nextLine();
            }
        }

        // Input the price of the top 3 stocks from each sector
        System.out.println("Enter sectorwise price");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                sectoralStocksPrice[i][j] = sc.nextDouble();
            }
        }

        String topSectorWise[] = new String[noOfSectors]; // to be printed
        Double topSectorWisePrice[] = new Double[noOfSectors]; // to be printed
        int quantity[] = new int[6]; // to be printed
        Double totalSectoralWiseAllotted[] = new Double[6]; // to be printed
        Double remainder[] = new Double[6];
        Double totalAllocated = 0.0;

        Random rand = new Random();

        // Randomly selecting a stock from each sector and calculating the quantity
        for (int i = 0; i < noOfSectors; i++) {
            int random_integer = rand.nextInt(upperBound - lowerBound) + lowerBound;
            topSectorWise[i] = sectoralStocks[i][random_integer];
            topSectorWisePrice[i] = sectoralStocksPrice[i][random_integer];
            quantity[i] = (int) (sectoralAmount / topSectorWisePrice[i]);
            remainder[i] = sectoralAmount % (topSectorWisePrice[i] * quantity[i]);
            totalSectoralWiseAllotted[i] = topSectorWisePrice[i] * quantity[i];
            totalAllocated += totalSectoralWiseAllotted[i];
        }

        // Calculating remaining amount
        Double totalRemaining = budget - totalAllocated;

        // Finding the minimum price from the top 6 stocks selected
        Double min = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < noOfSectors; i++) {
            if (totalRemaining > topSectorWisePrice[i] && topSectorWisePrice[i] < min) {
                min = topSectorWisePrice[i];
                index = i;
            }
        }

        Double finalTotalAllocated = totalAllocated;
        Double finalTotalRemaining = totalRemaining;
        // Calculating the additional quantity to be purchased from remaining amount
        if (min != 0.0) {
            int additionalQuantity = 0;
            while (totalRemaining > additionalQuantity * min) {
                additionalQuantity++;
            }
            additionalQuantity--;
            quantity[index] += additionalQuantity;
            finalTotalAllocated = finalTotalAllocated + additionalQuantity * min;
            finalTotalRemaining = budget - finalTotalAllocated;
            totalSectoralWiseAllotted[index] = totalSectoralWiseAllotted[index] + additionalQuantity * min;
        }

        // Displaying the details of automatically generated portfolio
        System.out.println("TopSectorWise : TotalSectorWisePrice : Quantity : Remainder : TotalSectorWiseAllocated");
        for (int i = 0; i < noOfSectors; i++) {
            System.out.println(topSectorWise[i] + " : " + topSectorWisePrice[i] + " : " + quantity[i] + " : "
                    + remainder[i] + " : " + totalSectoralWiseAllotted[i]);
        }
        System.out.println("Final Total Allocated: " + finalTotalAllocated);
        System.out.println("Final Total Remaining: " + finalTotalRemaining);

        sc.close();
    }
}