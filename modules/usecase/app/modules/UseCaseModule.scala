package modules

import usecase.echo._
import contract.usecase.echo._

import wvlet.airframe._

/**
  * UseCaseModule.
  */
class UseCaseModule {
  val design: Design =
    newDesign
      .bind[HealthCheckEchoUseCase]
      .to[HealthCheckEchoUseCaseImpl]
      .bind[DebugEchoUseCase]
      .to[DebugEchoUseCaseImpl]
}
