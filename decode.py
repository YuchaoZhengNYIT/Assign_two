#!/usr/bin/python
import sys
import math

def decodeTimes(message, depth, times):
    finalString = message
    for i in range(0, times):
        finalString = decode(finalString, depth)
    print("--- Run after times, finalString is below ---")
    print("--- Message not include begin and last quotation ---")
    print("-----------------------------------------")
    print('"'+finalString+'"')
    print("-----------------------------------------")

def decode(message, depth):
    message_length = len(message)
    lineCount = []
    loopLength = (2*depth -2)
    for i in range(0,message_length):
        index = 0
        check_i = i % loopLength
        if(check_i<depth):
            index = check_i
        else:
            index = loopLength-check_i

        # print("index is :"+str(index))
        if(index>=len(lineCount)):
            lineCount.append(0)
        lineCount[index] += 1
    ## get line count
    # print("lineCount is :"+str(lineCount))
    stringLists = []
    for i in lineCount:
        stringLists.append(message[0:i])
        message = message[i:]

    # print("stringLists is :"+str(stringLists))
    finalString = ""
    nextListIndex = 0
    increase = 1
    while(stringLists[nextListIndex]!=""):
        # print("==== stringLists is :"+stringLists[nextListIndex])
        # print(stringLists)
        finalString += stringLists[nextListIndex][0]
        stringLists[nextListIndex] = stringLists[nextListIndex][1:]
        if(increase==1):
            nextListIndex+=1
        else:
            nextListIndex-=1

        if(nextListIndex>=depth-1):
            nextListIndex = depth-1
            increase = 0
        if(nextListIndex<=0):
            nextListIndex=0
            increase = 1

    # print(finalString)

   

    # print("-------- decode once message is below--------")
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

    decodeTimes(message,depth,times)


if __name__ == "__main__":
    main(sys.argv)