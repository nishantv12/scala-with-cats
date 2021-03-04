package com.example.typeclass

import cats._
import cats.implicits._

case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val printableCat: Printable[Cat] = (cat: Cat) => s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."

  implicit val showCat: Show[Cat] = Show.show(cat => s"${cat.name.show} is a ${cat.age.show} year-old ${cat.color.show} cat.")

  implicit val catEq: Eq[Cat] = (x: Cat, y: Cat) => x.name === y.name && x.age === y.age && x.color === y.color
}

object Main extends App {
  val cat = Cat("Billi", 2, "White")
  Printable.print(cat)

  println(cat.show)
  println(cat === cat)
  println(cat =!= cat)
}
