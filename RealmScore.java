//****************************************
//   Programmer: Tyler Barnard
//   
//   Service class: RealmScore
//****************************************

/**
	RealmScore class
*/

import java.util.*;
//import java.io.*;    //Needed for the File class

class RealmScore
{
      private int score = 0;             //score to be used
      private int r = 0;                 //remainder to be used in determining weekly hours and contract length
      private int rate = 0;              //hourly pay rate = score
      private int hours = 0;             //max hours worked per week
      private int term = 0;              //Length of contract in years
      private int yearlyIncome = 0;      //Income over one year if working max hours
      private int totalIncome = 0;       //Total income over length of contract, working max hours 
      
      private boolean share = false;     //Determines if 2-person rules are in effect
      private boolean flag = false;      //if share rules have been applied to score, set to true
      

   
	//  default constructor                     
   public RealmScore()
   {
      
   }

   /* constructor used to initialize the data member  
	*/                    
   public RealmScore(int s, boolean b)
   {  
      if (!b)
         score = s;
      else
         score = s / 2;
         
      r = score % 5;
      
      rate = score;
      
      if (r == 0)
         hours = 50;
      else
         hours = 10 * r;
         
      term = 5-r;
      
      if (hours == 50)                              //Any hours over 40 are payed double, so 50 hours worked = 60 hours of pay
         yearlyIncome = (hours + 10) * 52 * rate;
      else
         yearlyIncome = hours * 52 * rate; 
         
     totalIncome = yearlyIncome * term;
     
     share = b;
     
     if (b)
      flag = true;
     
   }
	   
   //Getters
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   /**
		getScore method
		
		@return The score
	*/

   public int getScore()
   {
      return score;
   }
   
   /**
		getRate method
		
		@return The hourly pay rate
	*/

   public int getRate()
   {
      return rate;
   }
   
   /**
		getHours method
		
		@return The maximum hours allowed each week
	*/

   public int getHours()
   {
      return hours;
   }
   
   /**
		getTerm method
		
		@return The length of the contract
	*/

   public int getTerm()
   {
      return term;
   }
   
   /**
		getYearlyIncome method
		
		@return The total income over one year
	*/

   public int getYearlyIncome()
   {
      return yearlyIncome;
   }
   
   /**
		getTotalIncome method
		
		@return The total income over length of contract
	*/

   public int getTotalIncome()
   {
      return totalIncome;
   }
   
   /**
		getShare method
		
		@return True if 2 person sharing is in effect.
	*/

   public boolean getShare()
   {
      return share;
   }
   
   //Setter
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   /**
      setScore method
      
      @param s New value for score
   */
   public void setScore(int s)
   {
      score = s;
         
      r = score % 5;
   }
   
   public void setShare(boolean b)
   {
      share = b;
   }
   
   //Functions
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   /**
      calcData method
      Calculates the various data members.
   */
   
   public void calcData()
   {  
      if(!flag && share)
         setScore(score / 2);
      
      rate = score;
      
      if (r == 0)
         hours = 50;
      else
         hours = 10 * r;
         
      term = 5-r;
      
      if (hours == 50)                              //Any hours over 40 are payed double, so 50 hours worked = 60 hours of pay
         yearlyIncome = (hours + 10) * 52 * rate;
      else
         yearlyIncome = hours * 52 * rate; 
         
     totalIncome = yearlyIncome * term;
   }
   
   /**
      printData
      Prints the data for the user to see.
   */
   
   public void printData()
   {
     System.out.println();
     System.out.println("With a score of " + score + ":");
     System.out.println("You will earn $" + rate + " per hour, and may work up to " + hours + " hours each week for " + term + " years.");
     System.out.println("You can earn up to $" + yearlyIncome + " per year, for a total of $" + totalIncome + " by the end of your contract.");
     System.out.println();
   }

   /* DELETE
   public void saveAllData(ArrayList<RealmScore> list)
   {  
      //https://caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html, resource used as example, should look up BufferedWriter later (inital research indicates it is for faster performance)
      try {
         FileWriter fw = new FileWriter(outFile);
         
         //wrap FileWriter in BufferedWriter
         BufferedWriter bw = new BufferedWriter(fw);
         
         for (int i = 0; i < list.size(); i++)
         {
            if (list.get(i).getShare())
               bw.write("With a reduced score of " + list.get(i).getScore() + " (from 2-Person rules):");
            else
               bw.write("With a score of " + list.get(i).getScore() + ":");
               
            bw.newLine();
            bw.write("  You will earn $" + list.get(i).getRate() + " per hour, and may work up to " + list.get(i).getHours() + " hours each week for " + list.get(i).getTerm() + " years.");
            bw.newLine();
            bw.write("  You can earn up to $" + list.get(i).getYearlyIncome() + " per year, for a total of $" + list.get(i).getTotalIncome() + " by the end of your contract.");
            
            if (list.get(i).getShare())
            {
            RealmScore temp = new RealmScore((list.get(i).getScore() * 2), false);
            bw.newLine();
            bw.write("With an original score of " + temp.getScore() + ":");
            bw.newLine();
            bw.write("  You will earn $" + temp.getRate() + " per hour, and may work up to " + temp.getHours() + " hours each week for " + temp.getTerm() + " years.");
            bw.newLine();
            bw.write("  You can earn up to $" + temp.getYearlyIncome() + " per year, for a total of $" + temp.getTotalIncome() + " by the end of your contract.");
            }
            
            bw.newLine();
            bw.write(" ");
            bw.newLine();
            
            
            
         }//end for
         
         bw.close();
         }//end try
         
      catch(IOException ex) {
         System.out.println("Error writing to file '" + outFile + "'");
      }
   
   }//end saveData
   */
   
}//end class