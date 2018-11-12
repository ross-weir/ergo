package org.ergoplatform.settings

import org.ergoplatform.mining.PowScheme
import scorex.util.ModifierId

import scala.concurrent.duration.FiniteDuration

/**
  * Configuration file for Ergo chain
  * @see src/main/resources/application.conf for parameters description
  */
case class ChainSettings(addressPrefix: Byte,
                         blockInterval: FiniteDuration,
                         votingLength: Int,
                         epochLength: Int,
                         useLastEpochs: Int,
                         powScheme: PowScheme,
                         monetary: MonetarySettings,
                         genesisId: Option[ModifierId] = None)
