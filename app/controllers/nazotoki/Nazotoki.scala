package controllers.nazotoki

/**
 * grouping tool
 */
object Nazotoki {

  def flatMapSublists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail) map {
        sl.head :: _
      }
    }

  def group[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
    case Nil => List(Nil)
    case n :: nss => combinations(n, ls) flatMap { c =>
      group(nss, ls.filterNot(c.contains(_))) map {
        c :: _
      }
    }
  }

  def balance(ns: List[Int], ls: List[GamePlayer], friends: List[(GamePlayer, GamePlayer)]): List[List[List[GamePlayer]]] = group(ns, ls)
          .filter(_.forall(x => containMaster(x)))
          .filter(_.forall(x => mixGender(x)))
          .filter(_.forall(x => checkFriends(x, friends)))
          .filter(_.forall(x => married(x)))
          .filter(_.forall(x => pair(x, "shutyou", "yukari")))
          //.filter(_.forall(x => pair(x, "shutyou", "yukkiy")))
          .map(x => x.map(y => y.sortWith((a, b) => a.name > b.name))
          .sortWith((a, b) => a(0).name > b(0).name))
          .distinct


  def containMaster(ls: List[GamePlayer]) = ls.exists(_.isMaster)

  def mixGender(ls: List[GamePlayer]) = ls.exists(_.isMale) && ls.exists(!_.isMale)

  def married(ls: List[GamePlayer]) = ls.forall(_.isMarried) || (ls.filter(_.isMale).exists(!_.isMarried) && ls.filter(!_.isMale).exists(!_.isMarried))

  def checkFriends(ls: List[GamePlayer], friends: List[(GamePlayer, GamePlayer)]) = ls.forall(x => getFriends(x, friends).exists(s => ls.contains(s)))

  def getFriends(player: GamePlayer, relay: List[(GamePlayer, GamePlayer)]) = (relay.filter(_._1 == player).map(_._2) ::: relay.filter(_._2 == player).map(_._1))
          .sortWith((a, b) => a.name > b.name).distinct


  def pair(ls: List[GamePlayer], boy: String, girl: String) =
    if (ls.exists(_.name == boy)) ls.exists(_.name == girl)
    else if (ls.exists(_.name == girl)) ls.exists(_.name == boy)
    else true
}
