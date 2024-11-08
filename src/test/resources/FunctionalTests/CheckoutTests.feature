  
Feature:Price Validate check out page
Description: The purpose of Tests are to validate check out page details 

Scenario: Verify Check out page loaded 
 	 Given user is on Home Page
 	 When  Home page is loaded successfully
 	 And  Select any plan on the Home Page
 	 And Check out page is loaded successfully
 	 
Scenario:  Verify Check out page loaded 
 	 Given user is on Home Page
 	 When  Home page is loaded successfully
 	 And  Select any plan on the Home Page
 	 And Check out page is loaded successfully
 	 And Verify Insurance price on the checkout page
 	 And Verify Insurance Coverage Period details
 	 And Verify Insurance Coverage Provider details
 	 And Verify Insurance Coverage Plan name
 	 And user Selects minimum date of plan
 	 Then user verifies the date is changed
 	 And user Selects minimum date of plan
 	 Then user verifies the date is changed

 	 
 	 
 	 
 	 
 	
 	    

