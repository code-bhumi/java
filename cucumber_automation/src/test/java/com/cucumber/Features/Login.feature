Feature: Application Login

    Scenario: Home page default login
        Given User is on NetBanking Landing page
        When User login into Application with "jin" and password "1234"
        Then Home page is populated
        And Cards displayed are "True"

    Scenario: Home page default login
        Given User is on NetBanking Landing page
        When User login into Application with "john" and password "4367"
        Then Home page is populated
        And Cards displayed are "false"
     