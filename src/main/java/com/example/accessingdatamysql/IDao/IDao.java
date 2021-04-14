package com.example.accessingdatamysql.IDao;


public interface IDao<T> {
	
	T create(T o);
	void update(int id);
	void deleteById(int id);
	T findById (int id);
	Iterable<T> findAll();
	
}
