package controllers

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
    val (sakamotoBoolean, ataruBoolean, yukkiyBoolean, nisshiyBoolean, kamiyaBoolean, yukariBoolean, mayumiBoolean, ayumiBoolean, masudaBoolean, rodionBoolean, satokoBoolean, shutyouBoolean, monzenBoolean) = test01Form.bindFromRequest.get
    Ok(sakamotoBoolean.toString+ataruBoolean.toString+yukkiyBoolean.toString)
  }

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
      monzen.name -> boolean)
  )
}