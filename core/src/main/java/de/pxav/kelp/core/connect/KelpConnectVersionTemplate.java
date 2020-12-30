package de.pxav.kelp.core.connect;

import de.pxav.kelp.core.application.KelpVersionTemplate;
import de.pxav.kelp.core.connect.packet.IPacketDecoder;
import de.pxav.kelp.core.connect.packet.IPacketEncoder;
import de.pxav.kelp.core.connect.packet.PacketRegistry;

import javax.crypto.Cipher;

/**
 * VersionTemplate for KelpConnect. It provides
 * version-specific channel handlers.
 *
 * @author Etrayed
 * @see IPacketEncoder
 * @see IPacketDecoder
 */
@KelpVersionTemplate
public abstract class KelpConnectVersionTemplate {

  /**
   * Creates a new {@link IPacketEncoder encoder}.
   *
   * @param registry  The packet registry which provides all the ids.
   * @param encrypter The {@link Cipher} used to encrypt data, {@code null} for no encryption.
   * @return A new {@link IPacketEncoder encoder}.
   */
  public abstract IPacketEncoder newPacketEncoder(PacketRegistry registry, Cipher encrypter);

  /**
   * Creates a new {@link IPacketDecoder decoder}.
   *
   * @param registry  The packet registry which provides all the {@link de.pxav.kelp.core.connect.packet.Packet}-classes.
   * @param decrypter The {@link Cipher} used to decrypt data, {@code null} for no decryption.
   * @return A new {@link IPacketDecoder decoder}.
   */
  public abstract IPacketDecoder newPacketDecoder(PacketRegistry registry, Cipher decrypter);
}
