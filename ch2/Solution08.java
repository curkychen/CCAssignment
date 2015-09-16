
public class Solution08 {
	/**
     * Create two pointer, current and runner.
     * when runner move 2 steps, the current move 1 step.
     * After they collide, move current pointer point to head
     * current pointer and runner pointer move 1 step together
     * when they collide, the node they collide is the begin of loop
     */
	public linkedNode loopdetection(linkedNode head) {
		// TODO Auto-generated method stub
		linkedNode current = head;
		linkedNode runner = head;
		while (true) {
			current = current.next;
			runner = runner.next.next;
			if(runner == current)
				break;
		}
		
		current = head;
		while(current != runner) {
			current = current.next;
			runner = runner.next;
		}
		return runner;
	}

}
