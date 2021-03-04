package com.example.monad.reader

import cats.data.Reader
import cats.syntax.applicative._

final case class Db(usernames: Map[Int, String], passwords: Map[String, String])

object Db {
  type DbReader[A] = Reader[Db, A]

  def findUsername(userId: Int): DbReader[Option[String]] = Reader(_.usernames.get(userId))

  def checkPassword(
                     username: String,
                     password: String): DbReader[Boolean] = Reader(_.passwords.get(username).contains(password))

  def checkLogin(
                  userId: Int,
                  password: String): DbReader[Boolean] =
    findUsername(userId).flatMap(_.fold(false.pure[DbReader])(checkPassword(_, password)))

}

object Test extends App {
  val users = Map( 1 -> "dade", 2 -> "kate", 3 -> "margo")
  val passwords = Map( "dade" -> "zerocool", "kate" -> "acidburn", "margo" -> "secret")
  val db = Db(users, passwords)

  println(Db.checkLogin(1, "zerocool").run(db))
  println(Db.checkLogin(4, "davinci").run(db))
}
