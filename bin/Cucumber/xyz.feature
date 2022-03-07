Feature: Role creation

Scenario Outline: Verifying Role Creation With Multiple sets of data


Given User already on Ranford Home Page

When User enters valid UserName and Password 

Then User Admin Login validation

When User clicks on role button

When Users Click on New Role and Enter all "<RoleName>" and "<RoleType>" 

Then Close Application

Examples: 

  | RoleName   | RoleType |
  | Cashierhdf | E |
  | TellerHdf  | E |
  | ManagerSb  | E |