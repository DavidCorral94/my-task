package com.example.mytasks.implicits

import cats.Applicative
import com.example.mytasks.algebras.{Tasks, Users}
import com.example.mytasks.interpreters.{TasksInterpreter, UsersInterpreter}
import com.example.mytasks.modules.Workflow

object runtime {
  implicit def users[F[_] : Applicative]: Users[F] = new UsersInterpreter[F]

  implicit def tasks[F[_] : Applicative]: Tasks[F] = new TasksInterpreter[F]

  implicit def workflow[F[_]](implicit U: Users[F], T: Tasks[F]): Workflow[F] =
    Workflow.impl[F](U, T)
}
