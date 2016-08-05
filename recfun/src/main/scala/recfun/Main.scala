package recfun

//import scala.reflect.internal.TreeInfo.IsFalse

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
  */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c-1, r-1) + pascal (c, r-1)
  }
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceAccum(acc: Int, chars: List[Char]): Boolean = {
        if (chars.isEmpty) return acc == 0
        if (acc < 0) return false // counting is not enough
        if (chars.head == '(') return balanceAccum( acc + 1, chars.tail)
        if (chars.head == ')') return balanceAccum( acc - 1, chars.tail)
        balanceAccum(acc, chars.tail)
    }
    balanceAccum(0, chars)
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.isEmpty) 0
    else if (money < 0) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
