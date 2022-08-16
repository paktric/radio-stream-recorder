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
- NetBeans IDE / SceneBuilder

### Implementation
The first step in this project was exploring the radio host's website to learn how the audio streaming works. At the top of the website, there is a play/pause button that allows audio to stream through the browser. With Chrome Developer Tools open, I pressed the 'play' button and reviewed the console events. I was able to find the stream URL that was called when the play button event was triggered. Opening this URL in a separate tab reveals a page with a single HTML video element with a type of "audio/mpeg". I found my target URL!

The next step was exploring how to pull that stream data into a Java program. I started with a simple Java file to do some testing in. 

### Challenges
*Explain issues that I ran into during the project and how I solved them*

<br />

# Conclusion
*Explain the conclusion the my project. Did I complete the objective? What did I learn from the project? How would I expand the project in the future?*
