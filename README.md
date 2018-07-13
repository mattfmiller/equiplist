# Equiplist

#### An API that allows users to track a personal collection of musical gear. (_This is an Epicodus exercise that is a work in progress_)

#### By _**Matt Miller**_

## Description

This application will allow users to add and update gear to a personal collection

#### User Story

A. As a user, I want to see all guitars in the collection (unfinished) <br>
B. As a user, I want to see one individual guitar (unfinished)<br>
C. As a user, I want to see specific information such as the guitar's make, model, finish, etc... (unfinished)<br>
D. As a user, I want to see which guitar type a single guitar is associated with (unfinished)<br>
E. As a user, I want to see all guitars of a specific guitar type (i.e. acoustic or lap steel) so I can browse through them (unfinished)<br>
F. As a user, I want to be able to leave a note on a guitar (unfinished)<br>
G. As a user, I want to see all notes for a guitar (unfinished)<br>
H. As a user, I want to see all instrument types (finished)<br>
I. As a user, I want to see all instruments of a specific instrument type (i.e. guitar or amp) so I can browse through them (finished)<br>
J. As an admin, I want to be able to add a guitar to the database (finished)<br>
K. As an admin, I want to edit guitar details when they change (unfinished)<br>
L. As an admin, I want to delete notes that are no longer relevant (unfinished)<br>
M. As an admin, I want to add a guitar type so a guitar can be associated with it (unfinished)<br>
N. As an admin, I want to add an Instrument Type so an Instrument can be associated with it (finished)<br>Â

## Data relationship
![alt tag](screenshots/data.png "Data Model")

## Setup/Installation Requirements

* View program by cloning repository from https://github.com/mattfmiller/jadle
* Open project in IDE such as IntelliJ IDEA
* Run App.java to compile the program
* Use a program such as postman to create API requests to localhost:4567
  * Add an instrument type `post:` `/instrumentTypes/new`
    * As JSON of the format: <br>
    `"name": "{user_input}"`
  * Get all instrument types: `get:` `/instrumentTypes`
  * Get specific instrument type: `get:` `/instrumentTypes/{instrumentType_id}`
  * Add a guitar: `post:` `/guitars/new`
    * As JSON of the format: <br>
    `"manufacturer": "{user_input}"`<br>
    `"model": "{user_input}"`<br>
	`"country": "{user_input}"`<br>
	`"serialNumber": "{user_input}"`<br>
	`"imageUrl": "{user_input}"`<br>
	`"instrumentTypeId": "{user_input}"`<br>
	`"current": "{user_input}"`<br>
	`"wishlist": "{user_input}"`<br>
	`"weight": "{user_input}"`<br>
	`"bodyWood": "{user_input}"`<br>
	`"finish": "{user_input}"`<br>
	`"color": "{user_input}"`<br>
	`"binding": "{user_input}"`<br>
	`"neckWood": "{user_input}"`<br>
	`"neckType": "{user_input}"`<br>
	`"neckProfile": "{user_input}"`<br>
	`"fretboardWood": "{user_input}"`<br>
	`"fretboardRadius": "{user_input}"`<br>
	`"frets": "{user_input}"`<br>
	`"fretMaterial": "{user_input}"`<br>
	`"inlays": "{user_input}"`<br>
	`"nutMaterial": "{user_input}"`<br>
	`"nutWidth": "{user_input}"`<br>
	`"scaleLength": "{user_input}"`<br>
	`"neckPickup": "{user_input}"`<br>
	`"middlePickup": "{user_input}"`<br>
	`"bridgePickup": "{user_input}"`<br>
	`"volumePots": "{user_input}"`<br>
	`"tonePots": "{user_input}"`<br>
	`"capacitor": "{user_input}"`<br>
	`"tuners": "{user_input}"`<br>
	`"tunerButtons": "{user_input}"`<br>
	`"bridge": "{user_input}"`<br>
	`"tailpiece": "{user_input}"`<br>
	`"guitarSwitch": "{user_input}"`<br>
	`"knobs": "{user_input}"`<br>
	`"pickguard": "{user_input}"`<br>
	`"controls": "{user_input}"`<br>
	`"guitarCase":"{user_input}"`

## Known Bugs

* N/A

## Support and contact details

For support, contact: matt.f.miller@live.com

## Technologies Used

* Java
* Spark
* SQL Database
* H2

### License

This software is licensed under the GPL license.

Copyright © 2018 **Matt Miller**
