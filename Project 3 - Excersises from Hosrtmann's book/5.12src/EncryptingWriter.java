import java.io.IOException;
import java.io.Writer;

/*
 * USED CLASS FROM BOOK WITH MODIFIED METHODS
 */
public class EncryptingWriter extends Writer {
	Writer writer;
	
	public EncryptingWriter(Writer w) {
		writer = w;
	}
	
	@Override
	public void write(char[] cbuf) throws IOException {
		for (char thisChar : cbuf) {
			if ((int) thisChar >= (int) 'A' && (int) thisChar <= (int) 'Z') {
				int result = ((int) thisChar - (int) 'A' + 3) % 26 + (int) 'A';
				writer.write(result);
			} else {
				writer.write((int) thisChar);
			}
		}
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		writer.write(cbuf, off, len);
	}
	
	@Override
	public void close() throws IOException {
		writer.close();
	}

	@Override
	public void flush() throws IOException {
		writer.flush();
	}



}