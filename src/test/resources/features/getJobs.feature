@api

Feature: GET jobs API endpoint tests

  Scenario: GET All Jobs
    Given I send a GET request
    Then I should get 200 status code back
    And I should see more than 1 job

  Scenario: GET a Single Job
    Given I send a GET request for a single job
    Then I should get 200 status code back
    And I should see the job details