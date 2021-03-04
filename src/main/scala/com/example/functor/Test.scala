package com.example.functor

import cats.syntax.functor._
import Tree._

object Test extends App {

//  Tree.leaf(4).map(_ + 2)

//  Tree.branch(Tree.leaf(10), Tree.leaf(22)).map(_ * 2)

  val map: Map[String, Seq[String]] = Map(1 -> Seq("one")) ++ None
  println(Map(1 -> Seq("one")) ++ None)
  println(Map(1 -> Seq("one")) ++ Some(2 -> Seq("two")))
}


