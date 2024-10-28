_This is an assignment to the class [Advanced Programming](https://hsro-inf-fpk.github.io) at the [University of Applied Sciences Rosenheim](http://www.th-rosenheim.de)._

# Assignment 4: Generics

## Task 1: Homework (on paper!)

Given is the following code. It is not very clean. You could also say the 'code smells! 

Imagine that the switch statement would be more complex and even more complicated MIDI sequences would have to be programmed when playing the chords.

```java
public static void main(String[] args) {
    String chords = "C G A C G F C";
    for (String chord: chords.split(" ")) {
        switch (chord) { 
            case "C":
                System.out.printf("c_e_g "); break
            case "G":
                System.out.printf("g_d_d "); break;
            case "A":
                System.out.printf("a_e_c "); break;
            case "F":
                System.out.printf("f_a_c "); break; 
            case "D":
                System.out.printf("d_fis_a "); break;
            default:
                System.out.printf("---"); 
        }
    } 
}
```

Replace the switch statement with an _enum_ class `Chord`. 
In the end, the switch statement should be replaceable by the following code:

```java
public static void main(String[] args) {
    List<Chord> chords = Arrays.asList(
            Chord.C, Chord.G, Chord.A, Chord.F, Chord.C, Chord.G, Chord.F, Chord.C); 
    for (Chord c:chords) {
        c.play(); 
    }
}
```
How does the enum class `Chord` looks like?

## Task 2: Coding
In this assignment we want to improve the previously implemented `SimpleListImpl` of [Assignment 2](https://github.com/hsro-inf-fpk/02-classes-interfaces).
Back then, `SimpleListImpl` was implemented to store references of type `Object`, which in turn required a type cast on retrieval:

```java
SimpleList sl = new SimpleListImpl();
sl.add(new MyClass());
MyClass k = (MyClass) sl.get(0);
```

Inside `SimpleListImpl`, the knowledge about the actual class was lost, and worse: the following code would compile but produce a runtime exception:

```java
SimpleList sl = new SimpleListImpl();
sl.add(new MyClass());
sl.add(new MyOtherClass());
MyClass k1 = (MyClass) sl.get(0);  // all ok
MyClass k2 = (MyOtherClass) sl.get(1);  // ClassCastException!
```

Generics help us to avoid both the type cast and the risk of runtime exceptions by checking the type at compile time.

For this assignment, start with the reference solution of assignment 2 and the `abstract` model class `Plant`.


## Setup

1. Clone the project (get the link by clicking the green _Clone or download button_)
2. Import the project to your IDE (remember the guide in assignment 1)
3. Validate your environment by running the tests from your IntelliJ and by running `gradle test` on the command line.


## Generic Lists

![class spec 1](assets/class-spec-1.svg)

To make a class generic, introduce a generic type (typically named `T`) in the class or interface signature, and replace all affected actual types with the generic type.

1. Make the following interfaces and classes generic
    * `SimpleList`
    * `SimpleListImpl`
    * `SimpleIterator`
    * `ListElement`
2. If necessary, adopt changes in the test class `SimpleListTests.java`
3. Remove now the unnecessary type casts
4. Add a method `get(...)` to the `SimpleList` interface, we will need to write the implementation in `SimpleListImpl`.
This method will return the element at the specified position in a list.
5. Add a new method `set(...)` to the `SimpleList` interface, we will need to write the implementation in `SimpleListImpl`.
This method it replaces the element at the specified position in a list with the specified element.


## Generic & Default Methods

In the second part we want to focus on generic and `default` methods.

1. Implement the `filter(...)` method as `default` method in the `SimpleList` interface. The method has an argument Predicate<T> this is a functional interface, which has 
a method `boolean test(T t)`. Usually, it used to apply in a filter for a collection of objects.

**Remember, an untested implementation is worthless! Write tests for the implemented method's .**


## Groundwork for Plant Assigment

First, create the model for this assignment:

![Model spec](./assets/class-spec-3.svg)

1. Create the `enum` _PlantColor_
2. Implement the `abstract` class _Plant_
3. Implement the child classes _Flower_ and _Shrub_<br>
   _Remarks:_ A shrub is always green; a flower may be any color
   **but** green (handle a wrong value in the constructor - throw an
IllegalArgumentException).
4. Implement the `Comparable` accordingly to `Uml`, a plant is same if it has same height.
5. Create tests to ensure that your model classes are correct (e.g.
green flowers won't work)


## Basic Bounds

Implement a `PlantBed` which manages a list of plants (use
`SimpleList<T>` which you can find in collections!).

![PlantBed spec](./assets/class-spec-4.svg)

A `PlantBed` may contain any subclass of `Plant` but nothing else!
Use appropriate bounds when declaring the generic class.

_Remarks:_ The method `getPlantsByColor` is very easy to implement if
you think of the `filter` method of the `SimpleList`! Remember to create
tests for nearly every line you code!


## Bounds on Wildcards

Last but not least we'll look at a very specific problem - the PECS (**P**roducer **E**xtends **C**onsumer **S**uper) principle.

![Utils spec](./assets/class-spec-5.svg)

1. Implement the utility method `splitBedByColor` in a utility class `PlantBedUtility`.
_Remark:_ the above UML diagram for the utility method does not include any bounds but you 
**need** some -- the compiler is unable to capture the types if you implement the method strictly as described in the UML!
2. We want to copy one `SimpleList<Flower>` into a `SimpleList<Plant>`, but this will not work because covariance is
not allowed with generics. The so-called wildcards provide a remedy.<br>
_Hint:_ <br>
`extends`(=Upper-bounded) to read<br>
`super`(=Lower-bounded-type) to write 
3. We do the same as above, but this time we use the 'Predicate' to add only the yellow flowers to the destination list.
