/*
 * Object List
 * 	Platformer:
 * 	    init: creates a new PFPanel, then sets it up/adds it to the window
 * 
 * 
 *  PFPanel:
 *      init: creates a new Timer, a new Square (player object), and a new ObjectManager
 * 		startGame: starts the timer
 * 		paintComponent: Draws the level based on "state" variable
 * 		actionPerformed: Event Handler
 * 				setupcomplete1 == false && state == 1 : Call objectManager setup for the first level
 * 				setupcomplete2 == false && state == 2 : Call objectManager setup for the second level
 * 				Movement (moveLeft, moveRight, jump) : Call movement on Square (player)
 * 				s.finishLevel == true : Indicates that the current level is complete and sets up the next level
 * 				state != T_STATE || state != E_STATE : Calls objectManager.update, and objectManager.checkCollision
 * 		KeyPressed: handles the key presses
 * 				E: Starts the game ("state" set to 1) from the title screen
 * 				R: Resets the player object if it's on a game screen/isn't at predefined coordinates
 * 				Movement (Left, Right, Jump): sets boolean flags for actionPerformed methods
 * 		KeyReleased: sets movement booleans to false
 * 		draw?State: draws the ? level (background/square)
 * 	
 * 
 * ObjectManager:
 * 		init: creates arrayLists of gameObjects for objects and goals, sets up the player object (syncing)
 * 		addObject: adds a configured gameObject to the list of objects(platforms)
 * 		setup: sets up the given level (?)
 * 			setup?: resets Square object, clears goals/objects, sets up/defines new objects
 * 		update: calls an update on all objects
 * 		draw: draws graphics for all objects
 * 		checkCollision: loops through the platforms to check if the player is stuck in the platform.  Also checks if the player is touching the goal, and sets the stuck/squareCollision variable
 * 		setSquare: sets the position of the new Square, and updates the hitbox.
 * 		
 * 
 * 
 * 	GameObject:
 * 		init: sets dimensions(x,y,w,h)
 * 		update: add/updates a collision box for this object
 * 		
 * 	Goals/Steps are subsets of this class.
 * 
 * 
 * 	Square:
 * 		init: see GameObject
 * 		getY: returns Y, for testing purposes
 * 		jump: allows the player to jump
 * 		moveLeft/moveRight: called by gameObject, moves character left/right by using a temporary position to check where it's going to be (check for why moveleft/moveright variables are set here)
 * 		update: sets boundaries for where it should be going
 * 		draw: draws the square and its hitbox
 * 
 * 	
 * 	Items that call finishLevel:
 * 		
 * 		
 * 
 * 
 * 	
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
