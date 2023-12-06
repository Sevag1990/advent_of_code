import re


def mapFromTo(mapping,x):
   y = -1 
   for row in mapping:
        end, start, count = map(int, row.split(" "))
        if start <= x <= start + count:
            y = end - start + x
            break
   if y != -1:
      return y
   else:
      return x

def part_one(input_lines : dict[int, int]) -> int:
    input_seeds = list(map(int, input_lines[0].split("seeds: ")[1].split()))
    seed_to_soil = input_lines[1].split("\n")[1:]
    soil_to_fertilizers = input_lines[2].split("\n")[1:]
    fertilizer_to_water = input_lines[3].split("\n")[1:]
    water_to_light = input_lines[4].split("\n")[1:]
    light_to_temp = input_lines[5].split("\n")[1:]
    temp_to_hum = input_lines[6].split("\n")[1:]
    hum_to_loc = input_lines[7].split("\n")[1:]
    
    res = [
        mapFromTo(seed_to_soil, n) for n in input_seeds
    ]
    res = [
        mapFromTo(soil_to_fertilizers, n) for n in res
    ]
    res = [
        mapFromTo(fertilizer_to_water, n) for n in res
    ]
    res = [
        mapFromTo(water_to_light, n) for n in res
    ]
    res = [
        mapFromTo(light_to_temp, n) for n in res
    ]
    res = [
        mapFromTo(temp_to_hum, n) for n in res
    ]
    res = [
        mapFromTo(hum_to_loc, n) for n in res
    ]
    return min(res)


def part_two (input_lines : dict[int, int]) -> int:

   return 0


def read_file(filename: str) -> list[list[int]]:
   with open(input_path, "r", encoding="utf-8") as file:
      data = file.read()
      input_lines = data.split("\n\n")

   #print("Part1: " ,part_one(input_lines))
   print("Part2: ",part_two(input_lines))
if __name__ == "__main__":
    #input_path = "input.txt"
    input_path = "./day5/input.txt"

    read_file(input_path)