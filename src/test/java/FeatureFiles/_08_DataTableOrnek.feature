Feature: DataTable Ornek

  Scenario: Users List
    When write username "ismet"
    And Write username and Password "ismet" and "1234"

    And Write username as DataTable
    | bilge  |
    | mehmet |
    | ahmet  |
    | ayse   |

    And Write username and Password as DataTable
    | bilge  | 1234 |
    | mehmet | 4567 |
    | ayse   | 7890 |
    | fatma  | 1234 |