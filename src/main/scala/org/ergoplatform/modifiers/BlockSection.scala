package org.ergoplatform.modifiers

import org.ergoplatform.settings.Algos
import scorex.core._

/**
  * An interface for Ergo block section which contains corresponding header id and a digest of its payload.
  */
trait BlockSection extends ErgoPersistentModifier {

  override lazy val id: ModifierId = BlockSection.computeId(modifierTypeId, headerId, digest)

  def digest: Array[Byte]

  def headerId: ModifierId
}

object BlockSection {
  def computeId(modifierType: ModifierTypeId, headerId: ModifierId, digest: Array[Byte]): ModifierId =
    bytesToId(Algos.hash.prefixedHash(modifierType, idToBytes(headerId), digest))
}
