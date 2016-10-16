package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 22);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        System.out.println("Ordeno por nombre utilizando el comparador tradicional");

        Collections.sort(employees, new EmployeeComparatorByName());
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        System.out.println();
        System.out.println();
        System.out.println("Ordeno por edad utilizando una clase anónima");
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getAge().compareTo(employee2.getAge());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee.getAge());
        }

        System.out.println();
        System.out.println();
        System.out.println("Ordeno por nombre utilizando un lambda");
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        System.out.println();
        System.out.println();
        System.out.println("Ordeno por edad utilizando un Factory Comparator de Java 8");
        employees.sort(Comparator.comparing(Employee::getAge).
                thenComparing(Employee::getName));
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println();
        System.out.println();
        System.out.println("Ordeno por edad utilizando un Factory Comparator de Java 8  y hago un reverse");
        employees.sort(Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getName).reversed());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

}