/**************************************************************************
*                                                                         *
*     Program Filename:  Khan06B.java                                     *
*     Author          :  Sarim Khan                                       *
*     Date Written    :  September 20, 2017                               *
*     Purpose         :  To calculate the percentage of successful runs   *
*     Input from      :  None                                             *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Random;
import java.util.Scanner; 
import java.text.DecimalFormat; 

public class Khan06B
{
   public static void main(String[] args)
   {
      int     i, j, Temp, BoxNumber, Counter; int k = 1;
      int numberofIterations; 
      boolean FoundMyNumber;
      Random  generator = new Random();
      int[]   Boxes = new int[101];
      Scanner Keyboard = new Scanner(System.in);
      double countLife = 0; 
      boolean Life = false; 
      double countTotal; 
      DecimalFormat df = new DecimalFormat ("0.00"); 
      
      System.out.println("Please enter the number of iterations you would like to perform)"); 
      numberofIterations = Keyboard.nextInt();  

   while (k != numberofIterations)
   {
      for (j = 1; j <= 100; j++)
         {
         Boxes[j] = j;
         }
      // end for

      for (j = 100; j > 1; j--)
      {
         i = generator.nextInt(j) + 1;
         Temp = Boxes[j];
         Boxes[j] = Boxes[i];
         Boxes[i] = Temp;
      }
      // end for      

      for (j = 1; j <= 100; j++)
      {
         Counter = 0;
         FoundMyNumber = false;
         BoxNumber = j;

         while (Counter < 50 && !FoundMyNumber)
         {
            Counter++;
            if (Boxes[BoxNumber] == j)
               FoundMyNumber = true;
            else
               BoxNumber = Boxes[BoxNumber];
            // end if
         }
         // end while
                  
         if (!FoundMyNumber)
         {
            Life = false; 
         }
         // end if
               
      }
      // end for
      if (Life == true)
      {
         countLife++; 
      }
      Life = true; 
      k++; 
   }
   //end while

      countTotal = (countLife/numberofIterations)*100; 
      System.out.println("The strategy was successful " + df.format(countTotal) + "% of the time."); 
   }
   // end function main
}
// end class prisoners
        
