package com.helloworld09.leetcode.scala

import scala.collection.mutable

object LC1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var cache = new mutable.HashMap[Int, Int]
    for (i <- List.range(0, nums.length)) {
      val num = nums(i)
      val residual = target - num
      cache.get(residual) match {
        case Some(idx) =>
          return Array(idx, i)
        case None =>
          cache += num -> i
      }
    }
    Array()
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(3,3)
    println(twoSum(nums, 6).toList)
  }
}
