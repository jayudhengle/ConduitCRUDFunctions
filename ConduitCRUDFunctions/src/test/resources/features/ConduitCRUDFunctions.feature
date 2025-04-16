Feature: Conduit CRUD Functions

  Background: Login into App
    Given User is on Login page
    When User provide "TestUser@gmail.com" and "Test@123"
    Then User should be on Home Page

  Scenario: Create new Article
    Given User should be on New Article Page
    When User enters Article details
      | title | Desc | Content | tag |
    Then Article must be created

  Scenario: Duplicate Article
    Given User should be on New Article Page
    When User enters Duplicate Article "12Test68"
    Then Must throw duplicate error

  Scenario: View Article
    Given User should be on Global Feed page
    When User select an article "12Test68"
    Then Article detail page must be displayed

  Scenario: Update an Article
    Given Article detail page is available
    When User update article detail
    Then Article detail must be updated

  Scenario: Delete an Article
    Given Article "12Test69" detail page is available
    When User delete article
    Then Article must be deleted
