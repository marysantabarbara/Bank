# Bank

To get this project to run, first thing you should do is download this repo into your local computer, then run it on your command prompt if you are using a Windows box. If you do not know how to do so please do the following.

1. Go to this website http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html and download the latest Java development kit.
2. After that install Java onto your computer.
3. Add the Java path to the systems enviornmental variables. Go to this site http://introcs.cs.princeton.edu/java/15inout/windows-cmd.html to figure out how to do that.
4. Open up the commnad prompt.
5. Type "java -version" and enter to make sure you have Java running.
6. Type "javac -version" and enter to make sure you have Java as an environmental variable.
7. Change the directory to the source files. For example type "cd C:\Downloads\Bank-master\src"
8. Type "javac Account.java" and enter
9. Type "javac Bank.java" and enter
10. Note there will be a lot of warnings. I did this all in Eclipse so I had those warnings turned off. They are not errors. It will run fine.
11. Type "java Bank"

Finally, you would have reached the program created. This program will create new instances of accounts every time it runs, so a new account would have to be made every time it runs. Soon I will implement writing accounts to text files so there will be no need for repetition. Despite that, it will handle mismatched data types and will ask for validity at times. Below will be some testing that I have done to test the inputs.

<img src="Testing\creat_menu.png">
<img src="Testing\manag_menu.png">
<img src="Testing\manag_menu2.png">
<img src="Testing\manag_menu3.png">
<img src="Testing\maint_menu.png">
<img src="Testing\exitt_menu.png">
