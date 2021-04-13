package pers.owen.firstcode

//class MySet<T>(val helperSet: HashSet<T>) : Set<T> {
//    override fun contains(element: T) = helperSet.contains(element)
//
//    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)
//
//    override fun isEmpty() = helperSet.isEmpty()
//
//    override fun iterator() = helperSet.iterator()
//
//    override val size: Int
//        get() = helperSet.size
//
//}

class MySet<T>(val helperSet: HashSet<T>) : Set<T> by helperSet {

    fun helloWorld() = println("Hello World")

    override fun isEmpty() = false
}