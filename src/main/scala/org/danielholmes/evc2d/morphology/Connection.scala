package org.danielholmes.evc2d.morphology

/*
  Reflections cause negative scaling, and allow similar
  but symmetrical sub-trees to be described

  A terminal-only flag
  can cause a connection to be applied only when the recursive limit
  is reached, and permits tail or hand-like components to occur at the
  end of chains or repeating units
 */
case class Connection(node: Node, position: Point, orientation: Any, scale: Any, reflection: Any, terminalOnly: Boolean)
