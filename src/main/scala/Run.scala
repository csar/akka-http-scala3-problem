import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.{path,get,complete}
import akka.http.scaladsl.server.Route
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

import scala.concurrent.{ExecutionContextExecutor, Future}

object Run extends App with Formats {
  implicit val system: ActorSystem = ActorSystem("dummy")


  implicit val ec: ExecutionContextExecutor = system.dispatcher


//  import Formats._f
  val route:Route = path("api") {
    get {
      val fut = Future.successful(List(Dummy(1),Dummy(2)))
      complete(fut)
    }
  }


  Http().newServerAt("0.0.0.0",9009).bind(route)
}


case class Dummy ( ii:Int)

trait Formats extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val _f : RootJsonFormat[Dummy] =  jsonFormat1(Dummy.apply)
}