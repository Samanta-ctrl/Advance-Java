//Consumer or Utilization logic:-

package oar.org.LightApp;

import java.util.Scanner;

public class Test 
{
	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter light type");
		String type=scn.next();
		scn.close(); //as scanner class is costly resource thats why we need to 
					//close the scanner class object to improve the performance (recommended but not mandatory)
		
		Iswitch sw=LightFatory.getLight(type);
		if(sw!=null)
		{
			sw.sOn();
			sw.sOff();
		}
	}
}
