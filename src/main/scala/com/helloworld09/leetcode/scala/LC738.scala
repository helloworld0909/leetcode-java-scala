package com.helloworld09.leetcode.scala

object LC738 {
  //738. Monotone Increasing Digits

  def monotoneIncreasingConflictIdx(N: Array[Int]): Int = {
    if (N.length <= 1)
      -1
    else if (N.head > N.tail(0))
      N.length - 1
    else {
      val tailConfilctIdx = monotoneIncreasingConflictIdx(N.tail)
      if (N.head == N.tail(0) & tailConfilctIdx == N.length - 2)
        N.length - 1
      else
        tailConfilctIdx
    }
  }

  def monotoneIncreasingDigits(N: Int): Int = {

    implicit def num2digits(N: Int): Array[Int] = {
      N.toString.toCharArray.map(_.toInt - '0'.toInt)
    }

    implicit def digits2num(array: Array[Int]): Int = {
      array.map(_.toString).mkString.toInt
    }

    val conflictIdx = monotoneIncreasingConflictIdx(N)
    val newDigits: Array[Int] = num2digits(N).reverse.zipWithIndex.map {
      case (digit, idx) =>
        if (idx < conflictIdx)
          9
        else if (idx == conflictIdx)
          digit - 1
        else
          digit

    }.reverse
    digits2num(newDigits)
  }

  def main(args: Array[String]): Unit = {
    require(monotoneIncreasingDigits(221598) == 199999)
    require(monotoneIncreasingDigits(963856657) == 899999999)
  }
}