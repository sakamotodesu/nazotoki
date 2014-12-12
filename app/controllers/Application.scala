package controllers

import controllers.nazotoki.Nazotoki._
import controllers.nazotoki.Players._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    //Ok(views.html.index("Your new application is ready!!!!!!!!"))
    //Ok(balance(List(4, 4, 5), players, friends).toString())
    Ok(views.html.index(balance(List(4, 4, 5), players, friends)))
  }

}