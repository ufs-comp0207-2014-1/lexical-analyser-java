# TinyPy Lexical Analyser (Java)

Start code for building a TINYPy Lexical Analyser in Java. Check out the project description [here](https://github.com/ufs-comp0207-2014-1/tinypy-compiler).

## Project Structure

The project is organized is follows:

* **Package [`main/java/br/ufs/dcomp/lfc/tinypyc/`](src/main/java/br/ufs/dcomp/lfc/tinypyc)**
> Here are located all the Java files for the lexical analyser, but the generated scanner class by the JFlex plugin. The [`Token.java`](src/main/java/br/ufs/dcomp/lfc/tinypyc/Token.java) class wraps the definitions of a token. The generated scanner class (`Scanner.java` by default) is located under the subdirectory [`generated/`](src/main/java/br/ufs/dcomp/lfc/tinypyc/generated).
* **Package [`src/main/resources/jflex/`](src/main/resources/jflex/)**
> Here are located all the Jflex lexical specifications (by default, the main specification is in the file [`tinypy.jflex`](src/main/resources/jflex/tinypy.jflex)).
* **Package [`src/test/java/br/ufs/dcomp/lfc/tinypyc/`](src/test/java/br/ufs/dcomp/lfc/tinypyc/)**
> At this package we have all the Java files for testing the lexical analyser. Check out the test suit at [`ScannerTest`](src/test/java/br/ufs/dcomp/lfc/tinypyc/ScannerTest.java) class.

## Running the JFlex Maven Plugin

This plugin reads JFlex grammar definition files (.jflex ) and generates a corresponding Java parser.

#### Example Configuration

This generates the source for all grammars files found in `src/main/resources/jflex` (and it sub-directories). The generated Java code is placed into `src/main/java`.
We can generate de Java code by running `mvn generate-sources -e` or `mvn compile -e`.

In `pom.xml` file:

```xml
<plugin>
    <groupId>de.jflex</groupId>
    <artifactId>jflex-maven-plugin</artifactId>
    <version>1.6.0</version>
        <executions>
            <execution>
                <configuration>
                    <outputDirectory>src/main/java</outputDirectory>
                    <lexDefinitions>
                        <lexDefinition>src/main/resources/jflex</lexDefinition>
                    </lexDefinitions>
                    <verbose>true</verbose>
                </configuration>
                <goals>
                    <goal>generate</goal>
                </goals>
            </execution>
        </executions>
</plugin>
```

For more details about the *JFlex* and *JFlex Maven Plugin* please visit the [JFlex HomePage](http://jflex.de/).
