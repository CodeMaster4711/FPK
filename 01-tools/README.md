_This is an assignment to the class [Advanced Programming](https://hsro-inf-fpk.github.io) at the [University of Applied Sciences Rosenheim](http://www.th-rosenheim.de)._

# Assignment 1: A (Java) software engineers toolbox


## Get familiar with Git

1. Familiarize yourself with [git](https://git-scm.com) by completing this [interactive tutorial](https://learngitbranching.js.org/) in your browser.
2. Install git on your machine.
	- Mac: Open `Terminal.app` and install the Apple Developer Tools by executing `xcode-select --install`.
	- Linux: Use your distribution's package manager to install git; on Ubuntu, you'll run something like 
		```bash
		$ sudo apt-get update
		$ sudo apt-get install git
		```
	- Windows: Download and install the [Windows installation package](https://git-scm.com/download/win); make sure to install (and use) git bash.
3. Try git in the real world - use Git - in our case GitLab:
	- Sign in on [GitLab TH Rosenheim](https://inf-git.fh-rosenheim.de) (you should have an account). As an alternative you can try to do the same on [GitHub](https://github.com/).
	- Create a new repository (note for GitHub: with a free account, you're limited to public repos); select __Initialize this repository with a README__ to add a `README.md` file.
	- On your computer, clone your new repository, edit the `README.md` to your choice, using the [GitHub markdown cheatsheet](https://guides.github.com/features/mastering-markdown/).
	- Add/stage and commit the changes, and push them to your repository.
	- Create and switch to a new branch (e.g. `feature/add-license`), and add a file `LICENSE` to it, containing the MIT open source software license.  For a real project, you may want to choose a different license (read more about licenses here: [https://opensource.org/licenses](https://opensource.org/licenses)). But this is actually a different story.
	- Push the branch; you should now be able to see it on GitHub.
	- On GitHub, create a pull request and merge it to master.
	- Back on your computer, checkout `master`, and pull the changes to update your local copy.

> Note: Since you'll be working on assignments together, it's a good idea to fork the official assignment repository, add your friend as a collaborator, and take it from there!

> You should now know what it means if someone asks you: Can you please merge my PR into your master branch?

## Get familiar with Gradle

0. Install the [Gradle build tool](https://gradle.org/) (use Gradle 8.3); make sure you have a recent [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) (JDK 19) installed and configured for command line use.
1. Familiarize yourself by completing the [Java application tutorial](https://guides.gradle.org/building-java-applications/). Note: This requires a command line shell, such as bash. If you're running Windows, you can use **Powershell**, **Cmd** or git's bash. In case you have Linux subsystem installed on Windows, you could try to use this.

> Note: Using the gradle wrapper is generally advised.

> You should now know how to read a basic `build.gradle` file, and what `gradle build` means.


## Get familiar with IntelliJ

1. Make sure you have the latest [IntelliJ IDEA](https://www.jetbrains.com/idea/) installed (it's [free for educational use](https://www.jetbrains.com/student/)!). Ideally, you pick the **Community Edition** which is free anyway.
2. On first launch, you may have to configure the default project structure and check your installed/configured JDKs:
	![Configure default project structure](./assets/idea-01-ps.png)
	![Verify installed/configured JDKs](./assets/idea-02-jdk.png)
	![Check default JDK for projects](./assets/idea-03-project-jdk.png)
	You may also have to [configure the location of Gradle](https://www.jetbrains.com/help/idea/gradle.html), if not automatically configured.
3. Select _Check out from Version Control: git_ and provide the repository URL; note that you can use either `https://inf-git.fh-rosenheim.de...` (and provide your username and password), or `git@inf-git.fh-rosenheim.de:...` (with SSH credentials as configured with GitLab).
	![Check out from VCS](./assets/idea-04-from-git.png)
4. After checkout, it may take a while for Gradle to build and index the project.
5. Look at the project's `build.gradle` and see how it configures for the use of [JUnit 5](http://junit.org/junit5/docs/current/user-guide/#running-tests-build-gradle).
6. Look at the class `fhro.inf.prg3.a01.MyExampleClass` and read the javadoc comments. What is it's (very simple) purpopse?
7. Look at the test class `fhro.inf.prg3.a01.MyExampleClassTest` and run the tests.
8. **Fix `MyExampleClass` so that all test cases pass.**

> Note: We will go into details with `import static` and `@...` later, but go ahead and google what they do!

