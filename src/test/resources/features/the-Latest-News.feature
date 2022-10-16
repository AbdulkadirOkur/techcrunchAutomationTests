@wip
Feature:For “The Latest News” list, verify followings;
  a. each news has at least an author
  b. each news has at least an image

  Background:Same starting steps added here
    Given Navigate to home page


  Scenario:Verifying that each news has an author
    Then check each news and verify that each news has an author


  Scenario: Verifying that each news has an Image
    Then check each news and verify that each news has an Image