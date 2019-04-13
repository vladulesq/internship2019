package Service;

import Domain.ATM;
import Domain.CreditCard;

import java.time.LocalDateTime;
import java.util.List;

public class ATMService
{
    private CreditCardService cardService;

    public ATMService (CreditCardService cardService)
    {
        this.cardService = cardService;
    }

    //Function that checks whether an ATM is open

    boolean isATMOpen(ATM ATM, LocalDateTime currentTime)
    {
        return  ATM != null && (currentTime.isAfter(ATM.getOpeningTime()) || currentTime.equals(ATM.getOpeningTime())) &&
                (currentTime.isBefore(ATM.getClosingTime()));
    }

    //Function that calculates the maximum withdrawable amount from an ATM

    private double maxWithdrawableAmountFromATM (ATM ATM, CreditCard card, double cashTillGoal)
    {
        double maxAmountFromCard = cardService.calculateMaxWithdrawnAmount(card);
        double maxAmountFromATM;

        if (maxAmountFromCard > ATM.getAmount())
            maxAmountFromATM = ATM.getAmount();
        else
            maxAmountFromATM = maxAmountFromCard;

        if (maxAmountFromATM > cashTillGoal)
            return cashTillGoal;
        else
            return maxAmountFromATM;
    }

    //Function that withdraws money from an ATM and returns the repective amount for later uses.

    double withdrawMoneyFromATM(ATM ATM, List<CreditCard> creditCards, LocalDateTime currentTime, double cashTillGoal)
    {
        List<CreditCard> usableCards = cardService.usableCreditCards(creditCards, currentTime);
        double totalMoney = 0.0;
        for (CreditCard card : usableCards)
        {
            if (cashTillGoal > 0)
            {
                 double moneyWithdrawnFromATM = cardService.withdrawMoneyFromCard(card, maxWithdrawableAmountFromATM(ATM, card, cashTillGoal));
                 ATM.setAmount(ATM.getAmount() - moneyWithdrawnFromATM);
                 totalMoney += moneyWithdrawnFromATM;
                 cashTillGoal -= totalMoney;
            }
        }
        return totalMoney;
    }
}
