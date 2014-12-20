package controllers

import controllers.nazotoki.GamePlayer
import controllers.nazotoki.Nazotoki._
import controllers.nazotoki.Players._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    //Ok(views.html.index("Your new application is ready!!!!!!!!"))
    //Ok(balance(List(4, 4, 5), players, friends).toString())
    Ok(views.html.index(balance(players, friends)))
  }

  def list = Action {
    Ok(views.html.list(test01Form, players))
  }

  def result = Action { implicit request =>
    val (sakamotoBoolean,
    ataruBoolean,
    yukkiyBoolean,
    nisshiyBoolean,
    kamiyaBoolean,
    yukariBoolean,
    mayumiBoolean,
    ayumiBoolean,
    masudaBoolean,
    rodionBoolean,
    satokoBoolean,
    shutyouBoolean,
    kaiBoolean,
    enableMaster,
    enableGender,
    enableFriends,
    enableMarried,
    enablePair) = test01Form.bindFromRequest.get
    val players1 = Nil
    val players2 = if (sakamotoBoolean) sakamoto :: players1 else players1
    val players3 = if (ataruBoolean) ataru :: players2 else players2
    val players4 = if (yukkiyBoolean) yukkiy :: players3 else players3
    val players5 = if (nisshiyBoolean) nisshiy :: players4 else players4
    val players6 = if (kamiyaBoolean) kamiya :: players5 else players5
    val players7 = if (yukariBoolean) yukari :: players6 else players6
    val players8 = if (mayumiBoolean) mayumi :: players7 else players7
    val players9 = if (ayumiBoolean) ayumi :: players8 else players8
    val players10 = if (masudaBoolean) masuda :: players9 else players9
    val players11 = if (rodionBoolean) rodion :: players10 else players10
    val players12 = if (satokoBoolean) satoko :: players11 else players11
    val players13 = if (shutyouBoolean) shutyou :: players12 else players12
    val players14 = if (kaiBoolean) kai :: players13 else players13

    val masterF = if(enableMaster) containMaster _ else dummyF
    val genderF = if(enableGender) mixGender _ else dummyF
    val friendsF = if(enableFriends) checkFriends _ else dummyFF
    val marriedF = if(enableMarried) married _ else dummyF
    val pairF = if(enablePair) pair _ else dummyFFF

    Ok(views.html.index(balance(players14, friends,masterF,genderF,friendsF,marriedF,pairF)))
  }


  val  dummyF = (ls: List[GamePlayer]) => true
  val dummyFF =  (ls: List[GamePlayer], friends: List[(GamePlayer, GamePlayer)]) =>true
//            .filter(_.forall(x => pair(x, "shutyou", "yukari")))
  val dummyFFF = (ls:List[GamePlayer],boy:String,girl:String)=>true
  val test01Form = Form(
    tuple(sakamoto.name -> boolean,
      ataru.name -> boolean,
      yukkiy.name -> boolean,
      nisshiy.name -> boolean,
      kamiya.name -> boolean,
      yukari.name -> boolean,
      mayumi.name -> boolean,
      ayumi.name -> boolean,
      masuda.name -> boolean,
      rodion.name -> boolean,
      satoko.name -> boolean,
      shutyou.name -> boolean,
      kai.name -> boolean,
      "enableMaster" -> boolean,
      "enableGender" -> boolean,
      "enableFriends" -> boolean,
      "enableMarried" -> boolean,
      "enablePair" -> boolean)
  )
}