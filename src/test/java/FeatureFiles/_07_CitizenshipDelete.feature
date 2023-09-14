#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)
#oluşturulan her CitizenShip i siliniz.
#yukarıdaki senaryoyu farklı 5 değer için çalıştırınız

Feature: Citizenship Delete Scenario

  Background: #Before Senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenships

  Scenario Outline: Create a citizenship
    When Create a citizenship name as "<name>" short name as "<shortname>"
    Then Success message should be displayed

    When Create a citizenship name as "<name>" short name as "<shortname>"
    Then Already exist message should be displayed

    When Search created citizenship name as "<name>" short name as "<shortname>"
    And Delete created citizenship
    Then Success delete message should be displayed

    Examples:
      | name  | shortname |
      | Kara Murat | KM23 |
      | Kara Murat1 | KM1 |
      | Kara Murat2 | KM2 |
      | Kara Murat3 | KM3 |
      | Kara Murat4 | KM4 |