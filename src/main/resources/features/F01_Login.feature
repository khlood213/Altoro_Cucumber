@Feature
  Feature: Check Login to Altoro Web Application

    @SmokeScenario
    Scenario: SC-1: Check login with valid Credientials
      When    click signin button
      And     enter valid credientials to login form
      And     click login button
      Then    system shall navigate to admin profile page