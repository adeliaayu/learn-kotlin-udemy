package generics

fun main() {

    // Parameterized Classes
    val parameterClass = ParameterizedClass("Apple")

    val res = parameterClass.getValue()

    println(res)

    // The Out Keyword - Assign this reference to any of its SUPERTYPE
    val outParameterizedProducer = OutParameterizedClass("Orange")

    val refOut: OutParameterizedClass<Any> = outParameterizedProducer       // bisa di assign dari string ke any

    println(refOut.get())
    assert(refOut is OutParameterizedClass<Any>)

    // The In Keyword - Assign this reference to its SUBTYPE
    val inParameterizedCustomer = InParameterizedClass<Number>()
    println(inParameterizedCustomer.toString(6))

    val refIn: InParameterizedClass<Double> = inParameterizedCustomer       // bisa assign dari number ke Double
    println(refIn.toString(6.4))
    assert(refIn is InParameterizedClass<Double>)

    // Copy an Array of Subtype to an Array of Supertype
    fun copy(from: Array<out Any>, to: Array<Any?>){
        assert(from.size == to.size)
        for (i in from.indices)
            to[i] = from[i]

    }

    val ints: Array<Int> = arrayOf(1,2,3)
    val any: Array<Any?> = arrayOfNulls(3)

    copy(ints, any)

    assert(any[0] == 1)
    println(any[0] == ints[0])


    // Adding Elements of Subtype to an Array of Its Supertype
    fun fill(dest: Array<in Int>, value: Int) {
        dest[0] = value
    }

    val objects: Array<Any?> = arrayOfNulls(1)

    fill(objects, 1)

    println(objects[0] == 1)


    // Star Projections
    fun printArray(array: Array<*>){
        array.forEach { println(it) }
    }

    fun addArray(add: Array<*>){
//        add[0] = 1                   Error karena kita CUMAN BISA BACA, GABISA NULIS kalo pake star projections
    }

    val array = arrayOf(1,2,3)
    printArray(array)

    // Generic Constraints
    fun <T: Comparable<T>> sort(list: List<T>) : List<T> {
        return list.sorted()                // harus implement interface Comparable kalo mau pake sorted()
    }

    val listOfInts = listOf(6,3,7,2,8)

    val sorted = sort(listOfInts)

    assert(sorted == listOf(2,3,6,7,8))
    println(sorted == listOf(2,3,6,7,8))

    // Multiple Upper Bounds
    fun <T> sort(xs: List<T>) where T : CharSequence, T : Comparable<T> {       // kalo implement lebih dari 1 interface, harus dipisah pake where
        // sort the collection in place

    }

    class StringCollection<T>(xs: List<T>) where T : CharSequence, T : Comparable<T> {
        // omitted
    }

    // Type Erasure         - instans dari generic class tidak menyimpan tipe dari parameternya saat runtime
    val books: Set<String> = setOf("1984", "Brave new world")
    val primes: Set<Int> = setOf(2, 3, 11)

    // Reified Type Parameters
//    fun <T> Iterable<*>.filterIsInstance() = filter { it is T }       ERROR karena tipe dari T telah dihapus

    val set = setOf("1984", 2, 3, "Brave new world", 11)
    println(set.filterIsInstance<Int>())
}

inline fun <reified T> Iterable<*>.filterIsInstance() = filter { it is T }  // inline function harus diluar main function

// Parameterized Classes
class ParameterizedClass<T>(private val value: T) {

    fun getValue(): T {
        return value
    }
}

// The Out Keyword
class OutParameterizedClass<out T>(private val value: T){
    fun get() : T {
        return value
    }
}

// The In Keyword
class InParameterizedClass<in T>{
    fun toString(value: T): String {
        return value.toString()
    }
}