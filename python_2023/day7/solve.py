

hands=[]
order = {'A': 13, 'K': 12, 'Q': 11, 'J': 10, 'T': 9, '9': 8, '8': 7, '7': 6, '6': 5, '5': 4, '4': 3, '3': 2, '2': 1, 'J': 0}

  
def get_strength(hand):
   trick_strength = []
   for card in set(hand):
     trick_strength.append(hand.count(card))
   trick_strength = tuple(sorted(trick_strength, reverse=True))   
   return trick_strength, hand


def part_one(input_lines: list[str]) -> int:
   winnings=0
   winnings2=0

   for line in input_lines:
      hand, pot = line.split()
      hands.append((tuple(order[card] for card in hand),int(pot),hand))
   
   #hands.sort(key=lambda s: get_strength(s[0]))
   #for i, pair in enumerate(hands,start=1):
      #winnings += pair[1] * (i)
  # print("Part1: ",winnings)
   hands.sort(key=lambda s: get_strength(s[0]))

   j=0
   for strength,hand,pot in hands:
      if 0 in strength:
         count_dict = {num: strength.count(num) for num in strength}
         most_common_numbers = [num for num, count in count_dict.items() if count == max(count_dict.values())]
         highest_common_number = max(most_common_numbers)
         hands[j] = ((tuple(highest_common_number if num == 0 else num for num in strength),hand,pot))
      j+=1 
   
   for i, pair in enumerate(hands,start=1):
       winnings2 += pair[1] * (i)
   print("Part2: ",winnings2)

   return (0)

def read_file(filename: str) -> list[list[int]]:
   with open(input_path, "r", encoding="utf-8") as file:
      data = file.read()
      input_lines = data.split("\n")
   print("Part1: ",part_one(input_lines))



if __name__ == "__main__":
    #input_path = "input.txt"
    input_path = "./day7/input.txt"

    read_file(input_path)