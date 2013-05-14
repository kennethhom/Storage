# Introduction
This repository contains out Android app and will allow us to collaboratively work on it. Below are instructions for getting this set up on your personal machine followed by a brief description of each activity. 

# Instructions
## Prerequisites
In order to follow this tutorial there are a few things you will need to do first. If you have already done one of these steps feel free to skip it and move on to the next step. 

1. Download the [ADT](http://developer.android.com/sdk/index.html) I wrote this tutorial starting from scratch with this version of Eclipse/ADT, you should use this version of Eclipse as it comes with plugins and configurations needed for this tutorial. 
2. Install git. You may already have this on your computer, you can easily confirm this by typing `git` on the command line. If it says "command not found" then you need to install git. You can download the latest version [here](http://git-scm.com/downloads). 
3. Go to [GitHub](https://github.com/) and sign up for an account. If your not familiar with git, you can do this [simple tutorial](http://try.github.io/), it will only take 15 minutes, but will teach you the basics of git. 
4. Configure git with your username and email, instructions can be found [here](https://help.github.com/articles/set-up-git), you can skip the section on password caching. 
5. Generate ssh keys and add them to your GitHub account, a full guide can be found [here](https://help.github.com/articles/generating-ssh-keys).

## Install the Google APIs
1. Open the **Android SDK Manager** from within Eclipse. It's the little green Android with a downwards facing arrow.
2. Place a check by the **Google APIs** and click install software. If you have a phone with an older version of Android be sure to check off the APIs and SDK platform for you version of Android as well.

## Show the Git Tools in Eclipse
1. Back in **Eclipse** go to the menubar and click Window > Show View > Other.
2. Search for **git** in the view that pops up, select all four views and press ok. Your view in Eclipse should now look like the the screenshot.

## Accessing our Repository
1. In the **Git Repositories** view click **Clone a Git repository**.
2. In the view that pops up fill in `git@github.com:avivkiss/WHIP_Scaffold.git` for the URI and select *ssh* as the protocol. Click **next**. Note: If you are getting an auth error then got to the Eclipse preferences and go to the "SSH2" preferences. From there, click "Add Private Key" and add everything in the .ssh folder.
3. Click **Next** on the next screen.
4. On the next screen check off *"Import all existing projects after clone finishes"* and click **Finish**.

## Wrapping up
At this point you should be able to pull down the repository. If you have already sent me your GitHub account name then you will be able to make changes to the repository. Otherwise you will have to fork and submit a pull request and someone who does have access can approve your change. 

If you haven't had a chance to learn git you can do this [simple tutorial](http://try.github.io/).

# Activities
In order to be able to consistently refer to parts of our app I have defined several activities based on our Use Case Diagram. An activity is basically one "screen" on Android that is composed of a view and controller.

## HomeActivity - Home Screen
This is the home screen that displays the option to find a winery or to go to the journal entry list.

## ListActivity - Entry Screen
This is the activity that displays the list of entries. We only need to make one of these, we do not need a separate activity for the drafts, we can just modify this one to show drafts rather than normal entries when that option is selected.

## MapActivity - Map Screen
This is the activity that displays a map and lets the user find a winery.

## EntryActivity - Edit/Display screen
This activity displays an entry. We only need one of these, not three separate ones for draft/new/published. The view will be able to become editable when the edit button is pressed or a new entry is made.
