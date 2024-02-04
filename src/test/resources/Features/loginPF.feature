
#Sample Feature Definition Template

@smoke
Feature: SalesForce login
 
 Background: 
 Given User is on Chrome browser
 Then User is able to enter sales force login URL
 And user click on enter button
 
  Scenario Outline: 
    Given User is on sales force login page
    When User enter <username> and <password>
    And Click on forgot password link
    Then user is navigate to Forgot password page
    
    Examples: 
      |username|password|
      |testing|usernmpass123|
      
      
     # Scenario: 
    #Given User click on Use Custom domain link
    #When User is navigated to UCD page
      