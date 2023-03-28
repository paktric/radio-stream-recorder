@ECHO OFF
cd C:\Users\Paktric\Documents\RadioRecordings
javac Recorder.java

REM args[]: hours, minutes, streamURL, saveDir, programName
java Recorder 0 5 https://wxpnhi.xpn.org/xpnhi-nopreroll C:\Users\Paktric\Documents\RadioRecordings\InProgressRecordings\ IndieRockHP

REM move the finished recording to the SavedRecordings folder
move C:\Users\Paktric\Documents\RadioRecordings\InProgressRecordings\* C:\Users\Paktric\Documents\RadioRecordings\SavedRecordings
