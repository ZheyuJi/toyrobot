# toyrobot

How to run this through terminal:
1. download the zip file and unzip it, or clone the project.
2. in the terminal, change directory to the folder that contains the java file and jar file.
3. compile java files using command: __javac -cp \* *.java__
4. run junit test using command: __java -jar junit-platform-console-standalone-1.5.0.jar --class-path='.'  --scan-classpath__
5. run program:
    5a. edit the input.txt to your desired input
    5b. run program using command: __java RobotMove < input.txt__
