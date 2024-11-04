_This is an assignment to the class [Advanced Programming](https://hsro-inf-fpk.github.io) at the [University of Applied Sciences Rosenheim](http://www.th-rosenheim.de)._

# Assignment 5: Annotations and Reflection


In this assignment we will use Java annotations and reflection to interact with a remote REST ([Representational State Transfer](https://en.wikipedia.org/wiki/Representational_state_transfer)) API.

This assignment is split into two parts:
1. De-/Serializable with GSON
1. Remote REST calls with Retrofit.
 
As everyone (or maybe just me) loves Chuck Norris jokes we will implement a simple program to get random Chuck Norris jokes from the [Chucknorris.io](https://chucknorris.io).


## Setup

1. Create a fork of this repository (button in the right upper corner)
2. Clone the project (get the link by clicking the green _Clone or download button_)
3. Import the project to your IDE (remember the guide in [assignment 1](https://github.com/hsro-inf-prg3/01-tools))
4. Validate your environment by running the tests from your IntelliJ and by running `gradle test` on the command line.


## Gradle and Dependency Management

When we started to use Gradle we already talked about dependency management.
In this assignment we will use Gradle to manage the required libraries.

To complete this assignment you will need the following libraries:

* [Retrofit](http://square.github.io/retrofit/) by Square
* [Gson](https://github.com/google/gson) by Google

With Gradle, project dependencies (both at compile and runtime) are specified in the `build.gradle` file, in the `dependencies` section.
Open the existing [build.gradle](./build.gradle) file and inspect the `dependencies` object (Gradle uses [Groovy](http://groovy-lang.org/), a language similar to Java and Javascript).
Every dependency has a scope where it will be available.
To use a library across the whole project, declare it with the scope `implementation`.

As an example of dependencies:

```
dependencies {
    implementation("org.apache.commons:commons-lang3:$commons_lang3_version")
    implementation("org.apache.logging.log4j:log4j-api:${log4j2Version}")
    implementation("org.apache.logging.log4j:log4j-core:${log4j2Version}")

    // --> NEW DEPENDENCIES SHOULD GO HERE! FIND OUT WHICH!

    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${junitVersion}")
}
```

The dependencies for Retrofit and Gson you might find on the web sites! Please validate that these are the correct dependencies you need:

```
    implementation("com.squareup.retrofit2:retrofit:${retrofit_version}")
    implementation("com.squareup.retrofit2:converter-gson:${retrofit_version}")
```

Gradle is designed to help you in all development phases and is extensible by plugins.
In the given `build.gradle` are three plugins already applied:

* `java`: brings Java support to Gradle e.g. compilation)
* `application`: enable you to run and package the application you will develop in this assignment
* `idea`: helps with IntelliJ import

To run the `main` method in the `App` class without IntelliJ you can now use the following Gradle command on the command line:

```bash
gradle run
```


## Overview

The hard part of this assignment is you need to combine three parts to form the whole program:

- Gson for serialization (to/from [JSON](http://json.org))
- Retrofit for HTTP requests

It is strongly advised to read through the whole assignment and related documentations first; having the complete picture before starting with the parts helps a lot!


## Part 1: Gson

Google Gson is a library to serialize and deserialize [JSON](https://en.wikipedia.org/wiki/JSON) to or from Java objects.

### a)

- Use the `Joke` class in an try to serialize and deserialize it. Be aware that your `joke` class is different to the JSON format below. 

Therefore, you have to use annotations (@SerializedName) for mapping.
- Write various tests for serialization and deserialization. Do not forget to test categories/rubrics

- How would you write your own `toJson` and `fromJson` using reflection and annotations. 

### Model

The following code snippet shows the structure of a simple JSON object:

```json
{
    "id": "558",
    "value": "Ghosts are actually caused by Chuck Norris killing people faster than Death can process them.",
    "categories": []
}
```

The most basic use case is to de/serialize objects; by default, GSON uses reflection to determine the properties.

```java
class Joke {
  String number;
  String content;
  String[] rubrics;
}
```
Try to get the following code in `App.main` running:

```java
Gson gson = new Gson();

// JSON String --> Object
Joke j = gson.fromJson("{\"id\": 10, \"joke\": \"Haha.\"}", Joke.class);
// categories remains `null`

// Object --> JSON String
String json = gson.toJson(j);
```

Gson makes use of annotations to map JSON keys to fields of your class.
Have a look at the [docs](https://github.com/google/gson/blob/master/UserGuide.md) and complete the model described in the following UML:

![Model spec](./assets/images/ModelSpec.svg)

> Hint: the given JSON object describes the exact structure of the JSON objects we want to deserialize.
> Use annotations to help gson map JSON fields to differently named Java field names.

**Here is what to do:**
- Import Gson to your project (dependencies in your build.gradle)
- Familiarize yourself with Gson by trying a few examples
- Get familiar with the `@SerializedName` annotation
- Get the code snippet in `App.main` running and try a few serialization and deserelization things
- Write a couple of tests to your mapping

What if your Json would look like this?

```json
{ "total": 3, 
  "result": [ 
    { "id": "164", 
      "value": "Chuck Norris once sued Burger King after they refused to put razor wire in his Whopper Jr, insisting that that actually is &quot;his&quot; way.", 
      "categories": [] }, 
    { "id": "275", 
      "value": "Little Miss Muffet sat on her tuffet, until Chuck Norris roundhouse kicked her into a glacier.", 
      "categories": [] }, 
     { "id": "66", 
       "value": "Chuck Norris can't finish a &quot;color by numbers&quot; because his markers are filled with the blood of his victims. Unfortunately, all blood is dark red.", 
       "categories": [] } 
  ],  
}
```

* Can you write a Java class to which GSON could serialize this?
* Make reuse of your `Joke` class


## Part II: Retrofit and Gson

Next step, lets figure out the format of the ICNDB jokes. Open your browser and try the following URL:

[https://api.chucknorris.io/jokes/random](https://api.chucknorris.io/jokes/random)

As you could see, the actual response body of the ICNDB API looks like the following (your might be different content-wise since it is random!):

```json
{
	"categories":[],
	"created_at":"2020-01-05 13:42:29.569033",
	"icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png",
	"id":"DFufkxxKRnesp7rCuEmHdg",
	"updated_at":"2020-01-05 13:42:29.569033",
	"url":"https://api.chucknorris.io/jokes/DFufkxxKRnesp7rCuEmHdg",
	"value":"It's a little known fact that Chuck Norris's cat had a part in Harry Potter. To conceal her identity they called her \" Mrs Norris\"."
}
```

The actual joke (`Joke`) needs to be an extended version so that it matches the returned json!.:

* Test if deserialization would work.

## Retrofit

Retrofit is a library to implement HTTP clients.
To create an HTTP client, create an interface containing some methods you will call later to perform HTTP requests.
Retrofit also uses annotations to conveniently map these methods to API resource paths, e.g. `getJokeByQuery("Bruce")` can be mapped to `https://api.chucknorris.io/jokes/search?query=Bruce`.

Read through the [Retrofit documentation](http://square.github.io/retrofit/) and implement the `ICNDBApi` so that you can provide a query string and return a list of jokes.

- Get the correct dependencies in your `build.gradle`
- Start by implementing the method `getRandomJoke()`; use the appropriate annotations to decodate the interface method.
- Modify the `main` method in the `App` class to create an instance of the `ICNDBApi` using `Retrofit.Builder`.

```java
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.chucknorris.io")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
```

- As you can see in the interface definition of ICNDBApi we are using either the `Joke` or the `Jokes` class directly.
- To do so, we have to use the `GsonConverterFactroy` (as you can see in the code above!)
- Print a random joke to `System.out`, and complete the test methods `testGetRandomJoke` and `testGetJokeByQuery`. Recall that you work with `Call` objects that need to be executed before you can retrieve the response body.
- After completing the `getRandomJoke()` method try to add the other methods.
- If you are not sure if your query strings are correct you can test them within the command line using `curl` or in a browser extension such as [Postman](https://www.getpostman.com/).

Most unix systems will provide the cURL program:

```bash
curl -X GET "https://api.chucknorris.io/jokes/random" -H "accept: application/json"
```

On Windows, you can use the PowerShell to accomplish the same like so:

```ps
(Invoke-WebRequest
    -Uri https://api.chucknorris.io/jokes/random
    -Headers @{"accept"="application/json"}
    ).Content | ConvertFrom-Json | ConvertTo-Json
```

(The part `| ConvertFrom-Json | ConvertTo-Json` is only necessary for formatting.)

_Remark: to execute this command you have to remove the newlines!_
