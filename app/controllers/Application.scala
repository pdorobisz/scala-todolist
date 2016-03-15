package controllers

import models.Task
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._


class Application extends BaseController {

  def index = Action {
    Redirect(routes.Application.tasks)
  }

  def tasks = Action { implicit request =>
    Ok(views.html.taskList(Task.all(), taskForm))
  }

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.taskList(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.Application.tasks)
      }
    )
  }

  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }

  def getTask(id: Long) = Action {
    Task.read(id) match {
      case Some(task) => Ok(views.html.taskDetails(task))
      case None => Redirect(routes.Application.tasks)
    }
  }

  val taskForm = Form(
    "label" -> nonEmptyText
  )
}
