import java.util.GregorianCalendar;
abstract public class Person {
	public String firstName;
	public String lastName;
	private GregorianCalendar dateOfBirth;
	public String gender;
	public boolean isMarried;
	protected String aadharNo;
	protected String PANNo;
	
	public void setDOB(GregorianCalendar dob)
	{
		dateOfBirth = dob;
	}
	public GregorianCalendar getDOB()
	{
		return dateOfBirth;
	}
	public void changeMaritalStatus(boolean m)
	{
		isMarried = m;
	}
	abstract public void exercise(int calories);
	abstract public void work();
	public final void sleep(int noOfHrs)
	{
		if (noOfHrs < 8)
			System.out.println("A person should ideally sleep for 8 hours every night.");
		else
			System.out.println("You have a healthy habit! Keep it up!");
	}
}

