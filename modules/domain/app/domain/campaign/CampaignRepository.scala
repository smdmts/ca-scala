package domain.campaign

trait CampaignRepository {
  def resolveBy(id: CampaignId): Option[Campaign]
}
