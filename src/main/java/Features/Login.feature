@Login
Feature: Perform login operation with multiple user ids

	Scenario Outline: Login with excel data
	
	Given I am on login page
	When I take input of creds from "<excel>"
	Then I perform login with data from the Excel file
	
	Examples:
	| excel |
	| userCreds.xlsx |