package Feb_28;

public class Read4 {
    private char[] buffer = new char[4];
    private int offset = 0;
    private int lengthOfBufferReadFromRead4 = 0;


    public int read(char[] buf, int n) {

        int totalCharRead = 0;
        boolean eof = false;
        while (!eof && totalCharRead < n) {
            if (lengthOfBufferReadFromRead4 == 0) {
                lengthOfBufferReadFromRead4 = read4(buffer);
                if (lengthOfBufferReadFromRead4 < 4)
                    eof = true;
            }
            int numOfCharachterToBeRead = Math.min(lengthOfBufferReadFromRead4, n - totalCharRead);
            for (int i = 0; i < numOfCharachterToBeRead; i++) {
                buf[totalCharRead + i] = buffer[offset + i];
            }

            totalCharRead += numOfCharachterToBeRead;
            lengthOfBufferReadFromRead4 -= numOfCharachterToBeRead;
            offset = (offset + numOfCharachterToBeRead) % 4;
        }
        return totalCharRead;
    }

    private int read4(char[] buffer) {
        return 0;
    }
}


