package org.danielholmes.evc2d.test.matter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
trait Vector extends js.Object {
  var x: Double
  var y: Double
}

@js.native
@JSName("Matter.Vector")
object Vector extends js.Object {
  def create(x: Double, y: Double): Vector = js.native
}

@js.native
@JSName("Matter.Body")
object Body extends js.Object {
  def applyForce(body: Body, position: Vector, force: Vector): Unit = js.native
  def setAngle(body: Body, angle: Number): Unit = js.native
  def rotate(body: Body, angle: Number): Unit = js.native
}

@js.native
trait Body extends js.Object {
  var angle: Double
  var vertices: js.Array[Vector]
}

@js.native
@JSName("Matter.Bodies")
object Bodies extends js.Object {
  def rectangle(x: Int, y: Int, width: Int, height: Int, options: js.Dictionary[js.Any] = js.Dictionary.empty): Body = js.native
}

@js.native
trait Constraint extends Composite

@js.native
@JSName("Matter.Constraint")
object Constraint extends js.Object {
  def create(options: js.Dictionary[js.Any] = js.Dictionary.empty): Constraint = js.native
}

@js.native
trait Composite extends js.Object

@js.native
trait World extends Composite

@js.native
@JSName("Matter.World")
object World extends js.Object {
  def create(options: js.Dictionary[js.Any] = js.Dictionary.empty): World = js.native
  def add(world: World, bodies: js.Array[Body]): Unit = js.native
}

@js.native
trait Engine extends js.Object {
  val world: World = js.native
}
@js.native
@JSName("Matter.Engine")
object Engine extends js.Object {
  def create(options: js.Dictionary[js.Any] = js.Dictionary.empty): Engine = js.native

  def run(engine: Engine): Unit = js.native
}

@js.native
trait Render extends js.Object
@js.native
@JSName("Matter.Render")
object Render extends js.Object {
  def create(options: js.Dictionary[js.Any]): Render = js.native
  def run(engine: Render): Unit = js.native
}
