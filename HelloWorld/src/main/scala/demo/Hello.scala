package demo

/**
  * Created by williamliu on 5/13/16.
  */
class Hello {

  // VALUES
  // a 'val'
  val my_value = 1 + 1  // 'val' are immutable (i.e. you cannot change the value)
  //my_value = 3  // This gives an error 'reassignment to val'
  println(my_value)  // 2
  var ab, bc = 100  // Can declare multiple values or variables together
  val greeting: String = null // You can specify the type if you want to; the type goes after the variable name

  // a 'var'
  var my_var = "will"  // 'var' allows reassignment
  my_var = "laura"

  // TYPES
  val intToString = 1.toString()
  println("This Int turned into a String! " + intToString)
  val someFloatToInt = 99.394.toInt
  println("This Float turned into an Int" + someFloatToInt)
  val someStringToDouble = "77.34".toDouble

  println("Hello".intersect("World")) // "lo"

  // FUNCTIONS
  // You can create functions with 'def'
  def sayHello(name: String) = s"Hello, $name!"
  println(sayHello("Will"))  // Hello, Will!
  def addOne(x: Int): Int = x + 1
  println(addOne(20))  // 21
  def three() = 1 + 2
  println(three())  // 3

  // You can create anonymous functions and either pass them around or save them
  val addThree = (x: Int) => x + 3
  println("Using an anonymous function to calculate " + addThree(7))

  // You can use {} to break up code
  def timesTwo(i: Int): Int = {
    println("hello world")
    i * 2 // The last line is returned by default
  }
  val resultTimesTwo = timesTwo(4)
  println(resultTimesTwo)

  // A _ is an unnamed magical wildcard
  def adder(m: Int, n: Int) = m + n
  println(adder(2, 3))
  val add2 = adder(2, _:Int) // with _, you can partially apply any argument in the argument list in a function, which gives you another function
  println(add2(3))

  def multiply(m: Int)(n: Int): Int = m * n
  println(multiply(2)(3)) // 6, both arguments are filled in
  val timesThree = multiply(3) _ // using _, partially apply an argument to the function
  println(timesThree(5)) // 15

  // You can take any function with multiple arguments and curry it
  // What this does is it takes a function with multiple parameters and transforms the function to take a single parameter
  val curriedAdd = (adder _).curried  // Takes our adder function we defined above (that has multiple arguments) and curry it
  val addTen = curriedAdd(10)
  println(addTen(4))

  // Curried Functions
  def addNoCurry(x: Int, y: Int) = x + y
  println(addNoCurry(7, 3)) // 10, takes two parameters and returns the result of adding the two
  def addWithCurry(x: Int) = (y: Int) => x + y
  println(addWithCurry(7)(3)) // 10, redefines the method so it takes only a single Int as a parameter and returns a
  // functional (closure) as a result. Our driver code then calls this functional, passing in the second 'parameter'.
  // This functional computes the value and returns the final result.
  def addWithNicerCurry(x: Int)(y: Int) = x + y  // Same as addWithCurry, but with nicer syntax
  println(addWithNicerCurry(20)(10))

  // We can use the * syntax for methods that take parameters of a repeated type
  def capitalizeAll(args: String*) = {
    args.map { arg =>
      arg.capitalize  // apply 'capitalize' function to several strings
    }
  }
  val myStrings = capitalizeAll("rarity", "applejack")
  println(myStrings)
  println(myStrings{0})
  println(myStrings{1})

  // CLASSES
  class Calculator {
    val brand: String = "HP"
    def add(m: Int, n: Int): Int = m + n
    def nothingHere(): Int = 0
  }
  val calc = new Calculator
  println(calc.add(1, 2))
  println(calc.brand)
  println(calc.nothingHere())

  // Constructors are the code outside of method definitions in your class
  class awesomeCalculator(brand: String) {
    /*
     * A constructor.
     */
    val color: String = if (brand == "TI") {
      "blue"
    } else if (brand == "HP") {
      "black"
    } else {
      "white"
    }
    // An instance method
    def add(m: Int, n: Int): Int = m + n
  }
  val awesomeCalc = new awesomeCalculator("HP")
  println(awesomeCalc.color)

  // Arithmetic and Operator Overloading
  var a = 2
  var b = 3
  println(a + b)  // these operators like '+' are actually methods
  println(a.+(b))  // same as above; in general you can write: `a method b` as a shorthand for `a.method(b)`
  println(1.to(10))  // Same idea as example above
  println(1 to 10)  // See, same as above

  var counter = 0
  counter += 1  // Increments counter; there is no counter++ or counter-- since the Int class is immutable

  import scala.math._  // The _ is a wildcard in Scala, similar to * in Java
  println(sqrt(2))  // 1.4142
  pow(2, 4)  // 16.0
  min(3, Pi)  // 3.0

  println(BigInt.probablePrime(100, scala.util.Random))  // Random is a singleton object defined from `scala.util` package

  println("Hello".distinct) // Helo, Scala methods without parameters don't use parentheses
  // The rule of thumb is that a parameterless method that doesn't modify the object has no parenthesis

  println("Hello"(4)) // 'o'
  println("Hello".apply(4))  // 'o', same as above

  val myArray = Array(1, 4, 9, 16)
  println(myArray.deep.mkString("\n"))

  // CONDITIONAL EXPRESSIONS
  val x = 20
  val s = if (x > 0) 1 else -1
  println(s)

  var r = 3
  var n = 7
  if (x > 0) { r = r * n; n -= 1}  // If multiple statements are on the same line, you need a semicolon to separate them

  // Input and Output
  //val name = readLine("Your name is ")
  //print("Your age is ")
  //val age = readInt()
  //printf("Hello, %s! Next year, you will be %d.\n", name, age + 1)

  // LOOPS
  // Scala doesn't have the regular for-loop setup of initialize, do-stuff, update
  // You can either use a regular while loop or a stranger for-loop
  // Usually you don't use loops often in Scala; instead you process the values in a sequence by
  // applying a function to all of them, which is done with a single method call
  while( n > 0) {  // While Loop
    println("This is a while loop")
    n -= 1
  }

  var z = 5  // For loop
  for (i <- 1 to z)  // traverses from 1 to 5 (i.e. 1, 2, 3, 4, 5)
    println("This is a for loop")

  // for Strings, you often need length - 1
  val myString = "Hello"
  var sum = 0
  for (i <- 0 until myString.length) // Last value for i is s.length - 1
    sum += myString(i)
  println(sum)  // 500

  // BASIC DATA STRUCTURES
  val myList = List(1, 2, 3, 4)
  println(myList)

  val mySet = Set(1, 2, 3, 4)  // Sets have no duplicates
  println(mySet)

  val myTuple = ("localhost", 80)  // groups together logical collections of items without using a class
  println(myTuple)  // access based off their position (1 based instead of 0)
  print(myTuple._1)  // "localhost"
  print(myTuple._2)  // 80
  val anotherTuple = 1 -> 2  // Special way of making a Tuple with 2 values
  print(anotherTuple)

  myTuple match {
    case ("localhost", port) => "Hello"
    case ("host", port) => "There"
  }

  print(myTuple._1)

}
