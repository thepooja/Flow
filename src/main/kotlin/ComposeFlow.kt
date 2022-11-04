import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
//        zipFlow()
        combineFlow()
    }
}

// It will match corresponding values of two flow
suspend fun zipFlow(){

    val english = flowOf("One","Two","Three")
    val french = flowOf("Un","Deux","Troix")
    english.zip(french){a,b -> "'$a' in french is '$b'"}
        .collect{ println(it) }
}

// Combine the latest value of one flow with latest value of another flow
suspend fun combineFlow(){
    val numbers = (1..5).asFlow().onEach { delay(300L) }
    val values = flowOf("One","Two","Three","Four","Five").onEach { delay(400L) }
    numbers.combine(values){n,v -> "$n -> $v"}
        .collect{ println(it) }
}