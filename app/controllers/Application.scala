package controllers

import models.Task
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._


class Application extends BaseController {

  def index = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }

  val taskForm = Form(
    "label" -> nonEmptyText
  )
}
