import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//SHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
public class ShoppingBag
{
   String FILENAME;

   public ShoppingBag(String fILENAME)
   {
      super();
      FILENAME = fILENAME;
   }
   
   public ArrayList<String> getPriceOfGroceries() throws FileNotFoundException
   {
      String filename = "resources/groceries.txt";
      
      BufferedReader inFile = new BufferedReader(new FileReader(filename));

      //Define and initialize the ArrayList
      ArrayList<String> groceryList = new ArrayList<String>(); //The ArrayList stores strings

      String inline; //Buffer to store the current line
      
      try
      {
         while ((inline = inFile.readLine()) != null) //Read line-by-line, until end of file
         {
            Pattern intsOnly = Pattern.compile("([\\+-]?\\d+)([eE][\\+-]?\\d+)?");
            Matcher makeMatch = intsOnly.matcher(inline);
            makeMatch.find();
            String str = makeMatch.group();
             groceryList.add(str);
             System.out.println(str);
         }
         inFile.close(); //We've finished reading the file 
      } catch (IOException e)
      {
         
         e.printStackTrace();
      }
    
      return groceryList;
            
   }
  
   
   public ArrayList<Integer> findSubset(int budget)
   {
      ArrayList<Integer> subset = new ArrayList<>();
      return subset;
   }
   
   
   
}
