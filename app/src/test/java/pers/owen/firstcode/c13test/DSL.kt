package pers.owen.firstcode.c13test

class Dependency {
    val libraries = ArrayList<String>()

    fun implementation(lib: String) {
        libraries.add(lib)
    }
}

fun dependencies(block: Dependency.() -> Unit): List<String> {
    val dependency = Dependency()
    dependency.block()
    return dependency.libraries
}

fun main() {
    val libraries = dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0")
    }

    for (library in libraries) {
        println(libraries)
    }
}