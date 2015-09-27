
/** 
 * 
 * Question - Sort Big File
 * Created by Yu Zheng on 9/25/2015 
 *
 * idea: 
 * 
 */

Assume we have X MB memory to use. So, here is the detail how I implement it：
1. we would divide the whole file into K parts, and K * X = 2 GB. we would load one part into memory each time.
use a sort method which time cost is O(nlogn) so sort the part of file. And then, we save it in a file.
2. we load the next file and sort it.
3. After we sort all part of file, we can merge them together. 
