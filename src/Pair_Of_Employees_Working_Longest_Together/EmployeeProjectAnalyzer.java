package Pair_Of_Employees_Working_Longest_Together;

import Pair_Of_Employees_Working_Longest_Together.core.Engine;
import Pair_Of_Employees_Working_Longest_Together.entity.Project;

import java.io.IOException;
import java.util.*;

import static Pair_Of_Employees_Working_Longest_Together.service.FindService.findLongestWorkingPair;
import static Pair_Of_Employees_Working_Longest_Together.service.ImportDataServiceImpl.importData;

public class EmployeeProjectAnalyzer {

    public static void main(String[] args) throws IOException {

        List<Project> projects = importData();

        List<String> commonProjects = findLongestWorkingPair(projects);

        Engine engine = new Engine(commonProjects);
        engine.run();

    }
}



