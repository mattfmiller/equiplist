# Equiplist

#### An API that allows users to track a personal collection of musical gear. (_This is an Epicodus exercise that is a work in progress_)

#### By _**Matt Miller**_

## Description

This application will allow users to add and update gear to a personal collection

#### User Story

A. As a user, I want to see all instruments in the collection <br>
B. As a user, I want to see all guitars in the collection <br>
C. As a user, I want to see all amps in the collection <br>
D. As a user, I want to see all pedals in the collection <br>
E. As a user, I want to see specific information about a single guitar<br>
F. As a user, I want to see specific information about a single amp<br>
G. As a user, I want to see specific information about a single pedal<br>
H. As a user, I want to be able to add a guitar to the database<br>
I. As a user, I want to be able to add an amp to the database<br>
J. As a user, I want to be able to add a pedal to the database<br>
K. As a user, I want to see which guitar type(s) a single guitar is associated with<br>
L. As a user, I want to be able to add a guitar type to a guitar<br>
M. As a user, I want to see all guitars of a specific guitar type<br>
N. As a user, I want to be able to add a note on an instrument<br>
O. As a user, I want to see all notes for an instrument<br>
P. As a user, I want to edit instrument details when they change<br>
Q. As a user, I want to delete instruments when they are no longer in my collection or wantlist.
R. As a user, I want to delete notes that are no longer relevant<br>
S. As a user, I want to delete a guitar type association in case of error<br>


## Data relationship
![alt tag](screenshots/data.png "Data Model")

## Setup/Installation Requirements

* View program by cloning repository from https://github.com/mattfmiller/jadle
* Open project in IDE such as IntelliJ IDEA
* Run App.java to compile the program
* Use a program such as postman to create API requests to localhost:4567
  * Get all guitars: `get:` `/guitars`
  * Get specific guitar: `get:` `/guitars/{guitar_id}`
  * Add a guitar: `post:` `/guitars/new`
    * As JSON of the format: <br>
    `"manufacturer": "{user_input}"`<br>
    `"model": "{user_input}"`<br>
	  `"country": "{user_input}"`<br>
	  `"serialNumber": "{user_input}"`<br>
    `"year": "{user_input}"`<br>
    `"weight": "{user_input}"`<br>
	  `"imageUrl": "{user_input}"`<br>
	  `"instrumentTypeId": "{user_input}"`<br>
	  `"current": "{user_input}"`<br>
	  `"wishlist": "{user_input}"`<br>
	  `"paid": "{user_input}"`<br>
    `"sold": "{user_input}"`<br>
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
