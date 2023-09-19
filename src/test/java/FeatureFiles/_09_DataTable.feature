Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the element in DialogContent
      | addButon |

    And User sending the keys in Dialog
      | nameInput | Konya23 |
      | codeInput | Kon23   |

    And Click on the element in DialogContent
      | saveButton |

    And User delete the element from Dialog
      | Konya23 |

    Then Success message should be displayed

  Scenario: Create Nationality
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And  Click on the element in DialogContent
      | addButon |

    And User sending the keys in Dialog
      | nameInput | KonNat23 |

    And Click on the element in DialogContent
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | KonNat23 |

    Then Success message should be displayed

  Scenario: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in DialogContent
      | addButon |

    And User sending the keys in Dialog
      | nameInput       | Hamza  |
      | codeInput       | HMZ23  |
      | integrationCode | 231243 |
      | priority        | 56     |

    And Click on the element in DialogContent
      | activeButton |
      | activeButton |
      | saveAndClose |

    Then Success message should be displayed

    And User delete the element from Dialog
      | Hamza |

    Then Success message should be displayed
