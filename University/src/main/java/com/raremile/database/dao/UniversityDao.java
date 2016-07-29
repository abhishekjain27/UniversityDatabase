package com.raremile.database.dao;

import com.raremile.database.entities.University;

import com.raremile.database.entities.exceptions.NonFatalException;

public interface UniversityDao {

	public boolean addUniv(University univerity) throws NonFatalException;
	
	public void fetchUniv() throws NonFatalException;
}
