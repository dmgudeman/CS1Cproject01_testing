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
  
   
   public SubSet findSubset(int budget)
   {
      ArrayList<SubSet> Col = new ArrayList<>();
      SubSet emptySet = new SubSet();
      Col.add(emptySet);
      SubSet theSubSet = null; 
    
      
      for (Integer item : groceryList)                 
      {      
         for ( int i = 0; i < Col.size(); i++ )   
         {             
            if (Col.get(i).getSubSetSum() + item <= 25)
            {  
               theSubSet = new SubSet();
               theSubSet = Col.get(i).addToSubSet(item);
               Col.add(theSubSet);
               System.out.println(Col);
               
            }
            if  (Col.get(i).getSubSetSum() + item == 25)
            {
               return theSubSet;
               
            }
            
         }
      
      }
     
      return theSubSet;
   }
   
   public Integer listSummation(ArrayList<Integer> listToSum)
   {     
      Integer sum = 0;
      for (Integer i : listToSum)
      {    
         sum = sum + i;
      }       
      return sum;
   }
   
}
