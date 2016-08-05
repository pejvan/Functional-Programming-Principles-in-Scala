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
    // notes:
    //  if the first unmatched parenthesis is the closing one, then they cannot be balanced
    //    examples: ")hello..." or "(hello))..."
    //  if the last char is an opening paren, it cannot be balanced
    //    example: "hello(" or "(hello())...("

    def balance(char: Char, numUnmatchedOpenParen: Int, chars: List[Char]): Boolean = {
      if ( char != ')' && char != '(' ) {
        if (chars.isEmpty) return numUnmatchedOpenParen == 0
        else return balance(chars.head, numUnmatchedOpenParen, chars.tail)
      }

      if ( char == '(' ) {
        if (chars.nonEmpty) return balance(chars.head, numUnmatchedOpenParen + 1, chars.tail)
        else return false
      }

      if ( char == ')' ){
        if (numUnmatchedOpenParen > 0 && chars.nonEmpty) return balance(chars.head, numUnmatchedOpenParen - 1, chars.tail)
        else return numUnmatchedOpenParen == 1
      }

      throw new Exception("Shouldn't reach here!")
    }

    balance(chars.head, 0, chars.tail)
  }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = 1
  }
