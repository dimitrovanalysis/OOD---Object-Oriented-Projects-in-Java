import java.io.*;

/**
 * USED SOLUTION IN BOOK WITH MODIFIED METHODS
 * @author AUTHOR
 *
 */
public class DecryptingReader extends Reader {
	
	private Reader reader;
	
	public DecryptingReader(Reader r) {
		reader = r;
	}
	
	//modified version of author solution here (did not need to create ceasarCipher)
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return reader.read(cbuf, off, len);
	}
	
	//NEEDED SEPERATE MODIFIED READ FUNCTION 
	@Override
	public int read(char[] cbuf) throws IOException {
		int count = 0;
		int myChar = 0;
		while (myChar != -1 && count < cbuf.length) {
			myChar = reader.read();
			if (myChar >= (int) 'A' && myChar <= (int) 'Z') {
				myChar = (myChar - (int) 'A' - 3) % 26 + (int) 'A';
			}
			cbuf[count++] = (char) myChar;
		}
		
		if (count != cbuf.length) count = -1;
		
		return count;
	}
	
	
	@Override
	public void close() throws IOException {
		reader.close();
	}


}