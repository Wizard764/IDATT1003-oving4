package Main;
import java.util.Random;
public class Player
{
    private int sumPoints = 0;
    java.util.Random die = new Random();
    int getSumPoints(){return sumPoints;}
    void throwDie()
    {
        int dieThrow = die.nextInt(6) + 1;
        if(dieThrow == 1)
        {
            sumPoints = 0;
        }
        else
        {
            sumPoints += dieThrow;
        }
    }
    boolean isFinished(){return sumPoints >= 100;}
}