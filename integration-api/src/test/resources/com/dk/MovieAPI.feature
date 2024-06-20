Feature: Movie API

    Scenario: Get all movies
        Given I am an authenticated user
        When I request all movies
        Then I should recieve a list of movies
