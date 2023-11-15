package Main;

import InputUtil.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);//Scanner for reading input
        Currency[] currencies =     {new Currency("dollar", 10.74f),//Array of test-currencies
                                    new Currency("euro", 11.49f),
                                    new Currency("svenske kroner", .97f)};
        String currenciesPrompt = "Select currency('0' to exit):\n";//Prompt for selecting from available currencies
        for(int i = 0; i < currencies.length; i++)//building prompt with loop
        {
            currenciesPrompt += Integer.toString(i+1) + ". " + currencies[i].name + "\n";
        }
        String currenciesError = "You must enter a number between 0 and " + Integer.toString(currencies.length);//Error upon invalid currency choice

        byte programState = 0; //0: currency selection, 1: selection of conversion mode, 2: input of value to convert
        int selectedCurrency = -1;//Index of selected currency + 1
        int conversionMode = -1;//1 indicates to NOK, 2 indicates from NOK, 3 indicates reverting to main menu
        boolean running = true;//Main loop flag
        while(running)
        {
            switch(programState)//Main program loop
            {
                case 0://Presents menu of currencies
                    selectedCurrency = InputUtil.InputInt(currenciesPrompt, currenciesError, 0, currencies.length, sc);
                    if(selectedCurrency == 0) {running = false;}//Exit program if 0
                    else {programState = 1;}//Advance to conversion type selection
                    break;
                case 1://Presents menu of conversion to or from selected currency
                    conversionMode = InputUtil.InputInt("Please choose a conversion mode(0 to exit program):\n1. Convert from " + currencies[selectedCurrency - 1].name + " to NOK\n2. Convert from NOK to " + currencies[selectedCurrency - 1].name + "\n3. Revert to main menu",
                            "You must enter a number between 0 and 3", 0, 3, sc);
                    if(conversionMode == 0){running = false;}//Exit program if 0
                    else if(conversionMode == 3){programState = 0;}//Revert to main menu if 3
                    else{programState = 2;}//Advance to value input if mode chosen correctly
                    break;
                case 2://Take numerical input and print conversion
                    if(conversionMode == 1)//When converting to nok
                    {
                        float usrInput = InputUtil.InputFloat("Enter number of "+ currencies[selectedCurrency - 1].name + " to convert to NOK: ", "You must enter a valid decimal number.", sc);//Take input
                        System.out.println(Float.toString(usrInput) + " " + currencies[selectedCurrency - 1].name + " = " + Float.toString(usrInput * currencies[selectedCurrency-1].value) + " NOK");//Print result
                    }
                    else//When converting from NOK
                    {
                        float usrInput = InputUtil.InputFloat("Enter number of NOK to convert to " + currencies[selectedCurrency - 1].name + ": ", "You must enter a valid decimal number.", sc);//Take input
                        System.out.println(Float.toString(usrInput) + " NOK = " + Float.toString(usrInput / currencies[selectedCurrency-1].value) + " " + currencies[selectedCurrency - 1].name);//Print result
                    }
                    programState = 1;
                    break;//Otherwise repeat with programState still = 2
            }
        }
    }
}