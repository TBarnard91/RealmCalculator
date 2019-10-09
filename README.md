# RealmCalculator

Simple program to calculate various results from a given score. I generally got scores from a card game called Star Realms.

/* GENERAL INFO

   The concept is this: The user will be payed to do something they enjoy, or is important to them. Perhaps it is to spend time learning partiular skills,
   Playing games, perfected a hobby, or even going back to school and earning money for time spent in class or studying. For examples below, I will assume gaming as the activity.
   A score earned by the user in a game of StarRealms will determine the rate and how many years contracted to work by Realm.
   First, play a round of StarRealms where you have to win by completing all 3 missions (from the Missions expansion) on easy difficulty. You may put off completing missions until you have either completed 2,
   or have over 100 HP. At that point you must do everything within reason to finish the remaining missions. The amount of HP remaining when all missions are complete is your score. 
   Typically all expeansions must be enabled.
   
   Alternate rules include disabling some expansions, aggressively pursuing all misions, playing on harder difficulties, or deliberately not checking
   missions and playing normally (but not knocking out opponent with damage). 
   Allowing conventional wins (reduce opponent health to 0) and awarding partial score based on missions completed (0 for 0, 1/3 for 1, 2/3 for 2, and full for 3) is another option.
   
   The score is your hourly pay, so a score of 102 = $102/hr. To determine the max hours per week you can work, divide by 5 and multiply the remainder by 10. So, 102 would give 20 hours.
   The exception is when a number is divisible by 5. When that happens they can work 50 hours per week, and are payed double for the 10 hours of overtime, for the equilivant of 60 payed hours.
   
   The last thing is the years contracted. Again, you divide by 5 and take the remainder, but this time subtract it from 5. The result is the years you will be payed to 
   play games. So, 102 would give 3 years. 
   
   This program will take a score and return the score, $$/hour, max hours/week, years available, and max income over the course of your contract. If the score is divisable by 2 
   then a prompt at the beginning of the program will ask if 2-person rules are in effect (see note below).
*/

/* SCORE COMPARISONS

   The scores all have their own advantages and disadvantages. For this, assume any score ending in 0 is the same as one ending in 5. Likewise for 1/6, 2/7, 3/8, 4/9, as the remainders will be equal.
   A 0/5 will be the best, due to maxing out both hours worked (with double pay for the last 10 hours) and years contracted. The only downside is 50 hours a week is a full time job, and will be for
   all of the 5 years. Without the 10 hours of overtime, it is on par with a 4/9 per year, but has the most years making it far better all other options. The 10 hours of overtime increase the 
   pay not by 20%, but by 50%, and so is crucial to making the most of this score.
   
   A 1/6 will be the worst financially speaking, having both the lowest total income and spreading out over 4 years. However, 10 hours a week is less then what I play currently, and requires no
   additional time or effort on my part.
   
   A 2/7 and 3/8 are almost identical financially, with the former being 20h/week for 3 years, and the latter 30h/week for 2 years. They are both better financially then a 1/6 or 4/9.
   Personal preference determines which is ideal for you. A 2/7 with 20 hours a week is easy to incorporate and often will require no extra time or effort, making it simply better then a 1/6.
   A 3/8 however will usually require extra time (at least from me, others already play >30h a week), but will be complete in only 2 years.
   
   A 4/9 is close financially to a 1/6, and therefore poor in terms of total income. It also demands 40 hours a week, so I (being married to a non-gamer) would not be able to work full time
   and still make the msot of it. The only upside is that it is only 1 year.
   
   It is important to know that there is no obligation to work while contracted. It will be active the full length regardless of whether or not you game. Any additional hours gaming will go
   into a PTO account. Any week you end below your max hours, the difference wil be payed from your PTO (if available). At the end of the contract PTO will not be payed out. In addition,
   for a 0/5, PTO cannot be used for the 10 hours of overtime.
  
   
   The contract is meant to be freeing, and a guaranteed boon to any adult getting started in life. The hours are not mandatory, so work as many as you can or wish.
   At worst, you simply get payed for the time you already spend playing video games. Even poor scores can equal or surpass a good salary, and the best can pay
   well over 100k a year. Use the additional time and money to lay a foundation for your career and personal life such as taking unpaid internships, attending college
   or bootcamps, paying off debt and finding a job where you wish to live.
   
   For me personally, a 0/5 and 2/7 are the best. The 0/5 of course is the best of all worlds, paying the same per hour but with the longest contract and the option to work full
   time for greatly increased pay. A 2/7 is just as easy for me to do as a 1/6 (since I average 10-15hours on steam plus 5-10 elsewhere) and earns the same money as a 3/8. 
*/

/* 2-PERSON RULES

   An alternate mode is using the score to determine what 2 people will be paid, specifically myself and Nick Keller, who I believe would responsibly use such a financial boost.
   Only even-numbered scores will be allowed. Divide the score by 2, and then use the result to calculate everything else. (0 = 5, 2 = 1. 4 = 2, 6/1 = 3, 8/2 = 4). This does limit
   available options, results in much lower personal scores and therefore incomes.
*/
