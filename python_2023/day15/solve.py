boxes = [{} for _ in range(256)]

def hash(input) -> int :
   value=0
   for char in input:
         value+=(ord(char))
         value*=17
         value%= 256
   return value


def part_one(input_lines) -> int:
   part1=0
   for input in input_lines:
      part1+=hash(input)
   return part1


def part_two(input_lines) -> int:
   part2=0
   for input in input_lines:
      if "-" in input:
         label = input[:-1]
         box = boxes[hash(label)]
         if label in box:
            box.pop(label)
      if "=" in input:
         label, focal = input.split("=")
         box = boxes[hash(label)]
         box[label] = int(focal)
         
   for idx, box in enumerate(boxes):
    for jidx, lens in enumerate(box.items()):
        part2 += ((idx+1) * (jidx+1) * lens[1])
        
   return part2

def read_file(filename: str) -> list[list[int]]:
   with open(filename, "r", encoding="utf-8") as file:
      data = file.read()
      input_lines = data.split(",")
      print(part_one(input_lines))
      print(part_two(input_lines))

      
if __name__ == "__main__":
    #input_path = "input.txt"
    input_path = "./day15/input.txt"

    read_file(input_path)