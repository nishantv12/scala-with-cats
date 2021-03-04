package com.example.functor.contravariant

trait Printable2[A] {
  self =>

  def format(a: A): String

  def contramap[B](func: B => A): Printable2[B] = (a: B) => self.format(func(a))
}

object Printable2 {
  def format[A](a: A)(implicit printable: Printable2[A]): String = printable.format(a)
  def print[A](a: A)(implicit printable: Printable2[A]): Unit = println(format(a))
}

object Printable2Instances {
  implicit val printableString: Printable2[String] = (a: String) => "\"" + a + "\""
  implicit val printableInt: Printable2[Int] = (a: Int) => a.toString
  implicit val printableBoolean: Printable2[Boolean] = (bool: Boolean) => if(bool) "yes" else "false"
}

final case class Box[A](value: A)

object Box {
  implicit def printableBox[A](implicit printableA: Printable2[A]): Printable2[Box[A]] = printableA.contramap[Box[A]](_.value)
}

object Test extends App {
  import Printable2Instances._
  println(Printable2.format("hello"))
  println(Printable2.format(true))
  println(Printable2.format(2))
  println(Printable2.format(Box("hello world")))
  println(Printable2.format(Box(false)))
}