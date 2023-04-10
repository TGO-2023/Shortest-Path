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