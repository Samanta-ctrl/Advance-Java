package oar.org.CarProject;

public class CarTest
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("oar.org.CarProject.Car"); // fully qualified name of class car
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
