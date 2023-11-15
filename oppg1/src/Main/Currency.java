package Main;

public class Currency
{
    String name;
    float value;

    Currency(String name, float value)//parameter value in NOK
    {
        this.name = name;
        this.value = value;
    }

    float toNOK(float num)//Convert input number to NOK
    {
        return num * value;
    }

    float fromNOK(float num)//Convert input number to this
    {
        return num / value;
    }
}