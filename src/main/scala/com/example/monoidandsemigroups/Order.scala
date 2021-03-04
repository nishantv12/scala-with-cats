package com.example.monoidandsemigroups

import cats.{Monoid => CatsMonoid}
import cats.instances.double._

case class Order(totalCost: Double, quantity: Double)

object Order {
  implicit val orderMonoid: CatsMonoid[Order] = new CatsMonoid[Order] {
    override def empty: Order = Order(CatsMonoid.empty[Double], CatsMonoid.empty[Double])

    override def combine(x: Order, y: Order): Order = Order(CatsMonoid.combine(x.totalCost, y.totalCost), CatsMonoid.combine(x.quantity, y.quantity))
  }
}
