Feature: Feature to automate Star Wars App UI

  Background: User navigates to Star Wars App
    Given I navigate to Star Wars App

  Scenario: Validate Movie Sorting and Last Movie Title
    Given I click on Title and sort the movies
    Then Last movie should be The Phantom Menace
