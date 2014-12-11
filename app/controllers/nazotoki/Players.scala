package controllers.nazotoki


object Players {
  val sakamoto = GamePlayer("sakamoto", isMale = true, isMaster = false, isMarried = false)
  val ataru = GamePlayer("ataru", isMale = true, isMaster = false, isMarried = true)
  val yukkiy = GamePlayer("yukkiy", isMale = false, isMaster = true, isMarried = false)
  val nisshiy = GamePlayer("nisshiy", isMale = true, isMaster = true, isMarried = false)
  val kamiya = GamePlayer("kamiya", isMale = true, isMaster = false, isMarried = true)
  val yukari = GamePlayer("yukari", isMale = false, isMaster = true, isMarried = false)
  val mayumi = GamePlayer("mayumi", isMale = false, isMaster = true, isMarried = false)
  val ayumi = GamePlayer("ayumi", isMale = false, isMaster = false, isMarried = true)
  val masuda = GamePlayer("masuda", isMale = true, isMaster = true, isMarried = false)
  val rodion = GamePlayer("rodion", isMale = true, isMaster = false, isMarried = true)
  val satoko = GamePlayer("satoko", isMale = false, isMaster = false, isMarried = false)
  val shutyou = GamePlayer("shutyou", isMale = true, isMaster = false, isMarried = false)
  val monzen = GamePlayer("monzen", isMale = true, isMaster = true, isMarried = true)

  val friends = List((sakamoto, ataru),
    (sakamoto, yukkiy), (sakamoto, nisshiy), (sakamoto, kamiya), (sakamoto, yukari), (sakamoto, ayumi), (sakamoto, masuda), (sakamoto, rodion), (sakamoto, shutyou), (sakamoto, monzen),
    (ataru, yukkiy), (ataru, nisshiy), (ataru, kamiya), (ataru, yukari), (ataru, ayumi), (ataru, masuda), (ataru, shutyou), (ataru, monzen),
    (yukkiy, nisshiy), (yukkiy, kamiya), (yukkiy, yukari), (yukkiy, mayumi), (yukkiy, masuda), (yukkiy, satoko), (yukkiy, shutyou), (yukkiy, monzen),
    (nisshiy, kamiya), (nisshiy, yukari), (nisshiy, ayumi), (nisshiy, masuda), (nisshiy, shutyou), (nisshiy, monzen),
    (kamiya, yukari), (kamiya, ayumi), (kamiya, masuda), (kamiya, shutyou), (kamiya, monzen),
    (yukari, ayumi), (yukari, masuda), (yukari, shutyou), (yukari, monzen),
    (ayumi, masuda), (ayumi, shutyou), (ayumi, monzen),
    (masuda, shutyou), (masuda, monzen),
    (shutyou, monzen)
  )
  val players = List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda, rodion, satoko, shutyou, monzen)

}
