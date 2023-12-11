part1=[]
part2=[]

def extrapolate(resultList:[]):
   resultList=resultList[::-1]
   for idx, i in enumerate(resultList):
      if all(element == 0 for element in resultList[idx]):
         resultList[idx].append(0)
         continue   
      t=resultList[idx-1][-1] + resultList[idx][-1]
      resultList[idx].append(t)
   part1.append(resultList[-1][-1])
   return part1

def extrapolate_part2(resultList:[]):
   resultList=resultList[::-1]
   for idx, i in enumerate(resultList):
      
      if all(element == 0 for element in resultList[idx]):
         resultList[idx].append(0)
         continue   
      t=resultList[idx][0]- resultList[idx-1][0] 
      resultList[idx].insert(0,t)
   part2.append(resultList[-1][0])
   return part2

def part_one(line) -> int:
   for i in line :
      resultList=[]
      tempList=[]
      sequences = list(map(int,i.split()))
      resultList.append(sequences)
      while any(value != 0 for value in sequences):
         for idx in range(len(sequences) - 1):
            tempList.append(sequences[idx + 1] - sequences[idx])
         sequences = tempList
         resultList.append(tempList)
         tempList=[] 
      extrapolate(resultList)
      extrapolate_part2(resultList)

   return 0


def read_file(filename: str) -> list[list[int]]:
   with open(filename, "r", encoding="utf-8") as file:
      data = file.read()
      input_lines = data.split("\n")
      part_one(input_lines)
      print(sum((part1)))
      print(sum((part2)))
      
if __name__ == "__main__":
    input_path = "input.txt"
    #input_path = "./day9/input.txt"

    read_file(input_path)