package com.example.functor.invariant

import com.example.functor.contravariant.Box

trait Codec[A] { self =>
  def encode(value: A): String
  def decode(s: String): A
  def imap[B](dec: A => B, enc: B => A): Codec[B] = new Codec[B] {
    override def encode(value: B): String = self.encode(enc(value))

    override def decode(s: String): B = dec(self.decode(s))
  }
}

object Codec {
  def encode[A](value: A)(implicit c: Codec[A]): String =
    c.encode(value)

  def decode[A](str: String)(implicit c: Codec[A]): A =
    c.decode(str)

  implicit val codecString: Codec[String] = new Codec[String] {
    override def encode(value: String): String = value

    override def decode(s: String): String = s
  }

  implicit def codecDouble: Codec[Double] = codecString.imap[Double](_.toDouble, String.valueOf)

  implicit def codecBox[A](implicit codecA: Codec[A]): Codec[Box[A]] = codecA.imap[Box[A]](Box(_), _.value)
}


