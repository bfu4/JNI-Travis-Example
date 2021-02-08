#include "NativeImpl.h"
#include <iostream>

JNIEXPORT void JNICALL Java_NativeImpl_print
  (JNIEnv * env, jobject obj, jstring str) {
      std::cout << str << "\n";
  }

JNIEXPORT jint JNICALL Java_NativeImpl_add
  (JNIEnv *, jobject, jint i1, jint i2) {
      return i1 + i2;
  }
