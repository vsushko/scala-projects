package lectures.part3concurrency

import java.util.concurrent.Executors

/**
  *
  * @author vsushko
  */
object Intro extends App {

  // JVM threads

  val runnable = new Runnable {
    override def run(): Unit = println("Running in parallel")
  }

  val aThread = new Thread(runnable)

  // gives the signal to the JVM to start a JVM thread
  aThread.start()
  // create a JVM thread => OS thread

  // doesn't do anything in parallel!
  runnable.run()

  // blocks until aThread finishes running
  aThread.join()

  val threadHello = new Thread(() => (1 to 5).foreach(_ => println("hello")))
  val threadGoodbye = new Thread(() => (1 to 5).foreach(_ => println("goodbye")))

  // different runs produce different results!
  //  threadHello.start()
  //  threadGoodbye.start()

  // executors
  val pool = Executors.newFixedThreadPool(10)
  pool.execute(() => println("something in the thread pool"))

  pool.execute(() => {
    Thread.sleep(1000)
    println("done after 1 second")
  })

  pool.execute(() => {
    Thread.sleep(1000)
    println("almost done")
    Thread.sleep(1000)
    println("done after 2 seconds")
  })

  // pool.shutdown()
  // this throws an exception in the calling thread
  // pool.execute(() => println("should not appear"))

  // pool.shutdown()
  //  println(pool.isShutdown) // true

  def runInParallel = {
    var x = 0

    val thread1 = new Thread(() => {
      x = 1
    })
    val thread2 = new Thread(() => {
      x = 2
    })

    //    thread1.start()
    //    thread2.start()
    println(x)
  }

  // race condition
  // for (_ <- 1 to 10000) runInParallel

  class BankAccount(var amount: Int) {
    override def toString: String = "" + amount
  }

  def buy(account: BankAccount, thing: String, price: Int) = {
    account.amount -= price
    //    println("I've bought " + thing)
    //    println("my account is now " + account)
  }

//  for (_ <- 1 to 1000) {
//    val account = new BankAccount(50000)
//    val thread1 = new Thread(() => buy(account, "shoes", 3000))
//    val thread2 = new Thread(() => buy(account, "iPhone12", 4000))
//
//    thread1.start()
//    thread2.start()
//    Thread.sleep(100)
//    if (account.amount != 43000) println("Aha: " + account.amount)
//  }

  // option #1: use synchronized()
  def buySafe(account: BankAccount, thing: String, price: Int) =
    account.synchronized {
      // no two threads can evaluate this at the same time
      account.amount -= price
      println("I've bought " + thing)
      println("my account is now " + account)
    }

  // option #2: use @volatile

  // Exercises
  // 1
  def inceptionThreads(maxThreads: Int, i: Int = 1): Thread = new Thread(() => {
    if (i < maxThreads) {
      val newThread = inceptionThreads(maxThreads, i + 1)
      newThread.start()
      newThread.join()
    }
    println(s"hello from thread $i")
  })
  inceptionThreads(50).start()

  // 2
  var x = 0
  val threads = (1 to 100).map(_ => new Thread(() => x += 1))
  threads.foreach(_.start())
  // the biggest value possible for x is 100
  // the smallest value possible for x is 1

  // 3
  var message = ""
  val awesomeThread = new Thread(() => {
    Thread.sleep(1000)
    message = "Scala is awesome"
  })
  message = "Scala sucks"
  awesomeThread.start()
  Thread.sleep(1000)
  awesomeThread.join()
  println(message)
  // the value of message almost always "Scala is awesome
}
