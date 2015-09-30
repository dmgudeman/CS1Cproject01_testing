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
   ArrayList<Integer> groceryList;

   public ShoppingBag(String fILENAME)
   {
      super();
      FILENAME = fILENAME;
   }
   
   public ArrayList<Integer> getPriceOfGroceries() throws FileNotFoundException
   {
  
      String filename = this.FILENAME;
      BufferedReader inFile = new BufferedReader(new FileReader(filename));

      //Define and initialize the ArrayList
      groceryList = new ArrayList<>(); //The ArrayList stores strings

      String inline; //Buffer to store the current line
      
      try
      {
         while ((inline = inFile.readLine()) != null) //Read line-by-line, until end of file
         {
            Pattern intsOnly = Pattern.compile("([\\+-]?\\d+)([eE][\\+-]?\\d+)?");
            Matcher makeMatch = intsOnly.matcher(inline);
            makeMatch.find();
            String str = makeMatch.group();
            Integer i = Integer.parseInt(str);
            groceryList.add(i);
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
      ArrayList<ArrayList<Integer>> Col = new ArrayList<>();
     
      
      ArrayList<Integer> emptySet = new ArrayList<>();
      Col.add(emptySet);
     
      ArrayList<Integer> theSubset = new ArrayList<>();
      
     //Collection Col = Collections.EMPTY_SET;
      
      
      for (Integer s : groceryList)
      {
         for (ArrayList<Integer> c : Col )
         {
            
            if (sumArrayList(c) + s <= 25 )
            {
               c.add(s);
               System.out.println(c);
            }
            if (sumArrayList(c) + s == 25 )
            {
               break;
            }
         }
      }
     
      return theSubset;
   }
   
   public Integer sumArrayList(ArrayList<Integer> listToSum)
   {
      
      Integer sum = 0;
      for (Integer I : listToSum)
      {
         
         sum = sum + I;
      }
          
      return sum;
   }
   
}
