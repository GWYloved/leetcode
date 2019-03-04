package array;
/*
In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Note:

1 <= seats.length <= 20000
seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class array_849_Maximize_Distance_to_Closest_Person {
    public static int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i)
                    future++;

                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1,0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0}));
        System.out.println(maxDistToClosest(new int[]{0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(maxDistToClosest(new int[]{0,0,0,1,1,0,0,0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,1,0,0}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,0,0,1}));
    }
}
