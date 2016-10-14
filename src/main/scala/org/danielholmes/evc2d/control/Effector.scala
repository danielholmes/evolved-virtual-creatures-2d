package org.danielholmes.evc2d.control

// connection to sensor or neuron
/*
Each effector is given a maximum-strength proportional to the
maximum cross sectional area of the two parts it joins. Effector
forces are scaled by these strengths and not permitted to exceed
them. Since strength scales with area, but mass scales with volume,
as in nature, behavior does not always scale uniformly.
 */
class Effector(connection: Any, weight: Double)
