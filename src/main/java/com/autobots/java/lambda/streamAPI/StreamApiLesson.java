package com.autobots.java.lambda.streamAPI;

import com.autobots.java.lambda.LambdaLesson;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiLesson {
    public static void main(String[] args) {

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");

//        List<String> nameWithA = new ArrayList<>();
//        for (String name : names) {
//            if (name.startsWith("A")) {
//                nameWithA.add(name.toLowerCase());
//                Collections.sort(nameWithA);
//            }
//            System.out.println(nameWithA);

        List<String> result = names.stream()
                .filter(name1 -> name1.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
//int r1 = 0;
//for (int num : numbers){
//    r1 += num;
//}
//        System.out.println(r1);

//        int totalSum = numbers.stream()
//                .mapToInt(num -> num)// преобразует Integer в int
//                .sum();
//        System.out.println(totalSum);//21
//
//        int totalElements = (int) numbers.stream()
//                .count();
//        System.out.println(totalElements);//6
//
//        numbers.stream()
//                .min(Integer::compareTo)
//                .ifPresent(System.out::println);//1
//
//        List<String> list = List.of("one", "two", "three", "Hello", "four", "five");
//        list.stream()
//                .filter(s -> s.length() > 3)
//                .findFirst()
//                .ifPresent(System.out::println);


        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "IT"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT")
        );
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        employeesByDepartment.forEach((department, list) -> {
            System.out.println("Отдел " + department);
            list.forEach(System.out::println);
        });

        Map<String, List<Employee>> employeesByDepartment2 = new HashMap<>();
        for (Employee employee : employees){
            employeesByDepartment2.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employeesByDepartment2.get(employee.getDepartment()).add(employee);

        }
        System.out.println("###################################");
        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment2.entrySet()){
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
    }
}

//        List<Employee> itEmployee = employees.stream()
//                .filter(d -> d.getDepartment().equalsIgnoreCase("IT"))
//                .collect(Collectors.toList());
//        System.out.println(itEmployee);
//        System.out.println("----ForEach-----");
//        employees.stream()
//                .filter(d -> d.getDepartment().equalsIgnoreCase("IT"))
//                .forEach(System.out::println);
//
//        System.out.println("---------");
//
//        List<Employee> itEmployees2 = new ArrayList<>();
//        for(Employee employee : employees){
//            if(employee.getDepartment().equalsIgnoreCase("IT")){
//                itEmployees2.add(employee);
//            }
//        }
//        System.out.println(itEmployees2);
