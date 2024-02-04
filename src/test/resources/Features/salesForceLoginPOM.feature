#Author: Yamuna Maile
#Feature: Login functionaltiy testing


Feature: SalesForce Login functionality
  
  @regression
  Scenario Outline: Login functionality test with valid data
  
    Given User is on SalesForce login page
    When User is enter <Username> and <Password>
    And User click on Use Custom Domain
    Then User is navigated Use Custom Domain Page
    

 Examples: 
 | Username | Password |
 | Test123 | nn1234 |
 #| admin | test111111 |