package com.raremile.database.entities;

public class University {
	private int univId;
	private String univName;

	public int getUnivId() {
		return univId;
	}

	public void setUnivId(int univId) {
		this.univId = univId;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int result = 1;
		result = prime * result + univId;
		result = prime * result + ((univName == null) ? 0 : univName.hashCode());
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
		University other = (University) obj;
		if (univId != other.univId)
			return false;
		if (univName == null) {
			if (other.univName != null)
				return false;
		} else if (!univName.equals(other.univName))
			return false;
		return true;
	}

}
