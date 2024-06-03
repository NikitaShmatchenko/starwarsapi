## Star Wars API
**Swagger link:** http://localhost:8080/swagger-ui/index.html

## Task 1
Implement the ```isCharacterOldWookie``` method in the CharacterServiceImpl class.  
This method should check if a character belongs to the Wookiee species and their age is greater than or equal to 60 years.

## Task 2
Implement the ```isCharacterTallerThanAverageHeightOfSpecie``` method in the CharacterServiceImpl class.  
This method should retrieve a character by ID and check if the character's height is greater than the average height of the species it belongs to.

## Task 3
Implement the ```getAverageWeightOfCharacters``` method in the CharacterServiceImpl class.  
This method should calculate the average weight of all characters.

## Task 4

There is a bug in the ```getHeaviestCharacterByEachSpecie``` method in the CharacterServiceImpl class. Find and fix it.

## Task 5
Add parameter validation to the ```createCharacter``` method in the CharacterController class.  
It should check that the age of the character being created is more than 0 years old and less than 1000 years old.

## Task 6
Implement the ```getHeaviestCharacterOnPlanet``` method in the CharacterServiceImpl class.  
The method should return the heaviest character on the specified planet. If there is no such planet, it should return null.  
Additionally, you need to create an endpoint (a method in the controller) that will invoke this method and return the proper status code based on the return value of the method.