package BT6;

public class Meeting {

	int begin;
	int end;

	public Meeting(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	public Meeting() {
		
	}
	public int getBegin() {
		return begin;
	}

	@Override
	public String toString() {
		return "Meeting [begin=" + begin + ", end=" + end + "]";
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
