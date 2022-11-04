import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        sendNumbers().collect(){
            println("Numbers are : $it")
        }
    }
}

// 1. Creating Flow
fun sendNumbers() = flow{
   for (i in 1..10) emit(i)
}

// Another way to create flow -- 2
fun sendNumber2()= listOf(1,2,3).asFlow()

// Another way to create a flow
fun sendNumbers3() = flowOf("one","two","three")

