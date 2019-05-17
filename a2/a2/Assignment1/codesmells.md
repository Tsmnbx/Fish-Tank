# Markdown

Markdown is a plain-text file format. There are lots of programming tools that use Markdown, and it's useful and
easy to learn. Hash marks (the number sign) indicate headers. Asterisks indicate lists.

# List of code smells

## Code Smell 1: [Large Class]

### Code Smell Category: [Bloater]

### List of classes and line numbers involved:

* [Write a class and list of line numbers, one class per asterisk, that describe the smell]
* FishTank lines 32 to 59

### Description:

[In your own words, explain how the description of the code smell applies to this particular code.]
This class has two diffrent fuctions. The first part creates the list and populates this list with fish, hungry fish and seawead objects. This fuction is achecived by lines 32 to 59 of the code. The second part of the fish tank runs the simlation of the fish in the tank. Having these two features in the same class instead of creating a new class for one of these features, makes the FishTank class to big. 

### Solution:

[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
To fix this code I would take the first feature, which is comprised of lines 32 to 59 and put them into a seprate class in charge of populating the tank.

### Explanation

[How does your solution get rid of the code smell? Write your explanation here.]
This gets rid of the code smell by reducing the size of the FishTank class and spliting up the functions of FishTank.

============================================================

## Code Smell 2: [Duplicate Code]

### Code Smell Category: [Dispensables]

### List of classes and line numbers involved:

* [Write a class and list of line numbers, one class per asterisk, that describe the smell]
*  Bubbles:lines 88-96, lines 106-114, and lines 124-133 
 

### Description:

[In your own words, explain how the description of the code smell applies to this particular code.]
This code is the same function in different methods and is the result of simply copying and pasting these lines into the floatStraightUp, floatLeftUp and floatRightUp methods. In this case the bubble is simply changing its apperance ad is taking up space in the Code.

### Solution:

[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
To fix this code you would delete the code in lines 88-96, lines 106-114, and lines 124-133 and create a new public void method above the floatStraightUp method that we can call sizeChange. In here we will place the code we found in the previously mentioned lines. The method will start with d = Math.random(); and end with the else if statement found in the previously metioned lines. We will then place a call to the sizeChange in the floatStraightUp, floatLeftUp and floatRightUp methods. 

### Explanation

[How does your solution get rid of the code smell? Write your explanation here.]
This solution takes the repeated code and places it in one place, a new method and the replaces the duplicate code in the methods I remved it from with a call of this new method. this removes unesscary code and there is only one copy of the code, the new method. 

============================================================

## Code Smell 3: [Shotgun Surgery]

### Code Smell Category: [Change Preventers]

### List of classes and line numbers involved:

* [Write a class and list of line numbers, one class per asterisk, that describe the smell]
* FishFrame: Lines 29-30
* FishTank: Lines 10,12,15,70,71

### Description:

[In your own words, explain how the description of the code smell applies to this particular code.]
THese values are related to eahc other, they control the size of the frame and values of the myLittleFishies Array and how large it can be. Since they are all primative types and not stored in on varaible, changing one of these will rewuire you to go and change of of the other values where the 480/10 and 640/6 show up. A change in one of these forces you to change a lot of other information in two classes, which is the description of shotgun surgery. 

### Solution:

[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
TO fix this, simple create a two new public static variables in FishTank called frameHeight and frameWidth. These variables will be int primatives and will take the values 480 and 640 respectively. Then in all the places you see a (480/10) and (640/6), you will replace these values with (frameHeight/charHeight) and (frameWidth/charWidth) so lines 15,70,71 in the FishTank class and lines 29 and 30 in the FishFrame class. in addition any place with the values 480 and 640 should be replaced with the either frameWidth if its 640 or frameHeight if its 480, this change will be applied to line 62.

### Explanation

[How does your solution get rid of the code smell? Write your explanation here.] THis solution fixes the probmlem becuase now if you want to make chnages to the height or width, the values were they same numbers have to be altered as well because they are the same are automticaly changed since it is replaced with a variable instead of having seprte numbers all over the place. This makes the code much easier to change in the future.

============================================================

## Code Smell 4: [Comments]

### Code Smell Category: [Dispensables]

### List of classes and line numbers involved:

* [Write a class and list of line numbers, one class per asterisk, that describe the smell]
* Fish: Lines 141-154
* HungeryFish: Lines 141-154

### Description:

[In your own words, explain how the description of the code smell applies to this particular code.]
The method(its in the same area and does the same thing in both classes, see the next smell for details on how to fix that) is too long and does two seprate things. The first part of the method (lines 135-139) move the fish up and down. The next part (lines 141 - 144) creates bubbles, the third (lines 146-149) part turns the fish around and the last part(lines 151 - 159) moves the fish up and down. These are seprate features and make the method hard to understand intitively which is why there are so many comments.Comment smells often mean the code itself could be improved and there is often an underlying smell, in this case the method itself is too long.

### Solution:

[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
Create four new public void methods in both the Fish class and the HungryFish class. The first method wil be called "leftRight" and will take all the code from lines 135-139, the second method will be called "bubbleCreate" and will take all the code from lines 141-144. The third method will be called "turn" which will be code from lines 146-149. The last method will be called "upDown" and will take the code from lines 151-159. Finally replace the entire code in the move method with function calls to leftRight,bubbleCreate,turn and upDown. 

### Explanation

[How does your solution get rid of the code smell? Write your explanation here.] This way the code is intutive, therefore the comments are not needed because the best comments are good method and class names. Here we have given the various features of the move method their own method, with apporprate names and placed them in move, removing the underlying smell that caused the comments to be needed in the first place. This means the comments were removed and the code is more intutive thus fixing the smell.

============================================================

## Code Smell 5: [Duplicate Code]

### Code Smell Category: [Dispensables]

### List of classes and line numbers involved:

* [Write a class and list of line numbers, one class per asterisk, that describe the smell]
* HungryFish: Line 1 to Line 163
* Fish: Line 1 to Line 158

### Description:

[In your own words, explain how the description of the code smell applies to this particular code.]
Both the Fish and the HungryFish are almost the exact same code. Only HungryFish's Constructor and reverseAppearance method are different in terms of implementation. 

### Solution:

[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
One could either remove the HungryFish class all together and make it a different implamentation of Fish or you could keep the HungryFish class and make it a subclass of Fish. In the second solution, you would delete all of the methods except for the reverseAppearance, which will be overriden in HungryFish. Also in Line 7 you would write "public class HungryFish extends Fish". This way you can keep the HungryFish method without having to change FishTank or any other place HungryFish shows up, which would make make this shotgun surgery. Or if you want to make HungryFish a more differnet in the future there is no need to have to recreate the class HungryFish.

### Explanation

[How does your solution get rid of the code smell? Write your explanation here.] This gets ride of the smell by removing all the unnecessary code in HungryFish when it could simply inherit everything it needs from Fish and override when needed. The duplicated code is gone and the smell is fixed.

============================================================
