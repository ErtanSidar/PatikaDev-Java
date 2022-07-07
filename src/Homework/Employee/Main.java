package Homework.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp= new Employee("Ertan Sidar", 2500, 50, 1997);
		emp.tax();
		emp.bonus();
		emp.raiseSalary();
		System.out.println(emp);
	}

}
