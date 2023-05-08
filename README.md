# shortest-path problem

## Authors
- [@Cahyadi Surya Nugraha 5025201184](https://github.com/Chroax)
- [@Fian Awamiry Maulana 5025201035](https://www.github.com/afanfian)
- [@Antonio Taifan Montana 5025201219](https://www.github.com/Shagdovala159)
- [@Naufal Ariq Putra Yosyam 5025201112](https://www.github.com/Naufalar10)

## Kebutuhan
[Link Kebutuhan Drive](https://drive.google.com/drive/folders/15paL2VorYRDbBIsALy4GNjHzvQYZBMG7?hl=id)

## Aturan commit
[Link Aturan Title Commit](https://www.conventionalcommits.org/en/v1.0.0-beta.2/)

## Ringkasan Jurnal
Path planning is one of the important tasks in intelligent control of an autonomous robots, it has a vast scope in robotics such as in terrain vehicles, unmanned aerial vehicles (UAVs), autonomous underwater vehicles. Various techniques for applications such as threat avoidance, finding shortest path, collision avoidance have been developed in the field of path planning over the past decade.

Finding the shortest feasible path is important for the purpose of navigation of autonomous robots, which is to find the best possible collision-free path between a starting node and a destination node for a known or unknown arena. Path planning for unknown environment is done using simultaneous localization and mapping, whereas path planning in known environment (static or dynamic) is done using potential field method, visibility graph method (VGraph) and grid method. The potential field method is widely applied for determining the real-time shortest possible path because of its simplified structure. The limitation of the potential field method is that for multi-modal surfaces the evaluation of shortest possible path may not be optimal because the method gets trapped inside the local minima which may result in oscillation in shortest path between the tightly packed obstacles boundaries. 

In this paper, Enhanced Linear Graph (ELGraph) is presented for feasible node pairs selection. The work focuses on node pair selection in an arena containing obstacles as convex polygons so that node pairs intersecting any obstacles is removed and therefore collision can be avoided. The approach is thoroughly discussed in the paper and compared with the commonly used conventional visibility graph (VGraph). Finally the feasible node pairs obtained are fed as input to Dijkstra algorithmto find the shortest possible path

## Reference Code
### Pseudo Code Reference From Internet
![Pseudo code reference](https://raw.githubusercontent.com/TGO-2023/shortest-path-problem/main/resource/image/code-reference.png)
[Link Reference](https://www.programiz.com/dsa/dijkstra-algorithm)

### Pseudo Code Reference From Journal
![Pseudo code reference](https://raw.githubusercontent.com/TGO-2023/shortest-path-problem/main/resource/image/journal-code-reference.png)

## Testing
### Obstacle
![Obstacle](https://raw.githubusercontent.com/TGO-2023/shortest-path-problem/main/resource/image/obstacle.png)

1. Obstacle 1 - RECTANGLE:
- x: 50.0, y: 450.0 
- x: 200.0, y: 450.0 
- x: 50.0, y: 350.0 
- x: 200.0, y: 350.0

2. Obstacle 2 - RIGHT_TRIANGLE:
- x: 350.0, y: 450.0 
- x: 350.0, y: 400.0 
- x: 450.0, y: 400.0

3. Obstacle 3 - RIGHT_TRIANGLE:
- x: 250.0, y: 400.0 
- x: 250.0, y: 250.0 
- x: 350.0, y: 250.0

4. Obstacle 4 - SQUARE:
- x: 50.0, y: 300.0 
- x: 150.0, y: 300.0 
- x: 50.0, y: 200.0 
- x: 150.0, y: 200.0

5. Obstacle 5 - RECTANGLE:
- x: 200.0, y: 200.0 
- x: 350.0, y: 200.0 
- x: 200.0, y: 100.0 
- x: 350.0, y: 100.0

6. Obstacle 6 - RECTANGLE:
- x: 400.0, y: 150.0 
- x: 450.0, y: 150.0 
- x: 400.0, y: 50.0 
- x: 450.0, y: 50.0

### Worthy Edge Result
```
List of Worthy Edge in Arena: 
Source(1) to Obstacle 1-1(2), Weight: 353.55
Source(1) to Obstacle 1-2(3), Weight: 403.11
Source(1) to Obstacle 1-3(4), Weight: 452.77
Source(1) to Obstacle 2-1(6), Weight: 494.97
Source(1) to Obstacle 2-3(8), Weight: 602.08
Source(1) to Obstacle 3-1(9), Weight: 471.70
Source(1) to Obstacle 4-1(12), Weight: 502.49
Source(1) to Obstacle 4-3(14), Weight: 602.08
Obstacle 1-1(2) to Obstacle 1-2(3), Weight: 150.00
Obstacle 1-1(2) to Obstacle 1-3(4), Weight: 100.00
Obstacle 1-1(2) to Obstacle 2-1(6), Weight: 300.00
Obstacle 1-1(2) to Obstacle 4-1(12), Weight: 150.00
Obstacle 1-1(2) to Obstacle 4-3(14), Weight: 250.00
Obstacle 1-2(3) to Obstacle 1-3(4), Weight: 180.28
Obstacle 1-2(3) to Obstacle 1-4(5), Weight: 100.00
Obstacle 1-2(3) to Obstacle 2-1(6), Weight: 150.00
Obstacle 1-2(3) to Obstacle 3-1(9), Weight: 70.71
Obstacle 1-3(4) to Obstacle 1-4(5), Weight: 150.00
Obstacle 1-3(4) to Obstacle 2-1(6), Weight: 316.23
Obstacle 1-3(4) to Obstacle 3-1(9), Weight: 206.16
Obstacle 1-3(4) to Obstacle 4-1(12), Weight: 50.00
Obstacle 1-3(4) to Obstacle 4-2(13), Weight: 111.80
Obstacle 1-3(4) to Obstacle 4-3(14), Weight: 150.00
Obstacle 1-4(5) to Obstacle 3-1(9), Weight: 70.71
Obstacle 1-4(5) to Obstacle 4-1(12), Weight: 158.11
Obstacle 1-4(5) to Obstacle 4-2(13), Weight: 70.71
Obstacle 2-1(6) to Obstacle 2-2(7), Weight: 50.00
Obstacle 2-1(6) to Obstacle 2-3(8), Weight: 111.80
Obstacle 2-1(6) to Obstacle 3-1(9), Weight: 111.80
Obstacle 2-2(7) to Obstacle 3-3(11), Weight: 150.00
Obstacle 2-2(7) to Obstacle 5-2(17), Weight: 200.00
Obstacle 2-2(7) to Obstacle 5-4(19), Weight: 300.00
Obstacle 2-2(7) to Obstacle 6-1(20), Weight: 254.95
Obstacle 2-2(7) to Obstacle 6-2(21), Weight: 269.26
Obstacle 2-2(7) to Goals(24), Weight: 602.08
Obstacle 2-3(8) to Goals(24), Weight: 531.51
Obstacle 3-1(9) to Obstacle 4-2(13), Weight: 141.42
Obstacle 3-2(10) to Obstacle 3-3(11), Weight: 100.00
Obstacle 3-2(10) to Obstacle 4-3(14), Weight: 206.16
Obstacle 3-2(10) to Obstacle 4-4(15), Weight: 111.80
Obstacle 3-2(10) to Obstacle 5-1(16), Weight: 70.71
Obstacle 3-2(10) to Obstacle 5-2(17), Weight: 111.80
Obstacle 3-2(10) to Obstacle 6-2(21), Weight: 223.61
Obstacle 3-2(10) to Goals(24), Weight: 604.15
Obstacle 3-3(11) to Obstacle 4-3(14), Weight: 304.14
Obstacle 3-3(11) to Obstacle 4-4(15), Weight: 206.16
Obstacle 3-3(11) to Obstacle 5-1(16), Weight: 158.11
Obstacle 3-3(11) to Obstacle 5-2(17), Weight: 50.00
Obstacle 3-3(11) to Obstacle 5-4(19), Weight: 150.00
Obstacle 3-3(11) to Obstacle 6-1(20), Weight: 111.80
Obstacle 3-3(11) to Obstacle 6-2(21), Weight: 141.42
Obstacle 3-3(11) to Goals(24), Weight: 514.78
Obstacle 4-1(12) to Obstacle 4-2(13), Weight: 100.00
Obstacle 4-1(12) to Obstacle 4-3(14), Weight: 100.00
Obstacle 4-3(14) to Obstacle 4-4(15), Weight: 100.00
Obstacle 4-3(14) to Obstacle 5-1(16), Weight: 150.00
Obstacle 4-3(14) to Obstacle 5-2(17), Weight: 300.00
Obstacle 4-3(14) to Obstacle 5-3(18), Weight: 180.28
Obstacle 4-4(15) to Obstacle 5-1(16), Weight: 50.00
Obstacle 4-4(15) to Obstacle 5-2(17), Weight: 200.00
Obstacle 4-4(15) to Obstacle 5-3(18), Weight: 111.80
Obstacle 5-1(16) to Obstacle 5-2(17), Weight: 150.00
Obstacle 5-1(16) to Obstacle 5-3(18), Weight: 100.00
Obstacle 5-2(17) to Obstacle 5-3(18), Weight: 180.28
Obstacle 5-2(17) to Obstacle 5-4(19), Weight: 100.00
Obstacle 5-2(17) to Obstacle 6-1(20), Weight: 70.71
Obstacle 5-2(17) to Obstacle 6-2(21), Weight: 111.80
Obstacle 5-2(17) to Goals(24), Weight: 492.44
Obstacle 5-3(18) to Obstacle 5-4(19), Weight: 150.00
Obstacle 5-3(18) to Obstacle 6-1(20), Weight: 206.16
Obstacle 5-3(18) to Obstacle 6-3(22), Weight: 206.16
Obstacle 5-4(19) to Obstacle 6-1(20), Weight: 70.71
Obstacle 5-4(19) to Obstacle 6-2(21), Weight: 111.80
Obstacle 5-4(19) to Obstacle 6-3(22), Weight: 70.71
Obstacle 6-1(20) to Obstacle 6-2(21), Weight: 50.00
Obstacle 6-1(20) to Obstacle 6-3(22), Weight: 100.00
Obstacle 6-2(21) to Obstacle 6-3(22), Weight: 111.80
Obstacle 6-2(21) to Obstacle 6-4(23), Weight: 100.00
Obstacle 6-2(21) to Goals(24), Weight: 380.79
Obstacle 6-3(22) to Obstacle 6-4(23), Weight: 50.00
Obstacle 6-3(22) to Goals(24), Weight: 403.11
Obstacle 6-4(23) to Goals(24), Weight: 353.55
```

### Graph Result
```
1-> [ 0 353.55 403.11 452.77 9999 494.97 9999 602.08 471.70 9999 9999 502.49 9999 602.08 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
2-> [ 353.55 0 150 100 9999 300 9999 9999 9999 9999 9999 150 9999 250 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
3-> [ 403.11 150 0 180.28 100 150 9999 9999 70.71 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
4-> [ 452.77 100 180.28 0 150 316.23 9999 9999 206.16 9999 9999 50 111.80 150 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
5-> [ 9999 9999 100 150 0 9999 9999 9999 70.71 9999 9999 158.11 70.71 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
6-> [ 494.97 300 150 316.23 9999 0 50 111.80 111.80 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
7-> [ 9999 9999 9999 9999 9999 50 0 9999 9999 9999 150 9999 9999 9999 9999 9999 200 9999 300 254.95 269.26 9999 9999 602.08 ]
8-> [ 602.08 9999 9999 9999 9999 111.80 9999 0 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 531.51 ]
9-> [ 471.70 9999 70.71 206.16 70.71 111.80 9999 9999 0 9999 9999 9999 141.42 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
10-> [ 9999 9999 9999 9999 9999 9999 9999 9999 9999 0 100 9999 9999 206.16 111.80 70.71 111.80 9999 9999 9999 223.61 9999 9999 604.15 ]
11-> [ 9999 9999 9999 9999 9999 9999 150 9999 9999 100 0 9999 9999 304.14 206.16 158.11 50 9999 150 111.80 141.42 9999 9999 514.78 ]
12-> [ 502.49 150 9999 50 158.11 9999 9999 9999 9999 9999 9999 0 100 100 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
13-> [ 9999 9999 9999 111.80 70.71 9999 9999 9999 141.42 9999 9999 100 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 ]
14-> [ 602.08 250 9999 150 9999 9999 9999 9999 9999 206.16 304.14 100 9999 0 100 150 300 180.28 9999 9999 9999 9999 9999 9999 ]
15-> [ 9999 9999 9999 9999 9999 9999 9999 9999 9999 111.80 206.16 9999 9999 100 0 50 200 111.80 9999 9999 9999 9999 9999 9999 ]
16-> [ 9999 9999 9999 9999 9999 9999 9999 9999 9999 70.71 158.11 9999 9999 150 50 0 150 100 9999 9999 9999 9999 9999 9999 ]
17-> [ 9999 9999 9999 9999 9999 9999 200 9999 9999 111.80 50 9999 9999 300 200 150 0 180.28 100 70.71 111.80 9999 9999 492.44 ]
18-> [ 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 180.28 111.80 100 180.28 0 150 206.16 9999 206.16 9999 9999 ]
19-> [ 9999 9999 9999 9999 9999 9999 300 9999 9999 9999 150 9999 9999 9999 9999 9999 100 150 0 70.71 111.80 70.71 9999 9999 ]
20-> [ 9999 9999 9999 9999 9999 9999 254.95 9999 9999 9999 111.80 9999 9999 9999 9999 9999 70.71 206.16 70.71 0 50 100 9999 9999 ]
21-> [ 9999 9999 9999 9999 9999 9999 269.26 9999 9999 223.61 141.42 9999 9999 9999 9999 9999 111.80 9999 111.80 50 0 111.80 100 380.79 ]
22-> [ 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 206.16 70.71 100 111.80 0 50 403.11 ]
23-> [ 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 9999 100 50 0 353.55 ]
24-> [ 9999 9999 9999 9999 9999 9999 602.08 531.51 9999 604.15 514.78 9999 9999 9999 9999 9999 492.44 9999 9999 9999 380.79 403.11 353.55 9999 ]
```

### Result
![Result](https://raw.githubusercontent.com/TGO-2023/shortest-path-problem/main/resource/image/result.png)

### Statistic
```
Total Nodes : 24
Total Worthy Edge : 82
Distance from source to goals: 1133.5870195763473
```