package nazotoki

/**
 * Game Player
 */
case class GamePlayer(name: String, isMale: Boolean, isMaster: Boolean, isMarried: Boolean, friends: List[String]) extends Player {

  override def toString = name

}


