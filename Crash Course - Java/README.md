# Java Guide
- This is a compilation of all the useful concepts in Java Programming

## What is Java
- Java is a compiled, Object Oriented Programming (OOP) language

## Access Modifiers 
- **Private** - Only visible in the class. It is not accessible outside the class.
- **(Default)** - Only visible in the package. It is not accessible by programs outside of the package. If no access modifier is specified, it will be default.
- **Protected** - Visible in the package and subclasses of this class in any package.
- **Public** - Visible to all programs in any package. 

## Object-Oriented Programming (OOP) Principles
<details>
<summary>Abstraction</summary>

### What is it?
- Abstraction means using simple things to represent complexity. Only essential attributes are visible to other classes, and the rest are kept private

### How it works 
- Abstraction as an OOP concept in Java works by letting programmers create useful, reusable tools. 
- For instance, we have a Module and a Student class. A module can have many students. The lecturer in charge of the module may only need to know the name of the students, he does not need to know what other module that student is enrolled in as well. As such, we can specify a `Student::getName` method in the Student class in the Module class. The module class should not be able to access all other attributes pertaining to the Student class like his age, personal details or the other modules he is doing
</details>

<details>
<summary>Encapsulation</summary>

### What is it?
This is the practice of keeping fields within a class private, then providing access to them via public methods. It’s ensures the confidentiality of the attributes within the class itself. 

</details>


<details>
<summary>Inheritance</summary>

### What is it?
It lets programmers create new classes that share some of the attributes of existing classes. 

### How it works 
It allow the new class to inherit the properties of their parent. We call the inherting class a subclass or a child class. The super class is also known as the parent. We use the keyword extends to define a child class that inherits properties from a parent class.

</details>


<details>
<summary>Polymorphism</summary>

### What is it?
This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. (More on overloading and overriding later)

</details>

## S.O.L.I.D Principle (5 Principles of Object Oriented Design)
- **S**ingle Responsibility Principle
- **O**pen Close Principle
- **L**iskov Substitution Principle
- **I**nterface Segregation Principle
- **D**ependency Inversion Principle

## (Method) Overriding vs Overloading
- Method overriding occurs when a function in a **child class** overrides the same function in its **parent class**. 
  A common example is the toString() method in java's Object class. When overriding a method, it is a good
  habit to add a `@Override` annotation to allow the compiler to check if overriding is indeed happening. Overriden
  methods must have the same method signatures as the method it is overriding from its parent.
- Method overloading is when there are more than one functions of the same name, but each of those functions 
  have different parameters. For example foo(int a, int b) and foo(double a, double b) is an example of overloaded methods.

## Inheritance vs Composition
- **Inheritance** is an **"is-a"** relationship while **Composition** is a **"has-a"** relationship

### Inheritance Example

~~~java
public class Hero {
	private final String name;

	/**
	 *  This is a constructor - the method that is used for object creation.
	 *  if no constructor is specified, java provides a default with no arguments
	 *	i.e. public hero();
	 */
	public Hero(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.name + " is a hero";
	}

	@Override
	public String toString() {
		return this.name;
	}
}

// We use the extends keyword to signify the parent of the current class
public class Warrior extends Hero { 
	private final String weapon;

	public Warrior(String name, String weapon) {
		/**
		 * Since the parent class requires 1 argument, we use the super() keyword 
		 * to pass the required argument to the parent. This function must be the 
		 * first statement in the constructor
		 */
		super(name); 
		this.weapon = weapon;
	}

	@Override
	public String getStatus() {
		return super.toString() + " is a warrior";
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
~~~

### Composition Example

~~~java
// Assuming we have the hero and warrior classes from the Inheritance example

public class Party {
	private final String name;
	private final Hero player1; // The Hero object is part of the Party object
	private final Hero player2;

	public Party(String name, Hero player1, Hero player2) {
		this.name = name;
		this.player1 = player1;
		this.player2 = player2;
	}

	@Override
	public String toString() {
		return "[" + this.player1 + ", " + this.player2 + "]";
	}
}
~~~

## Functional Programming (FP) Principles
<details>
<summary>Immutability</summary>

### What is it?
Immutability means that once, you assigned a value to that variable, it can no longer be changed. 

### How it works?
When we initialize a variable or object, it is effectively final if we do not change it. All variables must be final or effectively final if they are to be used in lambda expressions, annoymous classes or inner classes. One way to make a variable immutable is through the use of the `final` keyword.

</details>

<details>
<summary>Pure Functions and No Side Effects</summary>

### What is it?
A pure function is one that returns the same output for the same given input. It is free from side effects such as `System.out::println`

</details>


<details>
<summary>First Class Functions and Higher Order Functions</summary>

### What is it?
First Class Functions are functions that are treated like objects. Higher Order Functions are functions that can take in at least one First Class Function as an argument or return a First Class Function

### How it works 

~~~java
import java.util.function.Function;
 
Function<Integer, Integer> square = x -> x * x;

public int sum_of_square(Function<Integer, Integer> square, int x, int y) {
		int x_square = square.apply(x);
		int y_square = square.apply(y);
		return x_square + y_square;
}
~~~


</details>

## Lazy Evalutaion and Streams

<details>
<summary>Lazy Evaluation</summary>

### What is it?
Lazy Evaluation is to evaluate what is necesary and at the very last moment. This is most commonly implemented using `Streams` or `Supplier`

</details>

<details>
<summary>Streams</summary>

### What is it?
Streams represents a sequence of elements and supports various operations. Stream operation can either be intermediate or terminal. Intermediate operations return a stream and futher operations can be made on that stream. On the other hand, terminal operation return either a void or non-stream result. Examples of terminal operations includes `forEach`, `reduce`, `count`. 

### How it works 

~~~java
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

List<Integer> intlist = Arrays.asList(0, 1, 2, 5, 6, 3, 4);

intlist
   .stream()
   .filter(x -> x % 2 == 0)  // Take only even numbers
   .map(x -> x * 2) 				 // Multiply the even values by 2
   .reduce((x,y) -> x + y)   // Sum up all the values
   .orElse(0);
~~~

</details>