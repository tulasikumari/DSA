import java.util.*;

//You are given a 2D array containing coordinates and height of rectangle such that height[i]=[xi,yi,hi], where xi the
//        x coordinate of left edge, yi represents x coordinate of right edge of rectangle and hi represents the height of the
//        peaks of each rectangle. If you want to construct a border line over the peaks of rectangle represented in bar chart,
//        return the key coordinates required to build a border line that contacts the peaks of the given chart.
//        Note: key points are the left coordinates of shape representing peaks where you need to draw boarder line.
//        Input: height={{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}}
//        Output: {{1,10},{2,15},{5,12},{8,0},{9,1},{11,15},{13,0}}
//5a done
public class BorderLinePeaks {
    public int[][] getBorderLine(int[][] height) {
        List<int[]> keyCoords = new ArrayList<>();// Create a list to store key coordinates

                // Create a priority queue to keep track of the heights
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

                // Add the left and right edges of the first rectangle
                pq.add(height[0][2]);
                keyCoords.add(new int[]{height[0][0], height[0][2]});

                // Iterate over the remaining rectangles
                for (int i = 1; i < height.length; i++) {
                    int[] rect = height[i];

                    // Remove any heights that are no longer relevant
                    while (!pq.isEmpty() && pq.peek() > rect[1]) {
                        pq.poll();
                    }

                    // Add the height of the current rectangle
                    pq.add(rect[2]);

                    if (rect[0] > height[i-1][1]) {
                        keyCoords.add(new int[]{height[i-1][1], 0});
                    }

                    keyCoords.add(new int[]{rect[0], rect[2]});

                }

                // Add the right edge of the last rectangle
                keyCoords.add(new int[]{height[height.length-1][1], 0});

                // Convert the list to an array and return it
                return keyCoords.toArray(new int[0][]);
            }

            public static void main(String[] args) {
                int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
                BorderLinePeaks blp = new BorderLinePeaks();
                int[][] border = blp.getBorderLine(height);
                for (int[] coord : border) {
                    System.out.println(Arrays.toString(coord));
                }
            }
        }
