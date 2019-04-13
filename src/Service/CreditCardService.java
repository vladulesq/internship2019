package Service;

import Domain.CreditCard;
import Domain.Exception.CreditCardException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCardService
{

    //This is the function that checks which credit cards are usable.
    //First we filter out those that still have money on them and then we check if the expiration date is after the current date.
    //We then sort the cards based on the comission fee, since the person wants to use the card with the least fee as many times as he can.

    List<CreditCard> usableCreditCards(List<CreditCard> creditCards, LocalDateTime currentDateAndTime)
    {
        return creditCards.stream().filter(creditCard -> creditCard.getAvailableAmount() > 0)
                                   .filter(creditCard -> creditCard.getExpirationDate().isAfter(currentDateAndTime))
                                   .sorted(Comparator.comparing(creditCard -> creditCard.getFee()))
                                   .collect(Collectors.toList());
    }

    //Function that calculates the maximum amount of cash that can be withdrawn from a card

    double calculateMaxWithdrawnAmount(CreditCard card)
    {
        if (card.getAvailableAmount() > card.getWithdrawLimit())
            return card.getWithdrawLimit();
        else
            return card.getAvailableAmount();
    }

    //Function that withdraws money from the card and returns the respective withdrawn amount for later uses

    double withdrawMoneyFromCard(CreditCard card, double withdrawnAmount)
    {
        double comission = (card.getFee()/100) * withdrawnAmount;
        double totalSumDepleted = comission + withdrawnAmount;
        if (totalSumDepleted > card.getAvailableAmount())
        {
            throw new CreditCardException("The sum you wish to withdraw is higher than the money left on your card. Please enter another sum!");
        }
        else
        {
            card.withdrawFromCard(totalSumDepleted);
        }
        return totalSumDepleted;
    }
}
