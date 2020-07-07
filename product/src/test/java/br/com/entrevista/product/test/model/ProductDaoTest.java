package br.com.entrevista.product.test.model;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;

import br.com.entrevista.base.test.model.EntityDaoImplTest;
import br.com.entrevista.product.model.dao.impl.ProductDaoImpl;

public class ProductDaoTest extends EntityDaoImplTest {

	@Autowired
	@Qualifier("productDao")	
	ProductDaoImpl productDaoImpl;

	@Override
	protected IDataSet getDataSet() throws Exception {

		InputSource is = new InputSource(this.getClass().getClassLoader().getResourceAsStream("product.xml"));
		return new FlatXmlDataSet(new FlatXmlProducer(is, false, true));
	}
	
	@Test
	public void work() {
		Assert.assertNotNull(productDaoImpl);
	}

	@Test
	public void find() {

		Assert.assertNotNull(productDaoImpl.find(1001l));
		Assert.assertNull(productDaoImpl.find(93l));
	}

}