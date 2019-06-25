package com.zhouwx.dao.test;

import com.zhouwx.enity.test.Person;

public interface PersonDao {
	public Person querypersonbyid(int id);
	public void inserperson(Person person);
}
