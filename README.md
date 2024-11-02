# The_Metro_App_in_Java
  *Discrete_Structures_Project*

## **Project Members**
   - Name:     Iqra Fatima  
     Institue: University of Engineering and Technology, Taxila
   - Name:     Amna Rasib
     Institue: University of Engineering and Technology, Taxila
   - Name:     Hajra Wajid
     Institue: University of Engineering and Technology, Taxila
   - Name:     Sameen Nadeem
     Institue: University of Engineering and Technology, Taxila
   
## **IDE**
We are using *Eclipse* IDE for development of this project.

## **Concepts Used in Project**
### **Graphs**
 A graph is a collection of nodes (or vertices) connected by edges. In your metro app, each metro station represents a node, and the direct routes (with distances) between them represent edges. This graph structure allows you to model the connections and paths between different metro stations.

### **Directed Graphs**
In this implementation, the routes between stations can be considered directed, as they have a specific start and end point. For example, if there’s a route from Station A to Station B, it doesn’t necessarily mean there’s a direct route back from B to A. This characteristic allows for a more accurate representation of the metro system.

### **Weighted Graphs**
The edges in this graph have weights, which in our case are the distances between stations. This allows us to calculate the shortest path based on distance rather than just the number of edges (or stations) traversed.

### **Dijkstra’s Algorithm**
This algorithm is used to find the shortest path from a starting node to other nodes in a graph. You’ve implemented Dijkstra’s algorithm in your app to calculate the shortest route between the selected start and destination stations based on the distances (weights) assigned to the edges.

### **Data Structures**
We have employed various data structures, such as:
HashMap: Used to store stations and their connections (routes), providing efficient lookup times when searching for a specific station.
Priority Queue: Utilized to manage the nodes during the execution of Dijkstra’s algorithm, ensuring that the node with the smallest distance is processed next.

### **Lists**
ArrayLists or linked lists are used to store the routes associated with each station, allowing for dynamic management of the edges connected to each node.
   
