package external.akka

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.typesafe.config.Config

import scala.concurrent.ExecutionContextExecutor

/**
  * AkkaManager.
  */
class AkkaManager(implicit config: Config) {
  implicit val system: ActorSystem             = ActorSystem("am", config)
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor    = system.dispatcher
}
