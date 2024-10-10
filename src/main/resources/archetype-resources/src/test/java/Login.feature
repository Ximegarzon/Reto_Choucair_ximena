Feature: Login and Recruitment Process

  Scenario: User logs in and adds a new candidate
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should be redirected to the dashboard
    And the user navigates to Recruitment
    And the user adds a new candidate
    Then the candidate's status should be "Hired"
