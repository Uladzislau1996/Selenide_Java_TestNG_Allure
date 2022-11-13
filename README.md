# Selenide_Java_TestNG_Allure
## A test project in which I automated test cases that check the operation of the pop-up search on the bookmaker's website https://www.oppabet888.com/ru
## And at the moment I update my test project and i'm adding new test checks for registration block
### At the beginning of each test case, I enter the query that is indicated @DataProvider, use data "Arsenal and footbal". 
#### The test cases I covered the search popup with:
1. To check that the Pop-up contains all the elements in the Matches/Leagues tabs
2. To check that after clicking on the search button, results are pulled up that are equal to the value of the counter in Tab Matches
3. To check that after clicking on the search button, results are pulled up that are equal to the value of the counter in Taba Leagues
4. To check that the counter in PopUp in the MATCHES tab = number of results
5. To  check that there are no icon's coefficients in the League tab
6. To check that a stub is displayed if there is no query in the search in the LEAGUES / MATCHES tabs
7. To check that a stub is displayed if an invalid query is entered in the LEAGUES / MATCHES tabs
8. To check that the counter = 0 if there is no query in the search in the LEAGUES/MATCHES tabs
9. To check that the counter = 0 if an incorrect search query is entered in the LEAGUES / MATCHES tabs
10. To check that only when the 'Live' checkbox is enabled, the Live cell is always displayed opposite the results in the MATCHES tab
11. To check that only when the 'Live' checkbox is enabled, the Live cell is always displayed opposite the results in the LEAGUES tab
13. To check that the search results are pulled up if all the Live/Sports/Exact checkboxes are enabled
14. Checking that the search results are pulled up if the Sports/Exact match checkboxes are enabled
15. To check that the results are not pulled up if the checkboxes are turned off
16. To check if delete text button in the search box works
17. To check that the search result text is clickable and leads to the appropriate page in the Matches tab
18. To check that the text of the search result is clickable and leads to the corresponding page in the LEAGUES tab
19. To check that coefficients are clickable


### The test cases I covered the registration block:
 1. To check that all registration elements are displayed
 2. To check that country dropdown has 5 countries
 3. To check that currency dropdown has 4 currency
 4. Check that the dropdown city has 799 cities in India
 5. Check that the dropdown city has 15 cities in Bangladesh
 6. Check that the dropdown city has 61 cities in Malaysia
 7. Check that the dropdown city has 59 cities in Vietnam
 8. Check that the dropdown city has 145 cities in Indonesia
 9. Check that the dropdown city has 7 cities in Nepal
 10. Check default text in the all buttons/fields
 11. Check placeholder in the text fields