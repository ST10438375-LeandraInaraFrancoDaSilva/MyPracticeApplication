ReadMe
Screen Timer App
This app looks forward promote an easy way for individuals to store their screen time over a certain period of time. It displays comprehensive details by the input of date, morning screen time, afternoon screen time both in minutes and notes on which activity was being executed at the moment, average of time used is also displayed by adding the time spent on screen.
The app makes use of three pages, the first one is only responsible to direct users to the next page or exit the app, is the welcome one.
 

Once the start button is pressed the page responsible for taking the information inputted by the users takes place in there 4 details can be added by clicking in the add button, information can be cleared in order for other to be re-entered by clicking on the clear button and access to the next page is granted by clicking on the details view button.
 

In this page toasts were also placed in order for users to interact more clearly with app, if information was missing the users would get a message on that, if it was successfully added another toast would take place and so on.
 

The third page is were the details inputted are displayed as well as the average, the user also gets to go back to the previous page by clicking in the respective button, the information is shown in a specific format stipulated in the code and the average calculated by a formula also placed there. 
 
 
Link to my repository: …

Pseudocode:
SplashActivity:
 Display Splash Screen with app name, your name, student number, and logo
 If Start button clicked:
 Navigate to MainActivity
 If Exit button clicked:
 Close the app
MainActivity:
 Initialize dates as ArrayList<String>
 Initialize morningScreenTimes as ArrayList<Int>
 Initialize afternoonScreenTimes as ArrayList<Int>
 Initialize activityNotes as ArrayList<String>

 Initialize dateEditText
 Initialize morningScreenTimeEditText
 Initialize afternoonScreenTimeEditText
 Initialize activityNotesEditText
 Initialize addButton
 Initialize clearButton
 Initialize detailedViewButton
 On addButton click:
 Retrieve date from dateEditText
 Retrieve morningScreenTime from morningScreenTimeEditText
 Retrieve afternoonScreenTime from afternoonScreenTimeEditText
 Retrieve notes from activityNotesEditText
 If all inputs are valid:
 Add date to dates
 Add morningScreenTime to morningScreenTimes
 Add afternoonScreenTime to afternoonScreenTimes
 Add notes to activityNotes
 Clear input fields
 Show success message
 Else:
 Show error message
 On clearButton click:
 Clear dates
 Clear morningScreenTimes
 Clear afternoonScreenTimes
 Clear activityNotes
 Show data cleared message
 On detailedViewButton click:
 Create Intent to navigate to DetailedViewActivity
 Pass dates, morningScreenTimes, afternoonScreenTimes, activityNotes to DetailedViewActivity
 Start DetailedViewActivity
DetailedViewActivity:
 Initialize detailsTextView
 Initialize averageTextView
 Retrieve dates from Intent
 Retrieve morningScreenTimes from Intent
 Retrieve afternoonScreenTimes from Intent
 Retrieve activityNotes from Intent
 Initialize details as StringBuilder
 Initialize totalScreenTime as 0
 For each date in dates:
 Append date, morningScreenTime, afternoonScreenTime, and notes to details
 Add morningScreenTime and afternoonScreenTime to totalScreenTime
 If dates is not empty:
 Calculate averageScreenTime as totalScreenTime / number of days
 Else:
 Set averageScreenTime to 0
 Display details in detailsTextView
 Display averageScreenTime in averageTextView
 On backButton click:
 Finish current activity and navigate back to MainActivity

