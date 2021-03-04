package com.example.typeclass

trait Printable[A] {
  def format(a: A): String
}

object Printable {
  def format[A](a: A)(implicit printable: Printable[A]): String = printable.format(a)
  def print[A](a: A)(implicit printable: Printable[A]): Unit = println(format(a))
}

object PrintableInstances {
  implicit val printableString: Printable[String] = (a: String) => a
  implicit val printableInt: Printable[Int] = (a: Int) => a.toString
}