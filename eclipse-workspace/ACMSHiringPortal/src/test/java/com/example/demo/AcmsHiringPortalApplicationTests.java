package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.hiring.portal.AcmsHiringPortalApplication;
import com.hiring.portal.model.Category;
import com.hiring.portal.model.Question;
import com.hiring.portal.service.APIService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcmsHiringPortalApplication.class)
public class AcmsHiringPortalApplicationTests {

	@Autowired
	ApplicationContext context;
	//@Test
	public void TestCategory() {
		APIService apiservice = context.getBean(APIService.class);
		Category c = new Category();
		c.setCategoryname("Testing");
		c.setCoordid("1");
		c.setType("mcq");
		apiservice.addCategory(c);
	}
	
	@Test
	public void TestQuesiton() {
		APIService apiservice = context.getBean(APIService.class);
		Question q = new Question();
		q.setQuestion("What Grade you will get in SPE?");
		q.setOption1("A");
		q.setOption2("A");
		q.setOption3("A");
		q.setOption4("A");
		q.setCid((long) 8);
		q.setLevel("easy");
		q.setAnswer("A");
		q.setCoordid((long)1);
		apiservice.addMCQQuestion(q);	
	}
	
	@Test
	public void getAllOrganization() {
		APIService apiservice = context.getBean(APIService.class);
		System.out.println("All Organizations");
		for(String org : apiservice.getAllOrganizations()) {
			System.out.println(org);
		}
	
	}

}

