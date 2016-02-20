package controllers

import javax.inject.Inject

import models.Task
import play.api._
import play.api.i18n.{MessagesApi, I18nSupport}
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._


class Application @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }

  val taskForm = Form(
    "label" -> nonEmptyText
  )
}
