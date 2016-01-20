(a) Your name and student ID number
Javeria Mohammed Nasir and A20353791

(b) Answers to the following questions:

i. How do you run your program (i.e. what is the command line)?

The project run with two scenarios:
If player wish to give the dice value then the project accepts the command line argument : -dice
but if the player wants to just play the game then wihtout arguments also is fine.
So please put -dice as command argument if u want to run the program and wish to enter die values.
Else emplty the command line the project runs fine.

ii. Describe your object-oriented design for the program:
This MP uses object oriented concepts like  inhertence, polymorphism, encapsulation,Arraylist,Hashmap ie collections and a small use of thread.sleep().

A. How are you implemeting the game board?
The board game has multiple classes divivded based on the functionaliy of that class.It has main class and the test class.

B. How are you implementing the spaces and the types of spaces?
This board game has totally 40 spaces counting from 0(zero) postion.All the spaces value and there crdit values are stored in arraylist and its credit vlaues are retrieved using hashmap.

C. How are you implementing the Chance and Community Chest cards?
Chance and community are two different classes. These classes have some card values which are stored in arraylist and from these cards user need to pick any random card.The random cards are picked using arraylist random generator.Based on the index of the the creidt value is picked form the hashmap.

What specific problems or challenges did you have implementing your solution? For example,
was there a particular requirement that you had difficulty implementing? Or perhaps
there was a particularly nasty bug in your implementation you had problems tracking down.
Initially it was little difficutly to start off the project as had loads of things running in mind like what type to be sued to store values of squares/spaces and retrieve the vlaues and how to implement a object oriented programming cocepts.

iv. Were there any requirements that were not implemented or not implemented properly in
your solution? If so, please elaborate.
All the requirments are implemented and tested throughly.

v. Were there any requirements that were vague or open to interpretation that you had to make
a decision on how to implement? How did you elect to interpret them?
little thought process requirment was to move around the board.Keep track of the current players location and specially in case of chance card when we have move three spaces back scenario.
This time the test case format was different unlike the previous MP.It was firt time i wrote given-when-then unit test case.It was really good to implement that.

vi. How would you rate the complexity of this MP on a scale of 1 to 10 where 1 is very easy
and 10 is very difficult. Why did you give this rating?
This MP was cool,good and I could learn lot from this MP.It was 9/10.I enjoyed develpoing this MP comapred to the first one.