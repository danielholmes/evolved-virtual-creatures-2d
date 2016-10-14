package org.danielholmes.evc2d.morphology

object JointType extends Enumeration {
  type JointType = Value
  val Rigid, Revolute, Twist, Universal, BendTwist, TwistBend, Spherical = Value
}
