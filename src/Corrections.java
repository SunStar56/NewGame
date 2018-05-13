
// FINISHED MAY 6TH
// -Condensed if/else below in square(don’t need to check if(colliding)
// and if(!colliding)
// -created methods for moveLeft and moveRight in square
// -removed canMove variables because the values were never being changed and we
// can just use ifs to see if it is about to run into trouble
// -created a boolean moveRight and moveLeft in the gamePanel class so that we
// can move the player left and right at a constant speed
// -make window width and height variables static so that can be used to create
// the floor platform
// -keep the PFPanel member variable together at the top
// -remove the fake floor platform being drawn in drawGameState1
// -if you draw the collisionBox from the GameObject class, you will see that
// there is only one collision box being drawn(left platform)
// -get rid of the duplicate initialization of the window jPanel in the platform
// class
// -in checkCollision, make sure you are checking things in relation to an
// object’s collisionBox, not the object itself
// -make a boolean for whether the setup has been completed for a level with an
// if statement in the actionPerformed so that we aren’t redoing that every time
// we go through
// -calling om.setup1
// -setting setupComplete = true
// -you can also keep the square from falling before the gameState is reached by
// instantiating your square here and using a setter to set the object manager’s
// square value
// -put your om.update and om.checkCollision that is actionPerformed in an if
// that checks that the state is not = to T_STATE or E_STATE, otherwise it will
// try to update the square which isn’t created until the first game state

// FINISHED MAY 13
// -move player.draw to objectManager’s draw method
// -add an else in PFPanel’s keyPressed so that if E is dressed and the state =
// E_STATE, the state = T_STATE and setup complete = false.
// -if there is no collision we want to assign the values of the collision box
// to the values of x

// EVERYTHING IS DONE!!!