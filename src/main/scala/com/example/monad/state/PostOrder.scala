package com.example.monad.state

import cats.data.State

object PostOrder {
  type CalcState[A] = State[List[Int], A]

//  def evalOne(sym: String): CalcState[Int] = sym match {
//    case "+" => State[List[Int], Int] {
//      case b :: a :: tail => ((b + a) :: tail, b + a)
//      case _ => sys.error("fail")
//    }
//    case "-" =>
//    case "*" =>
//    case "/" =>
//    case num =>
//  }

}
