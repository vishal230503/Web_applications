package com.nt.beans;

public class StudentDetails {
	private int sno;
	private String sname;
	private String sadd;
	private float avg;
	public StudentDetails() {
		System.out.println("StudentDetails:: 0-param constructor");
	}
	public int getSno() {
		System.out.println("StudentDetails.getSno()");
		return sno;
	}
	public void setSno(int sno) {
		System.out.println("StudentDetails.setSno()");
		this.sno = sno;
	}
	public String getSname() {
		System.out.println("StudentDetails.getSname()");
		return sname;
	}
	public void setSname(String sname) {
		System.out.println("StudentDetails.setSname()");
		this.sname = sname;
	}
	public String getSadd() {
		System.out.println("StudentDetails.getSadd()");
		return sadd;
	}
	public void setSadd(String sadd) {
		System.out.println("StudentDetails.setSadd()");
		this.sadd = sadd;
	}
	public float getAvg() {
		System.out.println("StudentDetails.getAvg");
		return avg;
	}
	public void setAvg(float avg) {
		System.out.println("StudentDetails.setAvg()");
		this.avg = avg;
	}
}
