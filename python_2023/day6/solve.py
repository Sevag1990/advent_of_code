import re
import math




def read_file(filename: str) -> list[list[int]]:
   times = [55826490]
   distance= [246144110121111]
   result =  []

   for i in range(0,len(times)):
      count = 0
      for k in range(1,times[i]):
          total_distance = (times[i] - k) * (k)
        
          if total_distance > distance[i]:
            count += 1
      result.append(count)

   print("Part1: ", math.prod(result))
if __name__ == "__main__":
    #input_path = "input.txt"
    input_path = "./day6/input.txt"

    read_file(input_path)