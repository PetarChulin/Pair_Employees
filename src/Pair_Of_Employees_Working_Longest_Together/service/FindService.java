package Pair_Of_Employees_Working_Longest_Together.service;

import Pair_Of_Employees_Working_Longest_Together.entity.Project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Pair_Of_Employees_Working_Longest_Together.constants.ApplicationConstants.BEST_TEAM_PATTERN;

public class FindService{

    public static List<String> findLongestWorkingPair(List<Project> projects) {
        Map<String, Integer> overlapDurations = new HashMap<>();
        List<String> commonProjects = new ArrayList<>();

        for (int i = 0; i < projects.size() - 1; i++) {
            for (int j = i + 1; j < projects.size(); j++) {
                Project project1 = projects.get(i);
                Project project2 = projects.get(j);

                if (project1.getProjectId() == project2.getProjectId()) {
                    LocalDate overlapStartDate = project1.getDateFrom().isAfter(project2.getDateFrom())
                            ? project1.getDateFrom()
                            : project2.getDateFrom();
                    LocalDate overlapEndDate = project1.getDateTo().isBefore(project2.getDateTo())
                            ? project1.getDateTo()
                            : project2.getDateTo();

                    long duration = ChronoUnit.DAYS.between(overlapStartDate, overlapEndDate);
                    if (duration > 0) {
                        String pairKey = project1.getEmpId() + "," + project2.getEmpId();
                        overlapDurations.put(pairKey, overlapDurations.getOrDefault(pairKey, 0) + (int) duration);
                    }
                }
            }
        }

        int maxDuration = 0;
        for (int duration : overlapDurations.values()) {
            if (duration > maxDuration) {
                maxDuration = duration;
            }
        }

        for (Map.Entry<String, Integer> entry : overlapDurations.entrySet()) {
            if (entry.getValue() == maxDuration) {
                String[] pair = entry.getKey().split(",");
                int empId1 = Integer.parseInt(pair[0].trim());
                int empId2 = Integer.parseInt(pair[1].trim());
                commonProjects.add(String.format(BEST_TEAM_PATTERN, empId1, empId2, maxDuration));
            }
        }
        return commonProjects;
    }

 }
