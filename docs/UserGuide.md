# Trackr - User Guide

1. [Introduction](#1-introduction)
2. [Quick Start](#2-quick-start)
3. [Features](#3-features)<br>
   3.1 [Command format](#31-command-format)<br>
   3.2 [View help: `help`](#32-view-help-help)<br>
   3.3 [Add an item: `add`](#33-add-an-item-add)<br>
   ---3.3.1 [Add a module: `addMod`](#331-add-a-module-addmod)<br>
   ---3.3.2 [Add a tutorial group: `addTG`](#332-add-a-tutorial-group-addtg)<br>
   ---3.3.3 [Add a student: `addStudent`](#333-add-a-student-addstudent)<br>
   ---3.3.4 [Add a task: `addTask`](#334-add-a-task-addtask)<br>
   3.4 [List items: `list`](#34-list-items-list)<br>
   3.5 [Filter students: `filter`](#35-filter-students-filter)<br>
   3.6 [Delete an item: `delete`](#36-delete-an-item-delete)<br>
   3.7 [Find an item: `find`](#37-find-an-item-find)<br>
   ---3.7.1 [Find a module: `findMod`](#371-find-a-module-findmod)<br>
   ---3.7.2 [Find a tutorial group: `findTG`](#372-find-a-tutorial-group-findtg)<br>
   ---3.7.3 [Find a student: `findStudent`](#373-find-a-student-findstudent)<br>
   3.8 [Mark a task as done: `done`](#38-mark-a-task-as-done-done)<br>
4. [FAQ](#4-faq)
5. [Command Summary](#5-command-summary)

## 1. Introduction

Trackr is suited for teaching assistants (TAs) who prefer to use a desktop application for managing their student records. It is optimized for Command Line Interface (CLI), while still retaining the benefits of a Graphical User Interface (GUI). If you are a TA with a fast typing speed, Trackr is the app for you. Head over to (Section 2, "Quick Start") and get started!

## 3. Getting Started

### 3.1 Setting Up
Get started by installing __Trackr__ with the following steps:

1. Ensure you have Java 11 or above installed. The latest version of _java_ can be found [here](https://www.java.com/en/download/).
2. Download the latest version of __Trackr__ [here](https://github.com/AY2021S1-CS2103T-W12-2/tp/releases). Look for the file _trackr.jar_.
3. Copy the file to a folder you wish to use as your home folder for __Trackr__
4. Double-click _trackr.jar_ to start the app. The GUI should appear in a few seconds.


### 3.2 Using Trackr
__Trackr__ boasts many useful features to make using the app seamless and smooth. These include
commands to add or delete modules, tutorial groups, or students you are teaching. To use a feature, simply
type the command into the command box (see Figure 1) and press _Enter_ to execute it. Further explanations of 
all the commands are listed below [Section 5]().

![Ui](images/Ui.png)

## 4. Glossary
* __Command Line Interface (CLI)__: An interface that processes commands to a computer program in the form of lines of text.
* __Tutorial Group__: The specific class being taught under a given module.
* __Student__: An individual who is enrolled in a given module.


## 3. Features

### 3.1 Command format

-   Words in UPPER_CASE are the parameters to be supplied by the user.
    e.g. in add n/NAME, NAME is a parameter which can be used as add n/John Doe.
-   Items in square brackets are optional.
    e.g n/NAME [t/TAG] can be used as n/John Doe t/friend or as n/John Doe.
-   Items with …  after them can be used multiple times including zero times.
    e.g. [t/TAG]…  can be used as (i.e. 0 times), t/friend, t/friend t/family etc.
-   Parameters can be in any order.
    e.g. if the command specifies n/NAME p/PHONE_NUMBER, p/PHONE_NUMBER n/NAME is also acceptable.

### 3.2 View help: `help`

Shows a message explaining how to access the user guide.

Format: `help`

### 3.3 Add an item: `add`

Adds an item to the database.

#### 3.3.1 Add a module: `addMod`

Adds a module to the database.

Format: `addMod MODULE_CODE`

Example: `addMod CS2103T`

#### 3.3.2 Add a tutorial group: `addTG`

Adds a tutorial group to the current module in view.

Format: `addTG GROUP_CODE`

Example: `addTG T03`

#### 3.3.3 Add a student: `addStudent`

Adds a student to the current tutorial group in view.

Format: `addStudent n/STUDENT_NAME id/STUDENT_ID`

Example: `addStudent n/John Doe id/A1234567X`

#### 3.3.4 Add a task: `addTask`

Adds a task to the current module in view.

Format: `addTask TASK_NAME`

Example: `addTask grade CS2103T user guides`

### 3.4 List items: `list`

Displays items in the current list in view.

Format: `list`

### 3.5 Filter students: `filter`

Filters students in a module based on certain criteria.

Format: `filter KEYWORD`

List of keywords:

-   `taskNotDone`
-   `trailingBehind`
-   `notParticipating`

Example: `filter taskNotDone`

### 3.6 Delete an item: `delete`

Deletes an item from the database.

Format: `delete INDEX`

Example: `delete 1`

### 3.7 Find an item: `find`

Finds and retrieves an item from the current list in view.

#### 3.7.1 Find a module: `findMod`

Searches for and retrieves a module from within the database.

Format: `findMod MODULE_CODE`

Example: `findMod CS2103T`

#### 3.7.2 Find a tutorial group: `findTG`

Searches for and retrieves a student from within the database.

Format: `findTG GROUP_CODE`

Example: `findTG T03`

#### 3.7.3 Find a student: `findStudent`

Searches for and retrieves a student from within the database.

Format: `findStudent STUDENT_NAME`

Example: `findStudent John Doe`

### 3.8 Mark a task as done: `done`

Marks a task as done upon completion.

Format: `done TASK_NUMBER`

Example: `done 2`

## 5. Command Summary
Action | Format
------------ | -------------
Adding a module | `addMod MODULE_CODE`
Adding a tutorial group | `addTG GROUP_CODE`
Adding a student | `addStudent n/NAME id/STUDENT_ID`
Adding a task | `addTask TASK_NAME`
Listing all tasks | `list`
Filtering students | `filter KEYWORD`
Deleting an item | `delete INDEX`
Finding a module | `findMod MODULE_CODE`
Finding a tutorial group | `findTG GROUP_CODE`
Finding a student | `findStudent n/NAME id/STUDENT_ID`
Marking a reminder as done | `done TASK_NUMBER`

## 7. FAQ
__Q:__ Why did the command I input change colour from white to red? <br> 
__A:__ This happens when the input command is of the wrong syntax or doesn't exist. U may go to the [Command Summary]() to 
view the list of commands and their accepted formats.