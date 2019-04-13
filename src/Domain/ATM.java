package Domain;

import java.time.LocalDateTime;

public class ATM
{
    private String ATMName;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private double amount;

    public ATM ()
    {

    }

    public ATM(String ATMName, LocalDateTime openingTime, LocalDateTime closingTime)
    {
        this.ATMName = ATMName;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.amount  = 5000;
    }

    public String getATMName() {
        return ATMName;
    }

    public void setATMName(String ATMName) {
        this.ATMName = ATMName;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
