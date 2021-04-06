# Python 3 Guide
- This is a compilation of all the useful concepts in Python 3 Programming

## What is Python
- Python is an interpreted, high level programming language. It supports various Programming Paradigms - Procedural, Object-Oriented and Functional

### Python 2 vs Python 3
- Python 2 is considered a legacy language and most packages do not support Python 2 especially for Data Science and AI. Python 3 is also much easier to learn as compared to Python 2.

## Object Oriented Programming (OOP) In Python

<details>
<summary>Main Methods</summary>

### What is it?
- The main method is the point of execution for the entire software application. It tells the interpreter where should it begin the program

### How it works 

~~~python
def sum(a, b):
	return a + b

if __name__ == '__main__':
	print(sum(1,2))  # Output will be 3
~~~

</details>

<details>
<summary>Constructors</summary>

### What is it?
- The main method of the class. This is used to instantiate a new object.

### How it works 

~~~python
class Hero:
	def __init__(self, name):
		self.name = name

if __name__ == '__main__':
	hero1 = Hero("Hero1")
~~~

</details>

<details>
<summary>The "self" parameter</summary>

### What is it?
- This keyword is to signify the current instance of the class. It is similar to the `this` keyword in Java. Without the self, doing `hero1.attack()` will result in the error that you have one less positional argument (parameter) being parsed into the method

### How it works 

~~~python
class Hero:
	def __init__(self, name):
		self.name = name

	def attack(self):
		print("attack")

if __name__ == '__main__':
	hero1 = Hero("Hero1")
	hero1.attack() # Do not specify the word self into the parameter, it is implicitly stated from hero1
~~~

</details>

## Functional Programming

<details>
<summary>lambda expressions</summary>

### What is it?
- This function has its roots based on lambda calculus. It allows programmers to create 
annonymous functions

### How it works 

~~~python
# Instead of the conventional way
def sum(x, y):
	return x + y

# This is how lambda expressions can be used to create functions
sum = lambda x, y : x + y
~~~

</details>

<details>
<summary>Higher Order Function</summary>

### What is it?
- Allows a function to be parsed as a parameter into another function

### How it works 

~~~python

~~~

</details>

<details>
<summary>filter function</summary>

### What is it?
- Works like an if statement that selects only elements that passes the predicate

### How it works 

filter(_predicate_)

~~~python
# Given a list l
l = [1,2,3,4,5,6]

# output should be [2,4,6]
list(filter(lambda x : x % 2 == 0,l))
~~~

</details>

<details>
<summary>map function</summary>

### What is it?
- Works like an if statement that selects only elements that passes the predicate

### How it works 
It will map an object of the Domain to Co-Domain

Consider the following using `abs` function in python

in general x -> x and -x -> x

- -1 -> 1
-  2 -> 2
- -3 -> 3

~~~python
# Given a list l
l = [-1,2,-3,4,-5,6]

# output should be [1,2,3,4,5,6]
list(map(abs,l))
~~~

</details>

<details>
<summary>reduce function</summary>

### What is it?
- Reduces all values in an iterable down to a single value based on the given function

### How it works 

~~~python
from functools import reduce

# Output will be 720 (1 * 2 * 3 * 4 * 5 * 6)
reduce(lambda x,y : x * y, range(1,7))
~~~

</details>


