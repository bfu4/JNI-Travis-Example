#!/bin/bash

JAVA="/usr/lib/jvm/java-11-openjdk-amd64/"
g++ -c -fPIC -I"$JAVA"/include -I"$JAVA"/include/linux NativeImpl.cc -o NativeImpl.o

g++ -shared -fPIC -o libNativeImpl.so NativeImpl.o -lc

javac Main.java NativeImpl.java
