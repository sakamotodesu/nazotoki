package controllers.nazotoki

/**
 * Game Player
 */
case class GamePlayer(name: String, isMale: Boolean, isMaster: Boolean, isMarried: Boolean) extends Player {

  override def toString = name

}


