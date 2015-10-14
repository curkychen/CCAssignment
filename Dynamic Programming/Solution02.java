package yu;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * 
 * @author zhengyu
 *
 */

public class test {
	static class point {
		public int x;
		public int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		int L, C;
        Scanner in = new Scanner(System.in);
        L = in.nextInt();
        C = in.nextInt();
        int[][] martrix = new int[L][C];
        for(int i = 0; i < L; i++) {
        	char[] temp = in.next().toCharArray();
        	for(int j = 0; j < C; j++) {
        		if(temp[j] == 'o')
        			martrix[i][j] = -1;
        		else {
        			martrix[i][j] = -2;
				}
        	}
        }
        
        LinkedList<point> queue = new LinkedList<point>();
        point[] direction = {new point(0, -1), new point(0, 1), new point(-1, 0), new point(1, 0)};
        queue.add(new point(0, 0));
        long[][] step = new long[L][C];
        long[][] path = new long[L][C];
        martrix[0][0] = 0;
        path[0][0] = 1;
        while(queue.size() != 0) {
        	point current = queue.poll();
        	int cx = current.x;
        	int cy = current.y;
        	
        	for(int i = 0; i < direction.length; i++) {
        		int nextx = cx + direction[i].x;
        		int nexty = cy + direction[i].y;
        		
        		// not out of boundary
        		if(nextx >= 0 && nexty >= 0 && nextx < L && nexty < C) {
        			if(martrix[nextx][nexty] == -1) {
        				martrix[nextx][nexty] = martrix[cx][cy] + 1;
        				path[nextx][nexty] = path[cx][cy];
        				queue.add(new point(nextx, nexty));
        			}
        			else if(martrix[nextx][nexty] == -2) {
        				
        			}
        			else {
        				if(martrix[nextx][nexty] - martrix[cx][cy] == 1) {
        					path[nextx][nexty] = path[cx][cy] + path[nextx][nexty];
        				}
        				
        			}
        		}
        	}
        	
        }
        System.out.println(path[L - 1][C - 1]);
        System.out.println(martrix[L - 1][C - 1]);
    }

}