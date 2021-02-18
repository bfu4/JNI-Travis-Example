package com.github.bfu4.JNITravisExample;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.*;

public class NativeImpl {

	static boolean loaded = false;

	static {
		// I've actually not seen a better way to do this loading. Adapted, but mainly from @md_5.
        if (!loaded){
            try (InputStream soFile = NativeImpl.class.getClassLoader().getResourceAsStream("libNativeImpl.so")) {

                File temp = File.createTempFile("nativeimpl-", "libNativeImpl.so" );
                temp.deleteOnExit();

                try (OutputStream outputStream = new FileOutputStream(temp)) {
                	// md_5 uses this nice function called ByteStreams#copy(), seen below, from Google Commons.
                    copy(soFile, outputStream);
                } catch (Exception e) {
                	System.out.println("Could not copy file to output stream! Reason: " + e.getMessage());
                }

                System.load(temp.getPath());
                loaded = true;
            } catch (IOException ex) {
            	System.out.println("Could not get resource!");
            }
              
        }
	   loaded = true;
	}

 // Borrowed from google

 /*
  * Copyright (c) 2013 Google Inc.
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
  * in compliance with the License. You may obtain a copy of the License at
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software distributed under the License
  * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
  * or implied. See the License for the specific language governing permissions and limitations under
  * the License.
  */	

  /**
   * Copies all bytes from the input stream to the output stream. Does not close or flush either
   * stream.
   *
   * @param from the input stream to read from
   * @param to the output stream to write to
   * @return the number of bytes copied
   */
  public static long copy(InputStream from, OutputStream to) throws IOException {
    byte[] buf = new byte[0x1000];
    long total = 0;
    while (true) {
         int r = from.read(buf);
         if (r == -1) break;
         to.write(buf, 0, r);
         total += r;
       }
       return total;
    }

	public NativeImpl() { }

	public native void print(String s);

	public native int add(int i1, int i2);

}
