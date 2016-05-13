package demo

import org.scalatest.FunSuite

/**
  * Created by williamliu on 5/13/16.
  */
class HelloTest extends FunSuite {
  test("sayHello method works correctly") {
    val hello = new Hello
    assert(hello.sayHello("Scala") == "Hello, Scala!")
  }
}
