import re


possible_games = {
     'red': 12,
     'green':13,
     'blue': 14
}
def isPossibleGame(a,possibleGame) -> bool:
   for val in a:
     game =  int(re.findall('\d+',val)[0])
     if(game <= possibleGame):
        continue
     else : 
        return False
   return True

def part_one(input: str) -> int:
   result= 0
   gameNumber = input.partition(":")
   games = gameNumber[2]
   blue = isPossibleGame(re.findall('\d+ blue',games),possible_games.get("blue"))
   red = isPossibleGame(re.findall('\d+ red',games),possible_games.get("red"))
   green = isPossibleGame(re.findall('\d+ green',games),possible_games.get("green"))
   
   if(( blue and red and  green)):
      result = re.findall('\d+',gameNumber[0])[0]
      return int(result)
   else:
    return 0

def part_two(input: str) -> int:
   gameNumber = input.partition(":")
   games = gameNumber[2]
   blue = re.findall('\d+ blue',games)
   blueDigit = max(list(map(int,["".join(filter(str.isdigit,text)) for text in blue])))
   red = re.findall('\d+ red',games)
   redDigit = max(list(map(int,["".join(filter(str.isdigit,text)) for text in red])))
   green = re.findall('\d+ green',games)
   greenDigit = max(list(map(int,["".join(filter(str.isdigit,text)) for text in green])))

   return (blueDigit*redDigit*greenDigit)

def read_file(filename: str) -> list[list[int]]:
   part1 = 0
   part2 = 0
   with open(filename) as file:
      for line in file:
        part1 += part_one(line.rstrip())
        part2 +=  part_two(line.rstrip())
        
   print("Part1: " ,part1)
   print("Part2: ",part2)

if __name__ == "__main__":
    input_path = "input.txt"
    #input_path = "./day2/input.txt"

    read_file(input_path)