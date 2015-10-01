import java.util.ArrayList;

public class SubSet implements Cloneable
{
   private int sumOfElements = 0;
   ArrayList<Integer> subSetElements = new ArrayList<>();
   ArrayList<Integer> subSetIndices;

   public SubSet(ArrayList<Integer> subSet)
   {
      sumOfElements = 0;
      subSetElements = subSet;
      subSetIndices = new ArrayList<>();
   }

   int getSumOfElements()
   {
      return sumOfElements;
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
      try
      {
         newSubSet = (SubSet) this.clone();

         newSubSet.sumOfElements = newSubSet.sumOfElements
               + subSetElements.get(indexToAdd);
         newSubSet.subSetIndices.add(indexToAdd);
         return newSubSet;
      } catch (CloneNotSupportedException e)
      {
         System.out.println("addToSubSet didn't clone");
         return null;
      }
   }

   public void printSubSet(ArrayList<Integer> subSet)
   {
      for (Integer i : subSet)
      {
         System.out.println(i);
      }
   }

}
