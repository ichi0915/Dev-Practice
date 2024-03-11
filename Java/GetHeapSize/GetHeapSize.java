/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Program to get the Current JVM Heap size
 *
 */

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Main Class for the GetHeapSize
 */
class GetHeapSize {

	public static void main(String[]args){
		//Get the jvm heap size.
		long heapSize = Runtime.getRuntime().totalMemory();

		//Print the jvm heap size.
		System.out.println("Heap Size = " + heapSize);
		System.out.println("Heap Size = " + humanReadableByteCountBin(heapSize));
	}

	// SI (1 k = 1,000)
	public static String humanReadableByteCountSI(long bytes) {
		if (-1000 < bytes && bytes < 1000) {
			return bytes + " B";
		}
		CharacterIterator ci = new StringCharacterIterator("kMGTPE");
		while (bytes <= -999_950 || bytes >= 999_950) {
			bytes /= 1000;
			ci.next();
		}
		return String.format("%.1f %cB", bytes / 1000.0, ci.current());
	}

	// Binary (1 Ki = 1,024)
	public static String humanReadableByteCountBin(long bytes) {
		long absB = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
		if (absB < 1024) {
			return bytes + " B";
		}
		long value = absB;
		CharacterIterator ci = new StringCharacterIterator("KMGTPE");
		for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
			value >>= 10;
			ci.next();
		}
		value *= Long.signum(bytes);
		return String.format("%.1f %ciB", value / 1024.0, ci.current());
	}
}
