#!/bin/bash

JAVA="/usr/lib/jvm/java-11-openjdk-amd64/"
g++ -c -fPIC -I"$JAVA"/include -I"$JAVA"/include/linux src/main/java/bfu4/TestGradleJar/NativeImpl.cc -o src/main/java/bfu4/TestGradleJar/NativeImpl.o

g++ -shared -fPIC -o src/main/java/bfu4/TestGradleJar/libNativeImpl.so src/main/java/bfu4/TestGradleJar/NativeImpl.o -lc

# javac Main.java NativeImpl.java
