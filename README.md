## Star Wars API
**Swagger link:** http://localhost:8080/swagger-ui/index.html

## Task 1
Implement the ```isCharacterOldWookie``` method in the `CharacterServiceImpl` class.  
This method should check if a character belongs to the Wookiee species and their age is greater than or equal to 60 years.

## Task 2
Implement the ```isCharacterTallerThanAverageHeightOfSpecie``` method in the `CharacterServiceImpl` class.  
This method should retrieve a character by ID and check if the character's height is greater than the average height of the species it belongs to.

## Task 3
Implement the ```getAverageWeightOfCharacters``` method in the `CharacterServiceImpl` class.  
This method should calculate the average weight of all characters.

## Task 4
There is a bug in the ```getHeaviestCharacterByEachSpecie``` method in the `CharacterServiceImpl` class. Find and fix it.

## Task 5
Add parameter validation to the ```createCharacter``` method in the CharacterController class.  
It should check that the age of the character being created is more than 0 years old and less than or equal to 1000 years old and return `BAD_REQUEST` status if the validation fails.

## Task 6
Implement the ```getHeaviestCharacterOnPlanet``` method in the `CharacterServiceImpl` class.  
The method should return the heaviest character on the specified planet. If there is no such planet, it should return null.  
Additionally, you need to create an endpoint (a method in the controller) that will invoke this method and return the proper status code based on the return value of the method.

## Task 7
The `createCharacter` and `deleteCharacterById` service methods can possibly throw errors. Add exception handling to the controller class for these two methods and return proper status codes for both successful and failed operations.

Examples:
https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
https://www.baeldung.com/java-exceptions


## Task 8
Add a global exception handler for the root `java.lang.Exception` class to handle all unhandled exceptions. 

Examples: https://www.baeldung.com/exception-handling-for-rest-with-spring


