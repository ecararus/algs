package com.ecararus.algs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EmployeeHierarchy is a class with a main method that takes a sample employee list and prints out the employee
 * hierarchy.
 *
 *
 * Parsing the Employee Data: The parseEmployees method reads the employee data and creates a list of Employee records.
 * Building the Hierarchy: The buildHierarchy method constructs a map where each key is a boss's name and the value is a list of their subordinates.
 * Printing the Hierarchy: The printHierarchy method performs a depth-first traversal of the hierarchy tree, printing each employee's details with indentation to represent the hierarchy level.
 */
public class SimpleTreeTraversal {

    //each line contains the following comma separated fields for an employee:
    //name, boss' name, year started, job title
    public static final String employees =
                    "Ann, George, 2009, technical lead\n" +
                    "Bob, George, 2010, technical lead\n" +
                    "Charles, Bob, 2010, developer\n" +
                    "Diane, Bob, 2010, developer\n" +
                    "Emily, NONE, 2007, CEO\n" +
                    "Fred, Emily, 2008, chief marketing officer\n" +
                    "George, Emily, 2007, chief technology officer\n" +
                    "Harold, Ann, 2014, developer";

    /*
    Emily: CEO, 2007
    -Fred: chief marketing officer, 2008
    -George: chief technology officer, 2007
    --Ann: technical lead, 2009
    ---Harold: developer, 2014
    --Bob: technical lead, 2010
    ---Charles: developer, 2010
    ---Diane: developer, 2010
    */

    public static void main(String[] args) {
        List<Employee> employeeList = parseEmployees(employees);
        Map<String, List<Employee>> hierarchy = buildHierarchy(employeeList);
        printHierarchy(hierarchy, "NONE", 0);
    }

    private static List<Employee> parseEmployees(String employees) {
        List<Employee> employeeList = new ArrayList<>();
        String[] lines = employees.split("\n");
        for (String line : lines) {
            String[] parts = line.split(", ");
            employeeList.add(new Employee(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
        }
        return employeeList;
    }

    private static Map<String, List<Employee>> buildHierarchy(List<Employee> employeeList) {
        Map<String, List<Employee>> hierarchy = new HashMap<>();
        for (Employee employee : employeeList) {
            hierarchy.computeIfAbsent(employee.boss(), k -> new ArrayList<>()).add(employee);
        }
        return hierarchy;
    }

    private static void printHierarchy(Map<String, List<Employee>> hierarchy, String boss, int level) {
        if (!hierarchy.containsKey(boss)) return;
        for (Employee employee : hierarchy.get(boss)) {
            System.out.println("-".repeat(level) + employee.name() + ": " + employee.jobTitle() + ", " + employee.yearStarted());
            printHierarchy(hierarchy, employee.name(), level + 1);
        }
    }
}

record Employee(String name, String boss, int yearStarted, String jobTitle) {
}
