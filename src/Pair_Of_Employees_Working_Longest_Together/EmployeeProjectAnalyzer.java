package Pair_Of_Employees_Working_Longest_Together;

import Pair_Of_Employees_Working_Longest_Together.entity.Project;

import java.io.IOException;
import java.util.*;

import static Pair_Of_Employees_Working_Longest_Together.constants.ApplicationConstants.*;
import static Pair_Of_Employees_Working_Longest_Together.service.FindService.findLongestWorkingPair;
import static Pair_Of_Employees_Working_Longest_Together.service.ImportDataServiceImpl.importData;

public class EmployeeProjectAnalyzer {

    public static void main(String[] args) throws IOException {

        List<Project> projects = importData();

        List<String> commonProjects = findLongestWorkingPair(projects);

        if (commonProjects.isEmpty()) {
            System.out.println(NO_TEAMS_MSG);
        } else {
            System.out.println(HEAD_INFO_MSG);
            System.out.println(DELIMITER);
            for (String commonProject : commonProjects) {
                System.out.println(commonProject);
            }
        }
    }
}



