# Halve a Compound Shape

A compound shape is defined as a shape made up of multiple simple convex polygons.

Given a compound shape, return a new compound shape that has half the area of the original by halving
each component polygon. 

The intersecting edges between all component polygons must be preserved.

## Clarifying Questions

### Possible inputs and valid shapes

- Is every input solvable?
  - No, the code should handle this and return an error to the caller. 
- Can a component polygon be completely surrounded by other polygons?
  - No, this would not allow the intersecting edges to be preserved.
- Can the input compound shape be empty or contain only one component polygon?
  - Yes
- Can there be intersecting component polygons?
  - The input may have this condition, but it is not valid and an error should be returned. However,
    this can be ignored in a time-constrained interview.
- Can the compound shape have holes?
  - Yes, but consider if it matters for the algorithm, or maybe you don't need to worry about it.

### Output shape

- Should the output compound shape maintain the same number of component polygons as the original?
  - Yes
- Can a component polygon have extra points added/removed?
  - Yes, whatever is needed to halve the area of the original.
- Is it always possible to halve the area of a component polygon?
  - It may not always be possible to halve the area while keeping it as a convex polygon. You may add
    extra points that violate this rule in the output if needed.
- Does the output need to be stable (the same output for the same input)?
  - No, there are many possible outputs and no requirement to be stable.

### Programming Details

- How to handle floating point precision?
  - Use a reasonable allowable delta to consider numbers equal, such as 0.01 
