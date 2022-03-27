package com.example.kotlin_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data1: Int = 10     // 상수
        var data2: Int = 20     // 변수

        val data3: Int = 10     // 타입 지정
        val data4 = 10          // 타입 추론

        // 초기화 미루기 -> var 키워드로 선언한 변수만 가능
        // Int, Long, Short, Double, Float, Boolean, Byte 타입 사용 불가
        lateinit var data5: String  // 초기화 미루기
        data5 = "20"

        // lazy 마지막 줄의 실행결과가 변수의 초깃값, val에서만 사용 가능
        val data6: Int by lazy {
            println("lazy in lazy......")
            10
        }

        fun testLazy(){
            println("lazy"+"in testLazy......")
            println("lazy ${data6+10}")
            println("lazy "+(data6 + 20))
        }

        testLazy()

        // 데이터 타입
        // Kotlin에서는 모든 변수는 객체이다
        // 정수를 다루는 타입인 Int는 기초 데이터 타입이 아니라 클래스이다.
        // null은 객체가 선언만 되고 메모리 할당이 되지 않았음을 의미한다.
        fun someFun(){
            var data1: Int = 10
            var data2: Int? = null

            data1 = data1+10
            data1 = data1.plus(20)

            println("Data Type $data1")
        }
        someFun()

        // 2진수 표현
        val a1: Byte = 0b00001011

        // 정수 표현
        val a2: Int = 123
        val a3: Short = 123
        val a4: Long = 10L //

        // 실수 표현
        val a5: Double = 10.0
        val a6: Float = 20.0f // Float형은 f붙여주어야 함

        // true나 false를 표현하는 Boolean 타입
        val a7: Boolean = true

        // Char은 문자 표현, 작은따옴표(')로 감싸서 표현
        // Number 타입으로 표현 못한다.
        val a: Char = 'a'
//        if(a==1){     // 사용 불가
//        }


        // 문자열
        // 삼중 따옴표 -> 줄 바꿈이나 들여쓰기 등이 데이터에 그대로 반영
        // .trimIndent() 함수가 자동으로 추가된다.
        // 위 함수는 문자열 앞에 공백을 없애 준다.
        fun testStr(){
            val str1 = "Hello \n World"
            val str2 = """
                HELLO    k
                     WORLD
            """.trimIndent()

            println(str1)
            println(str2)
        }
        testStr()

        // 문자열 템플릿
        fun plus(no: Int): Int{
            var sum = 0
            for(i in 1..no){
                sum+=i
            }
            return sum
        }
        val name: String = "KNU"
        println("name : $name, sum : ${plus(10)}, minus : ${10 - 20}")

        // Any - 모든 타입 가능
        val any1: Any = 10
        val any2: Any = "hello"

        // Unit - 반환문이 없는 함수
        val unit1: Unit = Unit
//        fun some(): Unit {
//            println("Unit 테스트"+(10+20))
//        }
//        some()
        fun some(){
            println("Unit 테스트"+(10+20))
        }
        some()

        // 반환문이 없음을 명시적으로 나타낼 때 Unit 타입을 사용한다.

        // Nothing - null이나 예외를 반환하는 함수
        // Nothing 변수에는 null만 대입 가능
        val nothing1: Nothing? = null
        fun some1(): Nothing? {
            return null
        }
        fun some2(): Nothing{
            throw Exception()
        }
        // 반환은 하지만 의미 있는 갓은 아니라는 의미
        // 항상 null만 반환하는 함수라든가 예외를 던지는 함수에 사용

        // 널 허용과 불허용
        // 널 불허용
//        var nullTest1 : Int = 10
//        nullTest1 = null
        // 널 허용
//        var nullTest2 : Int? = 20
//        nullTest2 = null

        // 함수 선언하기
        // fun 함수명(매개변수명: 타입): 반환 타입 {...}
        // 매개변수는 val로 자동으로 적용되며 함수 안에서 값 변경 불가
//        fun funTest(data1 : Int){
//            data1 = 20  // 불가
//        }

        fun funTest(data1: Int, data2: Int): Int{
            return data1 - data2
        }
        println("함수 선언"+funTest(10,20))
        println("함수 선언"+funTest(data2 = 20, data1 = 10)) // 명명된 매개변수

    }
}