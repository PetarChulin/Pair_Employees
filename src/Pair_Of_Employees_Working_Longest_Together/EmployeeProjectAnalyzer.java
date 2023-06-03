package Pair_Of_Employees_Working_Longest_Together;

import Pair_Of_Employees_Working_Longest_Together.core.Engine;
import Pair_Of_Employees_Working_Longest_Together.entity.Project;
import Pair_Of_Employees_Working_Longest_Together.service.FindServiceImpl;
import Pair_Of_Employees_Working_Longest_Together.service.ImportDataServiceImpl;

import java.io.IOException;
import java.util.*;


public class EmployeeProjectAnalyzer {

    public static void main(String[] args) throws IOException {

        ImportDataServiceImpl importDataService = new ImportDataServiceImpl();
        List<Project> projects = importDataService.importData();

        FindServiceImpl findService = new FindServiceImpl();
        List<String> commonProjects = findService.findLongestWorkingPair(projects);
        List<String> getCommonProjects = findService.getCommonProjects(projects);

        Engine engine = new Engine(commonProjects, getCommonProjects);
        engine.run();

    }
}



