package com.example.monad.writer
import cats.data.{Writer, WriterT}
import cats.syntax.writer._
import cats.syntax.applicative._
import cats.instances.vector._
import cats.instances._

import scala.collection.immutable
import scala.concurrent.Future

object Factorial extends App {
  type LoggedFactorial[A] =  Writer[Vector[String], A]
  def slowly[A](body: => A): A =
    try body finally Thread.sleep(100)
  def factorial(n: Int): LoggedFactorial[Int] = {
    val ans: LoggedFactorial[Int] = if(n == 0) 1.pure[LoggedFactorial] else slowly(factorial(n - 1).map(n * _))
    ans.flatMap(res => res.writer(Vector(s"fact $n $res")))
  }
  val (log: immutable.Seq[String], res) = factorial(5).run
  println(log)
  println(res)

  import scala.concurrent._
  import scala.concurrent.duration._
  import scala.concurrent.ExecutionContext.Implicits.global

  val result = Await.result(
    Future.sequence(Vector(
      Future(factorial(3).run),
      Future(factorial(3).run))), 5.seconds)
  println(result)
  // fact 0 1
  // fact 0 1
  // fact 1 1
  // fact 1 1
  // fact 2 2
  // fact 2 2
  // fact 3 6
  // fact 3 6
  // res14: scala.collection.immutable.Vector[Int] = // Vector(120, 120)
}
