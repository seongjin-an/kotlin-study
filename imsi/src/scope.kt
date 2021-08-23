class Scope {
    companion object{
        private var instance:Scope? = null
        fun getInstance(): Scope {
            return instance?: Scope().also{ scope ->
                instance = scope
            }
        }
    }
    private constructor(){
        println("Scope object's created")
    }
}
/*
apply, with, let, also, run
범위 지정 함수의 공통점과 차이점(scope functions: 일시적으로 만들어서 속성(property)이나 함수를 처리하는 용도로 사용되는 함수)
이 함수들은 두가지 구성 요소를 가진다.
수신객체(receiver), 수신 객체 지정 람다(lambda with receiver)
 */
data class Person(var name: String, var age: Int)
fun main(){
    val ps = Person("", 0);
    ps.name = "James"
    ps.age = 56
    println("ps: $ps")
    /*
    1. let
    fun <T, R> T.let(block: (T) -> R): R
    let 함수는 매개변수화된 타입 T의 확장 함수이다.
    (extension) 자기 자신을 받아서 R을 반환하는 람다 식을 입력으로 받고, 블럭함수의 반환값 R을 반환한다.
     */
    val person = Person("", 0)
    val resultIt = person.let{
        it.name = "James"
        it.age = 56
        it
    }
    println("resultIt: $resultIt")
    val resultStr = person.let{
        it.name="Steve"
        it.age = 59
        "${it.name} is ${it.age}"
    }
    println("resultStr: $resultStr")
    val resultUnit = person.let{
        it.name = "Joe"
        it.age = 63
    }
    println("resultUnit: $resultUnit")
    //또한 T?.let{} 형태에서의 let 블럭 안에는 non-null 만 들어올 수 있어 non-null 체크 시에 유용하게 쓸 수 있다.

    /*
    2. with
    fun <T, R> with(receiver: T, block: T.() -R): R
    with는 일반 함수이기 때문에 객체 receiver를 직접 입력 받고, 객체를 사용하기 위한 두 번째 파라미터 블럭을 받는다.
    T.()를 람다 리시버라고 하는데, 입력을 받으면 함수 내에서 this를 사용하지 않고도 입력받은 객체 receiver의 속성을 변경할 수 있다.
    즉, 아래 예제에서 with(T) 타입으로 Person을 받으면 {}내의 블럭 안에서 곧바로 name이나 age 프로퍼티에 접근할 수 있다.
    with는 non-null의 객체를 사용하고 블럭의 return 값이 필요하지 않을 때 사용한다.
     */

    val personWith = Person("James", 44)
    val imsi = with(person){
        println(name)
        println(age)
        //만약 자기 자신을 반환해야 하는 경우 it이 아닌 this를 사용한다. let은 it을 사용하면 됨
    }
    println("imsi: $imsi")

    /*
    3. run
    run은 두 가지 형태로 선언되어 있다. 먼저 첫 번째는 이렇게 생겼다.
    fun <T, R> T.run(block: T.() ->R): R
    run은 with처럼 인자로 람다 리시버를 받고, 반환 형태도 비슷하게 생겼지만 T의 확장함수라는 점에서 차이가 있다.
    확장함수이기 때문에 safe call(.?)을 붙여 non-null일 때에만 실행할 수 있다. 어떤 값을 계산할 필요가 있거나 여러 개의 지역변수 범위를 제한할 때 사용한다.
     */
    val personRun = Person("Jack", 22)
    val ageNextYear = personRun.run{
        ++age
        //run 역시 자기 자신을 반환해야 하는 경우 it이 아닌 this를 사용한다.
    }
    println("ageNextYear: $ageNextYear")
    /*
    fun <R> run(block: () -> R):R
    이 run은 확장 함수가 아니고, 블럭에 입력값도 없다. 따라서 객체를 전달받아서 소것ㅇ을 변경하는 형식에 사용되는 함수가 아니다.
    이 함수는 어떤 객체를 생성하기 위한 명령문을 블럭 안에 묶음으로써 가독성을 높이는 역할을 한다.
     */
    val personRun2 = run{
        val name = "JJ"
        val age = 33
        Person(name, age)
    }
    println("personRun2: $personRun2")
    /*
    4. apply
    fun <T> T.apply(block: T.() -> Unit): T
    apply는 T의 확장 함수이고, 블럭 함수의 입력을 람다 리시버로 받았기 때문에 블럭 안에서 객체의 프로퍼티를 호출할 때 it,
    this를 사용할 필요가 없다. run과 유사하지만 블럭에서 return 값을 받지 않으며 자기 자신인 T를 반환한다는 점이 다르다.
     */
    val personApply = Person("", 0)
    val resultApply = person.apply{
        name = "TT"
        age = 44
    }
    println("resultApply: $resultApply")
    /*
    5. also
    fun <T> T.also(block: (T) -> unit): T
    also는 T의 확장함수이고, 블럭 함수의 입력으로 람다 리시버를 받지 않고 this로 받았다. apply와 마찬가지로 T를 반환한다.
     */
    val personAlso = Person("", 0)
    val resultAlso = person.also{
        it.name = "HH"
        it.age = 77
    }
    println("resultAlso: $resultAlso")
}
/*
conclusion
function    object reference    return value    is extension function
let         it                  lambda result   yes
run         this                lambda result   yes
run         -                   lambda result   no, called without the context object
with        this                lambda result   no, takes the context object as argument
apply       this                context object  yes
also        it                  context object  yes
------------------------------------------------------------------------------------------
fun <T, R> T.let(block: (T) -> R): R
fun <T, R> T.run(block: T.() -> R): R
fun <R> run(block: () -> R): R
fun <T, R> with(receiver: T, block: T.() -> R): R
fun <T> T.apply(block: T.() -> Unit): T
fun <T> T.also(block: (T) -> Unit): T
 */