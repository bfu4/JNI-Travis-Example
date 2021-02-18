#!/bin/bash

CPPDIR="src/main/cpp"
JAVADIR="src/main/java/com/github/bfu4"
RESDIR="src/main/resources"

HEADER_PREF="com_github_bfu4_JNITravisExample_"

g++ -c -fPIC -I"$JAVA_HOME"/include -I"$JAVA_HOME"/include/linux "$CPPDIR"/"$HEADER_PREF"NativeImpl.cc -o "$CPPDIR"/"$HEADER_PREF"NativeImpl.o

g++ -shared -fPIC -o "$RESDIR"/libNativeImpl.so "$CPPDIR"/"$HEADER_PREF"NativeImpl.o -lc

rm "$CPPDIR"/"$HEADER_PREF"NativeImpl.o