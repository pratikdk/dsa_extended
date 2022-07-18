public class P190_ReverseBits {

    public static int reverseBits(int n) {
        int r = 0;
        // while (n != 0) {
        //     r = r << 1; // shift r bits to left, make slot for new bit;
        //     r = r | (n & 1); // 0 or 1 based on 0th bit
        //     n = n >>> 1; // shift n to right, to scan for bits on left
        // }
        for (int i = 0; i < 32; i++) {
            r = r << 1; // shift r bits to left, make slot for new bit;
            r = r | (n & 1); // 0 or 1 based on 0th bit
            n = n >>> 1; // shift n to right, to scan for bits on left
        }
        return r;
    }
    
    public static void main(String[] args) {
        int[] probs = {
            43261596,
            -3,
            2,
            91
        };
        for (int prob: probs) {
            System.out.println(reverseBits(prob));
        }
    }
}

// 00000010100101000001111010011100
// 111001011110000010100101

//  2 + 2 = 1 0 + 1 0 = 1 0 0
//  3 + 1 = 1 1 + 0 1 = 1 0 0
//  3 + 2 = 1 1 + 1 0 + 1 0 1