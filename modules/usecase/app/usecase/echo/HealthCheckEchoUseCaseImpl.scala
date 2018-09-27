package usecase.echo

import contract.UseCaseContext
import contract.usecase.echo.HealthCheckEchoUseCase

import scala.concurrent.{ExecutionContext, Future}

/**
  * HealthCheckEchoUseCase.
  */
class HealthCheckEchoUseCaseImpl() extends HealthCheckEchoUseCase {
  override protected def call(arg: In)(implicit ec: ExecutionContext,
                                       uc: UseCaseContext): Future[Out] = Future {
    "200 OK"
  }
}
