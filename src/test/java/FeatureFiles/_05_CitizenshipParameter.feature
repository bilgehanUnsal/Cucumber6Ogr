#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

  Feature: Citizenship Multi Scenario

    Background: #Before Senaryo
      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login successfully
      And Navigate to citizenships

      Scenario: Create a citizenship
        When Create a citizenship name as "Kara Murat" short name as "KM23"
        Then Success message should be displayed

        When Create a citizenship name as "Kara Murat" short name as "KM23"
        Then Already exist message should be displayed
