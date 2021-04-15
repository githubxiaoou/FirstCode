package pers.owen.firstcode.c10test

open class Person(val name: String, val age: Int)

public class Student(name: String, age: Int): Person(name, age)

public class Teacher(name: String, age: Int): Person(name, age)