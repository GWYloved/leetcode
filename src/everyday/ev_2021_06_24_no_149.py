from typing import List

from numpy import sort


class ev_2021_06_24_no_149:
    def maxPoints(self, points: List[List[int]]) -> int:
        allPointSize = len(points)
        PointMaxNumberContainer = [0]*allPointSize
        for i in range(0, allPointSize -1):
            pointKNumberContainer = [0]*(allPointSize -1)
            pointA = points[i]
            skip = False
            for j in range(0, allPointSize - 1):
                if(j == i):
                    skip = True
                    continue
                pointB = points[j]
                if(pointB[0] == pointA[0]):
                    k = True
                else:
                    k = (pointB[1] - pointA[1])/(pointB[0] - pointA[0])
                if(skip):
                    pointKNumberContainer[j-1] = k
                else:
                    pointKNumberContainer[j] =k
                sort(pointKNumberContainer)




        return 1






if __name__ == "__main__":
    input = [[1, 1], [2, 2], [3, 3]]
    a = ev_2021_06_24_no_149()
    t = [1, True, 3]
    print(t)
    print(a.maxPoints(input))
    print((3-1)/(4-1))
