package controllers

import play.api.i18n.Lang
import play.api.mvc._


class Language extends BaseController {

  def setLang(lang: String) = Action { implicit request =>
    val response = Redirect(routes.Application.index)
    Lang.get(lang) map (messagesApi.setLang(response, _)) getOrElse response
  }
}
