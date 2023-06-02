package Pair_Of_Employees_Working_Longest_Together.service;

import Pair_Of_Employees_Working_Longest_Together.entity.Project;

import java.io.IOException;
import java.util.List;

public interface ImportDataService {

    List<Project> importData() throws IOException;

}
