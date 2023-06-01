package Pair_Of_Employees_Working_Longest_Together.entity;

import java.time.LocalDate;

public class Project {
    private int empId;
    private int projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Project(int empId, int projectId, LocalDate dateFrom, LocalDate dateTo) {
        this.empId = empId;
        this.projectId = projectId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getEmpId() {
        return empId;
    }

    public int getProjectId() {
        return projectId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }
}