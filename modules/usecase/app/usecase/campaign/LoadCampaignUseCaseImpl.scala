package usecase.campaign

import contract.UseCaseContext
import contract.usecase.campaign.LoadCampaignUseCase
import domain.campaign.CampaignRepository
import logger.LogSupport
import wvlet.airframe._
import wvlet.surface.tag._

import scala.concurrent.{ExecutionContext, Future}

/**
  * LoadCampaignUseCase.
  */
case class LoadCampaignUseCaseImpl() extends LoadCampaignUseCase with LogSupport {
  val aRepository: CampaignRepository = bind[CampaignRepository @@ String]
  val bRepository: CampaignRepository = bind[CampaignRepository @@ String]

  override protected def call(arg: In)(implicit ec: ExecutionContext,
                                       uc: UseCaseContext): Future[Out] = Future {
    // get from a or b db
    Seq(aRepository.resolveBy(arg), bRepository.resolveBy(arg)).flatten.headOption
      .getOrElse(sys.error("could not find campaign"))
  }

}
