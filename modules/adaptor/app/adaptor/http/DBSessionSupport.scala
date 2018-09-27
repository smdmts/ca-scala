package adaptor.http

import adaptor.datasource.rdb._
import scalikejdbc.DBSession
import wvlet.airframe._

/**
  * DBSessionSupport.
  */
trait ADBSessionSupport {
  def apply()(implicit session: DBSession): Design =
    new ADBModule().design
}

/**
  * DBSessionSupport.
  */
trait BDBSessionSupport {
  def apply()(implicit session: DBSession): Design =
    new BDBModule().design
}

case class ADBSessionModules() extends ADBSessionSupport
case class BDBSessionModules() extends BDBSessionSupport
