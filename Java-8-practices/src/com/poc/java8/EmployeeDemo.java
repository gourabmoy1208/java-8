package com.poc.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeDemo {

	static List<Employee> employeeList = new ArrayList<Employee>();
	public static void main(String[] args) {
		
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		// Query 1 : How many male and female employees are there in the organization?
		
		getMaleAndFemaleEmployees();
		
		// Query 2 : Print the name of all departments in the organization?
		  
		printOrganization();
		
		// Query 3 : What is the average age of male and female employees?
		menAndWomenAverageAge();
		
		// Query 4 : Get the details of highest paid employee in the organization?
		maxPaidEmployee();
		// Query 5 : Get the names of all employees who have joined after 2015?
		getNamesAfter2015();
		// Query 6 : Count the number of employees in each department?
		countEmployeesPerOrg();
		// Query 8 : Get the details of youngest male employee in the product development department?
		youngestMaleInProdDev();
		// Query 9 : Who has the most working experience in the organization?
		firstEmployee();
		// Query 10 : How many male and female employees are there in the sales and marketing team?
		maleAndFemaleInSales();
		// Query 11 : What is the average salary of male and female employees?
		averagingSalary();
		// Query 12 : List down the names of all employees in each department?
		AllOrgAndEmpNames();
		// Query 13 : What is the average salary and total salary of the whole organization?
		totalAndAverageSalary();
		
		// Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
		Optional<Employee> maxAge = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		
		System.out.println(maxAge.get().getName());
		System.out.println(maxAge.get().getOrg());
		System.out.println(maxAge.get().getAge());
		
	}
	private static void totalAndAverageSalary() {
		DoubleSummaryStatistics summary =  employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Total Salary : "+summary.getSum());
		System.out.println("Average Salary : "+summary.getAverage());
	}
	private static void AllOrgAndEmpNames() {
		Map<String, List<Employee>> employeeListByDepartment=
				employeeList.stream().collect(Collectors.groupingBy(Employee::getOrg));
				         
				Set<Entry<String, List<Employee>>> entrySet = employeeListByDepartment.entrySet();
				         
				for (Entry<String, List<Employee>> entry : entrySet) 
				{
				    System.out.println("--------------------------------------");
				             
				    System.out.println("Employees In "+entry.getKey() + " : ");
				             
				    System.out.println("--------------------------------------");
				             
				    List<Employee> list = entry.getValue();
				             
				    for (Employee e : list) 
				    
				        System.out.println(e.getName());
				}
	}
	private static void averagingSalary() {
		Map<String, Double> averageSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(e -> e.getSalary())));
		averageSalary.forEach((a,b) -> System.out.println(a +":" + b));
	}
	private static void maleAndFemaleInSales() {
		Map<String,Long> countEmp = employeeList.stream().filter(e -> e.getOrg().equalsIgnoreCase("sales and marketing")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		
		countEmp.forEach((a,b) -> System.out.println(a + ":" +b));
	}
	private static void firstEmployee() {
		Optional<Employee> firstEmp = employeeList.stream().sorted(Comparator.comparingInt(Employee::getJoiningYear)).findFirst();
		
		System.out.println(firstEmp.get());
	}
	private static void youngestMaleInProdDev() {
		Optional<Employee> minEmp = employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("Male") && e.getOrg().equalsIgnoreCase("product development")).min(Comparator.comparingInt(Employee::getAge));
		System.out.println(minEmp.get());
	}
	private static void countEmployeesPerOrg() {
		employeeList.stream().collect(Collectors.groupingBy(Employee::getOrg,Collectors.counting())).forEach((a,b) -> System.out.println(a+" : " + b));
	}
	private static void getNamesAfter2015() {
		Map<String,List<Employee>> empNames = employeeList.stream().filter(e -> e.getJoiningYear()>2015).collect(Collectors.groupingBy(Employee::getName));
		
		empNames.forEach((a ,b) -> System.out.println( a));
	}
	private static void maxPaidEmployee() {
		Comparator<Employee> maxEmp = Comparator.comparing(Employee::getSalary);
		Optional<Employee> maxEmployee = employeeList.stream().max(maxEmp);
		System.out.println("maxEmployee : "+maxEmployee.get().getName());
	}
	private static void menAndWomenAverageAge() {
		Map<String,Double> empAverageAge =employeeList.stream().collect(Collectors.groupingBy(emp -> emp.getGender(),Collectors.averagingInt(emp -> emp.getAge())));
		empAverageAge.forEach((a,b) -> System.out.println(a +":"+b));
	}
	private static void printOrganization() {
		List<String> empOrg = employeeList.stream().map(emp -> emp.getOrg()).distinct().collect(Collectors.toList());
		empOrg.forEach(emp -> System.out.println("Employee Organization : "+emp));
	}
	private static void getMaleAndFemaleEmployees() {
		Long maleEmployees =  employeeList.stream().filter(emp -> emp.getGender().equalsIgnoreCase("Male")).count();
		Long femaleEmployees =  employeeList.stream().filter(emp -> emp.getGender().equalsIgnoreCase("Female")).count();
		
		System.out.println("maleEmployees : " +maleEmployees + "&& femaleEmployees: "+femaleEmployees);
	}

}
