# Java quines

A [quine](https://en.wikipedia.org/wiki/Quine_(computing)) is a computer program that outputs its own source code.

In 1998, we set out a challenge for some students that we were teaching Java: They were to create the shortest
Java code that outputs itself. In the end, it became a challenge for us tutors. I found a [solution](https://snailshell.de/java.html)
that needed merely 208 bytes. More recent Java versions need even fewer bytes:

- [Java 1.0 quine](src/main/java/S.java) (208 bytes)
- [Java 1.5 quine](src/main/java/U.java) (172 bytes): Uses `printf` instead of `print`
- [Java 10 quine](src/main/java/V.java) (166 bytes): Uses `var` instead of `String` type declaration

## Disclaimer

Do not use in production 😉

## Credits

While the Java 1.0 quine is completely my own work, the Java 1.5 version
is based on [this example](https://de.wikipedia.org/wiki/Quine_(Computerprogramm)#Beispiele) IIRC.
I then used the Java 1.5 code to write the even shorter version for Java 10+.
