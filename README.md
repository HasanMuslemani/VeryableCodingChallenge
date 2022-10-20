# Veryable Coding Challenge #
Veryable coding challenge for Mobile Engineer [Android/Kotlin] position.
## Android Coding Challenge ##
As a Mobile Developer at Veryable, most of the times we implement UI prototypes by following the design
guidelines. For this exercise, we have provided you a scenario which you will need to develop. We have
also included the required assets (images, colors etc.) and a base project for this exercise.
### Instructions: ###
Please read the following instructions along with the Wireframe.pdf file to understand the requirement
of the application correctly. Wireframe.pdf is the document that details the interaction flow of the
application. Please follow the fonts and color guideline included in wireframe.pdf.

1. The purpose of this exercise is to build an app where you can see the list of your banking and card
accounts (Accounts View). Please use the attached base project to add your code.
2. The list on Accounts View is vertically scrollable. When user touch one of the items, the app should
take them to next page (Detail View) where users can see the details.
3. The user can touch either the physical Done button or the back arrow at the top left corner on
Detail View to go back to the Accounts View.
4. For each screen, display the Name on Toolbar.
5. On the Accounts View, you should make a network call to fetch the data from the [JSON file](https://veryable-public-assets.s3.us-east-2.amazonaws.com/veryable.json "JSON file") hosted on AWS. The application should read the Json data and display in order.
6. For each item in the data, display the following items:
      * Display the Bank or Card image (included in Assets Zip) depending on the account type.
      * Display Account name
      * Display Account Description.
      * Display transfer type which is ACH-Same Day for Bank Account and Instant for a Card.
      * Display an arrow on the right side.
      
## Technologies Used ##
* Kotlin
* Jetpack Compose
* Retrofit2
* MVVM Architecture
