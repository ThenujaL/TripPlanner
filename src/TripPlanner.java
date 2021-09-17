import jdk.internal.cmm.SystemResourcePressureImpl;

import java.util.Scanner;
public class TripPlanner {

    public static void main(String[] args) {
       Greeting();
       TimeAndBudget();
       TimeZone();
       area();
    }

    public static void Greeting(){ //greet user and asks name and destination
        Scanner iput = new Scanner (System.in);
        Scanner jput = new Scanner (System.in);
        System.out.println("Welcome to Vacation Planner");
        System.out.print("What is your name? ");

        String name = iput.nextLine();
        System.out.println("Nice to meet you " + name + ". Where are you travelling to?");

        String destination = jput.nextLine();
        System.out.println("Great! " + destination + " sounds amazing!");
    }

    public static void TimeAndBudget(){
        Scanner days = new Scanner(System.in);
        Scanner cost = new Scanner(System.in);
        Scanner CurSym = new Scanner(System.in);
        Scanner Value = new Scanner(System.in);

        System.out.print("How many days are you going to spend travelling? ");
        int TravelTime = days.nextInt(); //travel days

        System.out.print("How much money in USD are you planning on spending on your trip? $");
        double TravelCost = cost.nextDouble();

        System.out.print("What is the three letter travel symbol of your destination? ");
        String Symbol = CurSym.next();

        System.out.print("How many " + Symbol + " are there in 1 USD? " );
        double ConRate = Value.nextDouble();

        //travel time calculations
        int TimmeInHours = TravelTime * 24;
        int TimeInMinutes = TimmeInHours * 60;
        int TimeInSeconds = TimeInMinutes * 60;

        System.out.println("If you're travelling for " + TravelTime + " days, it is the same as " + TimmeInHours + " hours, " + TimeInMinutes + " minutes, or " + TimeInSeconds + " seconds.");

        //budget
        double BudgetPerDayDeci = TravelCost / TravelTime * 100; //round to two decimal spaces
        int BudgeInDeci = (int)BudgetPerDayDeci;
        double BudgetPerDay = BudgeInDeci / 100.0;
        ;

        System.out.println("If your budget is $" + TravelCost + " USD, your daily budget is $" + BudgetPerDay + " USD");

        //budget in destination currency
        double BudgetInDestCur = TravelCost * ConRate * 100; //rounding to two decimals
        int BudgetInDestCurInt = (int)BudgetInDestCur;
        double DestCurDeci = BudgetInDestCurInt / 100.0;

        double DailyDestBudg = BudgetInDestCur / TravelTime; //rounding to two decimal spaces
        int DayBudgeDesCur = (int)DailyDestBudg;
        double DailyDesDeci = DayBudgeDesCur / 100.0;


        System.out.println("Your budget in " + Symbol + " is " + DestCurDeci + " " + Symbol + ", which per day is " + DailyDesDeci + " " + Symbol);

    }

    public static  void TimeZone(){
        Scanner Time = new Scanner(System.in);

        //time difference
        System.out.print("What is the time difference, in hours, between you the destination and your home? ");
        int TimeDifference = Time.nextInt();
        int TimeInDestAtNidN = 12 + TimeDifference;

            if (TimeInDestAtNidN < 12){
                int TimeInDestAtMidNN = TimeInDestAtNidN + 12;
                int TimeInDestAtNoon = TimeDifference + 12;
                System.out.println("That means when it is midnight at home, it will be " + TimeInDestAtMidNN + ":00 at your destination and when is noon at home, it will be " + TimeInDestAtNoon + ":00 at your destination");
            }
            else{
                int TimeAtNoon = TimeDifference + 12;
                System.out.println("That means when it is midnight at home, it will be " + TimeDifference + ":00 at your destination and when is noon at home, it will be " + TimeAtNoon + ":00 at your destination");
            }
    }

    public static void area (){
        Scanner are = new Scanner(System.in);
        System.out.print("What is the area of your destination in square km? ");
        double area = are.nextDouble();

        double areInInt = area * 100; //rounds the inputted km if necessary
        double areaWithTwo = (int)areInInt;
        double AreRounded = areaWithTwo / 100.0;

        double areInMiles = area / 2.59;

        double areMultip = areInMiles * 100;
        double areaMWithTwo = (int)areMultip;
        double areMRounded = areaMWithTwo / 100.0;

        System.out.println(AreRounded + "km^2 in mi^2 is " + areMRounded);
    }
    }
