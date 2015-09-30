import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import cs1c.TimeConverter;

public class Main
{
//SHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
   public static void main(String[] args) throws FileNotFoundException
   {
      final String FILENAME = "resources/groceries.txt"; 

      ShoppingBag bag = new ShoppingBag(FILENAME);
    //  ArrayList<Integer> shoppingList = bag.getPriceOfGroceries();
      ArrayList<String> shoppingList = bag.getPriceOfGroceries();
      System.out.println("Groceries wanted:");
   //   System.out.println(shoppingList);

      System.out.println("Enter how much cash you have:");
      Scanner keyboard = new Scanner(System.in);
      int budget = Integer.parseInt(keyboard.next());

      long startTime, estimatedTime;

      // capture start time
      startTime = System.nanoTime();

      // implement finding subset of groceries that is closest to meeting budget
      // NOTE: In this part, you only need to keep track of the price of each
      // item,
      // and not the name of the item you are buying.
      ArrayList<Integer> purchases = bag.findSubset(budget);

      // stop and calculate elapsed time
      estimatedTime = System.nanoTime() - startTime;

      // output the result
      System.out.println("Purchased grocery prices are:");
      System.out.println(purchases);

      // report algorithm time
      System.out.println("\nAlgorithm Elapsed Time: "
            + TimeConverter.convertTimeToString(estimatedTime) + ", "
            + " seconds.\n");
   }

}
