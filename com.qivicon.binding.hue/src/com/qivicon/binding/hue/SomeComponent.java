package com.qivicon.binding.hue;

import org.openhab.binding.hue.internal.HueActivator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.EventAdmin;

@Component
public class SomeComponent {

	@Reference
	EventAdmin ea;
	
		HueActivator axx;
}
