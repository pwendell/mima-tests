package mima.test

import scala.tools.scalap.scalax.rules.scalasig.ScalaSigParser

/** Proof of concept for parsing package-private classes in Scala. */
object Parser {
  def main(args: Array[String]) {
    /** Determine whether clazz is package-private for the given package name. */
    def isPrivateWithin(clazz: Class[_], packageName: String): Boolean = {
      val maybeSig = ScalaSigParser.parse(clazz)
      val maybeSymbol = maybeSig.flatMap(sig => sig.topLevelClasses.headOption)
      val maybePrivate = maybeSymbol.map{ s => 
        s.symbolInfo.privateWithin match {
          case Some(pkg) => pkg.toString == packageName
          case _ => false
        }
      }
      maybePrivate.getOrElse(false)
    }
  
    val clazz = classOf[Example]
    println(s"Is private[foo]: ${isPrivateWithin(clazz, "foo")}")  
    println(s"Is private[mima.test]: ${isPrivateWithin(clazz, "mima.test")}")  
    println(s"Is private[mima]: ${isPrivateWithin(clazz, "mima")}")  
  } 
}
