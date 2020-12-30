package de.pxav.kelp.core.connect.server;

import de.pxav.kelp.core.connect.connection.ConnectionProperties;

import java.net.InetSocketAddress;

/**
 * Functional interface used in server-creation to create
 * {@link ConnectionProperties properties} for specified child-connections.
 *
 * @author Etrayed
 * @see ConnectionProperties
 */
@FunctionalInterface
public interface ConnectionPropertiesFactory {

  ConnectionProperties createProperties(Server server, InetSocketAddress remoteAddress);
}
