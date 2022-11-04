import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
//        tryCatch()
//        catch()
        completion()
    }
}

// It is like finally block
suspend fun completion(){
    (1..3).asFlow()
        .onEach { check(it!=2) }
        .onCompletion { cause ->
            if(cause !=null){
                println("Flow completed with Cause $cause")
            }
            else{
                println("Flow completed Successfully")
            }
        }
        .catch {  e -> println("Caught Exception $e")}
        .collect{ println(it) }
}

suspend fun catch(){
    (1..3).asFlow()
        .onEach { check(it!=2) }
        .catch { e -> println("Caught Exception $e") }
        .collect{ println(it) }
}

suspend fun tryCatch(){

    try{
        (1..3).asFlow()
            .onEach { check(it!= 2) }
            .collect{
                println(it)
            }
    }catch (e:Exception){
        println("Exception Occurred : $e")
    }
}