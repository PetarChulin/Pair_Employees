package Pair_Of_Employees_Working_Longest_Together.service;

import Pair_Of_Employees_Working_Longest_Together.entity.Project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Pair_Of_Employees_Working_Longest_Together.constants.ApplicationConstants.BEST_TEAM_PATTERN;
import static Pair_Of_Employees_Working_Longest_Together.constants.ApplicationConstants.BEST_TEAM_PROJECTS_LIST;

public class FindServiceImpl implements FindService {


    @Override
    public List<String> findLongestWorkingPair(List<Project> projects) {
        Map<String, Integer> overlapDurations = new HashMap<>();
        Map<String, Integer> projectDurations = new HashMap<>();
        List<String> commonProjects = new ArrayList<>();

        calculateOverlapDurations(projects, overlapDurations, projectDurations);

        int maxDuration = calculateMaxDuration(overlapDurations);

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

    @Override
    public List<String> getCommonProjects(List<Project> separateProjects) {
        Map<String, Integer> overlapDurations = new HashMap<>();
        Map<String, Integer> projectDurations = new HashMap<>();
        List<String> commonProjectsList = new ArrayList<>();

        calculateOverlapDurations(separateProjects, overlapDurations, projectDurations);

        int maxDuration = calculateMaxDuration(overlapDurations);

        for (Map.Entry<String, Integer> entry : projectDurations.entrySet()) {
            if (overlapDurations.get(entry.getKey().substring(0, entry.getKey().lastIndexOf(","))) == maxDuration) {
                String[] keys = entry.getKey().split(",");
                int empId1 = Integer.parseInt(keys[0].trim());
                int empId2 = Integer.parseInt(keys[1].trim());
                int projectId = Integer.parseInt(keys[2].trim());
                int overlapDuration = entry.getValue();
                commonProjectsList.add(String.format(BEST_TEAM_PROJECTS_LIST, empId1, empId2, projectId, overlapDuration));
            }
        }
        return commonProjectsList;
    }

    private void calculateOverlapDurations(List<Project> projects,
                                           Map<String, Integer> overlapDurations,
                                           Map<String, Integer> projectDurations) {
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

                        int empId1 = project1.getEmpId();
                        int empId2 = project2.getEmpId();
                        int smallerEmpId = Math.min(empId1, empId2);
                        int largerEmpId = Math.max(empId1, empId2);

                        String pairKey = smallerEmpId + "," + largerEmpId;
                        overlapDurations.put(pairKey, overlapDurations.getOrDefault(pairKey, 0) + (int) duration);

                        String projectKey = pairKey + "," + project1.getProjectId();
                        projectDurations.put(projectKey, projectDurations.getOrDefault(projectKey, 0) + (int) duration);
                    }
                }
            }
        }
    }
    private int calculateMaxDuration(Map<String, Integer> overlapDurations) {
        int maxDuration = 0;
        for (int duration : overlapDurations.values()) {
            if (duration > maxDuration) {
                maxDuration = duration;
            }
        }
        return maxDuration;
    }
}


