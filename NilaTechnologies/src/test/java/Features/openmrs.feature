Feature: Title of your feature

  Scenario: AssessmentScenario
    Given user open the browser
    And User launch the application "https://qa-refapp.openmrs.org/openmrs/login.htm"
    When User enter the "Admin" and "Admin123"
    And User click the Outpatient Clinic
    And User Click the loginButton
    When User Navigate to Patient_Register
    Then User Enter the Patient_details 
    