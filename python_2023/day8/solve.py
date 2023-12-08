


def part_one(instructions,nodes) -> int:
   node_dict = dict()
   instructions = list(instructions)

   for n in nodes:
        key, values_str = n.split(' = ')
        values = [v.strip() for v in values_str.strip('()').split(',')]
        node_dict[key] = values

   curr_post = ['AAA', node_dict['AAA']]
   steps = 0

   while curr_post[0] != 'ZZZ':
        i = instructions[steps % len(instructions)]
        to_key = curr_post[1][1] if i == 'R' else curr_post[1][0]
        
        if to_key not in node_dict:
            break

        curr_post = [to_key, node_dict[to_key]]
        steps += 1

   return steps


def read_file(filename: str) -> list[list[int]]:
   with open(input_path, "r", encoding="utf-8") as file:
      data = file.read()
      instructions, nodes = data.split("\n\n")
      print("Part1: ",part_one(instructions,nodes.split("\n")))


if __name__ == "__main__":
    input_path = "input.txt"
    #input_path = "./day8/input.txt"

    read_file(input_path)