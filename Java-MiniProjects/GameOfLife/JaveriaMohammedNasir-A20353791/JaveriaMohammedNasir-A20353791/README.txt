(a)Javeria Mohammed Nasir 
   A20353791
(b)
(i) Give a general description of your implementation.
Ans: The initail file is used to determine future generation of player 1 & player 2 movement.
Considering the requirement this assignment the initial has matrix information & current player cell existence.
The first line is treated as meta data to validate the matrix. Once this validation is done.
Each row is read as row of string. But each element of the row can be ready using charAt[i] option.
This help in knowing position of the element. Once this determined while traversing the array, its neighbours are determined.
Cell movement is done based if any player existing above, below, left & right.  

A. How did you decide to store the grid (i.e. what data type for the grid, what data type for
the cells)?
Ans:The Data type used for the grid is String[] and the datatype used for cells is char.

B.Walk through the methods called during the generation of a new state.
Ans:

Pseudo for spawning or living si :
int neighbors = getNeighbors(above, same, below);
if (neighbors < 2 || neighbors > 3) 
		neighbors -> die
else if (neighbors == 3)
		neighbors -> spawn/live
else if (neighbors == 3)
		3 neighbors -> spawn/live
else
		2 neighbors -> stay

(ii) What specific problems or challenges did you have implementing your solution? For example,
was there a particular requirement that you had difficulty implementing? Or perhaps
there was a particularly nasty bug in your implementation you had problems tracking down.

Ans: Inital implementation i started with one player was easy. But developing the game for two player was challeging for me.
Also it was need for tracking the variable closing, there was often need to run program in java debug mode to check the watch expression of different value getting stored in array or counter.

(iii) Were there any requirements that were not implemented or not implemented properly in
your solution? If so, please elaborate.
Ans: Shutdown hook isnt implement in this program, the program was not getting encapsulated within program.
Plus shortage of time. Other assignment were due on the same day & career fair as well.
Given more time this can be implemented.

(iv) Were there any requirements that were vague or open to interpretation that you had to make
a decision on how to implement? How did you elect to interpret them?
Ans: No the requirement was pretty much clear. Assignment had more focus on solve the puzzle or finding algorithm.

(v) How would you rate the complexity of this MP on a scale of 1 to 10 where 1 is very easy
and 10 is very difficult. Why did you give this rating?
Ans: 5. Since i have more of .Net experience getting on quick pace with java concept was little plus time constrait.
As well the assignment submission conflicts. Hoping to get java assignment which focus more java concepts and less on algorithms.