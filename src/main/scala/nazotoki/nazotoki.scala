package nazotoki

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

  def balance(ns: List[Int], ls: List[GamePlayer]): List[List[List[GamePlayer]]] = group(ns, ls).filter(_.forall(x => containMaster(x))).filter(_.forall(x=>mixGender(x)))

  def containMaster(ls: List[GamePlayer]) = ls.exists(_.isMaster)

  def mixGender(ls:List[GamePlayer]) = ls.exists(_.isMale)&& ls.exists(!_.isMale)

}
