package recfun

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
    if (c == r || r == 0 || c == 0) return 1
    pascal(r - 1, c - 1) + pascal(r - 1, c)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def isBalanced(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty)
        open == 0
      else if (chars.head == '(')
        isBalanced(chars.tail, open + 1)
      else if (chars.head == ')')
        isOpenExist(open) && isBalanced(chars.tail, open - 1)
      else isBalanced(chars.tail, open)
    }
    def isOpenExist(braceNumbers: Int): Boolean = braceNumbers > 0
    isBalanced(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty || money < 0) 0
    else if (money == 0) 1
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
