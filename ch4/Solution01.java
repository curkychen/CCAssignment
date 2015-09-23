
/** 
 * 
 * Question - Route Between Nodes
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: just use the DFS to search the route.
 * 
 */

public class Solution01 {
	enum State {Unvisit, Visited, Visting};

	public static boolean search(Graph g,Node start,Node end) {
		if(start == end)
			return true;

		for(Node u : g.getNodes())
			u.state = State.Unvisit;

		Stack<Node> s = new Stack<Node>();

		start.state = State.Visting;
		s.push(start);

		while(!s.isEmpty()) {
			Node current = s.pop();
			if(current != null) {
				for(Node v : u.getAdjacent()) {
					if (v.state == State.Unvisit) {
						if(v == end)
							return true;
						else {
							v.state = State.Visting;
							s.push(v);
						}
					}
				}
			}
			current.state = State.Visited;
		}
		return false;
	}

}
