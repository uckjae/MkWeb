package kr.or.bit.dto.chart;

public class AvgMaxMinEmpByJob {
	private String job;
	private int avgsal;
	private int maxsal;
	private int minsal;
	
	public AvgMaxMinEmpByJob(String job, int avgsal, int maxsal, int minsal){	
    super();
	this.job=job;
    this.avgsal=avgsal;
    this.maxsal=maxsal;
    this.minsal=minsal;
	}
	public AvgMaxMinEmpByJob() {
		
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAvgsal() {
		return avgsal;
	}

	public void setAvgsal(int avgsal) {
		this.avgsal = avgsal;
	}

	public int getMaxsal() {
		return maxsal;
	}

	public void setMaxsal(int maxsal) {
		this.maxsal = maxsal;
	}
	
	public int getMinsal() {
		return minsal;
	}

	public void setMinsal(int minsal) {
		this.minsal = minsal;
	}
	

}
