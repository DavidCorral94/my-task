package com.example.mytasks.interpreters

import cats.Applicative
import com.example.mytasks.algebras.Users
import com.example.mytasks.models.User
import cats.implicits._
import scala.util.Random._

class UsersInterpreter[F[_] : Applicative] extends Users[F] {

  override def add(a: User): F[Int] = 99.pure[F]

  override def list: F[List[User]] = List(User(99, "David")).pure[F]

  override def getRandomString: F[String] = nextString(4).pure[F]

}
