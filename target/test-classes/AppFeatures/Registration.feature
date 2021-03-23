Feature: User Registration


Scenario: User registration with different Data with columns
Given User is on registration page
When User enters following user details with columns
|firstname|lastname|emailadd      |phone|city|
|Bittu    |Philip  |bittu@gmail.com|9999 |london|
|Mathew   |Jacob   |bittu@gmail.com|9910 |Paris|
|Lisa     |Sam     |lisa@gmail.com |38949|NewYork|

Then User registration is successful