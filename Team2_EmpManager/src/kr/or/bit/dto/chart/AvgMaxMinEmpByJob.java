package kr.or.bit.dto.chart;

public class AvgMaxMinEmpByJob {
	private String job;
	private int avgsal;
	private int minsal;
	private int maxsal;
	
	public AvgMaxMinEmpByJob(String job, int avgsal, int minsal, int maxsal){	
    super();
	this.job=job;
    this.avgsal=avgsal;
    this.minsal=minsal;
    this.maxsal=maxsal;
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

	public int getMinsal() {
		return minsal;
	}

	public void setMinsal(int minsal) {
		this.minsal = minsal;
	}

	public int getMaxsal() {
		return maxsal;
	}

	public void setMaxsal(int maxsal) {
		this.maxsal = maxsal;
	}
	

}
