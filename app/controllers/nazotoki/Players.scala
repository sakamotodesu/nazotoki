package controllers.nazotoki

object Players {
  val sakamoto = GamePlayer("sakamoto", "阪本", isMale = true, isMaster = false, isMarried = false)
  val ataru = GamePlayer("ataru", "あたる", isMale = true, isMaster = false, isMarried = true)
  val yukkiy = GamePlayer("yukkiy", "ゆっきー", isMale = false, isMaster = true, isMarried = false)
  val nisshiy = GamePlayer("nisshiy", "にっしー", isMale = true, isMaster = true, isMarried = false)
  val kamiya = GamePlayer("kamiya", "神谷", isMale = true, isMaster = false, isMarried = true)
  val yukari = GamePlayer("yukari", "ゆかり", isMale = false, isMaster = true, isMarried = false)
  val mayumi = GamePlayer("mayumi", "まゆみ", isMale = false, isMaster = true, isMarried = false)
  val ayumi = GamePlayer("ayumi", "あゆみ", isMale = false, isMaster = false, isMarried = true)
  val masuda = GamePlayer("masuda", "増田", isMale = true, isMaster = true, isMarried = false)
  val rodion = GamePlayer("rodion", "ロディオン", isMale = true, isMaster = false, isMarried = true)
  val satoko = GamePlayer("satoko", "さとこ", isMale = false, isMaster = false, isMarried = false)
  val shutyou = GamePlayer("shutyou", "酋長", isMale = true, isMaster = false, isMarried = false)
  val kai = GamePlayer("kai", "絵", isMale = true, isMaster = true, isMarried = true)

  val friends = List((sakamoto, ataru),
    (sakamoto, yukkiy), (sakamoto, nisshiy), (sakamoto, kamiya), (sakamoto, yukari), (sakamoto, ayumi), (sakamoto, masuda), (sakamoto, rodion), (sakamoto, shutyou), (sakamoto, kai),
    (ataru, yukkiy), (ataru, nisshiy), (ataru, kamiya), (ataru, yukari), (ataru, ayumi), (ataru, masuda), (ataru, shutyou), (ataru, kai),
    (yukkiy, nisshiy), (yukkiy, kamiya), (yukkiy, yukari), (yukkiy, mayumi), (yukkiy, masuda), (yukkiy, satoko), (yukkiy, shutyou), (yukkiy, kai),
    (nisshiy, kamiya), (nisshiy, yukari), (nisshiy, ayumi), (nisshiy, masuda), (nisshiy, shutyou), (nisshiy, kai),
    (kamiya, yukari), (kamiya, ayumi), (kamiya, masuda), (kamiya, shutyou), (kamiya, kai),
    (yukari, ayumi), (yukari, masuda), (yukari, shutyou), (yukari, kai),
    (ayumi, masuda), (ayumi, shutyou), (ayumi, kai),
    (masuda, shutyou), (masuda, kai),
    (shutyou, kai)
  )
  val players = List(sakamoto, ataru, yukkiy, nisshiy, kamiya, yukari, mayumi, ayumi, masuda, rodion, satoko, shutyou, kai)

}
