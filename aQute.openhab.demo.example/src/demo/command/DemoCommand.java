package demo.command;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import demo.api.Demo;
import osgi.enroute.debug.api.Debug;

/**
 * This is the implementation. It registers the Demo interface and calls it
 * through a Gogo command.
 * 
 */
@Component(service=DemoCommand.class, property = { Debug.COMMAND_SCOPE + "=demo",
		Debug.COMMAND_FUNCTION + "=demo" }, name="aQute.openhab.demo.command")
public class DemoCommand {
	private Demo target;

	public void demo(String message) {
		target.say(message);
	}

	@Reference
	void setDemo(Demo service) {
		this.target = service;
	}

}
