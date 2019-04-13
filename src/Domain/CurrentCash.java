package Domain;

public class CurrentCash
{

    private double cashAmount;

    public CurrentCash()
    {
        this.cashAmount = 0.0;
    }

    public double getCashAmount()
    {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount)
    {
        this.cashAmount = cashAmount;
    }

    public void addWithdrawnAmount(double withdrawnAmount)
    {
        cashAmount += withdrawnAmount;
    }
}
