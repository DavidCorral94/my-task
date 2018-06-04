package com.example.mytasks.http

import cats.effect.Effect
import cats.syntax.functor._
import cats.syntax.flatMap._
import com.example.mytasks.modules.Workflow
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl

class Routes[F[_] : Effect](implicit wf: Workflow[F]) extends Http4sDsl[F] {

  val service: HttpService[F] = HttpService[F] {
    case GET -> Root => wf.getRandomString.map(s => Ok(s)).flatten
    //case GET -> Root / "users" => wf.getUsers.map(l => Ok(l.asJson)).flatten
    /*
        - importar libreria para asJson
        - encoder de user en implicits http
        - ...
     */
  }
}
