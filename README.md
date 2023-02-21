# *Radio Stream Recorder*
### Project by **`Patrick Moran`**

<table>
    <tr>
        <td><a href="http://www.paktric.com/">paktric.com</a></td>
        <td><a href="https://www.github.com/paktric/">github.com/paktric</a></td>
        <td><a href="https://www.linkedin.com/in/paktric/">linkedin.com/in/paktric/</a></td>
    </tr>
</table>

---

<br />

# Project Overview
### Motivation
The idea for this project comes from my brother-in-law, whose recent fatherhood prevents him from staying up late for his favorite radio show. The goal is to create a program that can be scheduled to record radio shows that are being live-streamed on the internet.

### Objective
- Create a program that can record live-stream audio from a URL
- Create a GUI that allows the user to customize the time of scheduled recordings

<br />

# Development Process
### Technologies Used
- Java
- GitHub for version control

### Implementation
The first step in this project was exploring the radio host's website to learn how the audio streaming works. At the top of the website, there is a play/pause button that allows the user to listen to the radio station through their browser. With Chrome Developer Tools open, I pressed the 'play' button and reviewed the console events. I was able to find the stream URL that was called when the play button event was triggered. Opening this URL in a separate tab reveals a page with a single HTML video element with a type of "audio/mpeg". I found my target URL!

The next step was figuring out how to pull that stream data into a Java program. I found some sample code on Stack Overflow that showed me how URLConnection, InputStream, and OutputStream could be used to capture audio. I created a simple Java program to test if these classes would work for my application, and after some modification I was able to capture the audio and save it to my computer as an mp3 file.

The remaining part of the project is still a work in progress, which is creating a graphical user interface.

### Challenges
- The first challenge for me was learning about streaming data. This was a new concept for me and it took a while to understand the sample code.
- Another big challenge for me was finding a way to schedule the recordings. Right now, this can be done with cron jobs or Windows task scheduler. I'm currently working on a version of this project which uses [Quartz Scheduler](http://www.quartz-scheduler.org/) so I can manage the recording jobs in the Java program itself.

<br />

# Conclusion
I was able to achieve the first objective of recording the live-stream audio. I'm still working on the second objective of creating a user-friendly GUI. At the moment, this program works best when used as a cron job or with Windows task scheduler. Stay tuned for updates on the GUI!
