package org.ergoplatform.settings

import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ValueReader

/**
 * Settings related to state bootstrapping with UTXO set snapshots. See ergo.node.utxo section for settings description.
 */
case class UtxoSettings(utxoBootstrap: Boolean, storingUtxoSnapshots: Int, p2pUtxoSnapshots: Int)

/**
 * Custom settings reader for `UtxoSettings`
 */
trait UtxoSettingsReader {
  implicit val utxoSettingsReader: ValueReader[UtxoSettings] = { (cfg, path) =>
    UtxoSettings(
      cfg.as[Boolean](s"$path.utxoBootstrap"),
      cfg.as[Int](s"$path.storingUtxoSnapshots"),
      cfg.as[Int](s"$path.p2pUtxoSnapshots")
    )
  }
}