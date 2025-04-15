Feature: Conduit CRUD Functions

  Scenario: Login into App
    Given User is on Login page
    When User provide "TestUser@gmail.com" and "Test@123"
    Then User should be on Home Page

  Scenario: Create new Article
    Given User should be on New Article Page
    When User enters Article details
      | title | Desc | Content | tag |
    Then Article must be created

  Scenario: View Article
    Given User should be on Global Feed page
    When User select an article "12Test46"
    Then Article detail page must be displayed

  Scenario: Update an Article
    Given Article detail page must be displayed
    When User update article detail
    Then Article detail must be updated

  Scenario: Delete an Article
    Given Article detail page must be displayed
    When User delete article
    Then Article "12Test47" must be deleted
