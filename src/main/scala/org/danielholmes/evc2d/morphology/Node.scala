package org.danielholmes.evc2d.morphology

/*
jointType determines the constraints on the relative motion
between this part and its parent by defining the number of degrees
of freedom of the joint and the movement allowed for each degree
of freedom.

Joint-limits
determine the point beyond which restoring spring forces will be
exerted for each degree of freedom.

A set of local neurons is also
included in each node, and will be explained further in the next
section
 */

import JointType.JointType
import org.scalactic.anyvals.{PosDouble, PosInt}

case class Node(
  size: Size,
  jointType: JointType,
  jointLimit: PosDouble,
  recursiveLimit: PosInt,
  localNeurons: Set[Any],
  connections: Set[Connection]
)