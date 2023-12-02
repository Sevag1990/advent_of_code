number_names = {
   'one': 1,
     'two':2,
     'three':3,
     'four':4,
     'five':5,
     'six':6,
     'seven':7,
     'eight':8,
     'nine':9
}

def part_one(input: str) -> int:
   v1 = 0
   v2 = 0
   for i, v in enumerate(input):
     if(v.isdigit()):
        v1 = v
        break
   for i, v in enumerate(input[::-1]):
      if(v.isdigit()):
        v2 = v
        break
   return(v1+v2)

def part_two(input: str) -> int:
     v1 = 0
     v2 = 0
     found = 0
     numberName = ""
     for i, v in enumerate(input):
         if found == 1:
            break
         if(v.isdigit()):
          v1 = v
          break
         numberName+=v
         for value in number_names.keys():
            if found == 1:
               break
           
            if value in numberName:
               v1 = number_names.get(value)
               found = 1
               break
     numberName = ""
     found = 0
     for i, v in enumerate(input[::-1]):
         if found == 1:
            break
         if(v.isdigit()):
          v2 = v
          break
         numberName+=v
         for value in number_names.keys():
            if value in numberName[::-1]:
              v2 = number_names.get(value)
              found = 1
              break

     return int(str(v1) + str(v2))
def read_file(filename: str) -> list[list[int]]:
   resultp1=0 
   resultp2 = 0 
   with open(filename) as file:
    for line in file:
      resultp1 += int(part_one(line.rstrip()))
      resultp2 += part_two(line.rstrip())
    
   print("Part1: " ,resultp1)
   print("Part2: " ,resultp2)

if __name__ == "__main__":
    input_path = "input.txt"
    #input_path = "./day1/input.txt"

    read_file(input_path)