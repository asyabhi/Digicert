Feature: Feature to automate Star Wars App UI

  Background: User navigates to Star Wars App
    Given I navigate to Star Wars App

  Scenario: Validate Movie Sorting and Last Movie Title
    Given I click on Title and sort the movies
    Then Last movie should be The Phantom Menace

  Scenario: Validate Species List in Empire Strike Back
    Given I click on The Empire Strikes Back
    Then Species list should have Wookie

  Scenario: Assert absence of Camino
    Given I click on The Phantom Menace
    Then Planet List should not have Camino

