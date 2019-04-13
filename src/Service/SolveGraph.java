package Service;

import Domain.ATM;
import Domain.CreditCard;
import Domain.CurrentCash;
import Domain.Path;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class SolveGraph
{
    private final static String STARTING_POSITION = "A";
    private final static double MONEY_GOAL = 7500;
    private ATMService ATMService;
    private PathService pathService;
    private List<CreditCard> allCreditCards;
    private List<Path> allPaths;
    private Map<String, ATM> allATMs;

    public SolveGraph(Service.ATMService ATMService, PathService pathService, List<CreditCard> allCreditCards, List<Path> allPaths, Map<String, ATM> allATMs)
    {
        this.ATMService = ATMService;
        this.pathService = pathService;
        this.allCreditCards = allCreditCards;
        this.allPaths = allPaths;
        this.allATMs = allATMs;
    }

    //Main function that solves the problem.

    public List<String> getAtmsRoute()
    {
        List<String> solution = new ArrayList<>();
        String ongoingLocation = STARTING_POSITION;
        CurrentCash cash = new CurrentCash();
        LocalDateTime startTime = LocalDateTime.of(2019, Month.MARCH, 19, 11, 30);

        while(cash.getCashAmount() < MONEY_GOAL)
        {
            double amountRemainingToBeExtracted = MONEY_GOAL - cash.getCashAmount();
            final LocalDateTime startTimeForThisWalk = startTime;
            final String startPositionForThisWalk = ongoingLocation;
            List<Path> allCandidatePaths = pathService.possiblePathsFromCurrentATM(allPaths, ongoingLocation);
            Optional<Path> computeMostEfficientPathToTheNextATM = allCandidatePaths.stream()
                    //First filter the paths that contain an open ATM and are linked to the start position
                    .filter(path -> ATMService.isATMOpen(allATMs.get(pathService.getATMFromPathAndCurrentATM(path, startPositionForThisWalk)), startTimeForThisWalk.plusMinutes(path.getDuration())))
                    //Now check which ATM is the closest to the current position
                    .min(Comparator.comparing(path -> startTimeForThisWalk.plusMinutes(path.getDuration())));
            String bestATM = pathService.getATMFromPathAndCurrentATM(computeMostEfficientPathToTheNextATM.get(), ongoingLocation);
            cash.addWithdrawnAmount(ATMService.withdrawMoneyFromATM(allATMs.get(bestATM), allCreditCards, startTimeForThisWalk, amountRemainingToBeExtracted));
            ongoingLocation = bestATM;
            solution.add(ongoingLocation);
            allATMs.remove(ongoingLocation);
            startTime = startTime.plusMinutes(computeMostEfficientPathToTheNextATM.get().getDuration());
            System.out.println("Visited " + bestATM + " at the hour " + startTime.getHour() + ":" + startTime.getMinute());
        }
        return solution;
    }
}
