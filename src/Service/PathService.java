package Service;

import Domain.Path;

import java.util.List;
import java.util.stream.Collectors;

public class PathService
{

    //Function that checks whether the current position exists in the given path between two ATM's.

    private boolean existsDirectPath(Path path, String currentATM)
    {
        return currentATM.equals(path.getTo()) || currentATM.equals(path.getFrom());
    }

    //Function that returns a list of paths that contain the current ATM.

    List<Path> possiblePathsFromCurrentATM(List<Path> paths, String currentATM)
    {
        return paths.stream().filter(path -> existsDirectPath(path, currentATM)).collect(Collectors.toList());
    }

    //Function that returns the ATM from a path and a current ATM

    String getATMFromPathAndCurrentATM(Path path, String currentATM)
    {
        if (path.getTo().equals(currentATM))
            return path.getFrom();
        else
            return path.getTo();
    }




}
