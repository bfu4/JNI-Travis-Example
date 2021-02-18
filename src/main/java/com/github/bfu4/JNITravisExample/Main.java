package com.github.bfu4.JNITravisExample;

public class Main {

   public static void main(String[] args) {
      NativeImpl impl = new NativeImpl();

      System.out.println(impl.add(1, 4));
      impl.print("meow");
   }

}
