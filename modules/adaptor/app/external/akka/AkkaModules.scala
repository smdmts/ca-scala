package external.akka

import com.typesafe.config.Config
import wvlet.airframe._

/**
  * AkkaModule.
  */
class AkkaModules(implicit config: Config) {
  val design: Design =
    newDesign
      .bind[AkkaManager]
      .toInstance(new AkkaManager())
}
