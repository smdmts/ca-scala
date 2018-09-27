package domain.campaign

case class CampaignId(value: Long) extends AnyVal

case object CampaignId {
  implicit def a(num: Long): CampaignId   = CampaignId(num)
  implicit def b(state: CampaignId): Long = state.value
}
