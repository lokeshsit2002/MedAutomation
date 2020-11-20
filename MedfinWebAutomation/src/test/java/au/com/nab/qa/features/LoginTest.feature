Feature: Test login through DXC Global Pass for the CVX application URL
Description: As a CVA, I want to log into CVX Application through DXC Global Pass

Background: DXC Global Pass Screen is opened when user navigates to CVX url
When User navigates to CVX url
#Then DXC Global Pass Screen is opened
   
@browser
Scenario Outline: Validate CVA login successfully
When In Microsoft login page,Enter UserId <userID>
And In Global Pass login,Enter Password <password>
Then Validate that CVX landing initiator page url contains "dashboard"

Examples:
|userID				|password		|
|lsingh38@dxc.com	|Diwali@108108	|