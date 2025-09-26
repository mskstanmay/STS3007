
# Maze Solving (Pathfinding in a Binary Matrix)

> Note: This topic is relevant for MCQs in FAT, not for CAT/coding questions.

## Problem Statement
Given a 2D matrix (maze) consisting of 0s and 1s:
- 1 represents an open cell (path)
- 0 represents a blocked cell (wall)

Find a path from the top-left corner (start) to the bottom-right corner (end) by moving only through cells with value 1. You can only move **down** or **right** at each step.

## Approach
1. Start at the top-left cell (0,0).
2. At each step:
	 - If the cell below (down) is 1 and within bounds, move down.
	 - Else if the cell to the right is 1 and within bounds, move right.
	 - Else, backtrack to the previous cell and try the next possible direction.
3. Continue until you reach the bottom-right cell (n-1, m-1) or determine that no path exists.

This is a classic backtracking problem. The algorithm explores all possible paths using recursion or a stack, marking visited cells to avoid cycles.

## Sample Input
```
maze = [
	[1, 0, 1, 1],
	[1, 1, 1, 0],
	[0, 1, 0, 1],
	[1, 1, 1, 1]
]
```

## Sample Output
```
Path exists: YES
One possible path: (0,0) → (1,0) → (1,1) → (1,2) → (2,1) → (3,1) → (3,2) → (3,3)
```

## Notes
- If there are multiple paths, any valid path can be returned.
- If no path exists, output should indicate so (e.g., `Path exists: NO`).
- This problem is often solved using DFS (Depth-First Search) with backtracking.
