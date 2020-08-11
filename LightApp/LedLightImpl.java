//Led light implementation logic:-

package oar.org.LightApp;

public class LedLightImpl implements Iswitch 
{

	@Override
	public void sOn() {
		System.out.println("Led light is tured on");
		
	}

	@Override
	public void sOff() {
		System.out.println("Led light is tured off");
		
	}

}
