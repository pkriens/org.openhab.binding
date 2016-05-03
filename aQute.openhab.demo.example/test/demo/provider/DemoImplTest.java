package demo.provider;

import org.junit.Test;

import demo.api.Demo;

/*
 * Example JUNit test case
 * 
 */

public class DemoImplTest {

	/*
	 * Example test method
	 */

	@Test
	public void simple() {
		Demo impl = new DemoImpl();
		
		impl.say("Hello World");
	}

}
