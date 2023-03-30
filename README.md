# *Radio Stream Recorder*

### Purpose:
This program can be scheduled to record radio shows that are being live-streamed on the internet.

### How to use:
This Java program is designed to be run by a batch file that is triggered with the Windows Task Scheduler. An example batch file is provided and must be altered to work on your machine. There are five parameters when running the Java program:

```
 param  args[0]  Number of hours the program should record for
 param  args[1]  Number of minutes the program should record for
 param  args[2]  Stream URL             eg. "https://wxpnhi.xpn.org/xpnhi-nopreroll"
 param  args[3]  Save directory         eg. "C:/Users/Paktric/Desktop/"
 param  args[4]  Radio program name     eg. "IndieRockHP"
```

After crafting the batch file, create a new Windows Task Scheduler task to trigger the recording. 

### Tips:
- Make sure to allow wake timers in your power settings and set the task to wake the computer if you have sleep settings.
- You can use a program like Google Drive Desktop to sync the SavedRecordings output folder to the cloud
