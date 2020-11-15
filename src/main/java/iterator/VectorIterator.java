package iterator;

import java.util.Vector;

import domain.Event;
public class VectorIterator implements ExtendedIterator {
	private Vector<Event> events;
	private int position=0;

	public VectorIterator(Vector<Event> e) {
		this.events = e;
	}
	@Override
	public boolean hasNext() {
		return position<events.size();
	}

	@Override
	public Object next() {
			return this.events.get(position++);

		}


	@Override
	public Object previous() {
			return this.events.get(position--);
		
	}

	@Override
	public boolean hasPrevious() {
		return position>-1;
	}

	@Override
	public void goFirst() {
		this.position=0;

	}

	@Override
	public void goLast() {
		this.position=this.events.size()-1;

	}

}
