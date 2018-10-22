package org.atomsk.mapper;

import java.util.HashMap;
import java.util.Map;

import org.atomsk.domain.PageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testSearch() {
		
		PageParam pageParam = new PageParam();

		pageParam.setScond("t");
		pageParam.setKeyword("sample");
//		pageParam.setTypes(new String[] {"t","c"});
//		pageParam.setKeyword("Sample");
		
		
		log.info(mapper.getList(pageParam));

	}

}
