#!/usr/bin/python
import sys

def encodeTimes(message, depth, times):
    finalString = message
    for i in range(0, times):
        finalString = encode(finalString, depth)
    print("--- Run after times, finalString is below ---")
    print("--- Message not include begin and last quotation ---")
    print("-----------------------------------------")
    print('"'+finalString+'"')
    print("-----------------------------------------")

def encode(message, depth):
    fences = []
    ind = 0
    for char in message:
        depth_index = ind % (2*depth -2)
        fence_index = 0
        if(depth_index<depth):
            fence_index = depth_index
        else:
            fence_index = (2*depth -2)-depth_index

        # print("fence_index is :"+ str(fence_index))
        if(fence_index>=len(fences)):
            fences.append("")

        fences[fence_index] += char
        ind += 1

    finalString = ""
    for i in fences:
        finalString += i

    # print("-------- Encode once message is below--------")
    # print(finalString)
    # print("--------------------------------------------")

    return finalString


def main(argv):
    message = ""
    depth = ""
    times = ""
    try:
        message = argv[1]
        depth = int(argv[2])
        times = int(argv[3])
        print("input message is :"+message)
        print("depth is :"+str(depth))
        print("times is :"+str(times))
    except:
    	print("wrong input")
    	return

    encodeTimes(message,depth,times)


if __name__ == "__main__":
    main(sys.argv)