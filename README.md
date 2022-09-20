# *Radio Stream Recorder*
### Project by **`Patrick Moran`**  <br />  Computer Science Student `&&` Software Developer

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
The idea for this project comes from my brother-in-law, whose recent fatherhood prevents him from staying up late for his favorite radio show.

### Objective
- Create a program that can record live-stream audio from a URL
- Create a GUI that allows the user to customize the time of scheduled recordings

<br />

# Development Process
### Technologies Used
- Java
- NetBeans IDE, SceneBuilder
- GitHub for version control

### Implementation
The first step in this project was exploring the radio host's website to learn how the audio streaming works. At the top of the website, there is a play/pause button that allows the user to listen to the radio station through their browser. With Chrome Developer Tools open, I pressed the 'play' button and reviewed the console events. I was able to find the stream URL that was called when the play button event was triggered. Opening this URL in a separate tab reveals a page with a single HTML video element with a type of "audio/mpeg". I found my target URL!

The next step was figuring out how to pull that stream data into a Java program. I found some sample code on Stack Overflow that showed me how URLConnection, InputStream, and OutputStream could be used to capture audio. I created a simple Java program to test if these classes would work for my application, and after some modification I was able to capture the audio and save it to my computer as an mp3 file.

### Challenges
- When I first got the recording to work, I tried to set the recording length based off Unix time, but the actual output length was always off by a few seconds. I did some research and it seemed like this had to do with the Bit rate of the audio that was recieved, which was 128kbps. I tried making some offsets to no avail. My solution was to use the LocalDateTime class to make target start and end times, instead of using the Unix time in milliseconds.
- 

<br />

# Conclusion
*Explain the conclusion the my project. Did I complete the objective? What did I learn from the project? How would I expand the project in the future?*
