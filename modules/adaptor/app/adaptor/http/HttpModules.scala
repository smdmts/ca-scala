package adaptor.http

import adaptor.http.controller.echo._
import adaptor.http.presenter.echo._
import contract.usecase.echo.{DebugEchoUseCase, HealthCheckEchoUseCase}
import wvlet.airframe._

import scala.concurrent.ExecutionContext

/**
  * HttpModules.
  */
class HttpModules(implicit ec: ExecutionContext) {
  val design: Design =
    newDesign
      .bind[HealthCheckPresenter]
      .toEagerSingleton
      .bind[DebugEchoPresenter]
      .toEagerSingleton
      .bind[EchoController]
      .toInstanceProvider {
        (a: HealthCheckPresenter,
         b: HealthCheckEchoUseCase,
         c: DebugEchoUseCase,
         d: DebugEchoPresenter) =>
          EchoController(a, b, c, d)
      }
      .bind[HttpService]
      .toInstanceProvider { a: EchoController =>
        HttpService(a)
      }
}
