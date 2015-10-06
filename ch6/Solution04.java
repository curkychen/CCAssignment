/** 
 * 
 * Question - Ants on a Triangle
 * Created by Yu Zheng on 10/1/2015 
 *
 * 
 */

public class Solution04 {
/**
 * If we work on triangle, we can easily compute the probability,
 * they would not collide since they move same direction, so, the
 * detail of computing is below:
 * P(clockwise) = (1 / 2) ^ 3;
 * p(conter clockwise) = (1 / 2) ^ 3;
 * p(same direction) = 1 / 4;
 * p(collision) = 1 - p(same direction) = 1 - (1 / 4) = 3 / 4;
 * for n, we can easily write them:
 * P(collision) = 1 - p(same direction) = 1 - (1 / 2) ^ (n - 1);
 */

}
