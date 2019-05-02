# mcp-individual-assignment
Multi-Story Car Park individual assignment, counted for 50% as a first year second semester project for the Java CC12320 Module.

This project was written with basic Java knowledge with background in other languages so it's likely a lot of it can be improved.
It did not require a lot of features included, including the ui but these give extra marks so was great to include.


todo:
-> remove duplicate code :
   -both receipt and user have vehicleRegistration and vehicleType, this is completely un needed so can be removed
->add remaining features in terms of users parking their own car, fetching their own car
->add a way to generate some directions for users when they are a given a zone and space to go park..
->add a way to time if they spend over 15 minutes leaving the car park after paying (doesn't let them leave and seekAssistance will be called
->add how we monitor if a user has paid and is leaving
-> use a cmd line menu to test every feature then if time is giving add a interface to do this
-> add more config file options maybe? could we store zones, attendants in a file and also even cars that are parked so when we next load we could use our previous version of the car park?
-> add the roam feature for attendants properly?
-> display the state of the car park -> spaces, in what zones, attendants,
-> make sure we dont always use the same attendant when using the attendant pool (randomly choose from the available ones)
-> write up the report and everything that includes