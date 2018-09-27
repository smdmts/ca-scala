package adaptor.http.controller.echo

import adaptor.http._
import adaptor.http.presenter.echo._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.PathMatcher._
import akka.http.scaladsl.server.Route
import contract.usecase.echo.{DebugEchoUseCase, HealthCheckEchoUseCase}

import scala.concurrent.ExecutionContext

/**
  * Echo.
  */
case class EchoController(healthCheckPresenter: HealthCheckPresenter,
                          healthCheckUseCase: HealthCheckEchoUseCase,
                          debugEchoUseCase: DebugEchoUseCase,
                          debugEchoPresenter: DebugEchoPresenter)(implicit val ec: ExecutionContext)
    extends RequestSupport {

  /**
    * DebugRoutes.
    */
  val debugRoutes: Route = GET("debug") { implicit context =>
    complete {
      debugEchoPresenter.response(debugEchoUseCase.execute(Unit))
    }
  }

  /**
    * HealthCheckRoutes.
    */
  val healthCheckRoutes: Route = GET("healthcheck") { implicit ctx =>
    complete(healthCheckPresenter.response(healthCheckUseCase.execute(Unit)))
  }

  val route: Route = debugRoutes ~ healthCheckRoutes

}
