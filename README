# Introduction
This repository contains header files for an *Entry* and *Journal* class. Both classes contain extensive comments explaining how they function in addition to outlining how they fit in to the overall application. Briefly, each entry that the user enters will be represented by an Entry object. The Journal class will be a [singleton class](https://en.wikipedia.org/wiki/Singleton_pattern) that is capable of manipulating and retrieving objects from out underlying data store. More details are given in the header file.

Nothing is set in stone and everything is open for suggestions and may change as we develop our app. I have also included suggestions for the way we should name our activities in addition to briefly describing what each one is responsible for. This should give us a common framework that we can use do describe out application for the Design Use Cases. Please feel free to submit a pull request with any changes you feel should be made.

# Activities
In order to be able to refer to parts of our apps I have defined several activities bellow based on our Use Case Diagram. An activity is basically one "screen" on Android that is composed of a view and controller.

## HomeActivity - Home Screen
This is the home screen that displays the option to find a winery or to go to the journal entry list.

## ListActivity - Entry Screen
This is the activity that displays the list of entries. We only need to make one of these, we do not need a separate activity for the drafts, we can just modify this one to show drafts rather than normal entries when that option is selected.

## MapActivity - Map Screen
This is the activity that displays a map and lets the user find a winery.

## EntryActivity - Edit/Display screen
This activity displays an entry. We only need one of these, not three separate ones for draft/new/published. The view will be able to become editable when the edit button is pressed or a new entry is made.