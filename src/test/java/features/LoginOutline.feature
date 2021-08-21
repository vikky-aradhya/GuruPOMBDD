Feature: Login into an application

  Background: User Navigates to application
    When User opens browser

  @Login_user_outline
  Scenario Outline: Login
    Given Login page is loaded
    And user Enters the user name as "<username>" and password as "<password>" and clicks on login button
    Then user validates HomePage

    Examples:
      | username  | password |
      | mngr47659 | 1@       |
      | java      | java     |


