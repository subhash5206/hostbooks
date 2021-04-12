package com.hostbooks.generator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(
			SharedSessionContractImplementor session, Object object) 
			throws HibernateException {
	
		String pref="ST-";
		String dte=new SimpleDateFormat("ddMMyy").format(new Date());
		int random=new Random().nextInt(100);
		return pref+dte+"-"+random;
	}
}
