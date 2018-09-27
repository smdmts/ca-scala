package adaptor.datasource.cache

import java.io.File

import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContext

/**
  * RDBTestModule.
  */
class RDBTestModule(implicit ec: ExecutionContext) {
  implicit val config =
    ConfigFactory.load(ConfigFactory.parseFileAnySyntax(new File("conf/application.conf")))
}
