# LDTS_T09_G01 - Fireboy and Watergirl

## Game Description
Fireboy and Watergirl is a cooperative two-player game where the objective is to navigate both characters through a temple with several levels. Each character has unique abilities: Fireboy can walk through fire but must avoid water, while Watergirl can traverse water but must steer clear of fire, both can't touch the green goo. In order to complete a level, each player has to collect all the diamonds of their respective color, Fireboy must collect all red diamonds and Watergirl must collect all the blue diamonds. The game can be played by two people, which requires teamwork, or solo, promoting coordination.

This project was developed by Carolina Ferreira (up2023), Constança Ferreira (up202306850) and Maria Luiza Vieira (up202304306).

## Implemented features
- **Main Menu Screen** - When the game runs it shows a menu screen with the options to play or to exit.
- **Keyboard control** - The keyboard inputs are received and interpreted according to the current game state.
- **Multiple Players Control** - Movement and actions of Fireboy and Watergirl are managed through the arrow keys and WASD keys respectively. They can move up, down, left and right.
- **Collisions detection** - Collisions in the game environment between different elements are checked (e.g.: goo, fire, water, diamonds). Players can retrieve diamonds if the right collision between diamonds is verified.
- **Players Death** - If the player touches a fluid that does not correspond to their own, it dies and returns to the Main Menu.
- **Different levels** - 3 different levels with different complexities were implemented.
- **Credits** - When the game has successfully ended, a screen is shown with the name of the creators and the option to return to Menu.

## Planned Features
We managed to implement all planned features, apart from making the characters jump. We tried several different ways to try and achieve that but some were unsuccessful and others didn’t quite work out the way we wanted to, so we thought it was best to keep the up and down movement.



## Design

### General Structure

#### Problem in Context:
Our primary focus for the project was for it to be organized and well-structured. Given that our game features a Graphical User Interface (GUI) and is organized into distinct game states, we identified two specific patterns that would best suit what we wanted.

#### The Pattern:
The patterns we chose to apply to the project were the **Model-View-Controller (MVC) Architectural** Pattern, widely used in GUI design, and the **State Pattern**, a behavioral design pattern that enables an object to modify its behavior based on changes to its internal state.

#### Implementation:
In terms of implementation, this allows us to have classes with distinct purposes. Those that manage the game state, handle game logic, and provide data to the controllers (model). Those that draw the game elements on the screen and update the display based on the game state (view). Those that process user input, update the model, and trigger view updates (controller).

These classes interact with one another in the following way:
Model contains the game data and logic and provides that data to the Controller and View. View is then responsible for rendering the game and receives data from the Model and updates the display. Controller handles and processes user input, updates the Model and triggers View updates.
That is allowed though Game which coordinates the flow between Model, View, and Controller by managing the overall game state and transitions.

The implementation of this pattern can be found inside the folders:
-[Model](src/main/java/com.t09g01.projeto/model)
-[View](src/main/java/com.t09g01.projeto/view)
-[Control](src/main/java/com.t09g01.projeto/control)

An explanation can be seen in the following diagram:
<p align="center">
  <img src="resources/images/UML/gameLoop.png"/>
</p>

#### Consequences:
These design patterns allow:
- The different states representing various menus to be explicitly defined in the code;
- Better code organization.
- Adding new features during the development process in a simpler way.


### Game States

### Game Loop

#### Problem in Context
When creating a game, it's important to establish a mechanism for updating the state of each entity over time. As the game expands, it becomes necessary to manage the game's pace and determine how frequently the visuals on the screen are refreshed.
This is important given that the speed at which the code executes varies depending on the user's system. To ensure a consistent speed for all users, there needs to be a system in place to regulate this.

#### The Pattern
The design pattern we used to address this issue is the **Game Loop**, a while-loop that runs based on the current state of the game.
We also introduced a target FPS value, which specifies how many times the screen should update per second during execution. Using this, we calculate the time the main execution thread needs to pause before proceeding to the next iteration of the loop.
This ensures that the game runs consistently and smoothly for users on different systems.

#### Implementation




#### Consequences
This design pattern allows:
- Consistent updates across systems so that the game runs at a consistent speed regardless of the user's hardware or system performance, delivering a uniform experience.
- Separation of Concerns because it divides the game’s logic into distinct phases, such as updating game state, handling input, and rendering.
- Dynamic, real-time interactions by continuously updating the game state and handling user inputs.



### Temple builder

#### Problem in Context:
Our Temple is composed of various elements such as blocks, fluids, doors, diamonds and players.
Instead of designing a unique builder for each level, we chose to create a temple that reads level configurations from a file and populates a class - TempleBuilder - with the required elements. This approach simplifies the process because it allows us to create only the necessary elements and easily draw different levels.

#### The Pattern:
The **Builder** is a creational design pattern that is used to construct complex objects step by step, resulting in a simpler code.

#### Implementation:
In our project, the TempleBuilder class is responsible for creating and assembling the parts of the Temple object. Temple itself supplies the specific components and is able to read different levels from different files.

#### Consequences:
This design pattern:
- Simplifies the process of creating complex objects by breaking down the construction process into smaller, manageable steps.
- Can help in creating immutable objects by ensuring that the object is fully constructed before it is used.
- Encapsulates the construction and representation of the object, allowing the same construction process to create different representations.



### GUI

#### Problem in Context:
The need for a unified and adaptable interface arose to handle discrepancies between the requirements of our game and the features provided by the Lanterna library.
The library includes numerous functions irrelevant to our program, violating the Interface Segregation Principle, and lacks essential functionalities that our GUI demands.
This means that directly using the raw library would link our game with a low-level module, violating the Dependency Inversion Principle (DIP). To address these challenges, we needed an adapter to bridge the gap between our game and the library.

#### The Pattern:
As a solution, we applied the **Adapter** design pattern, given that it acts as a bridge between incompatible interfaces, allowing our game to utilize the Lanterna library while ensuring it meets the specific requirements of our system. This pattern provides the necessary abstraction to ensure that our high-level module does not directly depend on low-level modules and allows each class in our application to interact with a more user-friendly GUI interface while still utilizing Lanterna's functionalities through the LanternaGUI adapter.

#### Implementation

#### Consequences:
This design pattern:
- Ensures, by tailoring the interface to the system’s needs, that only the relevant functionality is exposed, reducing complexity and avoiding unused features.
- Promotes code reusability by allowing existing classes to be used in new ways without modifying their source code. This makes it easier to extend and maintain the system.
- Ensures compliance with the Interface Segregation Principle by exposing only the necessary features.


## Known-code smells

## Testing

### Screenshot of coverage report

### Link to mutation testing report

## Self-evaluation
The work was divided in equal parts and we all gave our best.
- Carolina Ferreira - 33.3%
- Constança Ferreira - 33.3%
- Maria Luiza Vieira - 33.3%
