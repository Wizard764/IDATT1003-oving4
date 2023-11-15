package Main;

public class Main
{
    public static void main(String[] args)
    {
        Player a = new Player();
        Player b = new Player();
        boolean running = true;
        int roundNumber = 0;
        while(running)
        {
            a.throwDie();
            b.throwDie();
            roundNumber++;
            System.out.println(Integer.toString(roundNumber) + ". A: " + Integer.toString(a.getSumPoints()) + " points. B: " + Integer.toString(b.getSumPoints()) + " points.");
            if(a.isFinished())
            {
                if(b.isFinished()) {System.out.println("It's a tie");}
                else {System.out.println("A wins");}
                running = false;
            }
            else
            {
                if(b.isFinished())
                {
                    System.out.println("B wins");
                    running = false;
                }
            }
        }
    }
}