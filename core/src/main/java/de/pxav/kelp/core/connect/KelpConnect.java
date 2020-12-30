package de.pxav.kelp.core.connect;

import com.google.inject.Inject;
import de.pxav.kelp.core.connect.connection.Connection;
import de.pxav.kelp.core.connect.connection.ConnectionHolder;
import de.pxav.kelp.core.connect.connection.ConnectionProperties;
import de.pxav.kelp.core.connect.server.Server;
import de.pxav.kelp.core.connect.server.ServerProperties;

import java.util.Collections;
import java.util.List;

/**
 *
 * Base Class which unites all features of KelpConnect.
 *
 * @author Etrayed
 */
public class KelpConnect {

  /**
   * The versionTemplate used to access the version-specific stuff.
   */
  private final KelpConnectVersionTemplate versionTemplate;

  /**
   * This {@link ConnectionHolder} instance holds all connections ever created by this instance.
   */
  private final ConnectionHolder connectionHolder;

  @Inject
  public KelpConnect(KelpConnectVersionTemplate versionTemplate) {
    this.versionTemplate = versionTemplate;
    this.connectionHolder = new ConnectionHolder();
  }

  /**
   * Creates a new {@link Connection} instance which is bound to the local {@link #connectionHolder}.
   *
   * @param properties Properties for the connection. ChannelOptions for example.
   * @return A newly created connection.
   */
  public Connection createConnection(ConnectionProperties properties) {
    return new Connection(versionTemplate, connectionHolder, properties);
  }

  /**
   * Creates a new {@link Server} instance.
   *
   * @param properties Properties for the server. ChannelOptions for example.
   * @return A newly created server.
   */
  public Server createServer(ServerProperties properties) {
    return new Server(versionTemplate, properties);
  }

  /**
   * Lists all connections ever created by this instance.
   *
   * @return A {@link List} of all active {@link Connection connections} ever created by this class.
   */
  public List<Connection> getRegisteredConnections() {
    return Collections.unmodifiableList(connectionHolder.getRegisteredConnections());
  }

  /**
   * Checks if a {@link Connection connection} was created by this instance.
   *
   * @param connection The connection to check.
   * @return If the connection was created by this instance, {@code false} otherwise.
   */
  public boolean isConnectionRegistered(Connection connection) {
    return connectionHolder.isRegistered(connection);
  }

  /**
   * Closes all active connections created by this instance.
   */
  public void closeAllConnections() {
    connectionHolder.closeAll();
  }
}
