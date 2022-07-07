package Homework.Employee;

import java.util.Date;

public class Employee {
	
	String nameSurname;
	double salary;
    int workHours;
    int hireYear;
    
	public Employee(String nameSurname, double salary, int workHours, int hireYear) {
		super();
		this.nameSurname = nameSurname;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
	}
	
	public void tax() {
		if(this.salary<1000) {
			System.out.println("Vergi uygulamak için yeterli değildir");
		}else {
			System.out.println(salary*0.03 +" vergi uygulanmıştır");
		}
	}
	
	public void bonus() {
		if(workHours>40) {
			System.out.println((workHours-40)*30 +"tl bonus eklenmiştir");
		}
	}
	
	public void raiseSalary() {
		int newdate=new Date().getYear();
		if(newdate-hireYear<10) {
			salary=salary+salary*0.05;
			System.out.println("Yeni maaş :"+salary);
		}else if (newdate-hireYear>9 && newdate-hireYear<25) {
			salary=salary+salary*0.10;
			System.out.println("Yeni maaş :" +salary);
		}else {
			salary=salary+salary*0.15;
			System.out.println("Yeni maaş :" +salary);
		}
	}

	@Override
	public String toString() {
		return "Employee [nameSurname=" + nameSurname + ", salary=" + salary + ", workHours=" + workHours
				+ ", hireYear=" + hireYear + "]";
	}
	
}
