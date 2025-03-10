package entities;

public class Employee {

		private Integer Id;
		private String name;
		private Double salary;
		
		public Employee() {};

		public Employee(Integer id, String name, Double salary) {
			super();
			Id = id;
			this.name = name;
			this.salary = salary;
		}

		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}
		
		public void increaseSalary(double percentage) {
			salary += salary * percentage / 100.0;
			
		}
		
		public String toString() {
			return Id + ", " + name + ", " + String.format("%.2f", salary);
		}
	
}
