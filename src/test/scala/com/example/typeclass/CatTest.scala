package com.example.typeclass

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers
import cats.instances.option._


class CatTest extends AnyFunSuite with Matchers {
  test("Eq") {
    val cat1 = Cat("Garfield",   38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")

    Cat.catEq.eqv(cat1, cat2) mustBe false

    val optionCat1: Option[Cat] = Option(cat1)
    val optionCat2: Option[Cat] = Option.empty

    optionCat1 === optionCat2 mustBe false

    Stream()
  }
}
