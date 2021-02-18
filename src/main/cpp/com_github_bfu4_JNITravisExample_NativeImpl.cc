#include "com_github_bfu4_JNITravisExample_NativeImpl.h"
#include <iostream>

JNIEXPORT void JNICALL Java_com_github_bfu4_JNITravisExample_NativeImpl_print
  (JNIEnv * env, jobject obj, jstring str) {
      std::cout << str << "\n";
  }

JNIEXPORT jint JNICALL Java_com_github_bfu4_JNITravisExample_NativeImpl_add
  (JNIEnv *, jobject, jint i1, jint i2) {
      return i1 + i2;
  }
