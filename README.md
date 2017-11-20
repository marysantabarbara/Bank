# Assignment 2
### ICS 355
#### Mary Santabarbara

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

It will look very similar to below but not exactly since this was a picture from the last version.
<img src="Testing\creat_menu.PNG">

#### The Program
A new log in implementation has been added. 
  To log in to the adminisitrator
  - Log in to the user "peachy"
  - The password is "password"
Administrators can create and remove users, while regular users can add, withdraw, see, and transfer their balance. 

However, I was able to test the salted passwords. There are two users in the bank system, mbro and lbro, they both have the same passwords but the logged password is different in the database. The output of the prompt is pasted below, while you can look into the accountsList.txt in the src folder to check the logged passwords.


******************************************************
		Welcome to MS Bank
******************************************************
Please login by typing your username then press enter
	 or type exit and enter to exit
******************************************************

>peachy

******************************************************
		Welcome peachy
******************************************************
	Type your password

******************************************************

>password


******************************************************
			MAIN MENU
******************************************************
Please type menu item in ALL CAPS then press enter.

	CREAT 		To Add an Account
	REM 		To Remove an Account
	EXIT 		To Exit this prompt 

******************************************************

>creat
What is the first name?
>Mario
What is the last name?
>Brother
Is the name writen below correct?
Mario Brother

 Enter Y for Yes or N for No
>y
Please set the username
>mbro
Is the username writen below correct?
mbro

 Enter Y for Yes or N for No
>y
Please type the password
>password
Please re-type the password
>password
Successfully created an account.

Press enter to continue.


******************************************************
			MAIN MENU
******************************************************
Please type menu item in ALL CAPS then press enter.

	CREAT 		To Add an Account
	REM 		To Remove an Account
	EXIT 		To Exit this prompt 

******************************************************

>creat
What is the first name?
>Luigi
What is the last name?
>Brother
Is the name writen below correct?
Luigi Brother

 Enter Y for Yes or N for No
>y
Please set the username
>lbro
Is the username writen below correct?
lbro

 Enter Y for Yes or N for No
>y
Please type the password
>password
Please re-type the password
>password
Successfully created an account.

Press enter to continue.


******************************************************
			MAIN MENU
******************************************************
Please type menu item in ALL CAPS then press enter.

	CREAT 		To Add an Account
	REM 		To Remove an Account
	EXIT 		To Exit this prompt 

******************************************************

>exit

Good bye!


