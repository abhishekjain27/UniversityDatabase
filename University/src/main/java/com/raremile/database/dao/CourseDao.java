package com.raremile.database.dao;

import com.raremile.database.entities.Course;
import com.raremile.database.entities.exceptions.NonFatalException;

public interface CourseDao {

	public boolean addCourse(Course course) throws NonFatalException;

	public void fetchCourse() throws NonFatalException;
}
