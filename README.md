## Call Taxi Booking Application

**Description:**  
Design a taxi booking application where customers can book taxis available at certain points in a linear route.

### Problem Assumptions:
- **Taxi Count:** Assume 4 taxis for simplicity, but it should scale to any number of taxis.
- **Points on Route:** A, B, C, D, E, F (each 15 km apart)
- **Travel Time Between Points:** 60 minutes
- **Charges:**  
  - Minimum Rs.100 for the first 5 km
  - Rs.10 per km thereafter
- **Initial Taxi Position:** All taxis are stationed at A.

### Booking Rules:
- When a customer books a taxi:
  - A free taxi at the pickup point is allocated.
  - If no free taxi is available, the nearest taxi is allocated.
  - If two taxis are free at the same point, the one with lower earnings is allocated.
  - Taxis only charge from the pickup point to the drop point.
  - If no taxi is available, the booking is rejected.

### Modules:
1. **Call Taxi Booking**

   **Sample Inputs and Outputs:**

   **Input 1:**  
   - Customer ID: 1  
   - Pickup Point: A  
   - Drop Point: B  
   - Pickup Time: 9  

   **Output 1:**  
   - Taxi can be allotted.  
   - Taxi-1 is allotted.  

   **Input 2:**  
   - Customer ID: 2  
   - Pickup Point: B  
   - Drop Point: D  
   - Pickup Time: 9  

   **Output 2:**  
   - Taxi can be allotted.  
   - Taxi-2 is allotted.  

   **Input 3:**  
   - Customer ID: 3  
   - Pickup Point: B  
   - Drop Point: C  
   - Pickup Time: 12  

   **Output 3:**  
   - Taxi can be allotted.  
   - Taxi-1 is allotted.  

2. **Display Taxi Details**

   **Output Example:**
   ```
   Taxi-1    Total Earnings: Rs. 400
   BookingID   CustomerID   From   To   PickupTime   DropTime   Amount
   1           1            A      B    9           10         200
   3           3            B      C    12          13         200

   Taxi-2    Total Earnings: Rs. 350
   BookingID   CustomerID   From   To   PickupTime   DropTime   Amount
   2           2            B      D    9           11         350
