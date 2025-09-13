Schiffeversenken cli game  
https://en.wikipedia.org/wiki/Battleship_(game)

- Did this in java just to get a better feel for the language.
- TODO: write Tests to secure everything
- TODO: multiplayer over network

```
  1 2 3 4 5 6 7 8 9 10
A X M ~ ~ ~ ~ ~ ~ ~ ~
B X ~ ~ M ~ ~ M ~ X ~
C X ~ ~ ~ ~ ~ ~ ~ X ~
D X ~ ~ ~ ~ M ~ ~ X ~
E ~ ~ ~ M ~ ~ M ~ M ~
F M ~ X X X X X M ~ ~
G ~ ~ ~ ~ ~ ~ M ~ ~ ~
H ~ M M ~ ~ ~ ~ ~ ~ M
I ~ X ~ ~ M ~ ~ M ~ ~
J ~ X ~ ~ ~ ~ M X X X
```

~ water (unkown space, fog)  
0 your ship  
X hit ship  
M missed

- 10 x 10 board
- Ship validation
- Coordinate validation
- Coordintate input line "A1 A3"
- 5 Ships
- local 2 player

Aircraft Carrier is 5 cells
Battleship is 4 cells
Submarine is 3 cells
Cruiser is also 3 cells
Destroyer is 2 cells.

Example Game:

```
Player 1, place your ships on the game field
  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Aircraft Carrier (5 cells):
A1 A5
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Battleship (4 cells):
C7 D8
Error! Diagonal is not allowed!
Enter the coordinates of the Battleship (4 cells):
C7 G6
Error! Diagonal is not allowed!
Enter the coordinates of the Battleship (4 cells):
C7 C8
Error! Invalid ship length
Enter the coordinates of the Battleship (4 cells):
C7 F7
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ O ~ ~ ~
D ~ ~ ~ ~ ~ ~ O ~ ~ ~
E ~ ~ ~ ~ ~ ~ O ~ ~ ~
F ~ ~ ~ ~ ~ ~ O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Submarine (3 cells):
E3 E5
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ O ~ ~ ~
D ~ ~ ~ ~ ~ ~ O ~ ~ ~
E ~ ~ O O O ~ O ~ ~ ~
F ~ ~ ~ ~ ~ ~ O ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Cruiser (3 cells):
G3 I3
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ O ~ ~ ~
D ~ ~ ~ ~ ~ ~ O ~ ~ ~
E ~ ~ O O O ~ O ~ ~ ~
F ~ ~ ~ ~ ~ ~ O ~ ~ ~
G ~ ~ O ~ ~ ~ ~ ~ ~ ~
H ~ ~ O ~ ~ ~ ~ ~ ~ ~
I ~ ~ O ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Destroyer (2 cells):
J9 J10
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ O ~ ~ ~
D ~ ~ ~ ~ ~ ~ O ~ ~ ~
E ~ ~ O O O ~ O ~ ~ ~
F ~ ~ ~ ~ ~ ~ O ~ ~ ~
G ~ ~ O ~ ~ ~ ~ ~ ~ ~
H ~ ~ O ~ ~ ~ ~ ~ ~ ~
I ~ ~ O ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ O O
Press Enter and pass the move to another player








Player 2, place your ships to the game field
  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Aircraft Carrier (5 cells):
A1 A5
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Battleship (4 cells):
A9 A12
Error!
Enter the coordinates of the Battleship (4 cells):
A9 D9
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ O ~
B ~ ~ ~ ~ ~ ~ ~ ~ O ~
C ~ ~ ~ ~ ~ ~ ~ ~ O ~
D ~ ~ ~ ~ ~ ~ ~ ~ O ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Submarine (3 cells):
G6 G9
Error! Invalid ship length
Enter the coordinates of the Submarine (3 cells):
G6 G8
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ O ~
B ~ ~ ~ ~ ~ ~ ~ ~ O ~
C ~ ~ ~ ~ ~ ~ ~ ~ O ~
D ~ ~ ~ ~ ~ ~ ~ ~ O ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ O O O ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Cruiser (3 cells):
H6 H8
Error! cannot place your ship there.
Enter the coordinates of the Cruiser (3 cells):
I6 I8
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ O ~
B ~ ~ ~ ~ ~ ~ ~ ~ O ~
C ~ ~ ~ ~ ~ ~ ~ ~ O ~
D ~ ~ ~ ~ ~ ~ ~ ~ O ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ O O O ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ O O O ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Enter the coordinates of the Destroyer (2 cells):
E1 F1
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ O ~
B ~ ~ ~ ~ ~ ~ ~ ~ O ~
C ~ ~ ~ ~ ~ ~ ~ ~ O ~
D ~ ~ ~ ~ ~ ~ ~ ~ O ~
E O ~ ~ ~ ~ ~ ~ ~ ~ ~
F O ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ O O O ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ O O O ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Press Enter and pass the move to another player






  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
---------------------
  1 2 3 4 5 6 7 8 9 10
A O O O O O ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ O ~ ~ ~
D ~ ~ ~ ~ ~ ~ O ~ ~ ~
E ~ ~ O O O ~ O ~ ~ ~
F ~ ~ ~ ~ ~ ~ O ~ ~ ~
G ~ ~ O ~ ~ ~ ~ ~ ~ ~
H ~ ~ O ~ ~ ~ ~ ~ ~ ~
I ~ ~ O ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ O O
Player 1, it's your turn:
Take a shot!
A6
  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ M ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
You missed!
Press Enter and pass the move to another player





  1 2 3 4 5 6 7 8 9 10
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
---------------------
  1 2 3 4 5 6 7 8 9 10
A O O O O O M ~ ~ O ~
B ~ ~ ~ ~ ~ ~ ~ ~ O ~
C ~ ~ ~ ~ ~ ~ ~ ~ O ~
D ~ ~ ~ ~ ~ ~ ~ ~ O ~
E O ~ ~ ~ ~ ~ ~ ~ ~ ~
F O ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ O O O ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ O O O ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
Player 2, it's your turn:
Take a shot!
A1
  1 2 3 4 5 6 7 8 9 10
A X ~ ~ ~ ~ ~ ~ ~ ~ ~
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
You hit a ship!
Press Enter and pass the move to another player

...continue until one player has hit all oponents ships
```