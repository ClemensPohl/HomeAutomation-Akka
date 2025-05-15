Home Automation Console
Requirements
Java 17

Gradle

Setup
Ensure Java 17 is installed and available on your PATH.

Run the following commands in the root directories of both microservices to install them:

bash
Kopieren
Bearbeiten
./gradlew install
Repeat the command in each microservice directory.

Console Commands
General Environment Commands
Command    Description
t <value>    Manually trigger temperature reading
env-set <value>    Set fixed environment temperature
env-start    Start temperature simulation
env-stop    Stop temperature simulation
weather-set <type>    Set weather (e.g., sunny, cloudy, etc.)
weather-start    Start weather simulation
weather-stop    Stop weather simulation
blinds-open    Open blinds
blinds-close    Close blinds
movie-start    Start a movie
movie-stop    Stop the movie
env-mode <mode>    Set environment mode (INTERNAL, EXTERNAL, OFF)
quit    Exit the application

Fridge Commands
Command    Description
fridge-add <name> <weight> <price>    Add product to fridge
fridge-remove <name>    Remove product from fridge
fridge-list    List products in fridge

for docs read the documentation.md