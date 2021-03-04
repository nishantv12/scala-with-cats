package com.example.monoidandsemigroups
import cats.instances.int._
import cats.instances.option._
import cats.{Monoid => CatsMonoid}
import cats.syntax.semigroup._
import Order._

class SuperAdder {
  def add(items: List[Int]): Int = items.foldRight(CatsMonoid[Int].empty)(CatsMonoid[Int].combine)

  def add(items: List[Option[Int]]): Option[Int] = items.foldRight(CatsMonoid[Option[Int]].empty)(CatsMonoid[Option[Int]].combine)

  def add(orders: List[Order]): Order = orders.foldRight(CatsMonoid[Order].empty)(_ |+| _)
}
