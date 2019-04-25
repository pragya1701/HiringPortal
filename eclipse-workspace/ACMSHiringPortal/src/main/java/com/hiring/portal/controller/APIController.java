package com.hiring.portal.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import com.hiring.portal.model.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.hiring.portal.service.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api")
public class APIController {
	@Autowired
	private IAPIService ls;

	/************************************************************************
	 * Registration Module - Registration method - Coordinator detail - get id of
	 * coordinator from username
	 ************************************************************************/
	@PostMapping("/register")
	public ResponseEntity<Void> doRegistration(@Valid @RequestBody Coordinator std, UriComponentsBuilder builder) {
		boolean flag = ls.doRegister(std);
		if (flag == true) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	@GetMapping("/getcorddetails/{cordid}")
	public ResponseEntity<List<Coordinator>> getCordDetails(@PathVariable(value = "cordid") Long cordid) {
		List<Coordinator> list = ls.getCordDetails(cordid);
		return new ResponseEntity<List<Coordinator>>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/cordid/{username}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Long> getCordID(@PathVariable(value = "username") String username) {
		Long list = ls.getCordID(username);
		return new ResponseEntity<Long>(list, HttpStatus.OK);
	}

	/***************************************************************************
	 * Login This method is used to do login
	 ***************************************************************************/
	@PostMapping("/login")
	public ResponseEntity<Void> doLogin(@Valid @RequestBody Login lg, UriComponentsBuilder builder) {
		System.out.println("username::" + lg.getUsername());
		System.out.println("password::" + lg.getPassword());
		boolean flag = ls.doLogin(lg.getUsername(), lg.getPassword());
		if (flag == true) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	/***************************************************************************
	 * Categories 
	 * (1) MCQ Categories 
	 * (2) Code Categories 
	 * (3) get category id from name
	 ***************************************************************************/
	@GetMapping("/allmcqcategories")
	public ResponseEntity<List<Category>> getAllMCQCategories() {
		List<Category> list = ls.getAllMCQCategories();
		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}

	@GetMapping("/allcodecategories")
	public ResponseEntity<List<Category>> getAllCodeCategories() {
		List<Category> list = ls.getAllCodeCategories();
		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/categoryid/{categoryname}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Long> getCategoryID(@PathVariable(value = "categoryname") String categoryName) {
		Long list = ls.getCategoryID(categoryName);
		return new ResponseEntity<Long>(list, HttpStatus.OK);
	}

	/***************************************************************************
	 * Questions Display - all mcq questions according to level - all coding
	 * questions according to level - all questions based on category and level
	 ****************************************************************************/
	@GetMapping(path = "/allmcqquestions/{level}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Question>> getAllMCQQuestions(@PathVariable(value = "level") String level) {
		List<Question> list = ls.getAllMCQQuestions(level);
		return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/allcodequestions/{level}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Question>> getAllCodeQuestions(@PathVariable(value = "level") String level) {
		List<Question> list = ls.getAllCodeQuestions(level);
		return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/selectcategorywithlevel/{categorynamelevel}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Question>> getCategoryIDWithLevel(
			@PathVariable(value = "categorynamelevel") String categoryNameWithLevel) {
		List<Question> list = ls.getAllMCQCatQuestionsWithLevel(categoryNameWithLevel);
		System.out.println("Inside the category with level");
		return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
	}

	/******************************************************************************
	 * Addition of Question and Category - Add Question (MCQ , CODE) - Add Category
	 ******************************************************************************/
	@PostMapping("/addmcqquestion")
	public ResponseEntity<Void> addMCQQuestion(@Valid @RequestBody Question qmcq, UriComponentsBuilder builder) {
		boolean flag = ls.addMCQQuestion(qmcq);
		if (flag == true) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	@PostMapping("/addcategory")
	public ResponseEntity<Void> addMCQCategory(@Valid @RequestBody Category c, UriComponentsBuilder builder) {
		boolean flag = ls.addCategory(c);
		if (flag == true) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	@GetMapping("/findMax")
	public ResponseEntity<Long> findMax() {
		Long maxVal = ls.findMax();
		return new ResponseEntity<Long>(maxVal, HttpStatus.OK);
	}

	/**********************************************************************
	 * Organization Listing - List All Organizations - List All students - Select
	 * student for particular organization
	 *********************************************************************/

	@GetMapping("/allorganizations")
	public ResponseEntity<List<String>> getAllOrganizations() {
		List<String> list = ls.getAllOrganizations();
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

	@GetMapping("/allstudents")
	public ResponseEntity<List<String>> getAllStudents() {
		List<String> list = ls.getAllStudents();
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

	@GetMapping("/selectorganization/{organizationname}")
	public ResponseEntity<List<String>> getAllStudents(
			@PathVariable(value = "organizationname") String organizationname) {
		List<String> list = ls.getAllStudents(organizationname);
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

	/**********************************************************************
	 * Email Module 
	 * - Add Email Address 
	 * - Send Email (Invitation for test) --> User mapping will be done in this phase 
	 * - Send notification (Coordinator will send email notification to students based on organization
	 *********************************************************************/
	
	@GetMapping("/addemail/{emailadd}")
	public ResponseEntity<Void> addSelectedstudents(@PathVariable(value = "emailadd") String email) {

		Values.emailCustomList = email.split(",");
		System.out.println("inside");
		for (int i = 0; i < Values.emailCustomList.length; i++) {
			System.out.println(Values.emailCustomList[i]);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private EmailUtility em;

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/sendmail", method = RequestMethod.POST, produces = "text/plain")
	public ResponseEntity<Void> sendmail(@Valid @RequestBody TestWrapper testwrapper, UriComponentsBuilder builder) {
		System.out.println("hello api");
		try {
			String pass = "hiring@123";
			for (int i = 0; i < Values.emailList.size(); i++) {
				em.doPost("smtp.gmail.com", "587", "hiringportalacms@gmail.com", pass, Values.emailList.get(i),
						testwrapper.getSubject(), testwrapper.getBody());
			}
			if (Values.emailCustomList != null) {
				for (int i = 0; i < Values.emailCustomList.length; i++) {
					em.doPost("smtp.gmail.com", "587", "hiringportalacms@gmail.com", pass, Values.emailCustomList[i],
							testwrapper.getSubject(), testwrapper.getBody());
				}
			}

			ls.userCordMap(testwrapper);
			Values.emailList.clear();
			Values.emailCustomList = null;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/sendnotification", method = RequestMethod.POST, produces = "text/plain")
	public ResponseEntity<Void> sendNotification(@Valid @RequestBody TestWrapper testwrapper,
			UriComponentsBuilder builder) {
		System.out.println("Inside the Email method");
		try {
			String pass = "hiring@123";
			for (int i = 0; i < Values.emailList.size(); i++) {
				em.doPost("smtp.gmail.com", "587", "hiringportalacms@gmail.com", pass, Values.emailList.get(i),
						testwrapper.getSubject(), testwrapper.getBody());
			}
			if (Values.emailCustomList != null) {
				for (int i = 0; i < Values.emailCustomList.length; i++) {
					em.doPost("smtp.gmail.com", "587", "hiringportalacms@gmail.com", pass, Values.emailCustomList[i],
							testwrapper.getSubject(), testwrapper.getBody());
				}
			}
			Values.emailList.clear();
			Values.emailCustomList = null;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/***********************************************************************************
	 * Test Module 
	 * - Add questions to list
	 * - remove questions from list
	 * - show all the questions of given test before creating
	 * - Get Test id
	 * - Create Test (this will be stored in Test table --> not mapped to users)
	 * - List all the Tests
	 *************************************************************************************/
	@PostMapping("/addquestion/{question}")
	public ResponseEntity<Void> addSelectedQues(@PathVariable(value = "question") Long que) {
		Values.questionId.add(que);
		System.out.println(Values.questionId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/removequestion/{question}")
	public ResponseEntity<Void> removeSelectedQues(@PathVariable(value = "question") Long que) {
		Values.questionId.remove(que);
		System.out.println(Values.questionId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/showtest")
	public ResponseEntity<List<Question>> showTest() {
		List<Question> temp = ls.showTest();
		System.out.println("Inside show test::");
		for (int i = 0; i < temp.size(); i++) {
			System.out.println(temp.get(i));
		}
		return new ResponseEntity<List<Question>>(temp, HttpStatus.OK);
	}

	@GetMapping(path = "/testid/{testname}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Long> getTestID(@PathVariable(value = "testname") String testName) {
		Long list = ls.getTestID(testName);
		return new ResponseEntity<Long>(list, HttpStatus.OK);
	}

	@PostMapping("/createtest")
	public ResponseEntity<Void> createTest(@Valid @RequestBody Test test, UriComponentsBuilder builder) {
		boolean flag = ls.createTest(test);

		if (flag == true) {
			Document document = new Document();
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));
				document.open();
				for (int i = 0; i < Values.questions.size(); i++) {
					document.add(new Paragraph(Values.questions.get(i)));
				}
				document.close();
				writer.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Values.questions = new ArrayList<String>();
			Values.questionId = new HashSet<Long>();
			Values.questionIdTemp = new ArrayList<Long>();
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {

			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}

	}

	@GetMapping("/alltests")
	public ResponseEntity<List<Test>> getAllTests() {
		List<Test> list = ls.getAllTests();
		return new ResponseEntity<List<Test>>(list, HttpStatus.OK);
	}

	/****************************************************************************
	 * Test History
	 * - All Tests taken by the coordinator
	 * - ALl the users associated with particular test
	 ****************************************************************************/
	@GetMapping(path = "/gettesthistory/{cordid}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<TestHistoryWrapper>> getTestHistory(@PathVariable(value = "cordid") Long cordid) {
		List<TestHistoryWrapper> testHistoryWrapper = new ArrayList<TestHistoryWrapper>();
		testHistoryWrapper = ls.getTestHistory(cordid);
		return new ResponseEntity<List<TestHistoryWrapper>>(testHistoryWrapper, HttpStatus.OK);
	}

	@GetMapping(path = "getAllUsersWithTest/{testid}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<String>> getAllUsersWithTest(@PathVariable(value = "testid") Long testid) {
		List<String> allUsers = new ArrayList<String>();
		allUsers = ls.getAllUsersWithTest(testid);
		return new ResponseEntity<List<String>>(allUsers, HttpStatus.OK);
	}
	
	
	// logging api
	@GetMapping(path = "/countallstudents", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Integer> countAllStudents() {
		Integer allUsers = ls.countAllStudents();
		return new ResponseEntity<Integer>(allUsers, HttpStatus.OK);
	}
	

}
