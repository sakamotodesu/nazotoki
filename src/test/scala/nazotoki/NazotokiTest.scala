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
    val sakamoto = GamePlayer("sakamoto", isMale = true, isMaster = false, List("monzen", "yukkiy", "sakamoto"))
    val rodion = GamePlayer("rodion", isMale = true, isMaster = false, List("sakamoto", "yukkiy"))
    val monzen = GamePlayer("monzen", isMale = true, isMaster = true, List("sakamoto", "yukkiy"))
    val yukkiy = GamePlayer("yukkiy", isMale = false, isMaster = true, List("sakamoto", "monzen"))

    val players = List(sakamoto, rodion, monzen, yukkiy)
    val groups = group(List(2, 2), players)
    groups.foreach(println _)
    println("---")
    balance(List(2,2),players).foreach(println _)
    assert(containMaster(List(sakamoto,monzen)))
    assert(!containMaster(List(sakamoto,rodion)))
  }
}
