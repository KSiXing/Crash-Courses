# Java Guide
- This is a compilation of all the useful concepts in Java Programming

## What is Java
- Java is a compiled, Object Oriented Programming (OOP) language

## Access Modifiers 
**Private** - Only visible in the class. It is not accessible outside the class.
**(Default)** - Only visible in the package. It is not accessible by programs outside of the package. If no access modifier is specified, it will be default.
**Protected** - Visible in the package and subclasses of this class in any package.
**Public** - Visible to all programs in any package. 

## Object-Oriented Programming (OOP) Principles
<details>
<summary>Abstraction</summary>

### What is it?
- Abstraction means using simple things to represent complexity. For example, we all know how to eat cordon bleu, but we don’t need to know how to cook it in order to enjoy it.
- In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This prevents the codes from repeating the same work multiple times. 

### How it works 
- Abstraction as an OOP concept in Java works by letting programmers create useful, reusable tools. 
- For instance, a class of variable might be a student. The class might specify that each student object shall have a name, faculty, year, and contact number. The objects, in this case, might be science students, art students, or computing students etc.
</details>

<details>
<summary>Encapsulation</summary>

### What is it?
This is the practice of keeping fields within a class private, then providing access to them via public methods. It’s a protective barrier that keeps the data and code safe within the class itself. This way, we can re-use objects like code components or variables without allowing open access to the data system-wide.

</details>


<details>
<summary>Inheritance</summary>

### What is it?
It lets programmers create new classes that share some of the attributes of existing classes. This lets us build on previous work without reinventing the wheel.

### How it works 
It works by letting a new class adopt the properties of another. We call the inheriting class a subclass or a child class. The original class is often called the parent. We use the keyword extends to define a new class that inherits properties from an old class.

</details>


<details>
<summary>Polymorphism</summary>

### What is it?
This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. (More on overloading and overriding later)

</details>

## S.O.L.I.D Principle (5 Principles of Object Oriented Design)
**S**ingle Responsibility Principle
**O**pen Close Principle
**L**iskov Substitution Principle
**I**nterface Segregation Principle
**D**ependency Inversion Principle

## (Method) Overriding vs Overloading
- Method overriding occurs when a function in a **child class** overrides the same function in its **parent class**. 
  A common example is the toString() method in java's Object class. When overriding a method, it is a good
  habit to add a `@Override` annotation to allow the compiler to check if overriding is indeed happening. Overriden
  methods must have the same method signatures as the method it is overriding from its parent.
- Method overloading is when there are more than one functions of the same name, but each of those functions 
  have different parameters. For example foo(int a, int b) and foo(double a, double b) is an example of 
  overloaded methods.

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