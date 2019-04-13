package Domain;

import java.time.LocalDateTime;

public class CreditCard
{
    private String creditCard;
    private double fee;
    private double withdrawLimit;
    private LocalDateTime expirationDate;
    private double availableAmount;

    public CreditCard ()
    {

    }

    public CreditCard(String creditCard, double fee, double withdrawLimit, LocalDateTime expirationDate, double availableAmount)
    {
        this.creditCard = creditCard;
        this.fee = fee;
        this.withdrawLimit = withdrawLimit;
        this.expirationDate = expirationDate;
        this.availableAmount = availableAmount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(float withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(float availableAmount) {
        this.availableAmount = availableAmount;
    }

    public void withdrawFromCard(double amount){
        availableAmount -= amount;
    }
}
