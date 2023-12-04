import re


def part_one (input: str)-> int:
   result=[]
   part1=0
   gameNumber = input.partition(":")[2].split("|")
   mynumbers= list(filter(None,gameNumber[0].strip().split(" ")))
   winning= list(filter(None,gameNumber[1].strip().split(" ")))

   for i in mynumbers :
      for j in winning:
         if i == j:
            result.append(i)
   
   for i,x in enumerate(result):
      if i == 0:
         part1+=1
      else:
         part1*=2
   return part1 
def part_two(card : dict[int, int]) -> int:
   result=[]
   m = {}
   part2=0
   gameNumber = card.partition(":")[2].split("|")
   temp1 = gameNumber[0].strip().split(" ")
   mynumbers= list(filter(None,temp1))
   temp2 = gameNumber[1].strip().split(" ")
   winning= list(filter(None,temp2))

   for i in mynumbers :
      for j in winning:
         if i == j:
            result.append(i)
   
   for i,x in enumerate(result):
      if i not in result:
        part2+=1
      else:
         part2*=2
   return part2



def read_file(filename: str) -> list[list[int]]:
   part1 = 0
   part2 = 0
   with open(filename) as file:
      lines = file.readlines()
      cards = {i: 1 for i in range(len(lines))}   
      for i, card in enumerate(lines):
         part1 += part_one(card) 
         matchingNums = part_two(card) 
         for j in range(i+1, i+1+matchingNums):
            cards[j]+= cards[i]
            
   print("Part1: " ,part1)
   print("Part2: ",sum(cards.values()))
if __name__ == "__main__":
    input_path = "input.txt"
    #input_path = "./day4/input.txt"

    read_file(input_path)