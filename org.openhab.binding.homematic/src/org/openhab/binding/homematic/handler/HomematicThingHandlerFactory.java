/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.homematic.handler;

import static org.openhab.binding.homematic.HomematicBindingConstants.BINDING_ID;
import static org.openhab.binding.homematic.HomematicBindingConstants.THING_TYPE_BRIDGE;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.homematic.type.HomematicTypeGenerator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The {@link HomematicThingHandlerFactory} is responsible for creating thing and bridge handlers.
 *
 * @author Gerhard Riegler - Initial contribution
 */
@Component
public class HomematicThingHandlerFactory extends BaseThingHandlerFactory implements org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory{
    private HomematicTypeGenerator typeGenerator;

    @Reference
    protected void setTypeGenerator(HomematicTypeGenerator typeGenerator) {
        this.typeGenerator = typeGenerator;
    }

    protected void unsetTypeGenerator(HomematicTypeGenerator typeGenerator) {
        this.typeGenerator = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return BINDING_ID.equals(thingTypeUID.getBindingId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ThingHandler createHandler(Thing thing) {
        if (THING_TYPE_BRIDGE.equals(thing.getThingTypeUID())) {
            return new HomematicBridgeHandler((Bridge) thing, typeGenerator);
        } else {
            return new HomematicThingHandler(thing);
        }
    }

}
