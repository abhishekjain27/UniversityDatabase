package com.raremile.database.dao;

import com.raremile.database.entities.Student;
import com.raremile.database.entities.exceptions.NonFatalException;

public interface StudentDao {

	public boolean addStudent(Student student) throws NonFatalException;

	public void fetchStudent() throws NonFatalException;

}
