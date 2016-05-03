/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.freebox.internal;

import static org.openhab.binding.freebox.FreeboxBindingConstants.FREEBOX_THING_TYPE_SERVER;

import java.util.Collections;
import java.util.Set;

import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory;
import org.openhab.binding.freebox.handler.FreeboxHandler;
import org.osgi.service.component.annotations.Component;

/**
 * The {@link FreeboxHandlerFactory} is responsible for creating things and thing 
 * handlers.
 * 
 * @author Gaël L'hopital - Initial contribution
 */
@Component
public class FreeboxHandlerFactory extends BaseThingHandlerFactory implements ThingHandlerFactory {
    
    private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections.singleton(FREEBOX_THING_TYPE_SERVER);
    
    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {

        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(FREEBOX_THING_TYPE_SERVER)) {
            return new FreeboxHandler(thing);
        }

        return null;
    }
}

