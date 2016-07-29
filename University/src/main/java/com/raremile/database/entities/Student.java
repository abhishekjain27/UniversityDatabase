package com.raremile.database.entities;

public class Student {
	private int studId;
	private String studName;
	private int univId;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudname(String studname) {
		this.studName = studname;
	}
	public int getUnivId() {
		return univId;
	}
	public void setUnivId(int univId) {
		this.univId = univId;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", univId=" + univId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studId;
		result = prime * result + ((studName == null) ? 0 : studName.hashCode());
		result = prime * result + univId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studId != other.studId)
			return false;
		if (studName == null) {
			if (other.studName != null)
				return false;
		} else if (!studName.equals(other.studName))
			return false;
		if (univId != other.univId)
			return false;
		return true;
	}
}
