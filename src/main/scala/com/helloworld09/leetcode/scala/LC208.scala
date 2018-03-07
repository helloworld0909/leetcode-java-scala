package com.helloworld09.leetcode.scala

import scala.collection.mutable

class LC208 {
  //208. Implement Trie (Prefix Tree)

  /** Initialize your data structure here. */
  class TrieNode(val char: Char, var sons: mutable.Map[Char, TrieNode], var isLeaf: Boolean = false)

  val root: TrieNode = new TrieNode('_', new mutable.HashMap)

  /** Inserts a word into the trie. */
  def insert(word: String) {
    var currNode = root
    word.foreach { c: Char => {
      val someNode = currNode.sons.get(c)
      someNode match {
        case Some(node) =>
          currNode = node
        case None =>
          val newNode = new TrieNode(c, new mutable.HashMap)
          currNode.sons += c -> newNode
          currNode = newNode
      }
    }
    }
    currNode.isLeaf = true
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    var currNode = root
    word.foreach { c: Char => {
      val someNode = currNode.sons.get(c)
      someNode match {
        case Some(node) =>
          currNode = node
        case None =>
          return false
      }
    }

    }
    if (currNode.isLeaf) true
    else false
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    var currNode = root
    prefix.foreach { c: Char => {
      val someNode = currNode.sons.get(c)
      someNode match {
        case Some(node) =>
          currNode = node
        case None =>
          return false
      }
    }
    }
    true
  }
}


object LC208 extends App {
  val prefixTree = new LC208
  prefixTree.insert("hello")
  prefixTree.insert("hell")
  println(prefixTree.search("helloo"))
  println(prefixTree.startsWith("helll"))
}
