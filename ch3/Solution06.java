import java.util.LinkedList;
/** 
 * 
 * Question - Animal Shelter
 * Created by Yu Zheng on 9/21/2015 
 *
 * idea: We can use 2 linkedList to store cats and dogs, and each animal has order number, 
 * so that we can 
 * 
 */

public class Solution06 {

	public abstract class Animal {
		public String name;
		private int ordernum;

		public Animal(String name) {
			this.name = name;
		}

		public void setOrderNum(int o) {
			this.ordernum = o;
		}

		public int getOrderNum() {
			return ordernum;
		}
	}

	public class Dog extends Animal {
		public Dog(String name) {
			super.(name);
		}

	}

	public class Cat extends Animal {
		public Cat(String name) {
			super.(name);
		}

	}

	public class AnimalQueue{
		public LinkedList<Dog> d = new LinkedList<Dog>();
		public LinkedList<Cat> c = new LinkedList<Cat>();
		public int order = 0;

		public void enqueue(Animal a) {
			a.setOrderNum(order++);

			if(a intanceof Dog) {
				d.addLast((Dog) a);
			}
			else
				d.addLat((Cat) a);
		}

		public Animal dequeneAny() {
			if(d.size() == 0)
				return dequeneCat();
			if(c.size() == 0)
				return dequeneDog();

			Dog outd = d.peek();
			Cat outc = c.peek();

			if(outd.getOrderNum() < outc.getOrderNum())
				return dequeneDog();
			else
				return dequeneCat();
		}

		public Cat dequeneCat() {
			return c.poll();
		}	

		public Dog dequeneDog() {
			return d.poll();
		}
	}

}
