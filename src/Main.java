import Domain.ATM;
import Domain.CreditCard;
import Domain.Path;
import Service.ATMService;
import Service.CreditCardService;
import Service.PathService;
import Service.SolveGraph;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class Main
{
    public static void main(String args[]) {
        CreditCardService cardService = new CreditCardService();
        ATMService ATMService = new ATMService(cardService);
        PathService pathService = new PathService();
        List<Path> allPaths = new ArrayList<>();
        List<CreditCard> allCards = new ArrayList<>();
        Map<String, ATM> allATMs = new HashMap<>();

        //Creating and adding the credit cards

        CreditCard card1 = new CreditCard("SILVER", 0.2, 4500, LocalDateTime.of(2020, Month.MAY, 22, 23, 59, 59), 20000);
        CreditCard card2 = new CreditCard("GOLD", 0.1, 3000, LocalDateTime.of(2018, Month.AUGUST, 14, 23, 59, 59), 25000);
        CreditCard card3 = new CreditCard("PLATINUM", 0.0, 4000, LocalDateTime.of(2019, Month.MARCH, 19, 23, 59, 59), 3000);
        allCards.add(card1);
        allCards.add(card2);
        allCards.add(card3);

        //Creating and adding the ATM's

        ATM ATM1 = new ATM("ATM1", LocalDateTime.of(2019, Month.MARCH, 19, 12, 0, 0), LocalDateTime.of(2019, Month.MARCH, 19, 18, 0, 0));
        ATM ATM2 = new ATM("ATM2", LocalDateTime.of(2019, Month.MARCH, 19, 10, 0, 0), LocalDateTime.of(2019, Month.MARCH, 19, 17, 0, 0));
        ATM ATM3 = new ATM("ATM3", LocalDateTime.of(2019, Month.MARCH, 18, 22, 0, 0), LocalDateTime.of(2019, Month.MARCH, 19, 12, 0, 0));
        ATM ATM4 = new ATM("ATM4", LocalDateTime.of(2019, Month.MARCH, 19, 17, 0, 0), LocalDateTime.of(2019, Month.MARCH, 20, 1, 0, 0));
        allATMs.put("ATM1", ATM1);
        allATMs.put("ATM2", ATM2);
        allATMs.put("ATM3", ATM3);
        allATMs.put("ATM4", ATM4);

        //Creating and adding the paths

        Path path1 = new Path("A", "ATM1", 5);
        Path path2 = new Path("A", "ATM2", 60);
        Path path3 = new Path("A", "ATM3", 30);
        Path path4 = new Path("A", "ATM4", 45);
        Path path5 = new Path("ATM1", "ATM2", 40);
        Path path6 = new Path("ATM1", "ATM4", 45);
        Path path7 = new Path("ATM2", "ATM3", 15);
        Path path8 = new Path("ATM3", "ATM1", 40);
        Path path9 = new Path("ATM3", "ATM4", 15);
        Path path10 = new Path("ATM4", "ATM2", 30);
        allPaths.add(path1);
        allPaths.add(path2);
        allPaths.add(path3);
        allPaths.add(path4);
        allPaths.add(path5);
        allPaths.add(path6);
        allPaths.add(path7);
        allPaths.add(path8);
        allPaths.add(path9);
        allPaths.add(path10);

        SolveGraph solution = new SolveGraph(ATMService, pathService, allCards, allPaths, allATMs);
        List<String> listOfATMs = solution.getAtmsRoute();
        System.out.println(listOfATMs);


    }
}
