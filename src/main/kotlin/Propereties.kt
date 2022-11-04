import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {

    val numbersFlow = sendNewNumbers()
    println("Flow hasn't started yet")
    runBlocking {
        println("Starting Flow")
        //numbersFlow.collect{ println(it) }
        withTimeoutOrNull(1000L){
        cancelNumbers().collect{
            // due to timeout it will just print first two numbers, and flow will auto cancel
            println(it)
        }
        }
    }
}

fun sendNewNumbers() = listOf(1,2,3).asFlow()

// Flow cancel when timeout
fun cancelNumbers() = flow{
    listOf(1,2,3).forEach{
       kotlinx.coroutines.delay(400L)
        emit(it)
    }
}