# Design and Analysis of Algorithms

This repository contains Java implementations of fundamental algorithms demonstrating core techniques in dynamic programming, greedy strategies, and graph theory. Each algorithm is implemented with detailed explanations and test cases to aid understanding and practical application.

## Contents

- Longest Increasing Subsequence (LIS)
- Longest Divisible Subset
- Multistage Graph Algorithm
- Minimum Path Sum in a Grid (Dynamic Programming and Greedy approaches)

## Algorithm Details

### Longest Increasing Subsequence (LIS)

- **Problem:** Find the longest subsequence in an array where the elements are strictly increasing in order.
- **Approach:** Dynamic programming with \(O(n^2)\) time complexity.
- **Output:** Length and actual subsequence.

### Longest Divisible Subset

- **Problem:** Find the largest subset such that for every pair \(a, b\), either \(a \% b = 0\) or \(b \% a = 0\).
- **Approach:** Dynamic programming, subset order doesn't matter.
- **Output:** Length and actual subset.

### Multistage Graph Algorithm

- **Problem:** Given a directed graph partitioned into stages, find the minimum-cost path from the source vertex to the destination vertex.
- **Approach:** Dynamic programming with adjacency matrix representation.
- **Output:** Minimum cost and the path.

### Minimum Path Sum in a Grid

- **Problem:** Find the path from the top-left to bottom-right corner of a grid with minimal sum, moving only right or down.
- **Approaches:**
  - Dynamic Programming (guarantees optimal solution).
  - Greedy Algorithm (chooses locally minimal step; may be non-optimal).
- **Output:** Path and sum for both algorithms, with comparative analysis.

## Real-World Applications

| Algorithm                 | Applications                              |
|---------------------------|------------------------------------------|
| Longest Increasing Subsequence | Stock analysis, bioinformatics, sequence alignment |
| Longest Divisible Subset     | Cryptography, data clustering           |
| Multistage Graph Algorithm   | Project scheduling, network routing     |
| Minimum Path Sum in a Grid   | Robotics pathfinding, minimal cost routing|

## Analysis

| Algorithm                 | Time Complexity | Space Complexity       |
|---------------------------|-----------------|-----------------------|
| Longest Increasing Subsequence | \(O(n^2)\)     | \(O(n)\)               |
| Longest Divisible Subset     | \(O(n^2)\)     | \(O(n)\)               |
| Multistage Graph Algorithm   | \(O(n^2)\)     | \(O(n^2)\)             |
| Minimum Path Sum (DP)       | \(O(n \times m)\) | \(O(n \times m)\)      |
| Minimum Path Sum (Greedy)   | \(O(n \times m)\) | \(O(n + m)\)           |

## Reference
https://docs.google.com/presentation/d/1vyPhZOECJBBqxeYecbb5ZYoyBTPnxJDOLuPfHymDRys/edit?usp=sharing

## Contact

**Author:** Antara Kawathekar  
Email: antarakawathekar@gmail.com

---

Feel free to fork, modify, or contribute additional algorithms.



