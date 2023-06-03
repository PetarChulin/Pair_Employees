package Pair_Of_Employees_Working_Longest_Together.service;

import Pair_Of_Employees_Working_Longest_Together.entity.Project;

import java.util.List;

public interface FindService {

    List<String> findLongestWorkingPair(List<Project> projects);
    List<String> getCommonProjects(List<Project> separateProjects);
}
