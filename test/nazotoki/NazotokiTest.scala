package nazotoki

import controllers.nazotoki.Nazotoki._
import controllers.nazotoki.Players._
import org.scalatest.FunSuite

/**
 * test
 */
class NazotokiTest extends FunSuite {



  test("grouping") {
    assert(group(List(1, 2, 2), List("Aldo", "Beat", "Carla", "David", "Evi")) === List(List(List("Aldo"), List("Beat", "Carla"), List("David", "Evi")), List(List("Aldo"), List("Beat", "David"), List("Carla", "Evi")), List(List("Aldo"), List("Beat", "Evi"), List("Carla", "David")), List(List("Aldo"), List("Carla", "David"), List("Beat", "Evi")), List(List("Aldo"), List("Carla", "Evi"), List("Beat", "David")), List(List("Aldo"), List("David", "Evi"), List("Beat", "Carla")), List(List("Beat"), List("Aldo", "Carla"), List("David", "Evi")), List(List("Beat"), List("Aldo", "David"), List("Carla", "Evi")), List(List("Beat"), List("Aldo", "Evi"), List("Carla", "David")), List(List("Beat"), List("Carla", "David"), List("Aldo", "Evi")), List(List("Beat"), List("Carla", "Evi"), List("Aldo", "David")), List(List("Beat"), List("David", "Evi"), List("Aldo", "Carla")), List(List("Carla"), List("Aldo", "Beat"), List("David", "Evi")), List(List("Carla"), List("Aldo", "David"), List("Beat", "Evi")), List(List("Carla"), List("Aldo", "Evi"), List("Beat", "David")), List(List("Carla"), List("Beat", "David"), List("Aldo", "Evi")), List(List("Carla"), List("Beat", "Evi"), List("Aldo", "David")), List(List("Carla"), List("David", "Evi"), List("Aldo", "Beat")), List(List("David"), List("Aldo", "Beat"), List("Carla", "Evi")), List(List("David"), List("Aldo", "Carla"), List("Beat", "Evi")), List(List("David"), List("Aldo", "Evi"), List("Beat", "Carla")), List(List("David"), List("Beat", "Carla"), List("Aldo", "Evi")), List(List("David"), List("Beat", "Evi"), List("Aldo", "Carla")), List(List("David"), List("Carla", "Evi"), List("Aldo", "Beat")), List(List("Evi"), List("Aldo", "Beat"), List("Carla", "David")), List(List("Evi"), List("Aldo", "Carla"), List("Beat", "David")), List(List("Evi"), List("Aldo", "David"), List("Beat", "Carla")), List(List("Evi"), List("Beat", "Carla"), List("Aldo", "David")), List(List("Evi"), List("Beat", "David"), List("Aldo", "Carla")), List(List("Evi"), List("Carla", "David"), List("Aldo", "Beat"))))
  }

  test("grouping player") {
    val players = List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda, rodion, satoko, shutyou, monzen)
    assert(containMaster(List(sakamoto, monzen)))
    assert(!containMaster(List(sakamoto, rodion)))
    assert(mixGender(List(sakamoto, yukkiy)))
    assert(!mixGender(List(sakamoto, rodion)))
    assert(!pair(List(yukari, mayumi), "shutyou", "yukari"))
    assert(pair(List(yukari, shutyou), "shutyou", "yukari"))
    assert(married(List(yukari, shutyou)))
    assert(!married(List(yukari, monzen)))
    assert(married(List(ayumi, monzen)))
    assert(!married(List(sakamoto, monzen)))
    assert(married(List(sakamoto, monzen, yukkiy)))
    assert(getFriends(sakamoto, friends) === List(yukkiy, yukari, shutyou, rodion, nisshiy, monzen, masuda, kamiya, ayumi, ataru))
    assert(getFriends(satoko, friends) === List(yukkiy))
    assert(checkFriends(List(sakamoto, monzen), friends))
    assert(!checkFriends(List(sakamoto, satoko), friends))
    val ret = balance(List(4, 4, 5), players, friends)
    ret.foreach(println(_))
    println(ret.length)
  }

  test("divide") {
    assert(divide(List(sakamoto)) === List()) // FIXME
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda, rodion, satoko, shutyou, monzen)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda, rodion, satoko, shutyou)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda, rodion, satoko)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda, rodion)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy, kamiya)))
    println(divide(List(sakamoto, ataru, yukkiy, nisshiy)))
    println(divide(List(sakamoto, ataru, yukkiy)))
    println(divide(List(sakamoto, ataru)))
    println(divide(List(sakamoto)))
  }

}
