#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

Feature: Exam functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Exam Create and Delete
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in DialogContent
      | addButon |

    And User sending the keys in Dialog
      | nameInput | blgExam1 |

    And Click on the element in DialogContent
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in DialogContent
      | saveButton |

    Then Success message should be displayed

    #Silme ekranına ulaşmak için tekrar navigate yapıldı
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in DialogContent
      | searchAcademicPeriod |
      | academicPeriod1      |

    And User delete the element from Dialog
      | blgExam1 |

    Then Success message should be displayed
