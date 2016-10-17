package org.danielholmes.evc2d.test

import org.danielholmes.evc2d.test.matter._
import org.scalajs.dom.html.{Body => HTMLBody}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.Dynamic.global
import scala.scalajs.js.timers

@JSExport
object MatterJsTest {
  @JSExport
  def main(htmlBody: HTMLBody): Unit = {
    // create two boxes and a ground
    val ground = Bodies.rectangle(400, 600, 600, 50, js.Dictionary("isStatic" -> true))

    // Joined
    val leftLeg = Bodies.rectangle(500, 550, 50, 50)
    val body = Bodies.rectangle(560, 524, 50, 50, js.Dictionary("angle" -> Math.PI / 4))
    val rightLeg = Bodies.rectangle(620, 550, 50, 50)
    val leftHip = Constraint.create(js.Dictionary(
      "bodyA" -> leftLeg,
      "pointA" -> js.Dictionary("x" -> 25, "y" -> -25),
      "bodyB" -> body,
      "pointB" -> js.Dictionary("x" -> -35, "y" -> 0),
      "stiffness" -> 1
    ))
    val rightHip = Constraint.create(js.Dictionary(
      "bodyA" -> rightLeg,
      "pointA" -> js.Dictionary("x" -> -25, "y" -> -25),
      "bodyB" -> body,
      "pointB" -> js.Dictionary("x" -> 35, "y" -> 0),
      "stiffness" -> 1
    ))

    // Create a world
    val world = World.create(js.Dictionary(
      "bodies" -> js.Array(
        leftLeg,
        body,
        rightLeg,
        ground
      ),
      "constraints" -> js.Array(leftHip, rightHip),
      "bounds" -> js.Dictionary(
        "min" -> js.Dictionary("x" -> 0, "y" -> 0),
        "max" -> js.Dictionary("x" -> 800, "y" -> 650)
      ),
      "gravity" -> js.Dictionary(
        "scale" -> 0.001,
        "x" -> 0,
        "y" -> 1
      )
    ))

    // create an engine
    val engine = Engine.create(js.Dictionary(
      "world" -> world
    ))

    // create a renderer
    val render = Render.create(js.Dictionary(
      "element" -> htmlBody,
      "engine" -> engine
    ))

    // run the engine
    Engine.run(engine)

    // run the renderer
    Render.run(render)

    val walkStep = 1000
    timers.setTimeout(walkStep / 2) {
      timers.setInterval(walkStep) {
        Body.applyForce(rightLeg, Vector.create(0, 0), Vector.create(0, 0.005))
      }
    }
    timers.setInterval(walkStep) {
      Body.applyForce(leftLeg, Vector.create(0, 0), Vector.create(0, 0.005))
    }
  }
}
