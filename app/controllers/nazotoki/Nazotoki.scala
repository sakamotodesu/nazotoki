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

  def balance(ls: List[GamePlayer], friends: List[(GamePlayer, GamePlayer)]): List[List[List[GamePlayer]]] = {
    val ns = divide(ls)
    group(ns, ls)
            .filter(_.forall(x => containMaster(x)))
            .filter(_.forall(x => mixGender(x)))
            .filter(_.forall(x => checkFriends(x, friends)))
            .filter(_.forall(x => married(x)))
            .filter(_.forall(x => pair(x, "shutyou", "yukari")))
            //.filter(_.forall(x => pair(x, "shutyou", "yukkiy")))
            .map(x => x.map(y => y.sortWith((a, b) => a.name > b.name))
            .sortWith((a, b) => a(0).name > b(0).name))
            .distinct
  }

  def balance(ls: List[GamePlayer], friends: List[(GamePlayer, GamePlayer)],masterF: (List[GamePlayer]) => Boolean,genderF: (List[GamePlayer]) => Boolean,friendsF: (List[GamePlayer],List[(GamePlayer, GamePlayer)]) => Boolean,marriedF: (List[GamePlayer]) => Boolean,pairF:(List[GamePlayer],String,String)=>Boolean): List[List[List[GamePlayer]]] = {
    val ns = divide(ls)
    group(ns, ls)
            .filter(_.forall(x => masterF(x)))
            .filter(_.forall(x => genderF(x)))
            .filter(_.forall(x => friendsF(x, friends)))
            .filter(_.forall(x => marriedF(x)))
            .filter(_.forall(x => pairF(x, "shutyou", "yukari")))
            .map(x => x.map(y => y.sortWith((a, b) => a.name > b.name))
            .sortWith((a, b) => a(0).name > b(0).name))
            .distinct
  }

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

  //  1
  //  2
  //  3
  //  4
  //  5
  //  6
  //  7
  //  4,4
  //  5,4
  //  5,5
  //  6,5
  //  4,4,4
  //  5,4,4
  //  5,5,4
  //  5,5,5
  //  4,4,4,4
  //  5,4,4,4
  //  5,5,4,4,
  //  5,5,5,4,
  //  4,4,4,4,4
  //  5,4,4,4,4
  //  5,5,4,4,4
  //  5,5,5,4,4
  //  4,4,4,4,4,4
  def divide(ls: List[GamePlayer]): List[Int] = {
    val minMembers = 4
    val quotient = ls.length / minMembers
    val remainder = ls.length % minMembers
    if (quotient == 0) {
      List(remainder)
    } else {
      val full = List.fill(quotient)(minMembers)

      def flat(members: List[Int], r: Int): List[Int] = {
        r match {
          case 0 => members
          case n => val i = members.indexOf(members.min)
            flat(members.updated(i, members(i) + 1), r - 1)
        }
      }
      flat(full, remainder)
    }
  }
}
