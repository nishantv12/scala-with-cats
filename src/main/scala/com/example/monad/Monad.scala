package com.example.monad

trait Monad[F[_]] {
  def pure[A](value: A): F[A]

  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

  def map[A, B](value: F[A])(func: A => B): F[B] = flatMap(value)(a => pure(func(a)))

}

object Monad {
  type Id[A] = A

  implicit val monadId: Monad[Id] = new Monad[Id] {
    override def pure[A](value: A): Id[A] = value

    override def flatMap[A, B](value: Id[A])(func: A => Id[B]): Id[B] = func(value)

    override def map[A, B](value: Id[A])(func: A => B): Id[B] = func(value)
  }
}
