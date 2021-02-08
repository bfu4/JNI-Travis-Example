public class NativeImpl {

	static {
	   System.loadLibrary("NativeImpl");
	}

	public NativeImpl() { }

	public native void print(String s);

	public native int add(int i1, int i2);

}
