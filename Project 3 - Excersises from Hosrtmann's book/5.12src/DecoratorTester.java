import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/*
 * only works with capital letters!
 */
public class DecoratorTester {
	public static void main(String args[]) throws IOException {
		char[] charArray = {'O', 'B', 'J', 'E', 'C', 'T', 'O', 'R', 'D', 'E'};
		System.out.print("Char array of Name: ");
		System.out.println(charArray);
		//use classes to create functionality
		CharArrayWriter charWriter = new CharArrayWriter();
		EncryptingWriter writer = new EncryptingWriter(charWriter);
	//find encrypted version of char array
		System.out.print("Encrypted: ");
		writer.write(charArray);
		System.out.println(charWriter.toCharArray());
		CharArrayReader charReader = new CharArrayReader(charWriter.toCharArray());
		DecryptingReader reader = new DecryptingReader(charReader);
		
		char[] result = new char[10];
		reader.read(result);
		//print out decripted (should be original array)
		System.out.print("Decripted: ");
		System.out.println(result);
		
		writer.flush();
		writer.close();
		reader.close();
	}
}