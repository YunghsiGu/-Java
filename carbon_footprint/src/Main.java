import java.util.ArrayList;

public class Main {
	
    public static void main(String[] args) {
    	
    	// creates array of objects of type CarbonFootprint
        ArrayList<CarbonFootprint> categories = new ArrayList<CarbonFootprint>();
        categories.add(0, new Bicycle(200.00));
        categories.add(1, new Building(4000.52));
        categories.add(2, new Car(5845.25, 20.5));

        for (CarbonFootprint currentObject : categories) {
            System.out.println(currentObject.toString());
            System.out.printf("Carbon footprint: %.2f\n\n", currentObject.getCarbonFootprint());
        }  
    }
}

interface CarbonFootprint {
	
	// calculates the carbon footprint
    double getCarbonFootprint();	
}

class Bicycle implements CarbonFootprint {
	
    private double yearlyMiles;
    private final int caloriesPerMile = 34;

    // constructor
    public Bicycle(double miles) {
        yearlyMiles = miles;
    }

    public double getYearlyMiles() {
        return yearlyMiles;
    }

    public String toString() {
        return String.format("Bicycle-\n" + 
        		"Yearly miles: " + "%.2f", getYearlyMiles());
    }

    public double getCarbonFootprint() {
        return yearlyMiles * caloriesPerMile;
    }

}

class Building implements CarbonFootprint {

    private double averageMonthlyKwh;
    private final int months = 12;

    // constructor
    public Building(double monthlyConsumption) {
        averageMonthlyKwh = monthlyConsumption;
    }

    public String toString() {
        return String.format("Building-\n" + 
        		"The monthly consumption: " + "%.2f", averageMonthlyKwh);
    }

    public double getCarbonFootprint() {
        return averageMonthlyKwh * months;
    }

}

class Car implements CarbonFootprint {
	
    private double averageYearlyMiles;
    private double averageMPG;
    private final int kgCO2PerMile = 9;

    // constructor
    public Car(double miles, double MPG) {
        averageYearlyMiles = miles;
        averageMPG = MPG;
    }

    public String toString() {
        return String.format("Car-\n" + 
        		"Average yearly miles: " + "%.2f\n" + "Average MPG: " + "%.2f",
        		averageYearlyMiles, averageMPG);
    }

    public double getCarbonFootprint() {
        return averageYearlyMiles * averageMPG * kgCO2PerMile;
    }
}
