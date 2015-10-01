import java.util.ArrayList;
import java.util.List;

public class SubSet implements Cloneable
{
   private int subSetSum = 0;
   ArrayList<Integer> subSetElements = new ArrayList<>();
   ArrayList<Integer> subSetIndices;
   
   public SubSet() {};

   public SubSet(ArrayList<Integer> subSet)
   {
      subSetSum = 0;
      subSetElements = subSet;
      subSetIndices = new ArrayList<>();
   }

   int getSubSetSum()
   {
      return subSetSum;
   }

   public SubSet clone() throws CloneNotSupportedException
   {
     
      SubSet newSubSet = (SubSet) super.clone();
      newSubSet.subSetIndices = (ArrayList<Integer>) subSetIndices.clone();
      return newSubSet;
   }

   public SubSet addToSubSet(int indexToAdd)
   {
      SubSet newSubSet;
      if ( indexToAdd < 0 || indexToAdd >= subSetElements.size() )
          return null;

      try
      {
         newSubSet = (SubSet) this.clone();

         newSubSet.subSetSum = newSubSet.subSetSum
               + subSetElements.get(indexToAdd);
         newSubSet.subSetIndices.add(indexToAdd);
         return newSubSet;
      } catch (CloneNotSupportedException e)
      {
         System.out.println("addToSubSet didn't clone");
         return null;
      }
   }

   public void printSubSet(SubSet subSet)
   {  
      for ( int i = 0; i < ((List<Integer>) subSet).size(); i++)
      {
         System.out.println(subSet.subSetElements.get(i));
      }
   }

}
