/*
Freeware License, some rights reserved

Copyright (c) 2021 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.jj.sample;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.System.out;

/**
 * Created by iuliana.cosmina on 21/11/2021
 * Maybe clone the /java-17-for-absolute-beginners and build the docker container
 */
public class Main {

    public static void main(String... args) {
        //1. Type inference
        // Before
        Integer  i1 = new Integer(42);
        out.println("This is I1:" + i1);
        // After
        var i2 = Integer.valueOf(42);
        out.println("This is I2:" + i2);

        out.println("-----------------------------");

        // 2. Show the switch + yield keyword

        // 3. Text Blocks
        // Before
        String newLineCh = System.getProperty("line.separator");
        String  multilineStr1 = new StringBuilder("line one of the text block")
                .append(newLineCh)
                .append("line two of the text block")
                .append(newLineCh)
                .append("last line of the text block").toString();
        out.println(multilineStr1);
        out.println(newLineCh);

        // After
        String  multilineStr2 = """  
                line one of the text block
                line two of the text block
                last line of the text block
                """;
        out.println(multilineStr2);

        out.println("-----------------------------");

        // 4. record classes (Compare with Person class)
        record Person(String name, int age) {}  // default constructor, default property accessors, default toString, hashCode, equals
        // limitations: no additional fields, cannot extend another class/record, cannot be extended, can implement interfaces though
        // for records the canonical constructor is always used to create objects -> this fixes a serialization/deserialization security breach that has existed in Java since forever.

        Person pete = new Person("Pete", 42);
        out.println("Hi, I am: "  + pete);

        Person pete2 = new Person("Pete", 42);
        out.println("Hi, I am also Pete(?): "  + pete.equals(pete2));

        out.println("-----------------------------");

        // 5. pattern matching for instanceOf - avoid necessity of casting
        Object o = new Person("Fred", 24);
        // Before
        if( o instanceof Person) {
            Person fred = (Person) o; // this line is no longer necessary
            out.println("Hi, I am: "  + fred);
        }
        //After
        if(o instanceof Person fred) {
            out.println("Hi, I am: "  + fred); // scope is limited to the here
        }

        out.println("-----------------------------");

        // 6. sealed classes & interfaces too
        // limitation: all classes need to be in the same package, or same module - if modules are used, since the compiler must see the full hierarchy

        // 7. show jshell i, j, "mary" example

        // 8. jdeps example
        //jdeps target/java17-migration-1.0-SNAPSHOT.jar

        // 9. java source code launcher example
        // cd /Users/iulianacosmina/work-mine/java17-migration/src/main/java/com/jj/sample/
        // java Main.java

        //10. Collection factories => immutable
        List<Person> list = List.of(pete, pete2);
        Set<Person> set =  Set.of(pete, pete2);
        Map<Integer, Person> map = Map.of(1, pete, 2, pete2);

    }


}
