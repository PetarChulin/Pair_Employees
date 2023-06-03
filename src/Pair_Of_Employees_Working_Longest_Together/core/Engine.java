package Pair_Of_Employees_Working_Longest_Together.core;

import java.util.List;

import static Pair_Of_Employees_Working_Longest_Together.constants.ApplicationConstants.*;

public class Engine implements Runnable {

    private final List<String> commonProjects;
    private final List<String> getCommonProjects;

    public Engine(List<String> commonProjects, List<String> getCommonProjects) {
        this.commonProjects = commonProjects;
        this.getCommonProjects = getCommonProjects;
    }

    @Override
    public void run() {

        if (commonProjects.isEmpty()) {
            System.out.println(NO_TEAMS_MSG);
        } else {
            System.out.println(HEAD_INFO_MSG);
            System.out.println(DELIMITER);
            for (String commonProject : commonProjects) {
                System.out.println(commonProject);
            }
            System.out.println();
            System.out.println(LIST_INFO_MSG);
            System.out.println(DELIMITER);
            for (String getCommonProject : getCommonProjects) {
                System.out.println(getCommonProject);
            }
        }
    }
}
