import adaptor.http.HttpService
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.{Config, ConfigFactory}
import external.akka.AkkaManager
import modules.Modules
import wvlet.airframe.Design

import scala.concurrent.ExecutionContextExecutor

/**
  * BootStrap.
  */
object Bootstrap extends App {

  implicit val config: Config = loadConfig()

  // init first akka system.
  Modules.akkaModules().build[AkkaManager] { actorManager =>
    implicit val system: ActorSystem          = actorManager.system
    implicit val ec: ExecutionContextExecutor = actorManager.ec
    implicit val mat: ActorMaterializer       = actorManager.materializer
    implicit val design: Design               = Modules()
    val session                               = design.newSession
    try {
      session.start
      val service = session.build[HttpService]
      // initialize db.
      // val dbConfig = inject[DBConf]
      // dbConfig.initialize()
      // refreshable after initialized db.
      // CacheModules.refresh()

      Http().bindAndHandle(service.routes, "127.0.0.1", 8080)

    } finally {
      session.shutdown
    }
  }

  def loadConfig(): Config = {
    val conf = System.getProperties
    val base = ConfigFactory.load()
    val addition = Option(conf.getProperty("config.resource")).map { resource =>
      ConfigFactory.parseResources(getClass.getClassLoader, resource)
    } getOrElse {
      ConfigFactory.parseResources(getClass.getClassLoader, "application.conf")
    }
    base.withFallback(addition)
  }

}
