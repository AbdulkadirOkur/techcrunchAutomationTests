
Feature: Click one of news from “The Latest News” list to reach the full content and verify followings;
  a. the browser title is the same with the news title
  b. the links within the news content (this step should be more clear)

  Background:Same starting steps added here
    Given Navigate to home page
    Then Click one of news from The Latest News



  Scenario: Verify that the browser title should contain the news title
    Then browser title should contain news title


  Scenario: Verify that links within the news content are valid links
    Then links within the news content should be valid links