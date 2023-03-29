Feature: American Earliness Scenarios

  @SmokeTest
  Scenario: Validate HomePage American Airlines -  Successfully
    Given Open Browser and goto American Earline Page 'https://www.aa.com/homePage.do?locale=es_MX'
    Then Validate Name of page 'American Airlines - Boletos aéreos y vuelos baratos en AA.com'

  Scenario Outline: Login in American Airlines
    Given Open Browser and goto American Earline Page 'https://www.aa.com/homePage.do?locale=es_MX'
    Then Put '<advantage>' and '<firstName>' and '<password>' in web page
    And Validate the successful login '<newPage>'

    Examples:
      | advantage | firstName  | password       | newPage                                          |
      | cfuentes  | userCarlos | passwordCarlos | American Airlines \| We\'re working on our site! |
      | cfuentes  | userCarlos | passwordCarlos | Welcome Carlos                                   |

    Scenario Outline: Search Flights - Not found
      Given Open Browser and goto American Earline Page 'https://www.aa.com/homePage.do?locale=es_MX'
      When Put fly information '<From>' '<To>' '<Passengers>' '<Depart>' '<Return>'
      Then Validate page Results '<Results>'

      Examples:
        | From | To  | Passengers | Depart     | Return     | Results                              |
        | MEX  | CUN | 1          | 30/03/2023 | 30/04/2023 | Mexico City, Mexico a Cancun, Mexico |
