Feature: Login with Multiple Data

Scenario Outline: Login with correct credentials
    Given user is on Application Landing Page
    When user enters username "<Username>" in username field
    And user enters password "<Password>" in password field
    And user clicks on Login button of Landing Page
    Then user gets login failed error message
    
    
    Examples:
    	|Username									|Passowrd				|
    	|philipbittu@gmail.com12	|philip12				|
    	|philipbittu@gmail.com12	|philip					|
    	|philipbittu@gmail.com		|philip12				|