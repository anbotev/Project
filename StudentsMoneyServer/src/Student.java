
public class Student {
	
	public String name;
	public double grade;
	public double amount;
	public int facNumber;
	public int numberOfAward;
	
	public Student(String name, double grade, double amount, int facNumber, int numberOfAward) {
		super();
		this.name = name;
		this.grade = grade;
		this.amount = amount;
		this.facNumber = facNumber;
		this.numberOfAward = numberOfAward;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getFaculty() {
		return facNumber;
	}
	public void setFaculty(int faculty) {
		this.facNumber = faculty;
	}
	public int getNumberOfAward() {
		return numberOfAward;
	}
	public void setNumberOfAward(int number) {
		this.numberOfAward = number;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", amount=" + amount + ", faculty=" + facNumber + "]";
	}
	
	
	

}
