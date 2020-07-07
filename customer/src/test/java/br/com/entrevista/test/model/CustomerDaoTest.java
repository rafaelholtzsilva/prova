package br.com.entrevista.test.model;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;

import br.com.entrevista.base.test.model.EntityDaoImplTest;
import br.com.entrevista.customer.model.dao.impl.CustomerDaoImpl;

public class CustomerDaoTest extends EntityDaoImplTest {

	@Autowired
	@Qualifier("customerDao")
	CustomerDaoImpl customerDao;

	@Override
	protected IDataSet getDataSet() throws Exception {
		InputSource is = new InputSource(this.getClass().getClassLoader().getResourceAsStream("customer.xml"));
		return new FlatXmlDataSet(new FlatXmlProducer(is, false, true));
	}

	@Test
	public void findAll() {
		Assert.assertEquals(customerDao.findAll().size(), 4);

	}

	@Test
	public void find() {
		Assert.assertNotNull(customerDao.find(1l));
		Assert.assertNull(customerDao.find(93l));
	}

}