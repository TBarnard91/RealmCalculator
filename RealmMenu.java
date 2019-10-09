//****************************************
//   Programmer: Tyler Barnard
//   
//   Service class: RealmMenu
//****************************************

/**
	RealmMenu class
   RealmCalculator will create and call this class to display various menu options, which will return a true or false as each question is a yes or no.
   RealmMenu will create the RealmScore instances, and the ArrayList to store them in. RealmCalculator will simply be a list of calls to RealmMenu.
*/


import java.util.Scanner;  // Import the Scanner class
import java.util.*;   
import java.io.*;         // Needed for the File class

class RealmMenu
{
      private ArrayList<RealmScore> userScores = new ArrayList<RealmScore>();   //create ArrayList to hold RealmScore objects
      
      Scanner kb = new Scanner(System.in); //create a scanner object
      
      private int score = 0; //the score to be used
      private boolean share = false;
      
      private boolean check = true;   //used to check loops
      private String c = " "; //for input check
      
      private RealmScore user = new RealmScore(); //class used to calculate and store results from score
      
      private String outFile = "summary.txt";       //Text file to save data to
      
      /**
      Setters + Getters as needed
      */
      
      /*
         Ask about textFile
	      Input File
	      - 2 person rules for even scores
	      - Enter and check filename
	      - Collect scores, calculate them, copy to object for ArrayList, save info in filename
	      - Close program
	   
	      Manual Scoring
	      - Ask for score
	      - For even score, ask about 2-Person rules
	      - Set and calculate score, copy to ArrayList
	      - Ask for additional score
	      - On yes, repeat 1-4
	      - Ask to save file
	   */
      
      //default constructor
      public RealmMenu()
      {
      
      }//end default constructor
      
/////////////////////////////////////      
      public boolean fileAsk()
      {
         //determine is manual input of scores, or import from file method should be used
         System.out.println();
         System.out.println("Would you like to import scores from a text file?");
         do{
            System.out.println("Enter Y for yes, or N for no.");
            
            c = kb.nextLine();
            
            switch (c){
            
               case "Y":
               case "y":
               case "Yes":
               case "yes":
                  return true;
                  //break;
                  
              case "N":
              case "n":
              case "no":
              case "No":
                  return false;
                  //break;
               
               default:
                  System.out.println("Invalid input. Import scores from text file?");
                  System.out.println();
                  check = true;
             }//end switch
             
         }while(check); //end do-while
         
         return false;
         
      }//end fileAsk


//////////////////////////////////////
      public void shareAsk()
      {
         System.out.println();
         System.out.println("Would you like to enable 2-Person rules for even numbered scores?");
         
         while (check){
            System.out.println("Enter Y for yes, or N for no.");
            
            c = kb.nextLine();
            System.out.println();
            switch (c){
            
               case "Y":
               case "y":
               case "Yes":
               case "yes":
                  check = false;
                  share = true;
                  break;
                  
                  case "N":
                  case "n":
                  case "no":
                  case "No":
                     check = false;
                     share = false;
                     break;
                  
                   default:
                      System.out.println("Invalid input. Enable 2-person rules?");
                      System.out.println();
               }//end switch
             
         }//end inner while
      }//end shareAsk

///////////////////////////////////////////
      public void useFile() throws IOException
      {
         // Get the filename.
         System.out.print("Enter the filename: ");
         String filename = kb.nextLine();
                  
         // Open the file.
         File file = new File(filename);
         while (!file.exists())
         {
            System.out.println();
            System.out.print("Unable to find matching file. Please try again, or input 'q' to quit.");
            System.out.println();
            filename = kb.nextLine();
            if (filename.equals("Q") || filename.equals("q"))
            	System.exit(0);   //close program
            file = new File(filename);
          }
                     
          Scanner inputFile = new Scanner(file);
                  
          // Read lines from the file until no more are left.
          while (inputFile.hasNext())
          {
               // Read the next name.
               if(inputFile.hasNextInt())
               {
                  score = inputFile.nextInt(); 
                  addData(score);
               }//end if
               else
                  inputFile.nextLine();
            }//end while
            
            // Close the file.
                  inputFile.close();
      
   }//end useFile
   
////////////////////////////////////
   //add data to ArrayList
   public void addData(int s)
   {
      user.setScore(s);
      
      if (share && (s % 2 == 0))
         user.setShare(true);
      else
         user.setShare(false);
      
      RealmScore temp = new RealmScore(user.getScore(), user.getShare());
      userScores.add(temp);
      
      saveData();

   }//end addData

   public void saveData()
   {
      //https://caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html, resource used as example, should look up BufferedWriter later (initial research indicates it is for faster performance)
      try {
         FileWriter fw = new FileWriter(outFile);
         
         //wrap FileWriter in BufferedWriter
         BufferedWriter bw = new BufferedWriter(fw);
         
         for (int i = 0; i < userScores.size(); i++)
         {
            if (userScores.get(i).getShare())
               bw.write("With a reduced score of " + userScores.get(i).getScore() + " (from 2-Person rules):");
            else
               bw.write("With a score of " + userScores.get(i).getScore() + ":");
               
            bw.newLine();
            bw.write("  You will earn $" + userScores.get(i).getRate() + " per hour, and may work up to " + userScores.get(i).getHours() + " hours each week for " + userScores.get(i).getTerm() + " years.");
            bw.newLine();
            bw.write("  You can earn up to $" + userScores.get(i).getYearlyIncome() + " per year, for a total of $" + userScores.get(i).getTotalIncome() + " by the end of your contract.");
            
            if (userScores.get(i).getShare())
            {
            RealmScore temp = new RealmScore((userScores.get(i).getScore() * 2), false);
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
   
////////////////////////////////////
   public void manualInput()
   {  
      //retrieve the score
      do{
      
         System.out.println("Please enter the score.");
         
         if (kb.hasNextInt()){
            score = kb.nextInt();
            check = false;
            }
         else {
            System.out.println("Invalid input.");
            check = true;
            kb.nextLine();
            }
      }while (check);   //end first inner do-while
      
      addData(score);
      
      //display data
      user.calcData();
      System.out.println();
      user.printData();
      
      kb.nextLine();          //consume rest of line
            
   }//end manualInput
     
     
     
}//end RealmMenu class

//TODO Should share be static, or seperate, or used as is?