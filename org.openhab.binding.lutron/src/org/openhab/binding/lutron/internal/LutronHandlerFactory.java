/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.lutron.internal;

import static org.openhab.binding.lutron.LutronBindingConstants.THING_TYPE_DIMMER;
import static org.openhab.binding.lutron.LutronBindingConstants.THING_TYPE_IPBRIDGE;
import static org.openhab.binding.lutron.LutronBindingConstants.THING_TYPE_KEYPAD;
import static org.openhab.binding.lutron.LutronBindingConstants.THING_TYPE_OCCUPANCYSENSOR;
import static org.openhab.binding.lutron.LutronBindingConstants.THING_TYPE_SWITCH;

import java.util.Set;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.lutron.handler.DimmerHandler;
import org.openhab.binding.lutron.handler.IPBridgeHandler;
import org.openhab.binding.lutron.handler.KeypadHandler;
import org.openhab.binding.lutron.handler.OccupancySensorHandler;
import org.openhab.binding.lutron.handler.SwitchHandler;
import org.osgi.service.component.annotations.Component;

import com.google.common.collect.ImmutableSet;

/**
 * The {@link LutronHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Allan Tong - Initial contribution
 */
@Component
public class LutronHandlerFactory extends BaseThingHandlerFactory implements org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory{

    private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = ImmutableSet.of(THING_TYPE_IPBRIDGE,
            THING_TYPE_DIMMER, THING_TYPE_SWITCH, THING_TYPE_OCCUPANCYSENSOR, THING_TYPE_KEYPAD);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {

        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(THING_TYPE_IPBRIDGE)) {
            return new IPBridgeHandler((Bridge) thing);
        } else if (thingTypeUID.equals(THING_TYPE_DIMMER)) {
            return new DimmerHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_SWITCH)) {
            return new SwitchHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_OCCUPANCYSENSOR)) {
            return new OccupancySensorHandler(thing);
        } else if (thingTypeUID.equals(THING_TYPE_KEYPAD)) {
            return new KeypadHandler(thing);
        }

        return null;
    }
}
