package kr.or.bit.dto.chart;

public class LocDept {
	private int Newyork;
	private int Dallas;
	private int Chicago;
	
	
	
	public int getNewyork() {
		return Newyork;
	}
	public void setNewyork(int newyork) {
		Newyork = newyork;
	}
	public int getDallas() {
		return Dallas;
	}
	public void setDallas(int dallas) {
		Dallas = dallas;
	}
	public int getChicago() {
		return Chicago;
	}
	public void setChicago(int chicago) {
		Chicago = chicago;
	}
	
	@Override
	public String toString() {
		return "LocDept [Newyork=" + Newyork + ", Dallas=" + Dallas + ", Chicago=" + Chicago + "]";
	}

	
	
}
