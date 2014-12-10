package nazotoki

import nazotoki.Nazotoki._
import org.scalatest.FunSuite

/**
 * test
 */
class NazotokiTest extends FunSuite {

  test("grouping") {
    assert(group(List(1, 2, 2), List("Aldo", "Beat", "Carla", "David", "Evi")) === List(List(List("Aldo"), List("Beat", "Carla"), List("David", "Evi")), List(List("Aldo"), List("Beat", "David"), List("Carla", "Evi")), List(List("Aldo"), List("Beat", "Evi"), List("Carla", "David")), List(List("Aldo"), List("Carla", "David"), List("Beat", "Evi")), List(List("Aldo"), List("Carla", "Evi"), List("Beat", "David")), List(List("Aldo"), List("David", "Evi"), List("Beat", "Carla")), List(List("Beat"), List("Aldo", "Carla"), List("David", "Evi")), List(List("Beat"), List("Aldo", "David"), List("Carla", "Evi")), List(List("Beat"), List("Aldo", "Evi"), List("Carla", "David")), List(List("Beat"), List("Carla", "David"), List("Aldo", "Evi")), List(List("Beat"), List("Carla", "Evi"), List("Aldo", "David")), List(List("Beat"), List("David", "Evi"), List("Aldo", "Carla")), List(List("Carla"), List("Aldo", "Beat"), List("David", "Evi")), List(List("Carla"), List("Aldo", "David"), List("Beat", "Evi")), List(List("Carla"), List("Aldo", "Evi"), List("Beat", "David")), List(List("Carla"), List("Beat", "David"), List("Aldo", "Evi")), List(List("Carla"), List("Beat", "Evi"), List("Aldo", "David")), List(List("Carla"), List("David", "Evi"), List("Aldo", "Beat")), List(List("David"), List("Aldo", "Beat"), List("Carla", "Evi")), List(List("David"), List("Aldo", "Carla"), List("Beat", "Evi")), List(List("David"), List("Aldo", "Evi"), List("Beat", "Carla")), List(List("David"), List("Beat", "Carla"), List("Aldo", "Evi")), List(List("David"), List("Beat", "Evi"), List("Aldo", "Carla")), List(List("David"), List("Carla", "Evi"), List("Aldo", "Beat")), List(List("Evi"), List("Aldo", "Beat"), List("Carla", "David")), List(List("Evi"), List("Aldo", "Carla"), List("Beat", "David")), List(List("Evi"), List("Aldo", "David"), List("Beat", "Carla")), List(List("Evi"), List("Beat", "Carla"), List("Aldo", "David")), List(List("Evi"), List("Beat", "David"), List("Aldo", "Carla")), List(List("Evi"), List("Carla", "David"), List("Aldo", "Beat"))))
  }
  test("grouping player") {
    val sakamoto = GamePlayer("sakamoto", isMale = true, isMaster = false, isMarried = false, List("ataru", "yukkiy", "nisshiy", "kamiya", "yukari", "ayumi", "masuda", "rodion", "shutyou", "monzen"))
    val ataru = GamePlayer("ataru", isMale = true, isMaster = false, isMarried = true, List("sakamoto", "yukkiy", "nisshiy", "kamiya", "yukari", "ayumi", "masuda", "shutyou", "monzen"))
    val yukkiy = GamePlayer("yukkiy", isMale = false, isMaster = true, isMarried = false, List("sakamoto", "ataru", "nisshiy", "kamiya", "yukari", "mayumi", "ayumi", "masuda", "satoko", "shutyou", "monzen"))
    val nisshiy = GamePlayer("nisshiy", isMale = true, isMaster = true, isMarried = false, List("sakamoto", "ataru", "yukkiy", "kamiya", "yukari", "ayumi", "masuda", "shutyou", "monzen"))
    val kamiya = GamePlayer("kamiya", isMale = true, isMaster = false, isMarried = true, List("sakamoto", "ataru", "yukkiy", "nisshiy", "yukari", "ayumi", "masuda", "shutyou", "monzen"))
    val yukari = GamePlayer("yukari", isMale = false, isMaster = true, isMarried = false, List("sakamoto", "ataru", "yukkiy", "nisshiy", "kamiya", "ayumi", "masuda", "shutyou", "monzen"))
    val mayumi = GamePlayer("mayumi", isMale = false, isMaster = true, isMarried = false, List("yukkiy"))
    val ayumi = GamePlayer("ayumi", isMale = false, isMaster = false, isMarried = true, List("sakamoto", "ataru", "yukkiy", "nisshiy", "kamiya", "yukari", "masuda", "shutyou", "monzen"))
    val masuda = GamePlayer("masuda", isMale = true, isMaster = true, isMarried = false, List("sakamoto", "ataru", "yukkiy", "nisshiy", "kamiya", "yukari", "ayumi", "shutyou", "monzen"))
    val rodion = GamePlayer("rodion", isMale = true, isMaster = false, isMarried = true, List("sakamoto"))
    val satoko = GamePlayer("satoko", isMale = false, isMaster = false, isMarried = false, List("yukkiy"))
    val shutyou = GamePlayer("shutyou", isMale = true, isMaster = false, isMarried = false, List("sakamoto", "ataru", "yukkiy", "nisshiy", "kamiya", "yukari", "ayumi", "masuda", "monzen"))
    val monzen = GamePlayer("monzen", isMale = true, isMaster = true, isMarried = true, List("sakamoto", "ataru", "yukkiy", "nisshiy", "kamiya", "yukari", "ayumi", "masuda", "shutyou"))



    val players = List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda, rodion, satoko, shutyou, monzen)
    val groups = group(List(4, 4, 5), players)
    //groups.foreach(println _)
    println("---")

    assert(containMaster(List(sakamoto, monzen)))
    assert(!containMaster(List(sakamoto, rodion)))
    assert(mixGender(List(sakamoto, yukkiy)))
    assert(!mixGender(List(sakamoto, rodion)))

    println("---")
    assert(friends(List(sakamoto, yukkiy)))
    assert(!friends(List(sakamoto, mayumi)))
    assert(!friends(List(yukari, mayumi)))
    assert(friends(List(yukari, shutyou)))
    assert(!pair(List(yukari, mayumi), "shutyou", "yukari"))
    assert(pair(List(yukari, shutyou), "shutyou", "yukari"))
    assert(married(List(yukari, shutyou)))
    assert(!married(List(yukari, monzen)))
    assert(married(List(ayumi, monzen)))
    assert(!married(List(sakamoto, monzen)))
    assert(married(List(sakamoto, monzen, yukkiy)))
    val ret = balance(List(4, 4, 5), players)
    ret.foreach(println _)
    println(ret.length)


  }
}
