package com.dev.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

//Resultset----> Objeto
public interface IRowmapper<T> {
	T mapRow(ResultSet rs) throws SQLException;
}
