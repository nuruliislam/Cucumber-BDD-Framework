Feature: Login into Application

Scenario Outline: Login and Validating Text
Given Initialize the browser with chrome
And Navigate to "https://bikroy.com/en" Site
And Click on Login in home page to land on Secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is succesfully logged in 
And close browsers

Examples:
|username				|password	|
|abc123@gmail.com		|abc123		|