# Java-TDD_Kata_Bowling
Simple java local application, using Test Driven Development methodology.

**Level: MEDIUM**<br>
**Status: Completed**

Setup:
 - JDK 1.8.0_191
 - IDE IntelliJ Idea
 - Maven (IntellliJ Idea)

References:
[TDD Kata](https://www.programmingwithwolfgang.com/tdd-kata/)

# 1. Introduction
  TDD is a methodology that let implement efficient code. To use TDD in a project, all team members musth think in TDD mode, from functional analist to junior developer.
  The TDD paradigm consist in:
  1. Take funtional requirements like technical test cases
  2. Implement an basic unit test case
  3. Write the minimun code to pass the test case
  4. Refactoring the code
  5. Repeat the poings 2, 3 and 4 to cover all requirements.

In this example I will develop a simple application using TDD. Imagine you take the next requirements:
___
The game consists of 10 frames as shown above.  In each frame, the player has two opportunities to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares. A spare is when the player knocks down all 10 pins in two tries.  The bonus for that frame is the number of pins knocked down by the next roll. So in frame 3 above, the score is 10 (the total number knocked down)plus a bonus of 5 (the number of pins knocked down on the next roll.) A strike is when the player knocks down all 10 pins on his first try.  The bonus for that frame is the value of the next two balls rolled. In the tenth frame, a player who rolls a spare or strike is allowed to roll the extra

balls to complete the frame.  However, no more than three balls can be rolled in the tenth frame.

Write a class named “Game” that has two methods

roll(pins : int) is called each time the player rolls a ball.  The argument is the number of pins knocked down.
score() : int is called only at the very end of the game.  It returns the total score for that game.
___
Now we must think in basic unit test to cover every cases.
