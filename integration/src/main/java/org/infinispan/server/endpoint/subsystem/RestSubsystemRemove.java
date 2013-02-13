/*
 * Copyright 2011 Red Hat, Inc. and/or its affiliates.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA
 */
package org.infinispan.server.endpoint.subsystem;

import java.util.Locale;

import org.jboss.as.controller.AbstractRemoveStepHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.as.controller.descriptions.DescriptionProvider;
import org.jboss.dmr.ModelNode;

/**
 * RestSubsystemRemove.
 *
 * @author Tristan Tarrant
 * @since 6.0
 */
public class RestSubsystemRemove extends AbstractRemoveStepHandler implements DescriptionProvider {

   static final RestSubsystemRemove INSTANCE = new RestSubsystemRemove();

   @Override
   protected void performRuntime(OperationContext context, ModelNode operation, ModelNode model)
            throws OperationFailedException {
      context.removeService(EndpointUtils.getServiceName(operation, "rest"));
   }

   @Override
   public ModelNode getModelDescription(Locale locale) {
      return EndpointSubsystemProviders.REMOVE_REST_CONNECTOR_DESC.getModelDescription(locale);
   }

}