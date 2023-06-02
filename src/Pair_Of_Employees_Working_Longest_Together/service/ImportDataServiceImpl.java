package Pair_Of_Employees_Working_Longest_Together.service;

import Pair_Of_Employees_Working_Longest_Together.entity.Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Pair_Of_Employees_Working_Longest_Together.constants.ApplicationConstants.FILE_PATH;
import static Pair_Of_Employees_Working_Longest_Together.constants.ApplicationConstants.NULL;

public class ImportDataServiceImpl implements ImportDataService{

    @Override
    public List<Project> importData() throws IOException {
        String data;
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));

        List<Project> projects = new ArrayList<>();

        while ((data = br.readLine()) != null) {
            if (data.trim().isEmpty()) {
                continue;
            }

            String[] splitData = data.split(", ");

            int empId = Integer.parseInt(splitData[0].trim());
            int projectId = Integer.parseInt(splitData[1].trim());
            LocalDate dateFrom = LocalDate.parse(splitData[2].trim());
            LocalDate dateTo = splitData[3].trim().equalsIgnoreCase(NULL)
                    ? LocalDate.now()
                    : LocalDate.parse(splitData[3].trim());

            projects.add(new Project(empId, projectId, dateFrom, dateTo));
        }
        return projects;
    }
}
