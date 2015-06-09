Feature: Book Search

  Scenario: Search for a book in Amazon.com
    Given I go to URL
    When I search for a book
    And I add the book to cart
    Then The book is in cart
