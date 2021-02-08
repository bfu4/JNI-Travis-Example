#!/bin/bash

JAVA="$JAVA_HOME"
g++ -c -fPIC -I"$JAVA"/include -I"$JAVA"/include/linux src/main/java/com/github/bfu4/TestGradleJar/NativeImpl.cc -o src/main/java/com/github/bfu4/TestGradleJar/NativeImpl.o

g++ -shared -fPIC -o src/main/java/com/github/bfu4/TestGradleJar/libNativeImpl.so src/main/java/com/github/bfu4/TestGradleJar/NativeImpl.o -lc

# javac Main.java NativeImpl.java
