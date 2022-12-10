Feature: To perform all the CRUD Opertions

  Background: 
    Given The base URI is "http://localhost:3000/employees"

  Scenario: To Perform the GET Operation on Employe DB
    #Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario Outline: To Perform the GET Operation on Employe DB
    #Given The base URI is "http://localhost:3000/employees"
    When I perform the Post Operation for users "<uname>" and Salary <sal>
    Then Response code should be 201

    Examples: 
      | uname  | sal  |
      | Savita | 6800 |
      | Kavita | 7900 |
      | Anita  | 8400 |
