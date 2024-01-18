Feature:  Register features


  Background:
    Given I am a user on iStyle home page
    Then I click accept cookies button
    When I click 'Account' button


  Scenario: Missing email and password
    When I click 'Autentificare' button
    Then I validate error message 'A login email and password are required'.

  Scenario: Negative: Invalid email
    When I fill email input: 123
    When I click 'Autentificare' button
    Then I validate error message email: Please enter a valid email address (Ex: johndoe@domain.com).
    Then I validate error message pass: Acesta este un câmp obligatoriu.

  Scenario Outline: Negative: Valid email and invalid pass
    When I fill email input: <email>
    When I fill pass input: <password>
    When I click 'Autentificare' button
    Then I validate error message 'Utilizator sau parola incorecta.'.
  Examples:
    | email             | password     |
    | clescai@yahoo.com | cristina1233 |
    | lescaic@gmail.com | bagjsgag     |

  Scenario Outline: Positive: Valid email and pass
    When I fill email input: <email>
    When I fill pass input: <password>
    When I click 'Autentificare' button
    Then I am in my account
  Examples:
    | email                        | password   |
    | bdanielacristina24@gmail.com | 124BDC234h |


  Scenario: Negative: Invalid pass, when I don't fill any email.
    When I fill pass input: 123
    When I click 'Autentificare' button
    When I validate error message email: Acesta este un câmp obligatoriu.


