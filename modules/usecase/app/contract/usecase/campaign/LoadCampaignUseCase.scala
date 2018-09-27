package contract.usecase.campaign

import contract.{PushPort, UseCase}
import domain.campaign.{Campaign, CampaignId}

trait LoadCampaignUseCase extends UseCase with PushPort[CampaignId, Campaign]
