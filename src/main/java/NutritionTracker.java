import java.util.Scanner;
// Field
class FoodItem {
    String name;
    double fat;
    double carbs;
    double protein;
//Constructors 
public FoodItem(String name, double fat, double carbs, double protein) {
      this.name = name;
      this.fat = fat;
      this.carbs = carbs;
      this.protein = protein;
}
//Getting Calories 
public double getCalories(double numServings) {
  return (fat*9 + carbs*4 + protein*4) * numServings;
}
// Getting domainant Macronutrients
public String getDomianantMacro(String dominant) {
  if(fat > carbs && fat > protein) {
    dominant = "Fat";
  }
  else if (carbs > fat && carbs > protein) {
    dominant = "Carbs";
  }
  else if (protein > fat && protein > carbs) {
  dominant = "Protein";
  }
  return dominant;
}
// Setting up the looped info
public void printInfo() {
  System.out.println("Nutritional information per serving of " +name+ ":");
  System.out.println("  Fat: " + fat + "g");
  System.out.println("  Carbs: " + carbs + "g");
  System.out.println("  Protein: " + protein + "g");
  }
}
// Tracker class
public class NutritionTracker {
  static double totalCalories;
  public static void main(String[] args) {
// Creating the scanner
    Scanner scanner = new Scanner(System.in);
// Asking the user about the number of inputs
    System.out.println("How many food items would you like to input?: ");
    int foodNum = scanner.nextInt();
    scanner.nextLine();
// Main loop
    for(int i=0; i<foodNum; i++) {
      System.out.println("Enter the name of the food item: ");
      String name = scanner.nextLine();
      System.out.println("Enter the amount of fat in "+ name +" (Grams): ");
      Double fat = scanner.nextDouble();
      System.out.println("Enter the amount of carbs in "+ name +" (Grams): ");
      Double carbs = scanner.nextDouble();
      System.out.println("Enter the amount of protein in "+ name +" (Grams) ");
      Double protein = scanner.nextDouble();
      System.out.println("Enter the number of servings: ");
      Double numServings = scanner.nextDouble();
      scanner.nextLine();
//Outputting the collected info 
      FoodItem foodItem = new FoodItem(name, fat, carbs, protein);
      foodItem.printInfo();
      System.out.println("  Total Calories for "+numServings+ " servings of" +name+ ": " + (fat*9 + carbs*4 + protein*4) * numServings);
      System.out.println("Domainant Macronutrient: " + foodItem.getDomianantMacro(""));
        totalCalories += foodItem.getCalories(numServings);
      }
//Outputting the total info
    System.out.println("Total combined calories for all food items: "+ totalCalories);
    System.out.println("Thank you for using the Nutrition Information System!");
  }
}