import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        //takeOperator()
        //reduceOperator()
        flowOnOperator()
    }
}

// Change the context on which flow is emitted
suspend fun flowOnOperator(){
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect{
            println(it)
        }
}

suspend fun reduceOperator(){

    val size = 10
    val factorial = (1..size).asFlow()
        .reduce { accumulator, value -> accumulator*value  }

    println("Factorial of $size is $factorial")

}
suspend fun takeOperator(){
    (1..10).asFlow().take(2).collect{
        println(it)
    }
}

