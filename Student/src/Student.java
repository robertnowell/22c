
public class Student {
	private String name;
	private int id;
	private double gpa;
	
	public String get_name() {
		return name;
	}
	
	public int get_id() {
		return id;
	}
	
	public double get_gpa() {
		return gpa;
	}
	
	public void set_name(String new_name) {
		name = new_name;
	}
	
	public void set_id(int new_id) {
		id = new_id;
	}
	
	public void set_gpa(double new_gpa) {
		gpa = new_gpa;
	}
	
	public Student() {
		name = "";
		id = 0;
		gpa = 0;
	}

	public Student(String new_name, int new_id, double new_gpa) {
		name = new_name;
		id = new_id;
		gpa = new_gpa;
	}

	public String toString() {
		return "name: " + name + " gpa: " + gpa + "\n";
	}
	
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println(s1);
		
		Student s2 = new Student("test", 43, 34.2);
		System.out.println(s2);
	}
}


