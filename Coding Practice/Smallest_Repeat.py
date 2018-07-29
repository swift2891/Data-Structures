inp = str(input("Enter input : "))
mem = []
sub = ""
i=0
while(True):
	if(inp[i] in mem):
		break 
	else:
		sub += inp[i]
		mem.append(inp[i])
		i += 1
		
if(len(inp) == inp.count(sub) * len(sub)):
		print(sub)
else:
	print("None")