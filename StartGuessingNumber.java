import java.util.*;


public class StartGuessingNumber{
    static int getPoint=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Guisser g=new Guisser();
        Player p=new Player();
        Result r=new Result();
         int flag=0;
        
        int limit=5;
        boolean b=true;
        while(b){
        System.out.println("1 for Start Game \n2 gor Exit Game");
            int c=sc.nextInt();

            if(c==1)
            {
                int gNumber=g.GuessingNumber();
                System.out.println(gNumber);
                
                while(limit!=0){
                
                int pNumber=p.TakeInput();
               
                getPoint +=r.compair(gNumber,pNumber,limit,0);
            
                limit--;
                }

                if(Result.noGuess==true)
                {
                    System.out.println("\nOpps Your loose the game,Your no one Guess are not correct ");
                    break;
                }else if(Result.noGuess==false)
                {
                    System.out.println("______________________________________________________\nYou got Point : "+getPoint);
                    b=false;
                    flag=1;
                    break;
                }
               
            }else if(c==2)
            {
                b=false;
            }else{
                System.out.println("Please check the Enter Choiss");
            }
        }
        if(b==false)
        {
            if(flag==0){
            System.out.println("\nYou are Exit from Game");
            }else if(flag==1)
            {
                System.out.println("\n----------------------------------");
                System.out.println("\nWell Played,Game End");
                System.out.println("\n----------------------------------");
            }
        }
        sc.close();
    }
}


class Guisser{
    Random rd=new Random();
   
    int GuessingNumber(){
        int gNumber=rd.nextInt(101);
        return gNumber;

    }
}

class Player{
    Scanner sc=new Scanner(System.in);
    int pNumber;

    int TakeInput(){
        System.out.println("Enter the Number(Guess):");
        pNumber=sc.nextInt();
        return pNumber;
    }
    
}

class Result{
   static boolean noGuess=true;
   
    int compair(int gNumber,int pNumber,int limit,int getPoint)
    {
        if(gNumber>pNumber)
        {
            System.out.println("Your Guess Number is Less than Generated Number");

        }else if(gNumber<pNumber)
        {
            System.out.println("Your Guess Number is Greater than Generated Number");

        }else if(gNumber==pNumber)
        {
            noGuess=false;
            System.out.println(limit);
            switch(limit){

                case 5:
                System.out.println("You get 50 Point");
                getPoint+=50;
                break;
                case 4:
                System.out.println("You get 40 Point");
                getPoint+=40;
                break;
                case 3:
                System.out.println("You get 30 Point");
                getPoint+=30;
                break;
                case 2:
                System.out.println("You get 20 Point");
                getPoint+=20;
                break;
                case 1:
                System.out.println("You get 10 Point");
                getPoint+=10;
                break;
            }
        }
        return getPoint;
   }
    
    
}