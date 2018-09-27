package adaptor.datasource.rdb

import scalikejdbc.DBSession

import wvlet.airframe._

/**
  * ADBModule.
  */
class ADBModule(implicit session: DBSession) {
  val design: Design =
    newDesign
}

/**
  * BDBModule.
  */
class BDBModule(implicit session: DBSession) {
  val design: Design =
    newDesign
}
