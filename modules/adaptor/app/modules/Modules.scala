package modules

import adaptor.http.HttpModules
import com.typesafe.config.Config
import external.akka.{AkkaManager, AkkaModules}
import wvlet.airframe._

import scala.concurrent.ExecutionContext

/**
  * Modules.
  */
object Modules {

  def akkaModules()(implicit config: Config): Design = {
    new AkkaModules().design
  }

  def apply()(implicit ec: ExecutionContext, config: Config): Design = {
    val modules = new OtherModules().design + new HttpModules().design + new UseCaseModule().design
    staticModulesOpt = Some(modules)
    modules
  }

  private var staticModulesOpt: Option[Design] = None

  def staticModules = staticModulesOpt.get
}
