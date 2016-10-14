# Evolved Virtual Creatures 2D 

Implements Karl Sims' [Evolved Virtual Creatures](http://www.karlsims.com/evolved-virtual-creatures.html) project (in 2D 
instead of 3D)


## Dependencies

 - JDK 1.8+
 - Scala 2.11
 - SBT 0.13.12


## Running Tests

 - All: `sbt test`
 - Individual: `sbt 'test-only org.danielholmes.evc2d.HelloWorldSpec'`
 - Individual Continuous: `sbt ~'test-only org.danielholmes.evc2d.HelloWorldSpec'`


## Running in Development

`sbt ~fastOptJS`

Then access via:

[http://localhost:12345/target/scala-2.11/classes/index-dev.html](http://localhost:12345/target/scala-2.11/classes/index-dev.html)

Edits to the scala source will automatically reload this page


## Production Version

`sbt fullOptJS`


## Notes

 - 50 - 100 generations
 - population of 300
 - survival ratio - 1/5 (number of creatures that breed for next population). Random creatures added if less than 1/5 
   with positive fitness