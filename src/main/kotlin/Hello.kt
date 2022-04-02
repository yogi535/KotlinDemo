
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking


suspend fun main() {

    println("Hello, ")

    val flow = flowOf(2, 3, 5)


//    // println("flow=$flow")
//    flow.collect {
//        println("flow**=$it")
//    }
//    flow.collectLatest {
//        println("latest collect= $it")
//    }
//
//    flow.map {
//        modification(it)
//    }.collect {
//        println("latest map collect = $it")
//    }


    val myFlow = flow {
        // GlobalScope.launch { // is prohibited
        // launch(Dispatchers.IO) { // is prohibited
        // withContext(CoroutineName("myFlow")) // is prohibited
        emit(1) // OK
        emit(15555555) // OK
        emit(1) // OK
        emit(1) // OK
        emit(1) // OK
        emit(1) // OK
        emit(1) // OK
//        withContext(Dispatchers.IO)
//        {
//            emit(561) // OK
//        }
        coroutineScope {
            emit(2) // OK -- still the same coroutine
        }
    }

    myFlow.collect {
        println("collect=$it")
    }
    runBlocking {

        /*    launch {

            }
            launch {
            }*/

//        async {
//            show()
//        }
//
//        async {
//            display()
//        }
//
//        async {
//
//        }

    }
/*    val job=GlobalScope.async {
        show()
        display()
    }
    job.await()*/
    /*  val time = measureTimeMillis {
          runBlocking {
              for (i in 1..2) {
                  launch(Dispatchers.IO) {
                      work(i)
                  }
              }
          }
      }
      println("Done in $time ms")*/
}

fun work(i: Int) {
    Thread.sleep(500)
    println("Work $i done")
}

/*fun main() {

    val coroutineScope= CoroutineScope(Dispatchers.IO)



    CoroutineScope(Dispatchers.IO).launch {  show()
        display()
    }
   // CoroutineScope(Dispatchers.IO).launch { display() }

    *//*   println("Above OutSide Coroutine")
       GlobalScope.launch(Dispatchers.Unconfined) {
           delay(1000L)
           println("Inside Main GlobalScope")
       }

     *//*


    *//*GlobalScope.launch {
        delay(1000L)
        println("Hellooo")
    }

    Thread.sleep(1500)*//*

    runBlocking {

      *//*  var resultOne = "Android"
        var resultTwo = "Kotlin"
        println("Launch Before")
       var job= launch(Dispatchers.IO) { resultOne = function1() }
       var job2= launch(Dispatchers.IO) { resultTwo = function2() }
        joinAll(job,job2)
        println("Launch After")
        val resultText = resultOne + resultTwo
        println("Launch $resultText")*//*

       *//* coroutineScope.launch(Dispatchers.Default)
        {
            println("Launch First")
        }
        coroutineScope.launch(Dispatchers.Default)
        {
            println("Launch Second")
        }
        coroutineScope.launch(Dispatchers.Unconfined)
        {
            println("Launch Third")
        }*//*

      *//*  var count1: Int=0
        var count2: Int=0
        val job1: Job = launch(context = Dispatchers.IO) {
            count1++
            show()
        }

        val job2: Job = launch(context = Dispatchers.IO) {
            count2++

            display()
        }
        //joinAll(job1, job2)
        println("Both results retrieved:\n$count1\n$count2")*//*

    }



    runBlocking {

*//*

        async {
            show()

        }

        async {
            display()
        }
*//*





        *//*   println("first run block GlobalScope")

           println("second run block GlobalScope")

           launch {
               delay(2000)
               println("Coroutine Scope 2000")

           }
           launch {
               delay(1500)
               println("launch Scope 1500")
           }
           launch(Dispatchers.IO) {
               delay(1000)
               println("launch Scope 1000")
           }

           GlobalScope.launch(Dispatchers.IO) {
               delay(4000)
               println("GlobalScope Scope 4000")
           }*//*


    }

    println("outside run block")


*//*    println("Above OutSide Coroutine")

   // delay(500)


    GlobalScope.launch {
        delay(1000L)
        println("Hello Inside Global")
    }*//*

    *//* coroutineScope {

     }
     runBlocking {
         coroutineScope {
             delay(3500L)
             println("Hello Inside coroutineScope")
         }
     }*//*

    *//* coroutineScope {
         delay(1000L)
         println("Hello Inside coroutineScope")
     }*//*
*//*    runBlocking {

        launch {
            delay(3000L)
            println("Hello Inside runBlocking")
        }


    }*//*


}*/

suspend fun show() {
    println("Hello before")
    delay(1000)
    println("Hello Suspend 1000")
    delay(2000)
    println("Hello Suspend 2000")
    delay(3000)
    println("Hello Suspend 3000")
    delay(2500)
    println("Hello Suspend 2500")
}

suspend fun display() {
    println("display before")
    delay(1000)
    println("display Suspend 1000")
    delay(2000)
    println("display Suspend 2000")
    delay(3000)
    println("display Suspend 3000")
    delay(2500)
    println("display Suspend 2500")
}

suspend fun function1(): String {
    delay(1000L)
    val message = "function1"
    println("Launch $message")
    return message
}

suspend fun modification(it: Int): Int {
    return it * it
}

suspend fun function2(): String {
    delay(100L)
    val message = "function2"
    println("Launch $message")
    return message
}