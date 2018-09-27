package modules

import com.typesafe.config.Config
import conf.{AppConf, AwsConf, DBConf}
import wvlet.airframe._

import scala.concurrent.ExecutionContext

/**
  * OtherModule.
  */
class OtherModules(implicit ec: ExecutionContext, config: Config) {
  val design: Design =
    newDesign
      .bind[AppConf]
      .toInstance(new AppConf())
      .bind[AwsConf]
      .toInstanceProvider { a: AppConf =>
        AwsConf(a)
      }
      .bind[DBConf]
      .toInstanceProvider { a: AppConf =>
        DBConf(a)
      }
}
