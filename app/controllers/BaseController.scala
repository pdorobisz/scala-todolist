package controllers

import javax.inject.Inject

import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

abstract class BaseController extends Controller with I18nSupport {

  @Inject() private var messages: MessagesApi = _

  override def messagesApi: MessagesApi = messages
}
