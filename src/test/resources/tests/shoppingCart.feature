Feature: Shopping cart features

  Scenario Outline: I can add products in shopping cart
    Given I am a user on iStyle home page
    Then I click accept cookies button
    When I click 'Adauga' button with index: <index_product_1>
    When I click 'Adauga' button with index: <index_product_1>
    Then I close promotion popup
    When I click 'Shopping Cart' button
    When I click 'Vezi Cos' button
    Then I validate cart header : Total cos cumparaturi

    Examples:
    | index_product_1 |
    | 1               |
    | 5               |


  Scenario Outline: I can delete all products from shopping cart
    Given I am a user on iStyle home page
    Then I click accept cookies button
    When I click 'Adauga' button with index: <index_product_1>
    When I click 'Adauga' button with index: <index_product_2>
    Then I close promotion popup
    When I click 'Shopping Cart' button
    When I click 'Vezi Cos' button
    Then I validate shopping cart url is correct
    When I click 'Remove' button
    Then I validate empty basket message is displayed

    Examples:
      | index_product_1 |  | index_product_2 |
      | 0               |  | 3               |
      | 3               |  | 6               |


