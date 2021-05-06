Feature: Yandex Market Compare products feature

  Scenario: Yandex Market. Added products to compare list
    Given I open Yandex Market Home page
    And I open subcategory 'Смартфоны' in category 'Электроника' from menu section
    When I add products '1,2' to compare list on Yandex Market Catalog page
    And I click 'Сравнить' button in the pop-up header of the page
    Then added product titles should be displayed on the Yandex Market Compare Products page
