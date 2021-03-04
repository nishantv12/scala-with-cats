package com.example.monad.eval

import cats.Eval

object FoldRight {
  def foldRight[A, B](as: List[A], acc: B)(func: (A, B) => B):B =
    as match {
      case head::tail =>
        func(head, foldRight(tail, acc)(func))
      case Nil =>
        acc
    }

  def foldRightEval[A, B](as: List[A], acc: Eval[B])(func: (A, Eval[B]) => Eval[B]): Eval[B] =
    as match {
      case head::tail =>
        Eval.defer(func(head, foldRightEval(tail, acc)(func)))
      case Nil =>
        acc
    }

}
