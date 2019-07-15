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
  threadHello.start()
  threadGoodbye.start()

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
  println(pool.isShutdown)
}
