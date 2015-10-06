
/** 
 * 
 * Question - Missing Int
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: Since there are 2^32 number, and integer only has 2^31 non-negative intergers. 
 * we have 1 GB of memory, which means we have 8 billion bits. So we can map or number into memory and find which
 * number is missing
 * 
 */

public class Solution07 {
 long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
 byte[] bitfield = new byte[(int) (numberOfInts / 8)];
 String filename = "missing.txt";

 public void findOpenNumber() throws FileNotFoundException {
    Scanner in  = new Scanner(new FileReader(filename));
    while (in.hasNextInt()) {
      int n = in.nextInt();
      bitfield[n / 8] |= 1 << (n % 8);
    }


    for (int i = 0; i < bitfield.length; i++) {
      for (int j = 0; j < 8; j++){
        if ((bitfield[i] & (1 << j)) == 0) {
          System.out.println(i * 8 + j);
          return;
        }
      }
    }
  }
}

// FOLLOW UP Question
/**
 * if we only have 10 MB memory, I think we could divide these integers into several parts.
 * for example, part 1 contain 1000 interger, part 2 contain next 1000 integer and so on.
 * We have to compute the count of number for each part. and then, use the above idea again,
 * use bit vector to detect which number we missed.
 * 
 */
