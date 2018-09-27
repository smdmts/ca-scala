package adaptor.http

import adaptor.http.controller.echo._
import akka.http.scaladsl.server.Route

import scala.concurrent.ExecutionContext

/**
  * HttpService.
  */
case class HttpService(debugController: EchoController)(implicit ec: ExecutionContext)
    extends CorsSupport {
  val routes: Route = debugController.route
}
