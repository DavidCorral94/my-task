package com.example.mytasks.interpreters

import cats.Applicative
import cats.implicits._
import com.example.mytasks.algebras.Tasks
import com.example.mytasks.models.Task

class TasksInterpreter[F[_] : Applicative] extends Tasks[F] {

  override def add(a: Task): F[Int] = 1.pure[F]

  override def list: F[List[Task]] = List(Task(1, 99, "Scala Training")).pure[F]

}
