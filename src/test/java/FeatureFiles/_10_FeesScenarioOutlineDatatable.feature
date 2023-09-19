Feature: Fees multiple values functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in DialogContent
      | addButon |

    And User sending the keys in Dialog
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priority        | <priority> |

    And Click on the element in DialogContent
      | activeButton |
      | activeButton |
      | saveAndClose |

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name   | code | intCode  | priority |
      | Hamza1 | HMZ1 | PayBal   | 7        |
      | Hamza2 | HMZ2 | Cash     | 7        |
      | Hamza3 | HMZ3 | ApplePay | 7        |
      | Hamza4 | HMZ4 | Check    | 7        |