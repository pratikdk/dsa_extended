import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P271_EncodeAndDecodeString {

    public static String encode(String[] strs) {
        String res = "";
        for (String s: strs) {
            res += s.length() + "#" + s;
        }
        return res;
    }

    public static String[] decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j += 1;
            }
            int length = Integer.parseInt(s.substring(i, j));
            res.add(s.substring(j+1, j+1+length));
            i = j+1+length;
        }
        return res.toArray(new String[0]);
    }

    ///////////// My Implementation 

    public static String encode2(String[] strs) {
        String encodedStr = "";
        int maxSpan = 8;
        for (String s: strs) {
            String sFrames = "";
            int n = s.length();
            int totalFrames = (n/maxSpan)+1;
            for (int i = 0; i < totalFrames; i++) {
                int isTerminalFrame = 0;
                String iFrame = "";
                // frame's start & end indices
                int start = (maxSpan*i);
                int end;
                if (i == totalFrames-1) {
                    end = n;
                    isTerminalFrame = 1;
                } else {
                    end = start + maxSpan;
                }
                // frame length
                String frameLen = "00" + (end-start);
                iFrame += frameLen.substring(frameLen.length()-2, frameLen.length());
                // Is this terminal frame ?
                iFrame += isTerminalFrame;
                iFrame += s.substring(start, end);
                // append to previous frames 
                sFrames += iFrame;
            }
            encodedStr += sFrames;
        }
        return encodedStr;
    }

    public static String[] decode2(String s) {
        System.out.println(s);
        List<String> res = new ArrayList<>();
        int headerSize = 3;
        int i = 0;
        while (i < s.length()) {
            String iStr = "";
            int payloadLength = Integer.parseInt(s.substring(i, i+2));
            int isTerminal = Integer.parseInt(s.substring(i+2, i+3));
            while (true) {
                iStr += s.substring(i+headerSize, i+headerSize+payloadLength);
                i += headerSize+payloadLength;
                if (isTerminal == 1) {
                    break;
                }
                payloadLength = Integer.parseInt(s.substring(i, i+2));
                isTerminal = Integer.parseInt(s.substring(i+2, i+3));
            }
            res.add(iStr);
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[][] probs = {
            {"Encode", "and", "Decode", "strings"},
            {"I", "use", "Windows", "os!!"},
            {"0001", "1110"},
            {" 0 ", " ", "z "},
            {"verylongstringtosend"}
        };
        for (String[] strs: probs) {
            String encodedString = encode(strs);
            String[] strs2 = decode(encodedString);
            System.out.println(Arrays.deepToString(strs2));
        }
    }
}

// Frame size spec: 3(header)   8(payload)
// header: 2(payload length, max is 2 digits)   1(is current frame terminal for a string?)    
